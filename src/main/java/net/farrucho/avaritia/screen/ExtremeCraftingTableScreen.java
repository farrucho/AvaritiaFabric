package net.farrucho.avaritia.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.farrucho.avaritia.Avaritia;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

public class ExtremeCraftingTableScreen extends HandledScreen<ExtremeCraftingTableScreenHandler> {
    //A path to the gui texture. In this example we use the texture from the dispenser
    private static final Identifier TEXTURE = new Identifier(Avaritia.MOD_ID, "textures/gui/extreme_crafting_table_gui.png");


    protected boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
        return mouseX < (double)left || mouseY < (double)top || mouseX >= (double)(left + this.backgroundWidth) || mouseY >= (double)(top + this.backgroundHeight);
    }

    public ExtremeCraftingTableScreen(ExtremeCraftingTableScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, Text.of(""));
        this.backgroundWidth = 239;
        this.backgroundHeight = 256;
    }


    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - 256) / 2;
        int y = (height - 256) / 2;

        drawTexture(matrices, x, y, 0, 0, 256, 256);//256 é o tamanho dSa cenea
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);


        super.render(matrices, mouseX, mouseY, delta);


        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        //super.drawForeground(matrices, mouseX, mouseY);
    }




    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }


}
