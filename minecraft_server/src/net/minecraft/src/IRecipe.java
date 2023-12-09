package net.minecraft.src;

public interface IRecipe {
	boolean func_21134_a(InventoryCrafting var1);
	boolean matchesSmith(InventorySmithing inv);

	ItemStack func_21136_b(InventoryCrafting var1);
	ItemStack getSmithResult(InventorySmithing inv);

	int getRecipeSize();

	ItemStack func_25077_b();
}
