package net.minecraft.src;

public class ItemMelee extends Item {
    private int weaponDamage;
    private EnumMeleeMaterial material;

    public ItemMelee(int id, EnumMeleeMaterial mat) {
        super(id);
        this.maxStackSize = 1;
        this.material = mat;
        this.setMaxDamage(mat.getMaxUses());
        this.weaponDamage = mat.getDamageVsEntity();
    }

    public ItemMelee increaseDamage(int dmg) {
        this.weaponDamage += dmg;
        return this;
    }

    public ItemMelee decreaseDurability(int dur) {
        this.setMaxDamage(this.material.getMaxUses() - dur);
        return this;
    }

    public float getStrVsBlock(ItemStack item, Block block) {
        return
            (item.itemID == Item.ironSword.shiftedIndex || item.itemID == Item.knife.shiftedIndex) &&
            block.blockID == Block.web.blockID ? 15.0F : 1.5F;
    }

    public boolean hitEntity(ItemStack item, EntityLiving ply, EntityLiving ent) {
        item.damageItem(1, ent);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack item, int i, int j, int k, int l, EntityLiving ent) {
        item.damageItem(2, ent);
        return true;
    }

    public int getDamageVsEntity(Entity ent) { return this.weaponDamage; }

    public int getDmg() { return this.weaponDamage; }

    public boolean isFull3D() { return true; }

    public boolean canHarvestBlock(Block block) {
        return block.blockID == Block.web.blockID;
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer ply) {
        /*
        if (item.getItem() == Item.spear) {
            world.playSoundAtEntity(ply, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

            item.stackSize = 0;
        }
        */
        return item;
    }
}
