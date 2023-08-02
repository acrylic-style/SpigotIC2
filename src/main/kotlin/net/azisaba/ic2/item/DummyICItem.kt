package net.azisaba.ic2.item

data class DummyICItem(val name: String) : ICItem() {
    override fun registerRecipe() {}

    override fun toString(): String = name
}
