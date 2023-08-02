package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemReBattery : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            " C ",
            "ARA",
            "ARA",
        )
            .setIngredient('C', Items.INSULATED_HV_CABLE)
            .setIngredient('A', Items.IRON_CASING)
            .setIngredient('R', ItemStack(Material.REDSTONE))
            .build(IC2Plugin.key("re_battery"))
            .register()
    }
}
