package net.minecraft.src;

public class ItemKnife extends ItemMelee {
    public ItemKnife(int id) {
        super(id, EnumMeleeMaterial.M_KNIFE);
        this.setItemName("knife");
        this.setIconCoord(4, 5);
    }

    public boolean onBlockDestroyed(ItemStack item, int x, int y, int z, int a, EntityLiving ent) {
        item.damageItem(1, ent);
        return true;
    }
}
