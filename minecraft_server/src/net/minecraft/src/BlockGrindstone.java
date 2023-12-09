package net.minecraft.src;

public class BlockGrindstone extends Block {
    public BlockGrindstone(int id) {
        super(id, Material.wood);
        this.blockHardness = 2.0F;
        this.blockResistance = 5.0F;
        this.stepSound = Block.soundStoneFootstep;
        this.setBlockName("grindstone");
        this.blockIndexInTexture = this.getTextureFromCoord(13, 4);
    }

    public int getBlockTextureFromSide(int face) {
        return face == 1 ?
            this.getTextureFromCoord(12, 4) :
            (face == 0 ? this.getTextureFromCoord(14, 4) : this.blockIndexInTexture);
    }

    public boolean blockActivated(World w, int x, int y, int z, EntityPlayer p) {
        if (!w.singleplayerWorld) p.displayGrindstoneGUI(x, y, z);
        return true;
    }
}
