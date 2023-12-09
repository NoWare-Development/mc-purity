package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapelessRecipes implements IRecipe {
	private final ItemStack recipeOutput;
	private final List recipeItems;

	public ShapelessRecipes(ItemStack output, List items) {
		this.recipeOutput = output;
		this.recipeItems = items;
	}

	public ItemStack func_25077_b() { return this.recipeOutput; }

	public boolean func_21134_a(InventoryCrafting inv) {
		ArrayList items = new ArrayList(this.recipeItems);

		for (int x = 0; x < 3; ++x) {
			for (int y = 0; y < 3; ++y) {
				ItemStack item = inv.func_21084_a(x, y);
				if (item != null) {
					boolean valid = false;
					Iterator itemsIter = items.iterator();

					while (itemsIter.hasNext()) {
						ItemStack cItem = (ItemStack)itemsIter.next();
						if (item.itemID == cItem.itemID &&
							(cItem.getItemDamage() == -1 ||
							 item.getItemDamage() == cItem.getItemDamage() ||
							 (item.getItem().getMaxDamage() > 0 && item.getItemDamage() > 0))) {
							if (item.getItem().getMaxDamage() > 0 &&
								item.getItemDamage() >= item.getItem().getMaxDamage()) {
								return false;
							}
							valid = true;
							items.remove(cItem);
							break;
						}
					}
					if (!valid) return false;
				}
			}
		}
		return items.isEmpty();
	}

	public ItemStack func_21136_b(InventoryCrafting inv) {
		return this.recipeOutput.copy();
	}

	public int getRecipeSize() { return this.recipeItems.size(); }

	public boolean matchesSmith(InventorySmithing inv) { return false; }
	public ItemStack getSmithResult(InventorySmithing inv) { return null; }
}
