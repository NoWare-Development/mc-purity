package net.minecraft.src;

public class EntityNull extends EntityCreature {
  public EntityNull(World w) {
    super(w);
    this.texture = "/mob/null.png";
  }

  public boolean getCanSpawnHere() {
    int x = MathHelper.floor_double(this.posX);
    int y = MathHelper.floor_double(this.boundingBox.minY);
    int z = MathHelper.floor_double(this.posZ);
    return this.worldObj.getFullBlockLightValue(x, y, z) < 12 && /*!this.worldObj.canBlockSeeTheSky(x, y, z) && */ super.getCanSpawnHere();
  }

  public void onLivingUpdate() {
    /*
    //if (this.worldObj.getLoadedEntityList().contains(this)) this.worldObj.setEntityDead(this);
    EntityPlayer nearest = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 64.0D);
    if (this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 54.0D) != null) this.setEntityDead();

    if (nearest != null) {
      this.faceEntity(nearest, 180, 180);
    }
    */
  }

  public int getMaxSpawnedInChunk() { return 1; }
}
