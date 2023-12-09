package net.minecraft.src;

public class SlotSharpening extends Slot {
    private EntityPlayer thePlayer;
    private final IInventory sharpMatrix;

    public SlotSharpening(EntityPlayer ply, IInventory inv, IInventory matrix, int i, int x, int y) {
        super(inv, i, x, y);
        this.thePlayer = ply;
        this.sharpMatrix = matrix;
    }

    public boolean isItemValid(ItemStack item) { return false; }

    public void onPickupFromSlot(ItemStack result) {
        result.onCrafting(this.thePlayer.worldObj, this.thePlayer);

        for (int i = 0; i < this.sharpMatrix.getSizeInventory(); ++i) {
            ItemStack item = this.sharpMatrix.getStackInSlot(i);
            if (item != null) this.sharpMatrix.decrStackSize(i, 1);
        }
    }
}
