package net.azisaba.ic2.item

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.util.damage
import net.azisaba.ic2.util.register
import org.bukkit.*
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent

object ItemMiningDrill : ItemDrill() {
    override fun registerRecipe() {
        shapedRecipe(
            " I ",
            "III",
            "IPI",
        )
            .setIngredient('I', Items.IRON_PLATE)
            .setIngredient('P', Items.POWER_UNIT)
            .build(IC2Plugin.key("mining_drill"))
            .register()
    }
}
