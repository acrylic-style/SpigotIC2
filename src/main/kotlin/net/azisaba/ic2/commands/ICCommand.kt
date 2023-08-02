package net.azisaba.ic2.commands

import org.bukkit.command.CommandSender

interface ICCommand {
    val name: String

    fun onCommand(sender: CommandSender, args: Array<out String>)

    fun suggest(sender: CommandSender, args: Array<out String>): List<String>
}
