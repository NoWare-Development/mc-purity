package net.minecraft.src;

public class ItemFluid extends ItemFood {
  protected ItemFluid(int id, int heal) {
    super(id, heal, false);
  }

  public ItemStack onItemRightClick(ItemStack item, World w, EntityPlayer ply) {
    super.onItemRightClick(item, w, ply);
    ply.inventory.addItemStackToInventory(new ItemStack(Item.bottle, 1));
    return item;
  }
}
