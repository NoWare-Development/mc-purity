package net.minecraft.src;

public class TileEntityBarrel extends TileEntity implements IInventory {
  /*
   * Item stacks mapping
   * 0 - water bucket slot
   * 1 - output (bottle)
   * 2 - ingredients
   */
  private ItemStack[] barrelItemStacks = new ItemStack[3];

  public byte ingredientFlags = 0;
  public byte fluidLeft = 0;

  public int getSizeInventory() {
    return this.barrelItemStacks.length;
  }

  public ItemStack getStackInSlot(int slot) {
    return this.barrelItemStacks[slot];
  }

  public ItemStack decrStackSize(int slot, int size) {
    if (this.barrelItemStacks[slot] == null) return null;

    ItemStack item;
    if (this.barrelItemStacks[slot].stackSize <= size) {
      item = this.barrelItemStacks[slot];
      this.barrelItemStacks[slot] = null;
      return item;
    }

    item = this.barrelItemStacks[slot].splitStack(size);
    if (this.barrelItemStacks[slot].stackSize == 0)
      this.barrelItemStacks[slot] = null;

    return item;
  }

  public void setInventorySlotContents(int slot, ItemStack item) {
    this.barrelItemStacks[slot] = item;
    if (item != null && item.stackSize > this.getInventoryStackLimit())
      item.stackSize = this.getInventoryStackLimit();
  }

  public String getInvName() {
    return "Barrel";
  }

  public void readFromNBT(NBTTagCompound nbt) {
    super.readFromNBT(nbt);
    NBTTagList list = nbt.getTagList("Items");
    this.barrelItemStacks = new ItemStack[this.getSizeInventory()];

    for (int i = 0; i < list.tagCount(); i++) {
      NBTTagCompound tag = (NBTTagCompound)list.tagAt(i);
      byte slot = tag.getByte("Slot");
      if (slot >= 0 && slot < this.barrelItemStacks.length)
        this.barrelItemStacks[slot] = new ItemStack(tag);
    }

    if ((this.fluidLeft = nbt.getByte("FluidLeft")) > 0)
      this.ingredientFlags = nbt.getByte("IngredientFlags");
  }

  public void writeToNBT(NBTTagCompound nbt) {
    super.writeToNBT(nbt);

    nbt.setByte("FluidLeft", this.fluidLeft);
    if (this.fluidLeft > 0)
      nbt.setByte("IngredientFlags", this.ingredientFlags);

    NBTTagList tags = new NBTTagList();
    for (int i = 0; i < this.barrelItemStacks.length; i++) {
      if (this.barrelItemStacks[i] != null) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setByte("Slot", (byte)i);
        this.barrelItemStacks[i].writeToNBT(tag);
        tags.setTag(tag);
      }
    }

    nbt.setTag("Items", tags);
  }

  public int getInventoryStackLimit() { return 1; }

  public boolean canInteractWith(EntityPlayer ply) {
    return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false :
      ply.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
  }

  public void updateEntity() {
    if (!this.worldObj.singleplayerWorld) {
      if (this.barrelItemStacks[0] != null &&
          this.barrelItemStacks[0].itemID == Item.bucketWater.shiftedIndex &&
          this.fluidLeft < 5) {
        this.fluidLeft = 5;
        this.ingredientFlags = 0;
        this.barrelItemStacks[0] = new ItemStack(Item.bucketEmpty, 1);
      }

      if (this.fluidLeft > 0) {
        if (this.barrelItemStacks[2] != null)
          this.addIngredients();

        if (this.barrelItemStacks[1] != null &&
            this.barrelItemStacks[1].itemID == Item.bottle.shiftedIndex)
          this.brew();
      }
      else
        this.ingredientFlags = 0;
    }
  }

  private void addIngredients() {
    switch (this.barrelItemStacks[2].itemID) {
    case 256 + 40:
      this.ingredientFlags |= 0b100;
      break;
    case 256 + 41:
      this.ingredientFlags |= 0b1000;
      break;
    case 256 + 97:
      this.ingredientFlags |= 0b1;
      break;
    case 256 + 3041:
      this.ingredientFlags |= 0b10;
      break;
    case 256 + 4:
      this.ingredientFlags |= 0b10000;
      break;
    default:
      return;
    }

    this.barrelItemStacks[2] = null;
  }

  private void brew() {
    switch (this.ingredientFlags) {
    case 0b11:
      this.barrelItemStacks[1] = new ItemStack(Item.wine, 1);
      break;
    case 0b101:
      this.barrelItemStacks[1] = new ItemStack(Item.beer, 1);
      break;
    case 0b1001:
      this.barrelItemStacks[1] = new ItemStack(Item.kvass, 1);
      break;
    case 0b10001:
      this.barrelItemStacks[1] = new ItemStack(Item.cider, 1);
      break;
    default:
      if (this.ingredientFlags == 0b1 || this.ingredientFlags == 0b0)
        return;
      this.barrelItemStacks[1] = new ItemStack(Item.unknownBrew, 1);
      break;
    }
    this.fluidLeft--;
  }
}
