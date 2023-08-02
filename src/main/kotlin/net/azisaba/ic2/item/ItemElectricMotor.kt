package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemElectricMotor : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            " I ",
            "CBC",
            " I ",
        )
            .setIngredient('I', Items.IRON_CASING)
            .setIngredient('C', Items.COIL)
            .setIngredient('B', ItemStack(Material.IRON_INGOT))
            .build(IC2Plugin.key("electric_motor"))
            .register()
    }
}
