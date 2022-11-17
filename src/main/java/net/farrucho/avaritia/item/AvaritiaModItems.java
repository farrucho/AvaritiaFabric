package net.farrucho.avaritia.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.farrucho.avaritia.Avaritia;
import net.farrucho.avaritia.item.custom.AvaritiaArmorItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AvaritiaModItems {
    public static final Item NEUTRON_PILE = registerItem("neutron_pile", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item DIAMOND_LATTICE = registerItem("diamond_lattice", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item CRYSTAL_MATRIX_INGOT = registerItem("crystal_matrix_ingot", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item SKULLFIRE_SWORD = registerItem("skullfire_sword", new SwordItem(ToolMaterials.DIAMOND, 3, -2.4f, new Item.Settings().group(Avaritia.AVARITIA_GROUP).fireproof()));

    public static final Item NEUTRONIUM_NUGGET = registerItem("neutronium_nugget", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item NEUTRONIUM_INGOT = registerItem("neutronium_ingot", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));
    // SINGULARITYS
    public static final Item IRON_SINGULARITY = registerItem("iron_singularity", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));
    public static final Item GOLD_SINGULARITY = registerItem("gold_singularity", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));
    public static final Item DIAMOND_SINGULARITY = registerItem("diamond_singularity", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));
    public static final Item QUARTZ_SINGULARITY = registerItem("quartz_singularity", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));
    public static final Item REDSTONE_SINGULARITY = registerItem("redstone_singularity", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));
    public static final Item EMERALD_SINGULARITY = registerItem("emerald_singularity", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));
    public static final Item LAPIS_SINGULARITY = registerItem("lapis_singularity", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item ULTIMATE_STEW = registerItem("ultimate_stew", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(20).saturationModifier(2f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6000, 2), 1.0f).build()).group(Avaritia.AVARITIA_GROUP)));

    public static final Item COSMIC_MEATBALLS = registerItem("cosmic_meatballs", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(20).saturationModifier(2f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 6000, 2), 1.0f).build()).group(Avaritia.AVARITIA_GROUP)));

    public static final Item ENDEST_PEARL = registerItem("endest_pearl", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item RECORD_FRAGMENT = registerItem("record_fragment", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item INFINITY_CATALYST = registerItem("infinity_catalyst", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP)));

    public static final Item INFINITY_INGOT = registerItem("infinity_ingot", new Item(new FabricItemSettings().group(Avaritia.AVARITIA_GROUP).fireproof()));

    public static final Item INFINITY_HELMET = registerItem("infinity_helmet",
            new AvaritiaArmorItem(AvaritiaArmorMaterials.INFINITY, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(Avaritia.AVARITIA_GROUP).fireproof()));//so é encessario mudar 1 item o resto nao

    public static final Item INFINITY_CHESTPLATE = registerItem("infinity_chestplate",
            new AvaritiaArmorItem(AvaritiaArmorMaterials.INFINITY, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(Avaritia.AVARITIA_GROUP).fireproof()));

    public static final Item INFINITY_LEGGINGS = registerItem("infinity_leggings",
            new AvaritiaArmorItem(AvaritiaArmorMaterials.INFINITY, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(Avaritia.AVARITIA_GROUP).fireproof()));

    public static final Item INFINITY_BOOTS = registerItem("infinity_boots",
            new AvaritiaArmorItem(AvaritiaArmorMaterials.INFINITY, EquipmentSlot.FEET,
                    new FabricItemSettings().group(Avaritia.AVARITIA_GROUP).fireproof()));






    //animacao mcmeta dos itens, têm uma virgula a mais no final, por isso é que dao erro!!!

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Avaritia.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Avaritia.LOGGER.debug("Registando items para " + Avaritia.MOD_ID);
    }

}
