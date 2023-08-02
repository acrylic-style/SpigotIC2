package net.azisaba.ic2.registry

import net.azisaba.ic2.item.ICItem
import org.bukkit.inventory.ItemStack

object Registries {
    val ITEM_STACK = WritableRegistry<ItemStack>()
    val ITEM = WritableRegistry<ICItem>()
}
