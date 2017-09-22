package org.lucidfox.questfiller.model.quest

class ReputationGain(private val faction: String, private val canonicalName: String?, private val gain: Int) {

    private val link: String
        get() = if (canonicalName == null) {
            String.format("[[%s]]", faction)
        } else {
            String.format("[[%s|%s]]", canonicalName, faction)
        }

    val fullText: String
        get() = String.format("+%s reputation with %s", gain, link)

    override fun toString(): String {
        return String.format("+%s %s", gain, link)
    }
}
