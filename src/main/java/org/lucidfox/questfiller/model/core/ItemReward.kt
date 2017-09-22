package org.lucidfox.questfiller.model.core

class ItemReward(val name: String, val quantity: Int?, val index: Int) {

    override fun toString(): String {
        return if (quantity == null) name else String.format("%s (%s)", name, quantity)
    }
}
