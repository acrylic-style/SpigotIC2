package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register

object ItemPowerUnit : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            "RCI",
            "REM",
            "RCI",
        )
            .setIngredient('R', Items.RE_BATTERY)
            .setIngredient('C', Items.COPPER_CABLE)
            .setIngredient('I', Items.IRON_CASING)
            .setIngredient('E', Items.ELECTRONIC_CIRCUIT)
            .setIngredient('M', Items.ELECTRIC_MOTOR)
            .build(IC2Plugin.key("power_unit"))
            .register()
    }
}
