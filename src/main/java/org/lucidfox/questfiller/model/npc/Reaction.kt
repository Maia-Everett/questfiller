package org.lucidfox.questfiller.model.npc

enum class Reaction(private val value: Int) {
    HOSTILE(-1),
    NEUTRAL(0),
    FRIENDLY(1);

    override fun toString(): String {
        return Integer.toString(value)
    }

    companion object {

        fun getByColor(colorId: String): Reaction {
            when (colorId) {
                "" -> return NEUTRAL
                "2" -> return FRIENDLY
                "10" -> return HOSTILE
                else -> throw AssertionError()
            }
        }
    }
}
