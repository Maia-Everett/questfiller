package org.lucidfox.questfiller.model.core

import java.lang.reflect.Method

interface IDumpable {
    fun dump(): String {
        val sb = StringBuilder(javaClass.simpleName)
        sb.append("\n")

        for (m in javaClass.methods) {
            if ((m.name.startsWith("get") || m.name.startsWith("is"))
                    && m.parameterCount == 0 && "getClass" != m.name) {
                sb.append(m.name.replace("^(get|is)".toRegex(), ""))
                sb.append(": ")

                try {
                    sb.append(m.invoke(this))
                } catch (e: ReflectiveOperationException) {
                    e.printStackTrace()
                    sb.append("<error>")
                }

                sb.append("\n")
            }
        }

        return sb.toString()
    }
}
