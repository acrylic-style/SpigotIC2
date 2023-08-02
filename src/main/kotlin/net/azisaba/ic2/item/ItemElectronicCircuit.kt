package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemElectronicCircuit : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            "CCC",
            "RPR",
            "CCC",
        )
            .setIngredient('C', Items.INSULATED_COPPER_CABLE)
            .setIngredient('R', ItemStack(Material.REDSTONE))
            .setIngredient('P', Items.IRON_PLATE)
            .build(IC2Plugin.key("electronic_circuit"))
            .register()
    }
}
