package net.minecraft.src;

import java.util.Random;

public class BlockTallGrass extends BlockFlower {
	protected BlockTallGrass(int var1, int var2) {
		super(var1, var2);
		float var3 = 0.4F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
	}

	public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
		return var2 == 1 ? this.blockIndexInTexture : (var2 == 2 ? this.blockIndexInTexture + 16 + 1 : (var2 == 0 ? this.blockIndexInTexture + 16 : this.blockIndexInTexture));
	}

	public int idDropped(int var1, Random var2) {
		return var2.nextInt(8) == 0 ? Item.seeds.shiftedIndex : -1;
	}

	public void harvestBlock(World w, EntityPlayer ply, int x, int y, int z, int r) {
		if (!w.singleplayerWorld &&
			ply.getCurrentEquippedItem() != null &&
			ply.getCurrentEquippedItem().itemID == Item.knife.shiftedIndex) {
			this.dropHay(w, x, y, z);
		}
		else
			super.harvestBlock(w, ply, x, y, z, r);
	}

	private void dropHay(World w, int x, int y, int z) {
		EntityItem item = new EntityItem(w, (double)x, (double)y + 0.25D, (double)z, new ItemStack(Item.hay));
		item.delayBeforeCanPickup = 10;
		w.entityJoinedWorld(item);
	}
}
