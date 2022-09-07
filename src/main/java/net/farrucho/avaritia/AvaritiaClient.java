package net.farrucho.avaritia;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.farrucho.avaritia.block.AvaritiaModBlocks;
import net.farrucho.avaritia.screen.ExtremeCraftingTableScreen;
import net.farrucho.avaritia.screen.ModScreenHandlers;
import net.farrucho.avaritia.screen.NeutronCollectorScreen;
import net.farrucho.avaritia.screen.NeutroniumCompressorScreen;
import net.minecraft.client.render.RenderLayer;

public class AvaritiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.NEUTRON_COLLECTOR_SCREEN_HANDLER, NeutronCollectorScreen::new);
        ScreenRegistry.register(ModScreenHandlers.EXTREME_CRAFTING_TABLE_SCREEN_HANDLER, ExtremeCraftingTableScreen::new);
        ScreenRegistry.register(ModScreenHandlers.NEUTRONIUM_COMPRESSOR_SCREEN_HANDLER, NeutroniumCompressorScreen::new);
    }
}
