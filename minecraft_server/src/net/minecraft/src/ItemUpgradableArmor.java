package net.minecraft.src;

public class ItemUpgradableArmor extends ItemArmor {
    private static final int[] damageReduceAmountArray = {3, 8, 6, 3};
    private static final int[] maxDamageArray = {11, 16, 15, 13};
    private static final String[] armorUpgTypes = new String[]{"null", "diamond", "emerald", "ruby"};

    private static final String[] armorName = new String[]{"ironHelmet", "ironChest", "ironLegs", "ironBoots"};

    private static final String armorBlocked = "block";

    private boolean hasUpgrade = false;
    private int upgradeLevel = 0;

    // armor types:
    // 0 - helmet
    // 1 - chestplate
    // 2 - leggings
    // 3 - boots

    public final int armorLevel;

    public ItemUpgradableArmor(int id, int type, int level) {
        super(id, 2, 2, type);
        this.armorLevel = 2;
        this.upgradeLevel = level;
        this.hasUpgrade = level > 0;
        this.iconIndex = 2 + type * 16;
        this.damageReduceAmount = damageReduceAmountArray[this.armorLevel] + level;
        this._setItemName();
    }

    public boolean isUpgraded() { return this.hasUpgrade; }

    public ItemUpgradableArmor UpgradeArmorLevel(int level) {
        this.upgradeLevel = level;
        this.hasUpgrade = true;
        this.damageReduceAmount = damageReduceAmountArray[this.armorLevel] + level;
        return this;
    }

    private void _setItemName() {
        this.itemName = "item." + armorName[armorType];
    }

    public String getItemNameIS(ItemStack item) {
        ItemUpgradableArmor a = (ItemUpgradableArmor)item.getItem();
        if (item.getItemDamage() == 0 || a.isUpgraded())
            return super.getItemName() + "." + armorUpgTypes[this.upgradeLevel];
        return super.getItemName() + "." + armorBlocked;
    }
}
