package net.minecraft.src;

public class RecipesPurity {
    private void addArmorRecipes(CraftingManager mgr) {
        // Leather Armor
        mgr.addRecipe(new ItemStack(Item.helmetLeather),
                      new Object[]{"###", "# #",
                                   Character.valueOf('#'), Item.leather});
        mgr.addRecipe(new ItemStack(Item.plateLeather),
                      new Object[]{"# #", "###", "###",
                                   Character.valueOf('#'), Item.leather});
        mgr.addRecipe(new ItemStack(Item.legsLeather),
                      new Object[]{"###", "# #", "# #",
                                   Character.valueOf('#'), Item.leather});
        mgr.addRecipe(new ItemStack(Item.bootsLeather),
                      new Object[]{"# #", "# #",
                                   Character.valueOf('#'), Item.leather});

        // Chainmail Armor
        mgr.addRecipe(new ItemStack(Item.helmetChain),
                      new Object[]{"###", "# #", "# #",
                                   Character.valueOf('#'), Item.chainmailFragment});
        mgr.addRecipe(new ItemStack(Item.plateChain),
                      new Object[]{"# #", "###", "###",
                                   Character.valueOf('#'), Item.chainmailFragment});
        mgr.addRecipe(new ItemStack(Item.legsChain),
                      new Object[]{"###", "# #", "# #",
                                   Character.valueOf('#'), Item.chainmailFragment});
        mgr.addRecipe(new ItemStack(Item.bootsChain),
                      new Object[]{"# #", "# #",
                                   Character.valueOf('#'), Item.chainmailFragment});

        // Iron Armor
        mgr.addRecipe(new ItemStack(Item.ironHelmet),
                      new Object[]{"###", "# #",
                                   Character.valueOf('#'), Item.ingotIron});
        mgr.addRecipe(new ItemStack(Item.ironChest),
                      new Object[]{"# #", "###", "###",
                                   Character.valueOf('#'), Item.ingotIron});
        mgr.addRecipe(new ItemStack(Item.ironLegs),
                      new Object[]{"###", "# #", "# #",
                                   Character.valueOf('#'), Item.ingotIron});
        mgr.addRecipe(new ItemStack(Item.ironBoots),
                      new Object[]{"# #", "# #",
                                   Character.valueOf('#'), Item.ingotIron});
    }

    private void addDustRecipes(CraftingManager mgr) {
        Object[][] dItems = new Object[][]{
            {Item.stoneHammer, Item.ironHammer},
            {Item.coal, Item.ingotIron, Item.diamond, Item.redstoneRock}
        };

        ItemStack[] dResult = new ItemStack[]{
            new ItemStack(Item.coalDust, 4),
            new ItemStack(Item.ironDust),
            new ItemStack(Item.diamondDust),
            new ItemStack(Item.redstone, 4)
        };

        for (int i = 0; i < dItems[0].length; ++i) {
            for (int j = 0; j < dItems[1].length; ++j) {
                mgr.addShapelessRecipe(dResult[j], new Object[]{dItems[0][i], dItems[1][j]});
            }
        }
    }

    private void addSlotsRecipes(CraftingManager mgr) {
        mgr.addRecipe(new ItemStack(Item.upgradeSlot, 1, 0),
                      new Object[]{"###", "#D#", "###",
                                   Character.valueOf('#'), Block.stone});
        mgr.addShapelessRecipe(new ItemStack(Item.upgradeSlot, 1, 1),
                               new Object[]{
                                   new ItemStack(Item.upgradeSlot, 1, 0),
                                   new ItemStack(Item.diamondShard)});
        mgr.addShapelessRecipe(new ItemStack(Item.upgradeSlot, 1, 2),
                               new Object[]{
                                   new ItemStack(Item.upgradeSlot, 1, 0),
                                   new ItemStack(Item.emeraldShard)});
        mgr.addShapelessRecipe(new ItemStack(Item.upgradeSlot, 1, 3),
                               new Object[]{
                                   new ItemStack(Item.upgradeSlot, 1, 0),
                                   new ItemStack(Item.rubyShard)});
    }

    private void addShardsRecipes(CraftingManager mgr) {
        mgr.addRecipe(new ItemStack(Item.diamond),
                      new Object[]{"##", "##",
                                   Character.valueOf('#'), Item.diamondShard});
    }

    private void addHammersRecipes(CraftingManager mgr) {
        mgr.addRecipe(new ItemStack(Item.stoneHammer),
                      new Object[]{"###", "###", " / ",
                                   Character.valueOf('#'), Block.cobblestone,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.ironHammer),
                      new Object[]{"###", "###", " / ",
                                   Character.valueOf('#'), Item.ingotIron,
                                   Character.valueOf('/'), Item.stick});
    }

