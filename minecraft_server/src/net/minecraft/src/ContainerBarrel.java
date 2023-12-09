package net.minecraft.src;

public class ContainerBarrel extends Container {
  private TileEntityBarrel barrelInventory;
  private ICrafting ic;

  public ContainerBarrel(InventoryPlayer ply, TileEntityBarrel barrel) {
    this.barrelInventory = barrel;
    this.addSlot(new Slot(barrel, 0, 38, 17));
    this.addSlot(new Slot(barrel, 1, 123, 49));
    this.addSlot(new Slot(barrel, 2, 123, 17));

    int i;
    for (i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++) {
        this.addSlot(new Slot(ply, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
      }
    }

    for (i = 0; i < 9; i++) {
      this.addSlot(new Slot(ply, i, 8 + i * 18, 142));
    }
  }

  public void onCraftGuiOpened(ICrafting ic) {
    super.onCraftGuiOpened(ic);
    this.ic = ic;
    ic.updateCraftingInventoryInfo(this, 0, this.barrelInventory.ingredientFlags);
    ic.updateCraftingInventoryInfo(this, 1, this.barrelInventory.fluidLeft);
  }

  public boolean canInteractWith(EntityPlayer ply) {
    return this.barrelInventory.canInteractWith(ply);
  }

  public void updateCraftingMatrix() {
    super.updateCraftingMatrix();
    for (int i = 0; i < this.crafters.size(); i++) {
      ICrafting crafter = (ICrafting)this.crafters.get(i);
      crafter.updateCraftingInventoryInfo(this, 0, this.barrelInventory.ingredientFlags);
      crafter.updateCraftingInventoryInfo(this, 1, this.barrelInventory.fluidLeft);
    }
  }

  public ItemStack func_27086_a(int slot) {
    ItemStack item = null;
    Slot s = (Slot)this.inventorySlots.get(slot);
    if (s != null && s.func_27006_b()) {
      ItemStack slotItem = s.getStack();
      item = slotItem.copy();
      if (slot == 2) {
        this.func_28126_a(slotItem, 3, 39, true);
      }
      else if (slot >= 3 && slot < 30) {
        this.func_28126_a(slotItem, 30, 39, false);
      }
      else if (slot >= 30 && slot < 39) {
        this.func_28126_a(slotItem, 3, 30, false);
      }
      else {
        this.func_28126_a(slotItem, 3, 39, false);
      }

      if (slotItem.stackSize == 0)
        s.putStack((ItemStack)null);
      else
        s.onSlotChanged();

      if (slotItem.stackSize == item.stackSize)
        return null;

      s.onPickupFromSlot(slotItem);
    }

    this.ic.updateCraftingInventoryInfo(this, 0, this.barrelInventory.ingredientFlags);
    this.ic.updateCraftingInventoryInfo(this, 1, this.barrelInventory.fluidLeft);

    return item;
  }
}
