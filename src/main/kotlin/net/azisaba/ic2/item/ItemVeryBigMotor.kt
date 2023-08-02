package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register

object ItemVeryBigMotor : ICItem() {
    override fun registerRecipe() {
        shapedRecipe(
            "MMM",
            "MMM",
            "MMM"
        )
            .setIngredient('M', Items.ELECTRIC_MOTOR)
            .build(IC2Plugin.key("very_big_motor"))
            .register()
    }
}
