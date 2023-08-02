package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemCopperPlate : ICItem() {
    override fun registerRecipe() {
        shapelessRecipe()
            .addIngredient(Items.FORGE_HAMMER)
            .addIngredient(ItemStack(Material.COPPER_INGOT))
            .build(IC2Plugin.key("copper_plate"))
            .register()
    }
}
