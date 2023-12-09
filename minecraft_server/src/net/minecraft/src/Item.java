package net.minecraft.src;

import java.util.Random;

public class Item {
	protected static Random itemRand = new Random();
	public static Item[] itemsList = new Item[32000];
	public static Item shovelSteel = (new ItemSpade(0, EnumToolMaterial.IRON)).setIconCoord(2, 5).setItemName("shovelIron");
	public static Item pickaxeSteel = (new ItemPickaxe(1, EnumToolMaterial.IRON)).setIconCoord(2, 6).setItemName("pickaxeIron");
	public static Item axeSteel = (new ItemAxe(2, EnumToolMaterial.IRON)).setIconCoord(2, 7).setItemName("hatchetIron");
	public static Item flintAndSteel = (new ItemFlintAndSteel(3)).setIconCoord(5, 0).setItemName("flintAndSteel");
	public static Item appleRed = (new ItemFood(4, 4, false)).setIconCoord(10, 0).setItemName("apple");
	public static Item bow = (new ItemBow(5)).setIconCoord(5, 1).setItemName("bow");
	public static Item arrow = (new Item(6)).setIconCoord(5, 2).setItemName("arrow");
	public static Item coal = (new ItemCoal(7)).setIconCoord(7, 0).setItemName("coal");
	public static Item diamond = (new Item(8)).setIconCoord(7, 3).setItemName("emerald");
	public static Item ingotIron = (new Item(9)).setIconCoord(7, 1).setItemName("ingotIron");
	public static Item ingotGold = (new Item(10)).setIconCoord(7, 2).setItemName("ingotGold");
	public static Item swordSteel = (new ItemSword(11, EnumToolMaterial.IRON)).setIconCoord(2, 4).setItemName("swordIron");
	public static Item swordWood = (new ItemSword(12, EnumToolMaterial.WOOD)).setIconCoord(0, 4).setItemName("swordWood");
	public static Item shovelWood = (new ItemSpade(13, EnumToolMaterial.WOOD)).setIconCoord(0, 5).setItemName("shovelWood");
	public static Item pickaxeWood = (new ItemPickaxe(14, EnumToolMaterial.WOOD)).setIconCoord(0, 6).setItemName("pickaxeWood");
	public static Item axeWood = (new ItemAxe(15, EnumToolMaterial.WOOD)).setIconCoord(0, 7).setItemName("hatchetWood");
	public static Item swordStone = (new ItemSword(16, EnumToolMaterial.STONE)).setIconCoord(1, 4).setItemName("swordStone");
	public static Item shovelStone = (new ItemSpade(17, EnumToolMaterial.STONE)).setIconCoord(1, 5).setItemName("shovelStone");
	public static Item pickaxeStone = (new ItemPickaxe(18, EnumToolMaterial.STONE)).setIconCoord(1, 6).setItemName("pickaxeStone");
	public static Item axeStone = (new ItemAxe(19, EnumToolMaterial.STONE)).setIconCoord(1, 7).setItemName("hatchetStone");
	public static Item swordDiamond = (new ItemSword(20, EnumToolMaterial.EMERALD)).setIconCoord(3, 4).setItemName("swordDiamond");
	public static Item shovelDiamond = (new ItemSpade(21, EnumToolMaterial.EMERALD)).setIconCoord(3, 5).setItemName("shovelDiamond");
	public static Item pickaxeDiamond = (new ItemPickaxe(22, EnumToolMaterial.EMERALD)).setIconCoord(3, 6).setItemName("pickaxeDiamond");
	public static Item axeDiamond = (new ItemAxe(23, EnumToolMaterial.EMERALD)).setIconCoord(3, 7).setItemName("hatchetDiamond");
	public static Item stick = (new Item(24)).setIconCoord(5, 3).setFull3D().setItemName("stick");
	public static Item bowlEmpty = (new Item(25)).setIconCoord(7, 4).setItemName("bowl");
	public static Item bowlSoup = (new ItemSoup(26, 10)).setIconCoord(8, 4).setItemName("mushroomStew");
	public static Item swordGold = (new ItemSword(27, EnumToolMaterial.GOLD)).setIconCoord(4, 4).setItemName("swordGold");
	public static Item shovelGold = (new ItemSpade(28, EnumToolMaterial.GOLD)).setIconCoord(4, 5).setItemName("shovelGold");
	public static Item pickaxeGold = (new ItemPickaxe(29, EnumToolMaterial.GOLD)).setIconCoord(4, 6).setItemName("pickaxeGold");
	public static Item axeGold = (new ItemAxe(30, EnumToolMaterial.GOLD)).setIconCoord(4, 7).setItemName("hatchetGold");
	public static Item silk = (new Item(31)).setIconCoord(8, 0).setItemName("string");
	public static Item feather = (new Item(32)).setIconCoord(8, 1).setItemName("feather");
	public static Item gunpowder = (new Item(33)).setIconCoord(8, 2).setItemName("sulphur");
	public static Item hoeWood = (new ItemHoe(34, EnumToolMaterial.WOOD)).setIconCoord(0, 8).setItemName("hoeWood");
	public static Item hoeStone = (new ItemHoe(35, EnumToolMaterial.STONE)).setIconCoord(1, 8).setItemName("hoeStone");
	public static Item hoeSteel = (new ItemHoe(36, EnumToolMaterial.IRON)).setIconCoord(2, 8).setItemName("hoeIron");
	public static Item hoeDiamond = (new ItemHoe(37, EnumToolMaterial.EMERALD)).setIconCoord(3, 8).setItemName("hoeDiamond");
	public static Item hoeGold = (new ItemHoe(38, EnumToolMaterial.GOLD)).setIconCoord(4, 8).setItemName("hoeGold");
	public static Item seeds = (new ItemSeeds(39, Block.crops.blockID)).setIconCoord(9, 0).setItemName("seeds");
	public static Item wheat = (new Item(40)).setIconCoord(9, 1).setItemName("wheat");
	public static Item bread = (new ItemFood(41, 5, false)).setIconCoord(9, 2).setItemName("bread");
	public static Item helmetLeather = (new ItemArmor(42, 0, 0, 0)).setIconCoord(0, 0).setItemName("helmetCloth");
	public static Item plateLeather = (new ItemArmor(43, 0, 0, 1)).setIconCoord(0, 1).setItemName("chestplateCloth");
	public static Item legsLeather = (new ItemArmor(44, 0, 0, 2)).setIconCoord(0, 2).setItemName("leggingsCloth");
	public static Item bootsLeather = (new ItemArmor(45, 0, 0, 3)).setIconCoord(0, 3).setItemName("bootsCloth");
	public static Item helmetChain = (new ItemArmor(46, 1, 1, 0)).setIconCoord(1, 0).setItemName("helmetChain");
	public static Item plateChain = (new ItemArmor(47, 1, 1, 1)).setIconCoord(1, 1).setItemName("chestplateChain");
	public static Item legsChain = (new ItemArmor(48, 1, 1, 2)).setIconCoord(1, 2).setItemName("leggingsChain");
	public static Item bootsChain = (new ItemArmor(49, 1, 1, 3)).setIconCoord(1, 3).setItemName("bootsChain");
	public static Item helmetSteel = (new ItemArmor(50, 2, 2, 0)).setIconCoord(2, 0).setItemName("helmetIron");
	public static Item plateSteel = (new ItemArmor(51, 2, 2, 1)).setIconCoord(2, 1).setItemName("chestplateIron");
	public static Item legsSteel = (new ItemArmor(52, 2, 2, 2)).setIconCoord(2, 2).setItemName("leggingsIron");
	public static Item bootsSteel = (new ItemArmor(53, 2, 2, 3)).setIconCoord(2, 3).setItemName("bootsIron");
	public static Item helmetDiamond = (new ItemArmor(54, 3, 3, 0)).setIconCoord(3, 0).setItemName("helmetDiamond");
	public static Item plateDiamond = (new ItemArmor(55, 3, 3, 1)).setIconCoord(3, 1).setItemName("chestplateDiamond");
	public static Item legsDiamond = (new ItemArmor(56, 3, 3, 2)).setIconCoord(3, 2).setItemName("leggingsDiamond");
	public static Item bootsDiamond = (new ItemArmor(57, 3, 3, 3)).setIconCoord(3, 3).setItemName("bootsDiamond");
	public static Item helmetGold = (new ItemArmor(58, 1, 4, 0)).setIconCoord(4, 0).setItemName("helmetGold");
	public static Item plateGold = (new ItemArmor(59, 1, 4, 1)).setIconCoord(4, 1).setItemName("chestplateGold");
	public static Item legsGold = (new ItemArmor(60, 1, 4, 2)).setIconCoord(4, 2).setItemName("leggingsGold");
	public static Item bootsGold = (new ItemArmor(61, 1, 4, 3)).setIconCoord(4, 3).setItemName("bootsGold");
	public static Item flint = (new Item(62)).setIconCoord(6, 0).setItemName("flint");
	public static Item porkRaw = (new ItemFood(63, 3, true)).setIconCoord(7, 5).setItemName("porkchopRaw");
	public static Item porkCooked = (new ItemFood(64, 8, true)).setIconCoord(8, 5).setItemName("porkchopCooked");
	public static Item painting = (new ItemPainting(65)).setIconCoord(10, 1).setItemName("painting");
	public static Item appleGold = (new ItemFood(66, 42, false)).setIconCoord(11, 0).setItemName("appleGold");
	public static Item sign = (new ItemSign(67)).setIconCoord(10, 2).setItemName("sign");
	public static Item doorWood = (new ItemDoor(68, Material.wood)).setIconCoord(11, 2).setItemName("doorWood");
	public static Item bucketEmpty = (new ItemBucket(69, 0)).setIconCoord(10, 4).setItemName("bucket");
	public static Item bucketWater = (new ItemBucket(70, Block.waterMoving.blockID)).setIconCoord(11, 4).setItemName("bucketWater").setContainerItem(bucketEmpty);
	public static Item bucketLava = (new ItemBucket(71, Block.lavaMoving.blockID)).setIconCoord(12, 4).setItemName("bucketLava").setContainerItem(bucketEmpty);
	public static Item minecartEmpty = (new ItemMinecart(72, 0)).setIconCoord(7, 8).setItemName("minecart");
	public static Item saddle = (new ItemSaddle(73)).setIconCoord(8, 6).setItemName("saddle");
	public static Item doorSteel = (new ItemDoor(74, Material.iron)).setIconCoord(12, 2).setItemName("doorIron");
	public static Item redstone = (new ItemRedstone(75)).setIconCoord(8, 3).setItemName("redstone");
	public static Item snowball = (new ItemSnowball(76)).setIconCoord(14, 0).setItemName("snowball");
	public static Item boat = (new ItemBoat(77)).setIconCoord(8, 8).setItemName("boat");
	public static Item leather = (new Item(78)).setIconCoord(7, 6).setItemName("leather");
	public static Item bucketMilk = (new ItemBucket(79, -1)).setIconCoord(13, 4).setItemName("milk").setContainerItem(bucketEmpty);
	public static Item brick = (new Item(80)).setIconCoord(6, 1).setItemName("brick");
	public static Item clay = (new Item(81)).setIconCoord(9, 3).setItemName("clay");
	public static Item reed = (new ItemReed(82, Block.reed)).setIconCoord(11, 1).setItemName("reeds");
	public static Item paper = (new Item(83)).setIconCoord(10, 3).setItemName("paper");
	public static Item book = (new Item(84)).setIconCoord(11, 3).setItemName("book");
	public static Item slimeBall = (new Item(85)).setIconCoord(14, 1).setItemName("slimeball");
	public static Item minecartCrate = (new ItemMinecart(86, 1)).setIconCoord(7, 9).setItemName("minecartChest");
	public static Item minecartPowered = (new ItemMinecart(87, 2)).setIconCoord(7, 10).setItemName("minecartFurnace");
	public static Item egg = (new ItemEgg(88)).setIconCoord(12, 0).setItemName("egg");
	public static Item compass = (new Item(89)).setIconCoord(6, 3).setItemName("compass");
	public static Item fishingRod = (new ItemFishingRod(90)).setIconCoord(5, 4).setItemName("fishingRod");
	public static Item pocketSundial = (new Item(91)).setIconCoord(6, 4).setItemName("clock");
	public static Item lightStoneDust = (new Item(92)).setIconCoord(9, 4).setItemName("yellowDust");
	public static Item fishRaw = (new ItemFood(93, 2, false)).setIconCoord(9, 5).setItemName("fishRaw");
	public static Item fishCooked = (new ItemFood(94, 5, false)).setIconCoord(10, 5).setItemName("fishCooked");
	public static Item dyePowder = (new ItemDye(95)).setIconCoord(14, 4).setItemName("dyePowder");
	public static Item bone = (new Item(96)).setIconCoord(12, 1).setItemName("bone").setFull3D();
	public static Item sugar = (new Item(97)).setIconCoord(13, 0).setItemName("sugar").setFull3D();
	public static Item cake = (new ItemReed(98, Block.cake)).setMaxStackSize(1).setIconCoord(13, 1).setItemName("cake");
	public static Item bed = (new ItemBed(99)).setMaxStackSize(1).setIconCoord(13, 2).setItemName("bed");
	public static Item redstoneRepeater = (new ItemReed(100, Block.redstoneRepeaterIdle)).setIconCoord(6, 5).setItemName("diode");
	public static Item cookie = (new ItemCookie(101, 1, false, 8)).setIconCoord(12, 5).setItemName("cookie");
	public static ItemMap field_28021_bb = (ItemMap)(new ItemMap(102)).setIconCoord(12, 3).setItemName("map");
	public static ItemShears shears = (ItemShears)(new ItemShears(103)).setIconCoord(13, 5).setItemName("shears");
	public static Item record13 = (new ItemRecord(2000, "13")).setIconCoord(0, 15).setItemName("record");
	public static Item recordCat = (new ItemRecord(2001, "cat")).setIconCoord(1, 15).setItemName("record");

