package net.farrucho.avaritia;

import net.fabricmc.api.ModInitializer;
import net.farrucho.avaritia.block.AvaritiaModBlocks;
import net.farrucho.avaritia.block.AvaritiaModItems;
import net.farrucho.avaritia.block.entity.ModBlockEntities;
import net.farrucho.avaritia.screen.ModScreenHandlers;
import net.farrucho.avaritia.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Avaritia implements ModInitializer {
	public static final String MOD_ID = "avaritia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		AvaritiaModBlocks.registerModBlock();
		AvaritiaModItems.registerModItems();
		ModBlockEntities.registerAllBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();
		ModLootTableModifiers.modifyLootTables();
	}
}
