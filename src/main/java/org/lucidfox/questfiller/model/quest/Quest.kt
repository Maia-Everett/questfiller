package org.lucidfox.questfiller.model.quest

import java.text.NumberFormat
import java.util.ArrayList
import java.util.Locale
import java.util.Objects
import java.util.TreeSet
import java.util.stream.Stream

import org.lucidfox.questfiller.model.core.CharacterClass
import org.lucidfox.questfiller.model.core.Faction
import org.lucidfox.questfiller.model.core.IDumpable
import org.lucidfox.questfiller.model.core.ItemReward
import org.lucidfox.questfiller.model.core.Race

class Quest : IDumpable {
    // Infobox
    var id: Int = 0
    var name: String? = null
    var faction: Faction? = null
    var characterClass: CharacterClass? = null
    var race: Race? = null
    var category: String? = null
    var level: Int? = null
    var levelRequired: Int? = null
    var type: String? = null
    var groupSize: Int? = null
    var startEntity: String? = null
    var finishEntity: String? = null
    var reputationGains: List<ReputationGain> = ArrayList()
    var experience: Int = 0
    var otherGains: List<String> = ArrayList()
    var choiceRewards: List<ItemReward> = ArrayList()
    var nonChoiceRewards: List<ItemReward> = ArrayList()
    var abilityRewards: List<String> = ArrayList()
    var buffRewards: List<String> = ArrayList()
    var money: Int = 0
    var isRepeatable: Boolean = false
    var isShareable: Boolean = false
    var previousQuests: Set<String> = TreeSet()
    var nextQuests: Set<String> = TreeSet()

    // Main text
    var objectives: String? = null
    var stages: List<String> = ArrayList()
    var providedItems: List<String> = ArrayList()
    var description: String? = null
    var progress: String? = null
    var completion: String? = null
    var patchAdded: String? = null
    var isRemoved: Boolean = false

    fun hasItemRewards(): Boolean {
        return !choiceRewards.isEmpty() || !nonChoiceRewards.isEmpty()
    }

    // These are not actually item rewards, but the formatter will behave as if they're items with unknown quantity
    val allNonChoiceRewards: List<ItemReward>
        get() {
            val result = ArrayList<ItemReward>()
            result.addAll(nonChoiceRewards)
            Stream.concat(abilityRewards.stream(), buffRewards.stream()).forEach { reward -> result.add(ItemReward(reward, null, result.size + 1)) }
            return result
        }

    fun hasChoiceAbilityOrBuffRewards(): Boolean {
        return !choiceRewards.isEmpty() || !abilityRewards.isEmpty() || !buffRewards.isEmpty()
    }

    fun hasNonMoneyRewards(): Boolean {
        return hasItemRewards() || !abilityRewards.isEmpty() || !buffRewards.isEmpty()
    }

    fun hasMoney(): Boolean {
        return money != 0
    }

    fun hasRewards(): Boolean {
        return hasMoney() || hasNonMoneyRewards()
    }

    fun hasExperience(): Boolean {
        return experience != 0
    }

    val experienceStr: String
        get() = NumberFormat.getNumberInstance(Locale.US).format(experience.toLong())

    fun hasGains(): Boolean {
        return hasExperience() || !reputationGains.isEmpty()
    }

    private fun getNonzeroOrNull(quantity: Int): Int? {
        return if (quantity == 0) null else quantity
    }

    val gold: Int?
        get() = getNonzeroOrNull(money / 10000)

    val silver: Int?
        get() = getNonzeroOrNull(money % 10000 / 100)

    val copper: Int?
        get() = getNonzeroOrNull(money % 100)

    val isNeutral: Boolean
        get() = faction === Faction.NEUTRAL

    val isStartAndFinishEqual: Boolean
        get() = startEntity == finishEntity

    override fun toString(): String {
        return String.format("[%s] [%s] %s", faction?.id ?: "", level, name)
    }
}
