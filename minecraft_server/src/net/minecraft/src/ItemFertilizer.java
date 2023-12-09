package net.minecraft.src;

public class ItemFertilizer extends Item {
    public ItemFertilizer(int id) {
        super(id);
        this.setIconCoord(3, 5);
        this.setItemName("fertilizer");
    }

    public boolean onItemUse(ItemStack item, EntityPlayer ply, World w, int x, int y, int z, int a) {
        int id = w.getBlockId(x, y, z);
        if (id == Block.sapling.blockID) {
            if (!w.singleplayerWorld) {
                ((BlockSapling)Block.sapling).growTree(w, x, y, z, w.rand);
                --item.stackSize;
            }
            return true;
        }

        if (id == Block.crops.blockID) {
            if (!w.singleplayerWorld) {
                ((BlockCrops)Block.crops).fertilize(w, x, y, z);
                --item.stackSize;
            }
            return true;
        }

        if (id == Block.grapeLeaves.blockID) {
            if (!w.singleplayerWorld) {
                ((BlockGrapes)Block.grapeLeaves).fertilize(w, x, y, z);
                --item.stackSize;
            }
            return true;
        }

        if (id == Block.grapeBushSapling.blockID) {
            if (!w.singleplayerWorld) {
                ((BlockGrapeSapling)Block.grapeBushSapling).generateBush(w, x, y, z);
                --item.stackSize;
            }
            return true;
        }

        return false;
    }
}
