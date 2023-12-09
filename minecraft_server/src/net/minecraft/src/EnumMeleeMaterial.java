package net.minecraft.src;

public enum EnumMeleeMaterial {
    M_BAT(110, 3),
    M_MACE(75, 6),
    M_SPEAR(30, 7),
    M_KNIFE(25, 5),
    M_SWORD(250, 8);

    private final int maxUses;
    private final int damageVsEntity;

    private EnumMeleeMaterial(int uses, int damage) {
        this.maxUses = uses;
        this.damageVsEntity = damage;
    }

    public int getMaxUses() { return this.maxUses; }
    public int getDamageVsEntity() { return this.damageVsEntity; }
}
