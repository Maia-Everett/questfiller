package org.lucidfox.questfiller.model.mission

import java.text.NumberFormat
import java.util.ArrayList
import java.util.Locale

import org.lucidfox.questfiller.model.core.CharacterClass
import org.lucidfox.questfiller.model.core.Faction
import org.lucidfox.questfiller.model.core.IDumpable
import org.lucidfox.questfiller.model.core.ItemReward

abstract class Mission : IDumpable {
    var id: Int = 0
    var name: String? = null
    var location: String? = null
    var duration: String? = null
    var faction: Faction? = null
    var characterClass: CharacterClass? = null
    var category: String? = null
    var level: Int? = null
    var followerItemLevel: Int? = null
    var type: String? = null
    var groupSize: Int? = null
    var cost: Int? = null
    var isRare: Boolean = false
    var isExhausting: Boolean = false
    var followerXP: Int = 0
    var description: String? = null
    var enemies: List<MissionEnemy> = ArrayList()
    var bonusMoney: Int = 0
    var bonusXP: Int = 0
    var bonusResources: Int = 0
    var patchAdded: String? = null
    var bonusItems: List<ItemReward> = ArrayList()

    private fun getNonzeroOrNull(quantity: Int): Int? {
        return if (quantity == 0) null else quantity
    }

    fun hasNonItemRewards(): Boolean {
        return bonusXP != 0 || bonusMoney != 0 || bonusResources != 0
    }

    fun hasMoney(): Boolean {
        return bonusMoney != 0
    }

    fun hasResources(): Boolean {
        return bonusResources != 0
    }

    val followerXPStr: String?
        get() = if (followerXP == 0) {
            null
        } else NumberFormat.getNumberInstance(Locale.US).format(followerXP.toLong())

    val bonusXPStr: String?
        get() = if (bonusXP == 0) {
            null
        } else NumberFormat.getNumberInstance(Locale.US).format(bonusXP.toLong())

    val gold: Int?
        get() = getNonzeroOrNull(bonusMoney / 10000)

    val silver: Int?
        get() = getNonzeroOrNull(bonusMoney % 10000 / 100)

    val copper: Int?
        get() = getNonzeroOrNull(bonusMoney % 100)

    val isNeutral: Boolean
        get() = faction == Faction.NEUTRAL

    abstract val infoboxTemplate: String
    abstract val resourceName: String

    override fun toString(): String {
        return String.format("[%s] [%s] %s", if (faction == null) "" else faction!!.id, level, name)
    }
}
