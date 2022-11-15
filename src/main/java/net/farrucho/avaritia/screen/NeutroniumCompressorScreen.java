package net.farrucho.avaritia.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.farrucho.avaritia.Avaritia;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class NeutroniumCompressorScreen extends HandledScreen<NeutroniumCompressorScreenHandler> {
    //A path to the gui texture. In this example we use the texture from the dispenser
    private static final Identifier TEXTURE = new Identifier(Avaritia.MOD_ID, "textures/gui/neutronium_compressor_gui.png");


    public NeutroniumCompressorScreen(NeutroniumCompressorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(matrices, x, y);
        matrices.push();
        matrices.translate(x, y, 0);
        //textRenderer.draw(matrices, "Progress: " + String.valueOf(handler.getScaledProgress()) + "%",50,60,0);
        textRenderer.draw(matrices, String.valueOf((int)handler.getCurrentProgress()) + " / " + String.valueOf((int)handler.getMaxProgress()) ,65,60,0);
        matrices.pop();

    }

    private void renderProgressArrow(MatrixStack matrices, int x, int y) {
        if(handler.getCurrentProgress() > 0) {
            drawTexture(matrices, x + 90, y + 35, 176, 16, 18, (int) handler.getScaledProgressSingularity());
            drawTexture(matrices, x + 62, y + 34, 176, 0, (int) handler.getScaledProgressArrow(), 16);
        }
    }


    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }



    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
