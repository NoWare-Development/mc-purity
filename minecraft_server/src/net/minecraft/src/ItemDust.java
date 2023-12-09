package net.minecraft.src;

public class ItemDust extends Item {
    private EnumDustMaterial material;

    public ItemDust(int id, EnumDustMaterial mat) {
        super(id);
        this.maxStackSize = 16;
        this.material = mat;
        this.setMaxDamage(0);
    }
}
