package net.minecraft.src;

public interface IRecipe {
	boolean matches(InventoryCrafting var1);
	boolean matchesSmith(InventorySmithing inv);

	ItemStack getCraftingResult(InventoryCrafting var1);
	ItemStack getSmithResult(InventorySmithing inv);

	int getRecipeSize();

	ItemStack getRecipeOutput();
}
