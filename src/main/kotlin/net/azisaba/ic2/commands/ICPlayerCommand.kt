package net.azisaba.ic2.commands

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

interface ICPlayerCommand : ICCommand {
    override fun onCommand(sender: CommandSender, args: Array<out String>) {
        if (sender !is Player) {
            return sender.sendMessage("${ChatColor.RED}You must be player to use this command")
        }
        onCommand(sender, args)
    }

    fun onCommand(player: Player, args: Array<out String>)
}
