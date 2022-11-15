package net.farrucho.avaritia;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.farrucho.avaritia.block.AvaritiaModBlocks;
import net.farrucho.avaritia.block.AvaritiaModItems;
import net.farrucho.avaritia.block.entity.ModBlockEntities;
import net.farrucho.avaritia.screen.ModScreenHandlers;
import net.farrucho.avaritia.util.ModLootTableModifiers;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Avaritia implements ModInitializer {
	public static final String MOD_ID = "avaritia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final ItemGroup AVARITIA_GROUP = FabricItemGroupBuilder.create(
					new Identifier(MOD_ID, "avaritia_group"))
			.icon(() -> new ItemStack(AvaritiaModBlocks.EXTREME_CRAFTING_TABLE.asItem(),1))
			.build();

	@Override
	public void onInitialize() {
		AvaritiaModBlocks.registerModBlock();
		AvaritiaModItems.registerModItems();
		ModBlockEntities.registerAllBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();
		ModLootTableModifiers.modifyLootTables();
	}
}
