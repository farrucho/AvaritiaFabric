package net.farrucho.avaritia.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.farrucho.avaritia.Avaritia;
import net.farrucho.avaritia.block.AvaritiaModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static  BlockEntityType<ExtremeCraftingTableBlockEntity> EXTREME_CRAFTING_TABLE;
    public static BlockEntityType<NeutronCollectorBlockEntity> NEUTRON_COLLECTOR;

    public static void registerAllBlockEntities(){
        NEUTRON_COLLECTOR = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Avaritia.MOD_ID, "neutron_collector"),
                FabricBlockEntityTypeBuilder.create(
                        NeutronCollectorBlockEntity::new, AvaritiaModBlocks.NEUTRON_COLLECTOR).build(null)
        );

        EXTREME_CRAFTING_TABLE = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Avaritia.MOD_ID, "extreme_crafting_table"),
                FabricBlockEntityTypeBuilder.create(
                        ExtremeCraftingTableBlockEntity::new, AvaritiaModBlocks.EXTREME_CRAFTING_TABLE).build(null)
        );



    }
}
