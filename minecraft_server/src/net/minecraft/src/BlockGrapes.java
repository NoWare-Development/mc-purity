package net.minecraft.src;

import java.util.Random;

public class BlockGrapes extends Block {
  protected BlockGrapes(int id) {
    super(id, Material.leaves);
    this.setTickOnLoad(true);
  }

  private boolean isGrown(World w, int x, int y, int z) {
    return w.getBlockMetadata(x, y, z) == 1 ? true : false;
  }

  public int quantityDropped(Random rand) {
    return rand.nextInt(10) == 0 ? 1 : 0;
  }

  public int idDropped(int i, Random rand) {
    return Block.grapeBushSapling.blockID;
  }

  public void harvestBlock(World w, EntityPlayer ply, int x, int y, int z, int a) {
    if (!w.singleplayerWorld) {
      Random rand = new Random();

      if (ply.getCurrentEquippedItem() != null &&
          ply.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex) {
        ply.addStat(StatList.mineBlockStatArray[this.blockID], 1);
        this.dropBlockAsItem_do(w, x, y, z, new ItemStack(Block.grapeLeaves.blockID, 1, 0));
      }
      else {
        if (rand.nextInt(10) == 0) {
          EntityItem sapling = new EntityItem(w, (double)x, (double)y, (double)z, new ItemStack(Block.grapeBushSapling));
          sapling.delayBeforeCanPickup = 10;
          w.entityJoinedWorld(sapling);
        }
      }

      if (this.isGrown(w, x, y, z)) {
        EntityItem grapes = new EntityItem(w, (double)x, (double)y, (double)z, new ItemStack(Item.grape, 1 + rand.nextInt(4)));
        grapes.delayBeforeCanPickup = 10;
        w.entityJoinedWorld(grapes);
      }
    }
    else {
      super.harvestBlock(w, ply, x, y, z, a);
    }
  }

  public void updateTick(World w, int x, int y, int z, Random rand) {
    super.updateTick(w, x, y, z, rand);
    if (!this.isGrown(w, x, y, z) && (w.getBlockLightValue(x, y + 1, z) >= 9 || getIsBlockSolid(w, x, y, z, 0)) && rand.nextInt(50) == 0) {
      w.setBlockMetadataWithNotify(x, y, z, 1);
    }
  }

  public void onBlockClicked(World w, int x, int y, int z, EntityPlayer ply) {
    this.blockActivated(w, x, y, z, ply);
  }

  public boolean blockActivated(World w, int x, int y, int z, EntityPlayer ply) {
    if (!w.singleplayerWorld && this.isGrown(w, x, y, z)) {
      Random rand = new Random();

      EntityItem grapes = new EntityItem(w, ply.posX, ply.posY - 0.5F, ply.posZ, new ItemStack(Item.grape, 1 + rand.nextInt(4)));
      grapes.delayBeforeCanPickup = 0;
      w.entityJoinedWorld(grapes);
      w.setBlockMetadataWithNotify(x, y, z, 0);
      return true;
    }
    return false;
  }

  public void fertilize(World w, int x, int y, int z) {
    w.setBlockMetadataWithNotify(x, y, z, 1);
  }

  public boolean isOpaqueCube() { return false; }
}
