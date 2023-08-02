package net.azisaba.ic2.registry

interface Registry<T> {
    fun getOrNull(id: Int): T?

    operator fun get(id: Int): T = getOrNull(id) ?: error("$id is missing")

    fun getId(value: T): Int

    fun register(value: T): Int = throw UnsupportedOperationException()

    fun asList(): List<T> = createSequence().toList()

    fun createSequence(): Sequence<T> {
        var index = 0
        return generateSequence { getOrNull(index++) }
    }
}
