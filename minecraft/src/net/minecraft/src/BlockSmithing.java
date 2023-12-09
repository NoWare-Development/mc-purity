package net.minecraft.src;

public class BlockSmithing extends Block {
    public BlockSmithing(int id) {
        super(id, Material.wood);
        this.blockHardness = 2.0F;
        this.blockResistance = 5.0F;
        this.stepSound = Block.soundStoneFootstep;
        this.setBlockName("smithing");
        this.blockIndexInTexture = this.getTextureFromCoord(8, 8);
    }

    // Facings
    // 1 - top
    // 0 - bottom
    public int getBlockTextureFromSide(int face) {
        return face == 1 ?
            this.getTextureFromCoord(9, 8) :
            (face == 0 ? this.getTextureFromCoord(10, 8) : this.blockIndexInTexture);
    }

    public boolean blockActivated(World w, int i, int j, int k, EntityPlayer p) {
        if (!w.multiplayerWorld) p.displaySmithingGUI(i, j, k);
        return true;
    }
}