	/* New Items */
	// Offset: 3000

	// Dust
	public static Item coalDust = (new Item(3000)).setIconCoord(5, 6).setItemName("coalDust");
	public static Item ironDust = (new ItemDust(3001, EnumDustMaterial.IRON)).setIconCoord(5, 8).setItemName("ironDust");
	public static Item diamondDust = (new ItemDust(3002, EnumDustMaterial.DIAMOND)).setIconCoord(5, 7).setItemName("diamondDust");

	// Shards
	public static Item diamondShard = (new Item(3003)).setIconCoord(6, 6).setItemName("diamondShard");
	public static Item emeraldShard = (new Item(3004)).setIconCoord(6, 8).setItemName("emeraldShard");
	public static Item rubyShard = (new Item(3005)).setIconCoord(6, 7).setItemName("rubyShard");

	// Chainmail fragment
	public static Item chainmailFragment = (new Item(3006)).setIconCoord(0, 9).setItemName("chainmailFragment");

	// Wooden bat
	public static Item bat = (new ItemMelee(3007, EnumMeleeMaterial.M_BAT)).setIconCoord(0, 4).setItemName("bat");

	// Stone mace
	public static Item mace = (new ItemMelee(3008, EnumMeleeMaterial.M_MACE)).setIconCoord(1, 4).setItemName("mace");

