package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemCutter : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            "P P",
            " P ",
            "I I",
        )
            .setIngredient('P', Items.IRON_PLATE)
            .setIngredient('I', ItemStack(Material.IRON_INGOT))
            .build(IC2Plugin.key("cutter"))
            .register()
    }
}
