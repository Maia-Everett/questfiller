package org.lucidfox.questfiller.model.npc

import java.text.NumberFormat
import java.util.ArrayList
import java.util.Locale

import org.lucidfox.questfiller.model.core.Faction
import org.lucidfox.questfiller.model.core.IDumpable
import java.util.function.Predicate

class NPC : IDumpable {
    // Infobox
    var id: Int = 0
    var name: String? = null
    var title: String? = null
    var gender: String? = null
    var levelLow: String? = null
    var levelHigh: String? = null
    var levelClassification: String? = null
    var health: Long? = null
    var mana: Long? = null
    var repFaction: String? = null
    var race: String? = null
    var creatureType: CreatureType? = null
    var allianceReaction: Reaction? = null
    var hordeReaction: Reaction? = null
    var petFamily: String? = null
    var patchAdded: String? = null
    var money: Int = 0

    // Other
    var location: String? = null
    var quests: List<NPCQuest> = ArrayList()
    var quotes: List<String> = ArrayList()
    var itemsSold: List<SoldItem> = ArrayList()

    val isQuestGiver: Boolean
        get() = quests.stream().anyMatch(Predicate<NPCQuest> { it.isStarts })

    val isQuestEnder: Boolean
        get() = quests.stream().anyMatch(Predicate<NPCQuest> { it.isFinishes })

    val faction: Faction?
        get() = if (allianceReaction == null && hordeReaction == null) {
            null
        } else if (allianceReaction == Reaction.FRIENDLY && hordeReaction != Reaction.FRIENDLY) {
            Faction.ALLIANCE
        } else if (allianceReaction != Reaction.FRIENDLY && hordeReaction == Reaction.FRIENDLY) {
            Faction.HORDE
        } else if (allianceReaction == Reaction.HOSTILE && hordeReaction == Reaction.HOSTILE) {
            Faction.COMBAT
        } else if (allianceReaction == Reaction.NEUTRAL && hordeReaction == Reaction.NEUTRAL) {
            Faction.COMBAT
        } else {
            Faction.NEUTRAL
        }

    val healthStr: String
        get() = NumberFormat.getNumberInstance(Locale.US).format(health)

    val manaStr: String?
        get() = if (mana == null) null else NumberFormat.getNumberInstance(Locale.US).format(mana!!)

    val isUseItembox: Boolean
        get() = itemsSold.size <= MAX_ITEMBOX_ITEMS

    val raceLowerCase: String?
        get() = if (race == null) null else race!!.toLowerCase()

    val isRaceStartsWithVowel: Boolean
        get() = if (race == null || race!!.isEmpty()) false else "AEIOU".indexOf(race!![0]) != -1

    fun hasMoney(): Boolean {
        return money != 0
    }

    val gold: Int?
        get() = getNonzeroOrNull(money / 10000)

    val silver: Int?
        get() = getNonzeroOrNull(money % 10000 / 100)

    val copper: Int?
        get() = getNonzeroOrNull(money % 100)

    companion object {
        private val MAX_ITEMBOX_ITEMS = 30

        private fun getNonzeroOrNull(quantity: Int): Int? {
            return if (quantity == 0) null else quantity
        }
    }
}
