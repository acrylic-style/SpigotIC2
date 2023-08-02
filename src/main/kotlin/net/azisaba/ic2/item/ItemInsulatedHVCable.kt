package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemInsulatedHVCable : ICItem() {
    override fun registerRecipe() {
        shapelessRecipe()
            .addIngredient(Items.HV_CABLE)
            .addIngredient(ItemStack(Material.SLIME_BALL))
            .build(IC2Plugin.key("insulated_hv_cable"))
            .register()
    }
}
