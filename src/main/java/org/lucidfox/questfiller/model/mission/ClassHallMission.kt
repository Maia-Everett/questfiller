package org.lucidfox.questfiller.model.mission

class ClassHallMission : Mission() {
    override val resourceName: String
        get() = "MissionLegionbox"

    override val infoboxTemplate: String
        get() = "Order Resources"
}