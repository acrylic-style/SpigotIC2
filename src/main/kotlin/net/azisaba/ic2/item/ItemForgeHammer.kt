package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.RecipeBuilder
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemForgeHammer : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            " II",
            "SSI",
            " II"
        )
            .setIngredient('S', ItemStack(Material.STICK))
            .setIngredient('I', ItemStack(Material.IRON_INGOT))
            .build(IC2Plugin.key("forge_hammer_r"))
            .register()
        shapedRecipe(
            "II ",
            "ISS",
            "II "
        )
            .setIngredient('S', ItemStack(Material.STICK))
            .setIngredient('I', ItemStack(Material.IRON_INGOT))
            .build(IC2Plugin.key("forge_hammer_l"))
            .register()
    }
}
