package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiBarrel extends GuiContainer {
  private TileEntityBarrel barrelInventory;

  private float[] brewColor = {0.0F, 0.0F, 0.0F};
  private int fluidNotFilled = 0;

  public GuiBarrel(InventoryPlayer inventory, TileEntityBarrel barrel) {
    super(new ContainerBarrel(inventory, barrel));
    this.barrelInventory = barrel;
  }

  protected void drawGuiContainerForegroundLayer() {
    this.fontRenderer.drawString("Barrel", 8, 6, 4210752);
    this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
  }

  protected void drawGuiContainerBackgroundLayer(float f) {
    int texture = this.mc.renderEngine.getTexture("/gui/barrel.png");
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.renderEngine.bindTexture(texture);
    int startX = (this.width - this.xSize) / 2;
    int startY = (this.height - this.ySize) / 2;
    this.drawTexturedModalRect(startX, startY, 0, 0, this.xSize, this.ySize);

    this.drawFluid(startX, startY);
    this.drawIcons(startX, startY);
  }

  private void drawFluid(int sX, int sY) {
    if (this.barrelInventory.fluidLeft > 0) {
      this.updateBrewColor();
      GL11.glColor4f(this.brewColor[0],
                     this.brewColor[1],
                     this.brewColor[2], 1.0F);
      this.fluidNotFilled = 5 - this.barrelInventory.fluidLeft;
      int offsetY = this.fluidNotFilled * 9;
      this.drawTexturedModalRect(sX + 82, sY + 19 + offsetY, this.xSize, 18 + offsetY, 13, 45);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
  }

  private void drawIcons(int sX, int sY) {
    if (barrelInventory.getStackInSlot(0) == null)
      this.drawTexturedModalRect(sX + 37, sY + 16, this.xSize, 0, 18, 18);

    if (barrelInventory.getStackInSlot(1) == null)
      this.drawTexturedModalRect(sX + 122, sY + 48, this.xSize + 18, 0, 18, 18);
  }

  private void updateBrewColor() {
    switch (this.barrelInventory.ingredientFlags) {
    case 0b11:
      this.brewColor[0] = 0.5F;
      this.brewColor[1] = 0.15F;
      this.brewColor[2] = 0.25F;
      break;
    case 0b101:
      this.brewColor[0] = 0.83F;
      this.brewColor[1] = 0.73F;
      this.brewColor[2] = 0.38F;
      break;
    case 0b1001:
      this.brewColor[0] = 0.48F;
      this.brewColor[1] = 0.35F;
      this.brewColor[2] = 0.11F;
      break;
    case 0b10001:
      this.brewColor[0] = 0.73F;
      this.brewColor[1] = 0.76F;
      this.brewColor[2] = 0.23F;
      break;
    default:
      if (this.barrelInventory.ingredientFlags == 0b1 || this.barrelInventory.ingredientFlags == 0b0) {
        this.brewColor[0] = 0.215F;
        this.brewColor[1] = 0.215F;
        this.brewColor[2] = 0.85F;
        break;
      }
      this.brewColor[0] = 0.55F;
      this.brewColor[1] = 0.48F;
      this.brewColor[2] = 0.11F;
      break;
    }
  }
}
