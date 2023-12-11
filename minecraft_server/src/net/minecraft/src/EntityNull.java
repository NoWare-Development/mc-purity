package net.minecraft.src;

public class EntityNull extends EntityCreature {
  private int livingTime;

  public EntityNull(World w) {
    super(w);
    this.livingTime = 0;
  }

  public boolean getCanSpawnHere() {
    int x = MathHelper.floor_double(this.posX);
    int y = MathHelper.floor_double(this.boundingBox.minY);
    int z = MathHelper.floor_double(this.posZ);
    return this.worldObj.getBlockLightValueNoChecks(x, y, z) < 12 && !this.worldObj.canBlockSeeTheSky(x, y, z) && super.getCanSpawnHere();
  }

  public void onLivingUpdate() {
    EntityPlayer nearest = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 64.0D);
    if (this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 54.0D) != null) this.setEntityDead();

    if (nearest != null) {
      this.faceEntity(nearest, 180, 180);
    }

    if (this.livingTime > 1500) this.setEntityDead();
    this.livingTime++;
  }

  public int getMaxSpawnedInChunk() { return 1; }
}
