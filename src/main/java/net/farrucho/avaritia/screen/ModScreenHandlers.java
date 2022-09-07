package net.farrucho.avaritia.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.farrucho.avaritia.Avaritia;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<NeutronCollectorScreenHandler> NEUTRON_COLLECTOR_SCREEN_HANDLER;
    public static ScreenHandlerType<ExtremeCraftingTableScreenHandler> EXTREME_CRAFTING_TABLE_SCREEN_HANDLER;
    public static ScreenHandlerType<NeutroniumCompressorScreenHandler> NEUTRONIUM_COMPRESSOR_SCREEN_HANDLER;


    public static void registerAllScreenHandlers() {
        NEUTRON_COLLECTOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Avaritia.MOD_ID, "neutron_collector"), NeutronCollectorScreenHandler::new);
        EXTREME_CRAFTING_TABLE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Avaritia.MOD_ID, "extreme_crafting_table"), ExtremeCraftingTableScreenHandler::new);
        NEUTRONIUM_COMPRESSOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Avaritia.MOD_ID, "neutronium_compressor"), NeutroniumCompressorScreenHandler::new);
    }
}

