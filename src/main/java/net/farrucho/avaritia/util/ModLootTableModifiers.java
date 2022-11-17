package net.farrucho.avaritia.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.farrucho.avaritia.item.AvaritiaModItems;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier SKELETON_ID
            = new Identifier("minecraft", "entities/skeleton");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(SKELETON_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
                                new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
                                        .mainhand(ItemPredicate.Builder.create().items(AvaritiaModItems.SKULLFIRE_SWORD).build()).build()).build()))
                                .with(ItemEntry.builder(Items.WITHER_SKELETON_SKULL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f,1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }

}