    private void addMeleeRecipes(CraftingManager mgr) {
        mgr.addRecipe(new ItemStack(Item.bat),
                      new Object[]{"#", "#", "/",
                                   Character.valueOf('#'), Block.wood,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.mace),
                      new Object[]{"#", "#", "/",
                                   Character.valueOf('#'), Block.cobblestone,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.ironSword),
                      new Object[]{"#", "#", "/",
                                   Character.valueOf('#'), Item.ingotIron,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.spear),
                      new Object[]{"#  ", " / ", "  /",
                                   Character.valueOf('#'), Item.rock,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.spear),
                      new Object[]{"  #", " / ", "/  ",
                                   Character.valueOf('#'), Item.rock,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.knife),
                      new Object[]{"# ", " @",
                                   Character.valueOf('#'), Item.rock,
                                   Character.valueOf('@'), Item.stick});
    }

    private void addUpgradingArmorRecipes(CraftingManager mgr) {
        // 1 - result
        // 2 - armor
        // 3 - upgrade
        ItemStack[] armor = new ItemStack[]{
            new ItemStack(Item.ironHelmet),
            new ItemStack(Item.ironChest),
            new ItemStack(Item.ironLegs),
            new ItemStack(Item.ironBoots)
        };
        ItemStack[] upgrade = new ItemStack[]{
            new ItemStack(Item.upgradeSlot, 1, 1),
            new ItemStack(Item.upgradeSlot, 1, 2),
            new ItemStack(Item.upgradeSlot, 1, 3)
        };
        ItemStack[][] result = new ItemStack[][]{
            { // helmet
                new ItemStack(Item.ironHelmetD),
                new ItemStack(Item.ironHelmetE),
                new ItemStack(Item.ironHelmetR)
            },
            { // chestplate
                new ItemStack(Item.ironChestD),
                new ItemStack(Item.ironChestE),
                new ItemStack(Item.ironChestR)
            },
            { // leggings
                new ItemStack(Item.ironLegsD),
                new ItemStack(Item.ironLegsE),
                new ItemStack(Item.ironLegsR)
            },
            { // boots
                new ItemStack(Item.ironBootsD),
                new ItemStack(Item.ironBootsE),
                new ItemStack(Item.ironBootsR)
            }
        };

        for (byte aIndex = 0; aIndex < armor.length; ++aIndex)
            for (byte uIndex = 0; uIndex < upgrade.length; ++uIndex)
                mgr.addSmithingRecipe(result[aIndex][uIndex],
                                      armor[aIndex], upgrade[uIndex]);
    }

    private void addToolsRecipes(CraftingManager mgr) {
        // wooden
        mgr.addRecipe(new ItemStack(Item.pickaxeWood),
                      new Object[]{"///", " / ", " / ",
                                   Character.valueOf('/'), Item.stick});

        // stone
        mgr.addRecipe(new ItemStack(Item.shovelStone),
                      new Object[]{"#", "/", "/",
                                   Character.valueOf('#'), Block.cobblestone,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.pickaxeStone),
                      new Object[]{"###", " / ", " / ",
                                   Character.valueOf('#'), Block.cobblestone,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.axeStone),
                      new Object[]{"##", "/#", "/ ",
                                   Character.valueOf('#'), Block.cobblestone,
                                   Character.valueOf('/'), Item.stick});

        // iron
        mgr.addRecipe(new ItemStack(Item.shovelSteel),
                      new Object[]{"#", "/", "/",
                                   Character.valueOf('#'), Item.ingotIron,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.pickaxeSteel),
                      new Object[]{"###", " / ", " / ",
                                   Character.valueOf('#'), Item.ingotIron,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.axeSteel),
                      new Object[]{"##", "/#", "/ ",
                                   Character.valueOf('#'), Item.ingotIron,
                                   Character.valueOf('/'), Item.stick});

        // hoes
        mgr.addRecipe(new ItemStack(Item.hoeWood),
                      new Object[]{"//", "/ ", "/ ",
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.hoeStone),
                      new Object[]{"##", "/ ", "/ ",
                                   Character.valueOf('#'), Block.cobblestone,
                                   Character.valueOf('/'), Item.stick});
        mgr.addRecipe(new ItemStack(Item.hoeSteel),
                      new Object[]{"##", "/ ", "/ ",
                                   Character.valueOf('#'), Item.ingotIron,
                                   Character.valueOf('/'), Item.stick});
    }

