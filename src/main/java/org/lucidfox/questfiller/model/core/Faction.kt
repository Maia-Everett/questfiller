package org.lucidfox.questfiller.model.core

enum class Faction(val id: String, val factionName: String) {
    ALLIANCE("A", "Alliance"),
    HORDE("H", "Horde"),
    NEUTRAL("N", "Neutral"),
    COMBAT("C", "Combat");

    override fun toString(): String {
        return factionName
    }
}
