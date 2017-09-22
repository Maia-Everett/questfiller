package org.lucidfox.questfiller.model.core

import java.util.HashMap

enum class CharacterClass(private val id: Int, private val className: String) {
    DEATH_KNIGHT(6, "Death Knight"),
    DEMON_HUNTER(12, "Demon Hunter"),
    DRUID(11, "Druid"),
    HUNTER(3, "Hunter"),
    MAGE(8, "Mage"),
    MONK(10, "Monk"),
    PALADIN(2, "Paladin"),
    PRIEST(5, "Priest"),
    ROGUE(4, "Rogue"),
    SHAMAN(7, "Shaman"),
    WARLOCK(9, "Warlock"),
    WARRIOR(1, "Warrior");

    override fun toString(): String {
        return className
    }

    companion object {

        private val BY_ID = HashMap<Int, CharacterClass>()

        init {
            for (cc in CharacterClass.values()) {
                BY_ID.put(cc.id, cc)
            }
        }

        fun getById(id: Int): CharacterClass {
            return BY_ID[id]!!
        }
    }
}
