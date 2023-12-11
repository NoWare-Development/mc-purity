package net.minecraft.src;

import java.util.Random;

public class BlockSandstoneSlab extends Block {
  private boolean blockType;

  protected BlockSandstoneSlab(int id, boolean full) {
    super(id, 224, Material.rock);
    this.setHardness(0.8F);
    this.setStepSound(soundStoneFootstep);
    this.blockType = full;
    if (!full) {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }

    this.setLightOpacity(255);
  }

  public int getBlockTextureFromSide(int facing) {
    return facing == 1 ? this.blockIndexInTexture - 48 : (facing == 0 ? this.blockIndexInTexture + 16 : this.blockIndexInTexture);
  }

  public int idDropped(int x, Random rand) {
    return Block.sandStoneSlabSingle.blockID;
  }

  public boolean isOpaqueCube() {
    return this.blockType;
  }

  public int quantityDropped(Random rand) {
    return this.blockType ? 2 : 1;
  }

  public boolean renderAsNormalBlock() {
    return this.blockType;
  }

  public boolean shouldSideBeRendered(IBlockAccess w, int x, int y, int z, int face) {
    if (this != Block.sandStoneSlabSingle) {
      super.shouldSideBeRendered(w, x, y, z, face);
    }

    return face == 1 ? true : (!super.shouldSideBeRendered(w, x, y, z, face) ? false : (face == 0 ? true : w.getBlockId(x, y, z) != this.blockID));
  }
}
