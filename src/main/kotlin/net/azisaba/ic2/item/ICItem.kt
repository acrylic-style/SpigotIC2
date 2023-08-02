package net.azisaba.ic2.item

import net.azisaba.ic2.registry.Registries
import net.azisaba.ic2.util.RecipeBuilder
import org.bukkit.event.player.PlayerInteractEvent

abstract class ICItem {
    open fun onInteract(e: PlayerInteractEvent) {}

    abstract fun registerRecipe()

    private fun recipeBuilder(amount: Int) = RecipeBuilder(Registries.ITEM_STACK[Registries.ITEM.getId(this)].clone().apply { setAmount(amount) })
    protected fun shapedRecipe(vararg shape: String, amount: Int = 1) = recipeBuilder(amount).shaped(*shape)
    protected fun shapelessRecipe(amount: Int = 1) = recipeBuilder(amount).shapeless()
}
