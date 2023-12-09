package net.minecraft.src;

public class InventorySharpResult implements IInventory {
    private ItemStack[] sharpResult = new ItemStack[1];

    public int getSizeInventory() { return 1; }

    public ItemStack getStackInSlot(int index) { return this.sharpResult[0]; }

    public String getInvName() { return "Result"; }

    public ItemStack decrStackSize(int index, int i) {
        if (this.sharpResult[0] != null) {
            ItemStack result = this.sharpResult[0];
            this.sharpResult[0] = null;
            return result;
        }
        return null;
    }

    public void setInventorySlotContents(int index, ItemStack item) {
        this.sharpResult[0] = item;
    }

    public int getInventoryStackLimit() { return 1; }

    public void onInventoryChanged() {}

    public boolean canInteractWith(EntityPlayer ply) { return true; }
}