	// Spear
	public static Item spear = (new ItemMelee(3032, EnumMeleeMaterial.M_SPEAR)).setIconCoord(0, 5).setItemName("spear");

	// Hammers
	public static Item stoneHammer = (new ItemHammer(3009, EnumHammerMaterial.STONE)).setIconCoord(3, 4).setItemName("stoneHammer");
	public static Item ironHammer = (new ItemHammer(3010, EnumHammerMaterial.IRON)).setIconCoord(4, 4).setItemName("ironHammer");

	// Upgradable Armor
	// none
	public static Item ironHelmet = (new ItemUpgradableArmor(3011, 0, 0));
	public static Item ironChest = (new ItemUpgradableArmor(3012, 1, 0));
	public static Item ironLegs = (new ItemUpgradableArmor(3013, 2, 0));
	public static Item ironBoots = (new ItemUpgradableArmor(3014, 3, 0));
	// diamond
	public static Item ironHelmetD = (new ItemUpgradableArmor(3019, 0, 1));
	public static Item ironChestD = (new ItemUpgradableArmor(3020, 1, 1));
	public static Item ironLegsD = (new ItemUpgradableArmor(3021, 2, 1));
	public static Item ironBootsD = (new ItemUpgradableArmor(3022, 3, 1));
	// emerald
	public static Item ironHelmetE = (new ItemUpgradableArmor(3023, 0, 2));
	public static Item ironChestE = (new ItemUpgradableArmor(3024, 1, 2));
	public static Item ironLegsE = (new ItemUpgradableArmor(3025, 2, 2));
	public static Item ironBootsE = (new ItemUpgradableArmor(3026, 3, 2));
	// ruby
	public static Item ironHelmetR = (new ItemUpgradableArmor(3027, 0, 3));
	public static Item ironChestR = (new ItemUpgradableArmor(3028, 1, 3));
	public static Item ironLegsR = (new ItemUpgradableArmor(3029, 2, 3));
	public static Item ironBootsR = (new ItemUpgradableArmor(3030, 3, 3));

