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

object ItemDiamondDrill : ICItem() {
    override fun onInteract(e: PlayerInteractEvent) {
        if (e.action != Action.LEFT_CLICK_BLOCK || e.player.gameMode != GameMode.SURVIVAL) {
            // return if the player is not in survival mode or if the player is not left-clicking a block
            return
        }
        val block = e.clickedBlock!!
        val type = block.type
        if (!Tag.MINEABLE_SHOVEL.isTagged(type)) return
        if (!BlockBreakEvent(block, e.player).apply { Bukkit.getPluginManager().callEvent(this) }.isCancelled) {
            block.breakNaturally(e.item)
            val sound = when {
                type.name.contains("CONCRETE_POWDER") -> Sound.BLOCK_SAND_BREAK
                type.name.contains("SAND") -> Sound.BLOCK_SAND_BREAK
                type.name.contains("SNOW") -> Sound.BLOCK_SNOW_BREAK
                type == Material.ROOTED_DIRT -> Sound.BLOCK_ROOTED_DIRT_BREAK
                else -> if (Math.random() < 0.5) Sound.BLOCK_GRASS_BREAK else Sound.BLOCK_GRAVEL_BREAK
            }
            block.world.playSound(block.location, sound, 1F, 0.75F)
            block.world.spawnParticle(Particle.BLOCK_DUST, block.location, 64, 0.5, 0.5, 0.5, block.blockData)
            e.item!!.damage(e.player)
        }
    }

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
