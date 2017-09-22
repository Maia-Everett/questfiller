package org.lucidfox.questfiller.model.npc

class SoldItem(val name: String, val price: Int) : Comparable<SoldItem> {

    private fun getNonzeroOrNull(quantity: Int): Int? {
        return if (quantity == 0) null else quantity
    }

    val gold: Int?
        get() = getNonzeroOrNull(price / 10000)

    val silver: Int?
        get() = getNonzeroOrNull(price % 10000 / 100)

    val copper: Int?
        get() = getNonzeroOrNull(price % 100)

    override fun compareTo(other: SoldItem): Int {
        return name.compareTo(other.name)
    }
}