	// Iron Nugget
	public static Item ironNugget = (new Item(3015)).setIconCoord(3, 0).setItemName("ironNugget");

	// Upgrade Slot
	public static Item upgradeSlot = (new ItemUpgradeSlot(3016)).setIconCoord(4, 0).setItemName("upgradeSlot");

	// Rock
	public static Item rock = (new Item(3017)).setIconCoord(3, 1).setItemName("rock");

	// Redstone Rock
	public static Item redstoneRock = (new Item(3018)).setIconCoord(3, 2).setItemName("redstoneRock");

	// Iron Sword
	public static Item ironSword = (new ItemMelee(3031, EnumMeleeMaterial.M_SWORD)).setIconCoord(2, 4).setItemName("ironSword");

	// Poop (?)
	public static Item poop = (new Item(3033)).setIconCoord(3, 3).setItemName("poop");

	// Fertilizer
	public static Item fertilizer = (new ItemFertilizer(3034));

	// Iron Sword Upgrades
	public static Item ironSwordI = (new ItemMelee(3035, EnumMeleeMaterial.M_SWORD)).decreaseDurability(25).increaseDamage(2).setIconCoord(2, 4).setItemName("ironSword.iron");
	public static Item ironSwordD = (new ItemMelee(3036, EnumMeleeMaterial.M_SWORD)).decreaseDurability(50).increaseDamage(5).setIconCoord(2, 4).setItemName("ironSword.diamond");

