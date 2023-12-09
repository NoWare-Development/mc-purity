package net.minecraft.src;

public class ContainerBarrel extends Container {
  private TileEntityBarrel barrelInventory;

  public ContainerBarrel(InventoryPlayer ply, TileEntityBarrel barrel) {
    // Add barrel slots
    this.barrelInventory = barrel;
    this.addSlot(new Slot(barrel, 0, 38, 17)); // Water bucket slot
    this.addSlot(new Slot(barrel, 1, 123, 49)); // Output slot
    this.addSlot(new Slot(barrel, 2, 123, 17)); // Ingredient slot

    // Player slots
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

  public boolean isUsableByPlayer(EntityPlayer ply) {
    return this.barrelInventory.canInteractWith(ply);
  }

  public ItemStack getStackInSlot(int slot) {
    ItemStack item = null;
    Slot s = (Slot)this.slots.get(slot);
    if (s != null && s.getHasStack()) {
      ItemStack slotItem = s.getStack();
      item = slotItem.copy();
      if (slot == 2) {
        this.func_28125_a(slotItem, 3, 39, true);
      }
      else if (slot >= 3 && slot < 30) {
        this.func_28125_a(slotItem, 30, 39, false);
      }
      else if (slot >= 30 && slot < 39) {
        this.func_28125_a(slotItem, 3, 30, false);
      }
      else {
        this.func_28125_a(slotItem, 3, 39, false);
      }

      if (slotItem.stackSize == 0) {
        s.putStack((ItemStack)null);
      }
      else {
        s.onSlotChanged();
      }

      if (slotItem.stackSize == item.stackSize) return null;

      s.onPickupFromSlot(slotItem);
    }

    return item;
  }

  public void func_20112_a(int id, int value) {
    switch (id) {
    case 0:
      this.barrelInventory.ingredientFlags = (byte)value;
      break;
    case 1:
      this.barrelInventory.fluidLeft = (byte)value;
      break;
    default:
      break;
    }
  }
}
