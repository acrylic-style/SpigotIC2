package net.azisaba.ic2

import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.Tool
import io.papermc.paper.registry.keys.tags.BlockTypeTagKeys
import net.azisaba.ic2.item.*
import net.azisaba.ic2.registry.Registries
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.util.TriState
import org.bukkit.Material
import org.bukkit.Registry
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

@Suppress("UnstableApiUsage")
object Items {
    private val ENCH_WARNING = Component.text("注意: エンチャントするとクラフトに使用できなくなります", NamedTextColor.RED)
        .decorate(TextDecoration.BOLD)

    val FORGE_HAMMER = register(ItemForgeHammer, createItemStack(Material.IRON_HOE, "鍛冶ハンマー", "forge_hammer", lore = listOf(ENCH_WARNING)))
    val CUTTER = register(ItemCutter, createItemStack(Material.IRON_HOE, "カッター", "cutter", lore = listOf(ENCH_WARNING)))
    val IRON_PLATE = register(ItemIronPlate, createItemStack(Material.IRON_INGOT, "鉄板", "iron_plate"))
    val IRON_CASING = register(ItemIronCasing, createItemStack(Material.IRON_INGOT, "鉄キャスティング", "iron_casing"))
    val HV_CABLE = register(ItemHVCable, createItemStack(Material.IRON_INGOT, "高電圧ケーブル", "hv_cable"))
    val INSULATED_HV_CABLE = register(ItemInsulatedHVCable, createItemStack(Material.IRON_INGOT, "絶縁高電圧ケーブル", "insulated_hv_cable"))
    val COPPER_PLATE = register(ItemCopperPlate, createItemStack(Material.COPPER_INGOT, "銅板", "copper_plate"))
    val COPPER_CABLE = register(ItemCopperCable, createItemStack(Material.COPPER_INGOT, "銅のケーブル", "copper_cable"))
    val INSULATED_COPPER_CABLE = register(ItemInsulatedCopperCable, createItemStack(Material.COPPER_INGOT, "絶縁銅ケーブル", "insulated_copper_cable"))
    val ELECTRONIC_CIRCUIT = register(ItemElectronicCircuit, createItemStack(Material.IRON_INGOT, "電子回路", "electronic_circuit"))
    val COIL = register(ItemCoil, createItemStack(Material.IRON_INGOT, "コイル", "coil"))
    val ELECTRIC_MOTOR = register(ItemElectricMotor, createItemStack(Material.IRON_INGOT, "電動モーター", "electric_motor"))
    val RE_BATTERY = register(ItemReBattery, createItemStack(Material.IRON_INGOT, "充電池", "re_battery")).apply {
        setData(DataComponentTypes.MAX_STACK_SIZE, 1)
    }
    val POWER_UNIT = register(ItemPowerUnit, createItemStack(Material.IRON_INGOT, "パワーユニット", "power_unit"))
    val MINING_DRILL = register(ItemMiningDrill, createItemStack(Material.IRON_PICKAXE, "採掘ドリル", "mining_drill", lore = listOf(ENCH_WARNING)).apply {
        setData(DataComponentTypes.RARITY, ItemRarity.UNCOMMON)
        setData(DataComponentTypes.TOOL, Tool.tool()
            .addRule(Tool.rule(Registry.BLOCK.getTag(BlockTypeTagKeys.MINEABLE_SHOVEL), 6F + 5F, TriState.TRUE))
            .addRule(Tool.rule(Registry.BLOCK.getTag(BlockTypeTagKeys.MINEABLE_PICKAXE), 6F + 5F, TriState.TRUE))
            .defaultMiningSpeed(1.5F)
            .build())
    })
    val DIAMOND_DRILL = register(ItemDiamondDrill, createItemStack(Material.DIAMOND_PICKAXE, "ダイヤモンドドリル", "diamond_drill", lore = listOf(ENCH_WARNING)).apply {
        setData(DataComponentTypes.RARITY, ItemRarity.RARE)
        setData(DataComponentTypes.TOOL, Tool.tool()
            .addRule(Tool.rule(Registry.BLOCK.getTag(BlockTypeTagKeys.MINEABLE_SHOVEL), 8F + 65F, TriState.TRUE))
            .addRule(Tool.rule(Registry.BLOCK.getTag(BlockTypeTagKeys.MINEABLE_PICKAXE), 8F + 65F, TriState.TRUE))
            .defaultMiningSpeed(1.5F)
            .build())
    })
    val VERY_BIG_MOTOR = register(ItemVeryBigMotor, createItemStack(Material.IRON_INGOT, "クソデカモーター", "very_big_motor"))
    val NETHERITE_DRILL = register(ItemNetheriteDrill, createItemStack(Material.NETHERITE_PICKAXE, "ネザライトドリル", "netherite_drill_luck").apply {
        setData(DataComponentTypes.RARITY, ItemRarity.RARE)
        setData(DataComponentTypes.TOOL, Tool.tool()
            .addRule(Tool.rule(Registry.BLOCK.getTag(BlockTypeTagKeys.MINEABLE_SHOVEL), 8F + 101F, TriState.TRUE))
            .addRule(Tool.rule(Registry.BLOCK.getTag(BlockTypeTagKeys.MINEABLE_PICKAXE), 8F + 101F, TriState.TRUE))
            .defaultMiningSpeed(1.5F)
            .build())
    })

    private fun createItemStack(type: Material, displayName: String, itemModel: String = "", amount: Int = 1, lore: List<Component> = emptyList()) =
        ItemStack(type, amount).apply {
            itemMeta = itemMeta!!.apply {
                displayName(Component.text(displayName, NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, false))
                this.itemModel = IC2Plugin.key(itemModel)
                if (lore.isNotEmpty()) {
                    lore(lore.map { it.decoration(TextDecoration.ITALIC, false) })
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
