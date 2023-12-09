package net.minecraft.src;

public class ItemHammer extends Item {
    protected EnumHammerMaterial material;
    private int damageVsEntity;

    public ItemHammer(int id, EnumHammerMaterial mat) {
        super(id);
        this.maxStackSize = 1;
        this.setMaxDamage(mat.getMaxUses());
        this.material = mat;
        this.damageVsEntity = mat.getDamageVsEntity();
        this.setContainerItem(this);
    }

    public boolean isFull3D() { return true; }
    public boolean hitEntity(ItemStack item, EntityLiving ply, EntityLiving ent) {
        item.damageItem(2, ent);
        return true;
    }
    public boolean onBlockDestroyed(ItemStack item, int x, int y, int z, int a, EntityLiving ent) {
        item.damageItem(4, ent);
        return true;
    }
    public int getDamageVsEntity(Entity ent) { return this.damageVsEntity; }
    public int getDmg() { return this.damageVsEntity; }
}
