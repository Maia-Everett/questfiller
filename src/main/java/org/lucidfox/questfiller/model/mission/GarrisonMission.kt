package org.lucidfox.questfiller.model.mission

class GarrisonMission : Mission() {
    override val infoboxTemplate: String
        get() = "Missionbox"

    override val resourceName: String
        get() = "Garrison Resources"
}
