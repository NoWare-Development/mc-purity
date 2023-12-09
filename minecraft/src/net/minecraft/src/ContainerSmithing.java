package net.minecraft.src;

public class ContainerSmithing extends Container {
    public IInventory smithResult = new InventorySmithResult();
    public InventorySmithing slotsContainer =
        new InventorySmithing(this, 2);

    private World world;
    private int x;
    private int y;
    private int z;

    public ContainerSmithing(InventoryPlayer inv, World w, int x, int y, int z) {
        this.world = w;
        this.x = x;
        this.y = y;
        this.z = z;

        // armor [0]
        this.addSlot(new Slot(slotsContainer, 0, 54, 45));

        // upgradeSlot [1]
        this.addSlot(new Slot(slotsContainer, 1, 54, 24));

        // smithResult [2]
        this.addSlot(new SlotSmithing(inv.player,
                                      smithResult, slotsContainer,
                                      2, 112, 35));

        // Player Inventory
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

    public boolean isUsableByPlayer(EntityPlayer ply) {
        return this.world.getBlockId(this.x, this.y, this.z) != Block.smithing.blockID ? false :
            ply.getDistanceSq((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) <= 64.0D;
    }

    public void onCraftGuiClosed(EntityPlayer ply) {
        super.onCraftGuiClosed(ply);
        if (!this.world.multiplayerWorld) {
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

    public ItemStack getStackInSlot(int id) {
        ItemStack item = null;
        Slot s = (Slot)this.slots.get(id);
        if (s != null && s.getHasStack()) {
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
