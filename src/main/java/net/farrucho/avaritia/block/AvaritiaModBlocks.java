package net.farrucho.avaritia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.farrucho.avaritia.Avaritia;
import net.farrucho.avaritia.block.custom.ExtremeCraftingTableBlock;
import net.farrucho.avaritia.block.custom.NeutronCollectorBlock;
import net.farrucho.avaritia.block.custom.NeutroniumCompressorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AvaritiaModBlocks {
    public static final Block NEUTRON_COLLECTOR = registerBlock("neutron_collector", new NeutronCollectorBlock(FabricBlockSettings.of(Material.STONE)),ItemGroup.MISC);

    public static final Block EXTREME_CRAFTING_TABLE = registerBlock("extreme_crafting_table", new ExtremeCraftingTableBlock(FabricBlockSettings.of(Material.STONE)),ItemGroup.MISC);

    public static final Block NEUTRONIUM_COMPRESSOR = registerBlock("neutronium_compressor", new NeutroniumCompressorBlock(FabricBlockSettings.of(Material.STONE)),ItemGroup.MISC);

    public static final Block COMPRESSED_CRAFTING_TABLE = registerBlock("compressed_crafting_table", new Block(FabricBlockSettings.of(Material.WOOD)),ItemGroup.MISC);

    public static final Block DOUBLE_COMPRESSED_CRAFTING_TABLE = registerBlock("double_compressed_crafting_table", new Block(FabricBlockSettings.of(Material.WOOD)),ItemGroup.MISC);

    public static final Block NEUTRONIUM_BLOCK = registerBlock("neutronium_block", new Block(FabricBlockSettings.of(Material.STONE)),ItemGroup.MISC);







    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Avaritia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Avaritia.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlock() {
        Avaritia.LOGGER.debug("Registando blocos para " + Avaritia.MOD_ID);

    }
}
