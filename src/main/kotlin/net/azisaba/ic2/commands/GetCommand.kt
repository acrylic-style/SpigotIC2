package net.azisaba.ic2.commands

import net.azisaba.ic2.registry.Registries
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object GetCommand : ICPlayerCommand {
    override val name = "get"

    override fun onCommand(player: Player, args: Array<out String>) {
        if (args.isEmpty()) {
            return player.sendMessage("${ChatColor.RED}/ic2 get <item id>")
        }
        val id = args[0].toInt()
        player.inventory.addItem(Registries.ITEM_STACK[id])
    }

    override fun suggest(sender: CommandSender, args: Array<out String>): List<String> {
        if (args.size == 1) {
            return Registries.ITEM.asList().mapIndexed { index, icItem -> "$index ($icItem)" }.filter { it.startsWith(args[0]) }
        }
        return emptyList()
    }
}
