package com.jemmerl.jemsmachinecore.test.client.gui.screen;

import com.jemmerl.jemsmachinecore.JemsMachineCore;
import com.jemmerl.jemsmachinecore.test.inventory.container.TestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class TestScreen extends ContainerScreen<TestContainer> {
    private final ResourceLocation GUI = new ResourceLocation(JemsMachineCore.MOD_ID, "textures/gui/test_gui.png");

    public TestScreen(TestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int left = this.guiLeft;
        int top = this.guiTop;
        this.blit(matrixStack, left, top, 0, 0, this.xSize, this.ySize);
        // This draws something on the screen
        // images are always 256x256, with extra stuff in the blank space


        this.blit(matrixStack, left + 82, top + 9, 176, 0, 13, 17);
        // u/v offset is where the image is being read from, uWidth/Height is the size of what is read, and x/y is where it is rendered
    }
}
