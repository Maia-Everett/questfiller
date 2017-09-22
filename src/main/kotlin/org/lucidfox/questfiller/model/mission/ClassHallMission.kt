package org.lucidfox.questfiller.model.mission

class ClassHallMission : Mission() {
    override fun getResourceName(): String {
        return "MissionLegionbox"
    }

    override fun getInfoboxTemplate(): String {
        return "Order Resources"
    }
}