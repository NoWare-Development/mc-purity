package net.minecraft.src;

public class InventorySmithing implements IInventory {
    private ItemStack[] stackList;
    private Container eventHandler;
    private int size;

    public InventorySmithing(Container hand, int s) {
        this.size = s;
        this.stackList = new ItemStack[s];
        this.eventHandler = hand;
    }

    public void makeSlotEmpty(int i) {
        if (i >= 0 && i < this.size && i < this.getSizeInventory())
            this.stackList[i] = null;
    }

    public int getSizeInventory() { return this.stackList.length; }

    public ItemStack getStackInSlot(int index) {
        return index >= this.getSizeInventory()
            ? null
            : this.stackList[index];
    }

    public String getInvName() { return "Smithing"; }

    public ItemStack decrStackSize(int id, int n) {
        if (this.stackList[id] != null) {
            ItemStack item;
            if (this.stackList[id].stackSize <= n) {
                item = this.stackList[id];
                this.stackList[id] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return item;
            }
            item = this.stackList[id].splitStack(n);
            if (this.stackList[id].stackSize == 0)
                this.stackList[id] = null;

            this.eventHandler.onCraftMatrixChanged(this);
            return item;
        }

        return null;
    }

    public void setInventorySlotContents(int id, ItemStack item) {
        this.stackList[id] = item;
        this.eventHandler.onCraftMatrixChanged(this);
    }

    public int getInventoryStackLimit() { return 64; }

    public void onInventoryChanged() {  }

    public boolean canInteractWith(EntityPlayer ply) { return true; }
}