	// Knife
	public static Item knife = (new ItemKnife(3037));

	// Hay
	public static Item hay = (new Item(3038)).setIconCoord(4, 6).setItemName("hay");

	// Cloth
	public static Item cloth = (new Item(3039)).setIconCoord(0, 7).setItemName("cloth");

	// Pillow
	public static Item pillow = (new Item(3040)).setIconCoord(1, 9).setItemName("pillow");

	// Grape
	public static Item grape = (new ItemFood(3041, 2, false)).setIconCoord(15, 0).setItemName("grape");

	// Brews
	public static Item bottle = (new Item(3042)).setIconCoord(9, 6).setItemName("bottle");
	public static Item wine = (new ItemFluid(3043, 5)).setIconCoord(10, 6).setItemName("wine");
	public static Item kvass = (new ItemFluid(3044, 6)).setIconCoord(11, 6).setItemName("kvass");
	public static Item beer = (new ItemFluid(3045, 4)).setIconCoord(12, 6).setItemName("beer");
	public static Item unknownBrew = (new ItemFluid(3046, -2)).setIconCoord(13, 6).setItemName("unknownbrew");
	public static Item cider = (new ItemFluid(3047, 4)).setIconCoord(12, 7).setItemName("cider");

	public final int shiftedIndex;
	protected int maxStackSize = 64;
	private int maxDamage = 0;
	protected int iconIndex;
	protected boolean bFull3D = false;
	protected boolean hasSubtypes = false;
	private Item containerItem = null;
	protected String itemName;

