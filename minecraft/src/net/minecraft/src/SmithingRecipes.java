package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmithingRecipes implements IRecipe {
    private final ItemStack recipeOutput;
    private final ItemStack recipeUpgrade;
    private final ItemStack recipeArmor;

    public SmithingRecipes(ItemStack output, ItemStack upgrade, ItemStack armor) {
        this.recipeOutput = output;
        this.recipeUpgrade = upgrade;
        this.recipeArmor = armor;
    }

    public ItemStack getRecipeOutput() { return this.recipeOutput; }

    public boolean matches(InventoryCrafting inv) { return false; }

    public boolean matchesSmith(InventorySmithing inv) {
        ItemStack upgrade = inv.getStackInSlot(1);
        ItemStack armor = inv.getStackInSlot(0);

        boolean armorValid = false;
        boolean upgradeValid = false;
        if (upgrade != null && armor != null) {
            if (upgrade.itemID == this.recipeUpgrade.itemID &&
                upgrade.getItemDamage() == this.recipeUpgrade.getItemDamage()) upgradeValid = true;
            if (armor.itemID == this.recipeArmor.itemID &&
                armor.getItemDamage() == 0) armorValid = true;
        }
        return armorValid && upgradeValid;
    }

    public ItemStack getCraftingResult(InventoryCrafting inv) { return null; }

    public ItemStack getSmithResult(InventorySmithing inv) { return this.recipeOutput.copy(); }

    public int getRecipeSize() { return 1; }
}
