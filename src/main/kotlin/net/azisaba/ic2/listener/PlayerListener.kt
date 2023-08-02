package net.azisaba.ic2.listener

import net.azisaba.ic2.IC2Plugin
import net.azisaba.ic2.Items
import net.azisaba.ic2.registry.Registries
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

object PlayerListener : Listener {
    @EventHandler
    fun onPlayerInteract(e: PlayerInteractEvent) {
        val item = e.item ?: return
        val id = item.itemMeta?.persistentDataContainer?.get(IC2Plugin.itemIdKey, PersistentDataType.INTEGER) ?: return
        Registries.ITEM.getOrNull(id)?.onInteract(e)
    }

    @EventHandler
    fun onCraft(e: CraftItemEvent) {
        val matrix = arrayOfNulls<ItemStack>(e.inventory.matrix.size)
        e.inventory.matrix.forEachIndexed { index, item ->
            if (Items.FORGE_HAMMER.isSimilar(item) || Items.CUTTER.isSimilar(item)) {
                matrix[index] = item.clone()
            }
        }
        if (matrix.any { it != null }) {
            Bukkit.getScheduler().runTask(IC2Plugin.getInstance(), Runnable {
                matrix.forEachIndexed { index, item ->
                    if (item != null) {
                        e.inventory.setItem(index + 1, item)
                    }
                }
            })
        }
    }
}
