package net.minecraft.src;

public class EntityCow extends EntityAnimal {
	public int timeUntilNextPoop;

	public EntityCow(World var1) {
		super(var1);
		this.texture = "/mob/cow.png";
		this.setSize(0.9F, 1.3F);
		this.timeUntilNextPoop = this.rand.nextInt(2000) + 5000;
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (!this.worldObj.singleplayerWorld && --this.timeUntilNextPoop <= 0) {
			this.worldObj.playSoundAtEntity(this, "mob.chickenplop", 1.0F,
											(this.rand.nextFloat() - this.rand.nextFloat()
											 * 0.2F + 1.0F));
			this.dropItem(Item.poop.shiftedIndex, 1);
			this.timeUntilNextPoop = this.rand.nextInt(4000) + 10000;
		}
	}

	public void writeEntityToNBT(NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
	}

	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
	}

	protected String getLivingSound() {
		return "mob.cow";
	}

	protected String getHurtSound() {
		return "mob.cowhurt";
	}

	protected String getDeathSound() {
		return "mob.cowhurt";
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	protected int getDropItemId() {
		return Item.leather.shiftedIndex;
	}

	public boolean interact(EntityPlayer var1) {
		ItemStack var2 = var1.inventory.getCurrentItem();
		if(var2 != null && var2.itemID == Item.bucketEmpty.shiftedIndex) {
			var1.inventory.setInventorySlotContents(var1.inventory.currentItem, new ItemStack(Item.bucketMilk));
			return true;
		} else {
			return false;
		}
	}
}
