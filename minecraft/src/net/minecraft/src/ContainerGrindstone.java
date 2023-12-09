package net.minecraft.src;

public class ContainerGrindstone extends Container {
    public IInventory sharpResult = new InventorySharpResult();
    public InventorySharpening slotsContainer = new InventorySharpening(this, 3);

    private World world;
    private int x, y, z;

    public ContainerGrindstone(InventoryPlayer inv, World w, int x, int y, int z) {
        this.world = w;
        this.x = x;
        this.y = y;
        this.z = z;

        // Slots
        // sword [0]
        this.addSlot(new Slot(this.slotsContainer, 0, 58, 46));
        // dust [1]
        this.addSlot(new Slot(this.slotsContainer, 1, 58, 24));
        // rock [2]
        this.addSlot(new Slot(this.slotsContainer, 2, 36, 46));
        // result [3]
        this.addSlot(new SlotSharpening(inv.player, sharpResult, slotsContainer, 3, 124, 35));

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
        return this.world.getBlockId(this.x, this.y, this.z) != Block.grindstone.blockID ? false :
            ply.getDistanceSq((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) <= 64.0D;
    }

    public void onCraftGuiClosed(EntityPlayer ply) {
        super.onCraftGuiClosed(ply);
        if (!this.world.multiplayerWorld) {
            for (int i = 0; i < 3; ++i) {
                ItemStack item = this.slotsContainer.getStackInSlot(i);
                if (item != null) ply.dropPlayerItem(item);
            }
        }
    }

    public void onCraftMatrixChanged(IInventory inv) {
        if (this.slotsContainer.getStackInSlot(0) != null &&
            this.slotsContainer.getStackInSlot(1) != null &&
            this.slotsContainer.getStackInSlot(2) != null) {
            if (this.slotsContainer.getStackInSlot(0).itemID == Item.ironSword.shiftedIndex &&
                this.slotsContainer.getStackInSlot(2).itemID == Item.rock.shiftedIndex &&
                this.slotsContainer.getStackInSlot(1).getItem() instanceof ItemDust) {
                Item itemResult;

                Item itemDust = this.slotsContainer.getStackInSlot(1).getItem();
                if (itemDust.shiftedIndex == Item.ironDust.shiftedIndex)
                    itemResult = Item.ironSwordI;
                else
                    itemResult = Item.ironSwordD;

                int itemDamage = this.slotsContainer.getStackInSlot(0).getItemDamage();
                ItemStack result = new ItemStack(itemResult, 1, itemDamage);

                this.sharpResult.setInventorySlotContents(0, result);
            }
        }
    }

    public ItemStack getStackInSlot(int id) {
        ItemStack item = null;
        Slot s = (Slot)this.slots.get(id);
        if (s != null && s.getHasStack()) {
            ItemStack itemB = s.getStack();
            item = itemB.copy();

            if (itemB.stackSize == 0)
                s.putStack((ItemStack)null);
            else
                s.onSlotChanged();

            if (itemB.stackSize == item.stackSize) return null;
            s.onPickupFromSlot(itemB);
        }
        return item;
    }
}
