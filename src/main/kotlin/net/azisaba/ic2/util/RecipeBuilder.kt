package net.azisaba.ic2.util

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.ShapelessRecipe
import org.bukkit.inventory.recipe.CraftingBookCategory
import java.lang.IllegalStateException

@Suppress("ArrayInDataClass")
open class RecipeBuilder(private val result: ItemStack) {
    internal var category: CraftingBookCategory = CraftingBookCategory.MISC

    fun category(category: CraftingBookCategory) = apply {
        this.category = category
    }

    fun shaped(vararg shape: String) = Shaped(result, shape)

    fun shapeless() = Shapeless(result)

    data class Shaped internal constructor(val result: ItemStack, val shape: Array<out String>): RecipeBuilder(result) {
        private val ingredients = mutableMapOf<Char, RecipeChoice>()

        fun setIngredient(char: Char, item: ItemStack) = apply {
            ingredients[char] = RecipeChoice.ExactChoice(item)
        }

        fun build(namespacedKey: NamespacedKey) = ShapedRecipe(namespacedKey, result).apply {
            shape(*this@Shaped.shape)
            ingredients.forEach { (char, item) -> setIngredient(char, item) }
            this.category = this@Shaped.category
        }
    }

    data class Shapeless internal constructor(val result: ItemStack): RecipeBuilder(result) {
        private val ingredients = mutableListOf<RecipeChoice>()

        fun addIngredient(item: ItemStack) = apply {
            ingredients += RecipeChoice.ExactChoice(item)
        }

        fun build(namespacedKey: NamespacedKey) = ShapelessRecipe(namespacedKey, result).apply {
            ingredients.forEach { addIngredient(it) }
            this.category = this@Shapeless.category
        }
    }
}

fun Recipe.register() {
    try {
        Bukkit.addRecipe(this)
    } catch (e: IllegalStateException) {
        e.printStackTrace()
    }
}
