package net.farrucho.avaritia.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.farrucho.avaritia.Avaritia;
import net.farrucho.avaritia.block.custom.NeutronCollectorBlock;
import net.farrucho.avaritia.item.ModToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AvaritiaModItems {
    public static final Item NEUTRON_PILE = registerItem("neutron_pile", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item DIAMOND_LATTICE = registerItem("diamond_lattice", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item CRYSTAL_MATRIX_INGOT = registerItem("crystal_matrix_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item SKULLFIRE_SWORD = registerItem("skullfire_sword", new SwordItem(ModToolMaterial.SKULLFIRE, 3, -2.4f, new Item.Settings().group(ItemGroup.MISC).fireproof()));

    public static final Item NEUTRONIUM_NUGGET = registerItem("neutronium_nugget", new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item NEUTRONIUM_INGOT = registerItem("neutronium_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));






    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Avaritia.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Avaritia.LOGGER.debug("Registando items para " + Avaritia.MOD_ID);

    }
}
