package net.azisaba.ic2.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor

object RootCommand : TabExecutor {
    private val commands = listOf(GetCommand, RemoveRecipeCommand, RegisterRecipesCommand)

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("${ChatColor.RED}/ic2 <arguments>")
            return true
        }
        val cmd = commands.find { it.name == args[0] } ?: run {
            sender.sendMessage("${ChatColor.RED}Unknown sub-command: ${args[0]}")
            return true
        }
        cmd.onCommand(sender, args.slice(1..<args.size).toTypedArray())
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): List<String> {
        if (args.size == 1) {
            return commands.map { it.name }.filter { sender.hasPermission("ic2.command.$it") }.filter { it.startsWith(args[0]) }
        }
        if (args.size >= 2) {
            return commands.filter { sender.hasPermission("ic2.command.${it.name}") }
                .find { it.name == args[0] }?.suggest(sender, args.slice(1..<args.size).toTypedArray()) ?: emptyList()
        }
        return emptyList()
    }
}
