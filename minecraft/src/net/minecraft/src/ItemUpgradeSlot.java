package net.minecraft.src;

public class ItemUpgradeSlot extends Item {
    public static final String[] slotTypes = new String[]{"empty", "diamond", "emerald", "ruby"};
    public static final int[] upgradeBuffs = {0, 1, 3, 5};

    public ItemUpgradeSlot(int id) {
        super(id);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    public int getIconFromDamage(int i) {
        return this.iconIndex + i % 8 * 16 + i / 8;
    }

    public int getUpgradeBuff(ItemStack slot) {
        return this.upgradeBuffs[slot.getItemDamage()];
    }

    public String getItemNameIS(ItemStack item) {
        return super.getItemName() + "." + slotTypes[item.getItemDamage()];
    }

}
