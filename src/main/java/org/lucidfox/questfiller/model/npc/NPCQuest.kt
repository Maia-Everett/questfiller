package org.lucidfox.questfiller.model.npc

class NPCQuest(val name: String, val isStarts: Boolean, val isFinishes: Boolean) : Comparable<NPCQuest> {
    override fun compareTo(other: NPCQuest): Int {
        return name.compareTo(other.name)
    }
}
