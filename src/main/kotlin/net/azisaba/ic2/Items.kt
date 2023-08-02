package net.azisaba.ic2

import net.azisaba.ic2.item.*
import net.azisaba.ic2.registry.Registries
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

object Items {
    val FORGE_HAMMER = register(ItemForgeHammer, createItemStack(Material.IRON_HOE, "Forge Hammer", "forge-hammer"))
    val CUTTER = register(ItemCutter, createItemStack(Material.IRON_HOE, "Cutter", "cutter"))
    val IRON_PLATE = register(ItemIronPlate, createItemStack(Material.IRON_INGOT, "Iron Plate", "iron-plate"))
    val IRON_CASING = register(ItemIronCasing, createItemStack(Material.IRON_INGOT, "Iron Casing", "iron-casing"))
    val HV_CABLE = register(ItemHVCable, createItemStack(Material.IRON_INGOT, "HV Cable", "hv-cable"))
    val INSULATED_HV_CABLE = register(ItemInsulatedHVCable, createItemStack(Material.IRON_INGOT, "Insulated HV Cable", "insulated-hv-cable"))
    val COPPER_PLATE = register(ItemCopperPlate, createItemStack(Material.COPPER_INGOT, "Copper Plate", "copper-plate"))
    val COPPER_CABLE = register(ItemCopperCable, createItemStack(Material.COPPER_INGOT, "Copper Cable", "copper-cable"))
    val INSULATED_COPPER_CABLE = register(ItemInsulatedCopperCable, createItemStack(Material.COPPER_INGOT, "Insulated Copper Cable", "insulated-copper-cable"))
    val ELECTRONIC_CIRCUIT = register(ItemElectronicCircuit, createItemStack(Material.IRON_INGOT, "Electronic Circuit", "electronic-circuit"))
    val COIL = register(ItemCoil, createItemStack(Material.IRON_INGOT, "Coil", "coil"))
    val ELECTRIC_MOTOR = register(ItemElectricMotor, createItemStack(Material.IRON_INGOT, "Electric Motor", "electric-motor"))
    val RE_BATTERY = register(ItemReBattery, createItemStack(Material.SADDLE, "RE Battery", "re-battery"))
    val POWER_UNIT = register(ItemPowerUnit, createItemStack(Material.IRON_INGOT, "Power Unit", "power-unit"))
    val MINING_DRILL = register(ItemMiningDrill, createItemStack(Material.IRON_PICKAXE, "Mining Drill", "mining-drill"))
    val DIAMOND_DRILL = register(ItemDiamondDrill, createItemStack(Material.DIAMOND_PICKAXE, "Diamond Drill", "diamond-drill").apply {
        itemMeta = itemMeta!!.apply {
            addEnchant(Enchantment.DIG_SPEED, 8, true)
        }
    })
    val VERY_BIG_MOTOR = register(ItemVeryBigMotor, createItemStack(Material.IRON_INGOT, "クソデカモーター", "very-big-motor"))
    val NETHERITE_DRILL_LUCK = register(ItemNetheriteDrillLuck, createItemStack(Material.NETHERITE_PICKAXE, "ネザライトドリル", "netherite-drill-luck").apply {
        itemMeta = itemMeta!!.apply {
            addEnchant(Enchantment.DIG_SPEED, 10, true)
            addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true)
        }
    })
    val NETHERITE_DRILL_SILK = register(ItemNetheriteDrillSilk, createItemStack(Material.NETHERITE_PICKAXE, "ネザライトドリル", "netherite-drill-silk").apply {
        itemMeta = itemMeta!!.apply {
            addEnchant(Enchantment.DIG_SPEED, 10, true)
            addEnchant(Enchantment.SILK_TOUCH, 1, true)
        }
    })

    private fun createItemStack(type: Material, displayName: String, customModelDataKey: String = "", customModelData: Int? = null, amount: Int = 1, lore: List<String> = emptyList()) =
        ItemStack(type, amount).apply {
            itemMeta = itemMeta!!.apply {
                setDisplayName("${ChatColor.WHITE}$displayName")
                setCustomModelData(customModelData ?: IC2Plugin.getCustomModelData(customModelDataKey))
                if (lore.isNotEmpty()) {
                    setLore(lore)
                }
            }
        }

    private fun register(icItem: ICItem, item: ItemStack): ItemStack {
        Registries.ITEM.register(icItem)
        return item.apply {
            val id = Registries.ITEM_STACK.register(this)
            itemMeta = itemMeta!!.apply {
                persistentDataContainer.set(IC2Plugin.itemIdKey, PersistentDataType.INTEGER, id)
            }
        }
    }
}
