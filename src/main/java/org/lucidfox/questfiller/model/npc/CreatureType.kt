package org.lucidfox.questfiller.model.npc

import java.util.HashMap

enum class CreatureType private constructor(private val id: Int, private val typeName: String) {
    ABERRATION(15, "Aberration"),
    BATTLE_PET(12, "Battle Pet"),
    BEAST(1, "Beast"),
    CRITTER(8, "Critter"),
    DEMON(3, "Demon"),
    DRAGONKIN(2, "Dragonkin"),
    ELEMENTAL(4, "Elemental"),
    GIANT(5, "Giant"),
    HUMANOID(7, "Humanoid"),
    MECHANICAL(9, "Mechanical"),
    UNDEAD(6, "Undead"),
    UNCATEGORIZED(10, "Uncategorized");

    override fun toString(): String {
        return typeName
    }

    companion object {

        private val BY_ID = HashMap<Int, CreatureType>()

        init {
            for (ct in CreatureType.values()) {
                BY_ID.put(ct.id, ct)
            }
        }

        fun getById(id: Int): CreatureType {
            return BY_ID[id]!!
        }
    }
}
