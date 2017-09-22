package org.lucidfox.questfiller.model.mission

import java.util.ArrayList
import java.util.Collections
import java.util.function.Consumer

class MissionEnemy(val name: String, counters: Iterable<String>) {
    val counters: List<String>

    init {

        val countersCopy = ArrayList<String>()
        counters.forEach(Consumer<String> { countersCopy.add(it) })
        countersCopy.trimToSize()
        this.counters = Collections.unmodifiableList(countersCopy)
    }

    override fun toString(): String {
        return name + " " + counters
    }
}
