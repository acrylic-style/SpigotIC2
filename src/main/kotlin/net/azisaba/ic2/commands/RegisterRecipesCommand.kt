package net.azisaba.ic2.commands

import net.azisaba.ic2.registry.Registries
import org.bukkit.command.CommandSender

object RegisterRecipesCommand : ICCommand {
    override val name = "registerRecipes"

    override fun onCommand(sender: CommandSender, args: Array<out String>) {
        Registries.ITEM.createSequence().forEach { it.registerRecipe() }
    }

    override fun suggest(sender: CommandSender, args: Array<out String>): List<String> {
        return emptyList()
    }
}
