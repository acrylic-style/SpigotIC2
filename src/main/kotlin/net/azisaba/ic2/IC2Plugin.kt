package net.azisaba.ic2

import net.azisaba.ic2.commands.RootCommand
import net.azisaba.ic2.listener.PlayerListener
import net.azisaba.ic2.registry.Registries
import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin

class IC2Plugin : JavaPlugin() {
    companion object {
        lateinit var itemIdKey: NamespacedKey

        fun key(key: String) = NamespacedKey(getInstance(), key)

        fun getInstance() = getPlugin(IC2Plugin::class.java)

        fun getCustomModelData(key: String) = getInstance().config.getInt("custom-model-data.$key", -1).let {
            if (it == -1) null else it
        }
    }

    override fun onLoad() {
        itemIdKey = key("id")
    }

    override fun onEnable() {
        saveDefaultConfig()
        Items

        Bukkit.getPluginManager().registerEvents(PlayerListener, this)
        getCommand("ic2")!!.setExecutor(RootCommand)

        Registries.ITEM.createSequence().forEach { it.registerRecipe() }
    }
}
