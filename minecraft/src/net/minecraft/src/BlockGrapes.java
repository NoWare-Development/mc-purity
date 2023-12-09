package net.minecraft.src;

import java.util.Random;

public class BlockGrapes extends Block {
  public boolean graphicsLevel;
  private int baseIndexInPNG;
  private int indexOffset;

  protected BlockGrapes(int id, int index) {
    super(id, Material.leaves);
    this.baseIndexInPNG = index;
    this.blockIndexInTexture = index;
    this.indexOffset = 0;
    this.setTickOnLoad(true);
  }

  private boolean isGrown(World w, int x, int y, int z) {
    return w.getBlockMetadata(x, y, z) == 1 ? true : false;
  }

  public int getBlockTextureFromSideAndMetadata(int facing, int metadata) {
    return this.baseIndexInPNG + this.indexOffset + metadata;
  }

  public int quantityDropped(Random rand) {
    return rand.nextInt(10) == 0 ? 1 : 0;
  }

  public int idDropped(int i, Random rand) {
    return Block.grapeBushSapling.blockID;
  }

  public boolean isOpaqueCube() {
    return !this.graphicsLevel;
  }

  public void setGraphicsLevel(boolean gl) {
    this.graphicsLevel = gl;
    this.indexOffset = gl ? 0 : 2;
  }

  public void harvestBlock(World w, EntityPlayer ply, int x, int y, int z, int a) {
    if (!w.multiplayerWorld) {
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
    if (!w.multiplayerWorld && this.isGrown(w, x, y, z)) {
      Random rand = new Random();

      EntityItem grapes = new EntityItem(w, ply.posX, ply.posY - 1.0F, ply.posZ, new ItemStack(Item.grape, 1 + rand.nextInt(4)));
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

  public boolean shouldSideBeRendered(IBlockAccess w, int x, int y, int z, int a) {
    int id = w.getBlockId(x, y, z);
    return !this.graphicsLevel && id == this.blockID ? false : super.shouldSideBeRendered(w, x, y, z, a);
  }
}
