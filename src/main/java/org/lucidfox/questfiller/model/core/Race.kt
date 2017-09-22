package org.lucidfox.questfiller.model.core

import java.util.HashMap

enum class Race(private val id: Int, private val raceName: String) {
    BLOOD_ELF(10, "Blood Elf"),
    DRAENEI(11, "Draenei"),
    DWARF(3, "Dwarf"),
    GNOME(7, "Gnome"),
    GOBLIN(9, "Goblin"),
    HUMAN(1, "Human"),
    NIGHT_ELF(4, "Night Elf"),
    ORC(2, "Orc"),
    PANDAREN_NEUTRAL(24, "Pandaren"),
    PANDAREN_ALLIANCE(25, "Pandaren"),
    PANDAREN_HORDE(26, "Pandaren"),
    TAUREN(6, "Tauren"),
    TROLL(8, "Troll"),
    UNDEAD(5, "Undead"),
    WORGEN(22, "Worgen");

    override fun toString(): String {
        return raceName
    }

    companion object {

        private val BY_ID = HashMap<Int, Race>()

        init {
            for (cc in Race.values()) {
                BY_ID.put(cc.id, cc)
            }
        }

        fun getById(id: Int): Race {
            return BY_ID[id]!!
        }
    }
}
