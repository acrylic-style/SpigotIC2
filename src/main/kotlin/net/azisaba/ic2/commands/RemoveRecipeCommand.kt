package net.azisaba.ic2.commands

import net.azisaba.ic2.IC2Plugin
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

object RemoveRecipeCommand : ICCommand {
    override val name = "removeRecipe"

    override fun onCommand(sender: CommandSender, args: Array<out String>) {
        val key = IC2Plugin.key(args[0])
        Bukkit.removeRecipe(key)
    }

    override fun suggest(sender: CommandSender, args: Array<out String>): List<String> {
        return emptyList()
    }
}
