package org.lucidfox.questfiller.model.mission

class NavalMission : Mission() {
    override val infoboxTemplate: String
        get() = "Navalbox"

    override val resourceName: String
        get() = "Oil"
}
