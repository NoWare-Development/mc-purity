package net.minecraft.src;

import java.util.Random;

public class BlockOre extends Block {
	public BlockOre(int var1, int var2) {
		super(var1, var2, Material.rock);
	}

	public int idDropped(int var1, Random var2) {
		int ret;
		switch (this.blockID) {
		case 16:
			ret = Item.coal.shiftedIndex;
			break;
		case 56:
			ret = Item.diamond.shiftedIndex;
			break;
		case 21:
			ret = Item.dyePowder.shiftedIndex;
			break;
		case 101:
			ret = Item.emeraldShard.shiftedIndex;
			break;
		case 102:
			ret = Item.rubyShard.shiftedIndex;
			break;
		default:
			ret = this.blockID;
			break;
		}
		return ret;
	}

	public int quantityDropped(Random var1) {
		return this.blockID == Block.oreLapis.blockID ? 4 + var1.nextInt(5) : 1;
	}

	protected int damageDropped(int var1) {
		return this.blockID == Block.oreLapis.blockID ? 4 : 0;
	}
}
