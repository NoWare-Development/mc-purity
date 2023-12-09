package net.minecraft.src;

public enum EnumHammerMaterial {
    STONE(30, 8),
    IRON(45, 10);

    private final int maxUses;
    private final int damageVsEntity;

    private EnumHammerMaterial(int uses, int damage) {
        this.maxUses = uses;
        this.damageVsEntity = damage;
    }

    public int getMaxUses() { return this.maxUses; }
    public int getDamageVsEntity() { return this.damageVsEntity; }
}
