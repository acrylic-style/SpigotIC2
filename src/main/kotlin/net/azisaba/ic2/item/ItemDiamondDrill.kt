package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.damage
import net.azisaba.ic2.util.register
import org.bukkit.*
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

object ItemDiamondDrill : ItemDrill() {
    override fun registerRecipe() {
        shapedRecipe(
            " D ",
            "DMD",
        )
            .setIngredient('D', ItemStack(Material.DIAMOND))
            .setIngredient('M', Items.MINING_DRILL)
            .build(IC2Plugin.key("diamond_drill"))
            .register()
    }
}
