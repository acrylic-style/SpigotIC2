package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register

object ItemIronCasing : ICItem() {
    override fun registerRecipe() {
        shapelessRecipe(2)
            .addIngredient(Items.FORGE_HAMMER)
            .addIngredient(Items.IRON_PLATE)
            .build(IC2Plugin.key("iron_casing"))
            .register()
    }
}
