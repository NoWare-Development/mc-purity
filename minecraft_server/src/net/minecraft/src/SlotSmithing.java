package net.minecraft.src;

public class SlotSmithing extends Slot {
    private EntityPlayer thePlayer;
    private final IInventory smithMatrix;

    public SlotSmithing(EntityPlayer ply,
                        IInventory inv,
                        IInventory matrix,
                        int index, int x, int y) {
        super(inv, index, x, y);
        this.thePlayer = ply;
        this.smithMatrix = matrix;
    }

    public boolean isItemValid(ItemStack item) { return false; }

    public void onPickupFromSlot(ItemStack result) {
        result.func_28142_b(this.thePlayer.worldObj, this.thePlayer);
        for (int i = 0; i < this.smithMatrix.getSizeInventory(); ++i) {
            ItemStack item = this.smithMatrix.getStackInSlot(i);
            if (item != null) {
                this.smithMatrix.decrStackSize(i, 1);
            }
        }
    }
}
