package net.azisaba.ic2.registry

class WritableRegistry<T>() : Registry<T> {
    constructor(vararg values: T) : this() {
        map.addAll(values.toList())
    }

    private val map = mutableListOf<T>()

    override fun getOrNull(id: Int): T? = synchronized(map) { map[id] }

    override fun getId(value: T): Int = synchronized(map) { map.indexOf(value) }

    override fun register(value: T): Int = synchronized(map) {
        if (map.indexOf(value) != -1) {
            error("$value is already registered")
        }
        map.add(value)
        map.indexOf(value)
    }

    override fun asList(): List<T> = map.toList()

    override fun createSequence(): Sequence<T> = map.asSequence()

    companion object {
        inline fun <reified E : Enum<E>> byEnum(): WritableRegistry<E> = WritableRegistry(*E::class.java.enumConstants)
    }
}
