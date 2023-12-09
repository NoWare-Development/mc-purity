package net.minecraft.src;

import java.util.Random;

public class BlockStone extends Block {
	public BlockStone(int var1, int var2) {
		super(var1, var2, Material.rock);
	}

	public int idDropped(int var1, Random var2) {
		return Item.rock.shiftedIndex;
	}

	public void dropBlockAsItemWithChance(World w, int x, int y, int z, int a, float f) {
		super.dropBlockAsItemWithChance(w, x, y, z, a, f);
		if (!w.singleplayerWorld) {
			for (int i = 0; i < 3; ++i) {
				if (w.rand.nextInt(15) <= a) {
					float f1 = 0.4F;
					float f2 = w.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
					float f3 = w.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
					float f4 = w.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
					EntityItem item = new EntityItem(w,
													 (double)((float)x + f2),
													 (double)((float)y + f3),
													 (double)((float)z + f4),
													 new ItemStack(Item.rock));
					item.delayBeforeCanPickup = 10;
					w.entityJoinedWorld(item);
				}
			}
		}
	}
}
