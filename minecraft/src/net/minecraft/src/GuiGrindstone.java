package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiGrindstone extends GuiContainer {
    public GuiGrindstone(InventoryPlayer inv, World w, int i, int j, int k) {
        super(new ContainerGrindstone(inv, w, i, j, k));
    }

    public void onGuiClosed() {
        super.onGuiClosed();
        this.inventorySlots.onCraftGuiClosed(this.mc.thePlayer);
    }

    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Grindstone", 8, 6, 4210752);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float i) {
        int tex = this.mc.renderEngine.getTexture("/gui/sharpening.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(tex);
        int w = (this.width - this.xSize) / 2;
        int h = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(w, h, 0, 0, this.xSize, this.ySize);

        ContainerGrindstone inv = (ContainerGrindstone)this.inventorySlots;
        if (inv.slotsContainer.getStackInSlot(0) == null)
            this.drawTexturedModalRect(w + 57, h + 45, this.xSize, 0, 18, 18);
        if (inv.slotsContainer.getStackInSlot(1) == null)
            this.drawTexturedModalRect(w + 57, h + 23, this.xSize + 36, 0, 18, 18);
        if (inv.slotsContainer.getStackInSlot(2) == null)
            this.drawTexturedModalRect(w + 35, h + 45, this.xSize + 18, 0, 18, 18);
    }
}
