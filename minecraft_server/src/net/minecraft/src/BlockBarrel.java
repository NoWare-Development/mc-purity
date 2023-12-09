package net.minecraft.src;

import java.util.Random;

public class BlockBarrel extends BlockContainer {
  private Random rand = new Random();

  protected BlockBarrel(int id) {
    super(id, Material.wood);
  }

  protected TileEntity getBlockEntity() {
    return new TileEntityBarrel();
  }

  public boolean blockActivated(World w, int x, int y, int z, EntityPlayer ply) {
    if (!w.singleplayerWorld) {
      TileEntityBarrel barrel = (TileEntityBarrel)w.getBlockTileEntity(x, y, z);
      ply.displayGUIBarrel(barrel);
    }

    return true;
  }

  public void onBlockRemoval(World w, int x, int y, int z) {
    TileEntityBarrel ent = (TileEntityBarrel)w.getBlockTileEntity(x, y, z);

    for (int i = 0; i < ent.getSizeInventory(); i++) {
      ItemStack item = ent.getStackInSlot(i);
      if (item != null) {
        float a = this.rand.nextFloat() * 0.8F + 0.1F;
        float b = this.rand.nextFloat() * 0.8F + 0.1F;
        float c = this.rand.nextFloat() * 0.8F + 0.1F;

        while (item.stackSize > 0) {
          int size = this.rand.nextInt(21) + 10;
          if (size > item.stackSize) size = item.stackSize;
          item.stackSize -= size;

          EntityItem dropped = new EntityItem(w, (double)((float)x + a), (double)((float)y + b), (double)((float)z + c), new ItemStack(item.itemID, size, item.getItemDamage()));
          float vel = 0.05F;
          dropped.motionX = (double)((float)this.rand.nextGaussian() * vel);
          dropped.motionY = (double)((float)this.rand.nextGaussian() * vel + 0.2F);
          dropped.motionZ = (double)((float)this.rand.nextGaussian() * vel);
          w.entityJoinedWorld(dropped);
        }
      }
    }

    super.onBlockRemoval(w, x, y, z);
  }
}
