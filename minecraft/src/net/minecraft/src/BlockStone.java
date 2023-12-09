package net.minecraft.src;

import java.util.Random;

public class BlockStone extends Block {
	public BlockStone(int var1, int var2) {
		super(var1, var2, Material.rock);
	}

	public int idDropped(int var1, Random var2) {
		return Item.rock.shiftedIndex;
	}

	public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
		super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
		if (!var1.multiplayerWorld) {
			for (int var7 = 0; var7 < 3; ++var7) {
				if (var1.rand.nextInt(15) <= var5) {
					float var8 = 0.4F;
					float var9 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
					float var10 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
					float var11 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
					EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var9), (double)((float)var3 + var10), (double)((float)var4 + var11), new ItemStack(Item.rock));
					var12.delayBeforeCanPickup = 10;
					var1.entityJoinedWorld(var12);
				}
			}
		}
	}
}