	protected Item(int var1) {
		this.shiftedIndex = 256 + var1;
		if(itemsList[256 + var1] != null) {
			System.out.println("CONFLICT @ " + var1);
		}

		itemsList[256 + var1] = this;
	}

	public String getDamage(int i) {
		String name = "Damage: ";
		String value = String.valueOf(this.getDmg());
		String[] ret = new String[]{name, value};
		return ret[i];
	}

	public int getDmg() { return 1; }

	public Item setIconIndex(int var1) {
		this.iconIndex = var1;
		return this;
	}

	public Item setMaxStackSize(int var1) {
		this.maxStackSize = var1;
		return this;
	}

	public Item setIconCoord(int var1, int var2) {
		this.iconIndex = var1 + var2 * 16;
		return this;
	}

	public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
		return false;
	}

	public float getStrVsBlock(ItemStack var1, Block var2) {
		return 1.0F;
	}

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		return var1;
	}

	public int getItemStackLimit() {
		return this.maxStackSize;
	}

	public int getMetadata(int var1) {
		return 0;
	}

	public boolean getHasSubtypes() {
		return this.hasSubtypes;
	}

	protected Item setHasSubtypes(boolean var1) {
		this.hasSubtypes = var1;
		return this;
	}

	public int getMaxDamage() {
		return this.maxDamage;
	}

	protected Item setMaxDamage(int var1) {
		this.maxDamage = var1;
		return this;
	}

	public boolean func_25005_e() {
		return this.maxDamage > 0 && !this.hasSubtypes;
	}

	public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
		return false;
	}

	public boolean func_25007_a(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
		return false;
	}

	public int getDamageVsEntity(Entity var1) {
		return 1;
	}

	public boolean canHarvestBlock(Block var1) {
		return false;
	}

	public void saddleEntity(ItemStack var1, EntityLiving var2) {
	}

	public Item setFull3D() {
		this.bFull3D = true;
		return this;
	}

	public Item setItemName(String var1) {
		this.itemName = "item." + var1;
		return this;
	}

	public String getItemName() {
		return this.itemName;
	}

	public Item setContainerItem(Item var1) {
		if(this.maxStackSize > 1) {
			throw new IllegalArgumentException("Max stack size must be 1 for items with crafting results");
		} else {
			this.containerItem = var1;
			return this;
		}
	}

	public Item getContainerItem() {
		return this.containerItem;
	}

	public boolean hasContainerItem() {
		return this.containerItem != null;
	}

	public String func_25006_i() {
		return StatCollector.translateToLocal(this.getItemName() + ".name");
	}

	public void func_28018_a(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
	}

	public void func_28020_c(ItemStack var1, World var2, EntityPlayer var3) {
	}

	public boolean func_28019_b() {
		return false;
	}

	static {
		StatList.func_25086_b();
	}
}
