package net.minecraft.src;

import java.util.Random;

public class BlockGrapeSapling extends BlockFlower {
  protected BlockGrapeSapling(int id) {
    super(id, 200);
    float bsub = 0.4F;
    this.setBlockBounds(0.5F - bsub, 0.0F, 0.5F - bsub, 0.5F + bsub, bsub * 2.0F, 0.5F + bsub);
  }

  public void updateTick(World w, int x, int y, int z, Random rand) {
    if (!w.singleplayerWorld) {
      super.updateTick(w, x, y, z, rand);
      if (w.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(30) == 0) {
        this.generateBush(w, x, y, z);
      }
    }
  }

  public int getBlockTextureFromSide(int facing) {
    return 200;
  }

  public void generateBush(World w, int x, int y, int z) {
    w.setBlockAndMetadata(x, y - 1, z, Block.wood.blockID, 0);
    w.setBlockAndMetadata(x, y, z, Block.grapeLeaves.blockID, 0);
    if (!getIsBlockSolid(w, x, y + 1, z, 0))
      w.setBlockAndMetadata(x, y + 1, z, Block.grapeLeaves.blockID, 0);
  }
}
