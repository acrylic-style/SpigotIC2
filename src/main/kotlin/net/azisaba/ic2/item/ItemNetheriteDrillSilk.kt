package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.register
import org.bukkit.*
import org.bukkit.inventory.ItemStack

object ItemNetheriteDrillSilk : ItemDrill() {
    override fun registerRecipe() {
        shapedRecipe(
            "BTB",
            "DMD",
            "RDR",
        )
            .setIngredient('D', ItemStack(Material.NETHERITE_INGOT))
            .setIngredient('M', Items.DIAMOND_DRILL)
            .setIngredient('T', ItemStack(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
            .setIngredient('B', Items.VERY_BIG_MOTOR)
            .setIngredient('R', Items.RE_BATTERY)
            .build(IC2Plugin.key("netherite_drill_silk"))
            .register()
    }
}
