package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register

object ItemHVCable : ICItem() {
    override fun registerRecipe() {
        shapelessRecipe(2)
            .addIngredient(Items.CUTTER)
            .addIngredient(Items.IRON_PLATE)
            .build(IC2Plugin.key("hv_cable"))
            .register()
    }
}