    public void addRecipes(CraftingManager mgr) {
        // Armor
        this.addArmorRecipes(mgr);

        // Dusts
        this.addDustRecipes(mgr);

        // Upgrading slots
        this.addSlotsRecipes(mgr);

        // Shards
        this.addShardsRecipes(mgr);

        // Hammers
        this.addHammersRecipes(mgr);

        // Melee weapons
        this.addMeleeRecipes(mgr);

        // Upgrading armor
        this.addUpgradingArmorRecipes(mgr);

        // Tools
        this.addToolsRecipes(mgr);

        /* Other */
        // Iron Nugget
        mgr.addShapelessRecipe(new ItemStack(Item.ironNugget, 9),
                               new Object[]{new ItemStack(Item.ingotIron)});

        // Chainmail Fragment
        mgr.addRecipe(new ItemStack(Item.chainmailFragment),
                      new Object[]{" i ", "i#i", " i ",
                                   Character.valueOf('i'), Item.ironNugget,
                                   Character.valueOf('#'), Item.ingotIron});

        // Cobblestone (from rocks)
        mgr.addRecipe(new ItemStack(Block.cobblestone),
                      new Object[]{"##", "##",
                                   Character.valueOf('#'), Item.rock});

        // Smithing table
        mgr.addRecipe(new ItemStack(Block.smithing),
                      new Object[]{"###", "#@#", "@@@",
                                   Character.valueOf('#'), Block.stone,
                                   Character.valueOf('@'), Block.planks});

        // Shears
        mgr.addRecipe(new ItemStack(Item.shears),
                      new Object[]{" #", "# ",
                                   Character.valueOf('#'), Item.ingotIron});

        // Coal Block
        mgr.addRecipe(new ItemStack(Block.blockCoal),
                      new Object[]{"###", "###", "###",
                                   Character.valueOf('#'), Item.coal});

        // Grape Bush Sapling
        mgr.addShapelessRecipe(new ItemStack(Block.grapeBushSapling, 1),
                               new Object[]{
                                   new ItemStack(Item.grape, 1, 0),
                                   new ItemStack(Item.dyePowder, 1, 15)});

        // Fertilizer
        mgr.addShapelessRecipe(new ItemStack(Item.fertilizer, 4),
                               new Object[]{
                                   new ItemStack(Item.poop),
                                   new ItemStack(Item.wheat),
                                   new ItemStack(Item.sugar),
                                   new ItemStack(Item.clay)});

        // Grindstone
        mgr.addRecipe(new ItemStack(Block.grindstone),
                      new Object[]{"XXX", "###", "@@@",
                                   Character.valueOf('X'), Item.leather,
                                   Character.valueOf('#'), Block.cobblestone,
                                   Character.valueOf('@'), Block.planks});

        // Mossy cobblestone
        mgr.addRecipe(new ItemStack(Block.cobblestoneMossy),
                      new Object[]{" X ", "X#X", " X ",
                                   Character.valueOf('X'), Item.seeds,
                                   Character.valueOf('#'), Block.cobblestone});

        // Bed
        mgr.addRecipe(new ItemStack(Item.bed),
                      new Object[]{"XX$", "###",
                                   Character.valueOf('X'), Item.cloth,
                                   Character.valueOf('$'), Item.pillow,
                                   Character.valueOf('#'), Block.planks});

        // Pillow
        mgr.addRecipe(new ItemStack(Item.pillow),
                      new Object[]{"X#X", "#$#", "X#X",
                                   Character.valueOf('X'), Item.silk,
                                   Character.valueOf('#'), Block.cloth,
                                   Character.valueOf('$'), Block.hayBlock});

        // Hay Block
        mgr.addRecipe(new ItemStack(Block.hayBlock),
                      new Object[]{"##", "##",
                                   Character.valueOf('#'), Item.hay});

        // Carved Planks
        mgr.addRecipe(new ItemStack(Block.carvedPlanks, 2),
                      new Object[]{"# ", " #",
                                   Character.valueOf('#'), Block.planks});

        // Stone bricks
        mgr.addRecipe(new ItemStack(Block.stoneBricks, 4),
                      new Object[]{"##", "##",
                                   Character.valueOf('#'), Block.smoothStone});

        // Stone slabs
        mgr.addRecipe(new ItemStack(Block.stairSingle, 3),
                      new Object[]{"###",
                                   Character.valueOf('#'), Block.smoothStone});

        // Bottle
        mgr.addRecipe(new ItemStack(Item.bottle, 3),
                      new Object[]{"# #", " # ",
                                   Character.valueOf('#'), Block.glass});

        // Barrel
        mgr.addRecipe(new ItemStack(Block.barrel, 1),
                      new Object[]{"#@#", "# #", "#@#",
                                   Character.valueOf('#'), Block.wood,
                                   Character.valueOf('@'), Block.planks});
    }
}
