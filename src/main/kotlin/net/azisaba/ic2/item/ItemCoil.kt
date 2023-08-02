package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemCoil : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            "CCC",
            "CIC",
            "CCC",
        )
            .setIngredient('C', Items.COPPER_CABLE)
            .setIngredient('I', ItemStack(Material.IRON_INGOT))
            .build(IC2Plugin.key("coil"))
            .register()
    }
}
