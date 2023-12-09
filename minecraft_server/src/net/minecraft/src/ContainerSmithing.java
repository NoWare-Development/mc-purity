package net.minecraft.src;

public class ContainerSmithing extends Container {
    public IInventory smithResult = new InventorySmithResult();
    public InventorySmithing slotsContainer =
        new InventorySmithing(this, 2);

    private World world;
    private int x, y, z;

    public ContainerSmithing(InventoryPlayer inv, World w, int i, int j, int k) {
        this.world = w;
        this.x = i;
        this.y = j;
        this.z = k;

        // armor [0]
        this.addSlot(new Slot(slotsContainer, 0, 54, 45));

        // upgrade slot [1]
        this.addSlot(new Slot(slotsContainer, 1, 54, 24));

        // smith result [2]
        this.addSlot(new SlotSmithing(inv.player,
                                      smithResult, slotsContainer,
                                      2, 112, 35));

        // Player inventory
        int pX, pY;
        for (pY = 0; pY < 3; ++pY) {
            for (pX = 0; pX < 9; ++pX) {
                this.addSlot(new Slot(inv, pX + pY * 9 + 9, 8 + pX * 18, 84 + pY * 18));
            }
        }

        for (pX = 0; pX < 9; ++pX)
            this.addSlot(new Slot(inv, pX, 8 + pX * 18, 142));

        this.onCraftMatrixChanged(this.slotsContainer);
    }

    public boolean canInteractWith(EntityPlayer ply) {
        return this.world.getBlockId(this.x, this.y, this.z) != Block.smithing.blockID
            ? false :
            ply.getDistanceSq((double)this.x + 0.5D,
                              (double)this.y + 0.5D,
                              (double)this.z + 0.5D) <= 64.0D;
    }

    public void onCraftGuiClosed(EntityPlayer ply) {
        super.onCraftGuiClosed(ply);
        if (!this.world.singleplayerWorld) {
            for (int i = 0; i < 2; ++i) {
                ItemStack item = this.slotsContainer.getStackInSlot(i);
                if (item != null) ply.dropPlayerItem(item);
            }
        }
    }

    public void onCraftMatrixChanged(IInventory inv) {
        this.smithResult.setInventorySlotContents(0,
                                                  CraftingManager.getInstance()
                                                  .findMatchingRecipeSmithing(this.slotsContainer));
    }

    public ItemStack func_27086_a(int id) {
        ItemStack item = null;
        Slot s = (Slot)this.inventorySlots.get(id);
        if (s != null && s.func_27006_b()) {
            ItemStack itemR = s.getStack();
            item = itemR.copy();

            if (itemR.stackSize == 0)
                s.putStack((ItemStack)null);
            else
                s.onSlotChanged();

            if (itemR.stackSize == item.stackSize) return null;

            s.onPickupFromSlot(itemR);
        }

        return item;
    }
}
