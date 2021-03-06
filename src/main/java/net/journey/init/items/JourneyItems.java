package net.journey.init.items;

import net.journey.init.JourneySounds;
import net.journey.items.*;
import net.journey.items.interactive.ItemAddEssence;
import net.journey.items.interactive.ItemAddXP;
import net.journey.items.interactive.ItemAncientCatalyst;
import net.journey.items.interactive.ItemAncientPiece;
import net.journey.items.interactive.ItemCrafting;
import net.journey.items.interactive.ItemDarkGem;
import net.journey.items.interactive.ItemDemonicEye;
import net.journey.items.interactive.ItemEternalNight;
import net.journey.items.interactive.ItemLootPouch;
import net.journey.items.interactive.ItemNetherBossSpawner;
import net.journey.items.interactive.ItemPresent;
import net.journey.items.interactive.ItemRestoreHealth;
import net.journey.items.interactive.ItemSentryEye;
import net.journey.items.interactive.ItemSpecificDimensionSpawner;
import net.journey.util.Config;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.slayer.api.item.ItemMod;

import java.util.ArrayList;

public class JourneyItems {

    public static final EntityEquipmentSlot HEAD = EntityEquipmentSlot.HEAD, BODY = EntityEquipmentSlot.CHEST, LEGS = EntityEquipmentSlot.LEGS, BOOTS = EntityEquipmentSlot.FEET;
    //overworld
    public static ToolMaterial shadiumSwordMat = addToolMaterial(2210, 13F, 8.5F, true);
    public static ToolMaterial luniumSwordMat = addToolMaterial(2210, 13F, 8.5F, true);
    public static ToolMaterial sapphiretoolSwordMat = addToolMaterial(1561, 13F, 8, true);
    
    //nether
    public static ToolMaterial hellstoneSwordMat = addToolMaterial(2356, 13F, 8.5F, true);
    
    //euca
    public static ToolMaterial mekyumSwordMat = addToolMaterial(3120, 13F, 11.5F, true);
    public static ToolMaterial storonSwordMat = addToolMaterial(3120, 13F, 11.5F, true);
    public static ToolMaterial koriteSwordMat = addToolMaterial(3120, 13F, 11.5F, true);
    public static ToolMaterial celestiumSwordMat = addToolMaterial(3120, 13F, 11.5F, true);
    
    //depths
    public static ToolMaterial flairiumSwordMat = addToolMaterial(3120, 14.5F, 12, true);
    public static ToolMaterial desSwordMat = addToolMaterial(3120, 15F, 13, true);
    
    //corba
    public static ToolMaterial gorbiteSwordMat = addToolMaterial(3120, 13F, 16.5F, true);
    public static ToolMaterial orbaditeSwordMat = addToolMaterial(3120, 13F, 16.5F, true);

    public static ToolMaterial sapphiretool = addToolMaterial(1461, 10F, 5F, true);
    public static ToolMaterial lunium = addToolMaterial(1490, 12F, 5F, true);
    public static ToolMaterial shadium = addToolMaterial(1521, 12F, 5F, true);
    public static ToolMaterial hellstone = addToolMaterial(1432, 15F, 5F, true);
    public static ToolMaterial nethic = addToolMaterial(481, 21F, 5F, true);
    public static ToolMaterial celestium = addToolMaterial(1621, 18F, 5F, true);
    public static ToolMaterial mekyum = addToolMaterial(1621, 18F, 5F, true);
    public static ToolMaterial storon = addToolMaterial(1621, 18F, 5F, true);
    public static ToolMaterial korite = addToolMaterial(1621, 18F, 5F, true);
    public static ToolMaterial flairium = addToolMaterial(2130, 21F, 5F, true);
    public static ToolMaterial des = addToolMaterial(2130, 21F, 5F, true);
    public static ToolMaterial orbadite = addToolMaterial(3142, 28F, 5F, true);
    public static ToolMaterial gorbite = addToolMaterial(3142, 28F, 5F, true);
    public static ToolMaterial hoeoflife = addToolMaterial(126, 28F, 5F, true);
    public static ToolMaterial hoeofearth = addToolMaterial(512, 28F, 5F, true);
    public static ToolMaterial hellstoneMulti = addToolMaterial(3000, 10F, 5F, false);
    public static ToolMaterial flairiumMulti = addToolMaterial(3000, 16F, 5F, false);
    public static ToolMaterial luniumMulti = addToolMaterial(3000, 7F, 5F, false);
    public static ToolMaterial celestiumMulti = addToolMaterial(3000, 13F, 5F, false);
    public static ToolMaterial mekyumMulti = addToolMaterial(3000, 13F, 5F, false);
    public static ToolMaterial storonMulti = addToolMaterial(3000, 13F, 5F, false);
    public static ToolMaterial koriteMulti = addToolMaterial(3000, 13F, 5F, false);
    public static ToolMaterial shadiumMulti = addToolMaterial(3000, 9F, 5F, false);
    public static ToolMaterial sapphireMulti = addToolMaterial(3000, 7F, 5F, false);
    public static ToolMaterial orbaditeMulti = addToolMaterial(3000, 20F, 5F, false);
    public static ToolMaterial gorbiteMulti = addToolMaterial(3000, 20F, 5F, false);
    public static ToolMaterial desMulti = addToolMaterial(3000, 16F, 5F, false);
    public static ToolMaterial smeltingMulti = addToolMaterial(3000, 8F, 5F, false);
    public static ToolMaterial SLIMY_PICK_MATERIAL = addToolMaterial(3000, 2F, 5F, true);
    public static ToolMaterial BEDROCK_SHOVEL_MATERIAL = addToolMaterial(1000, 4F, 5F, false);
    
    //TODO MATERIALS
    public static ToolMaterial woodMulti = addToolMaterial(60, 2F, 5F, false);
    public static ToolMaterial stoneMulti = addToolMaterial(132, 3F, 5F, false);
    public static ToolMaterial ironMulti = addToolMaterial(251, 4F, 5F, false);
    public static ToolMaterial goldMulti = addToolMaterial(33, 5F, 5F, false);
    public static ToolMaterial diamondMulti = addToolMaterial(1562, 6F, 5F, false);
    public static ArrayList<String> itemNames = new ArrayList<String>();//TODO is it really needed?
    public static ArrayList<Item> items = new ArrayList<Item>();
    public static Item hellstoneIngot;
    public static Item shadiumIngot;
    public static Item celestiumIngot;
    public static Item mekyumIngot;
    public static Item koriteIngot;
    public static Item storonIngot;
    public static Item luniumIngot;
    public static Item flairiumIngot;
    public static Item ash;
    public static Item sapphire;
    public static Item blazium;
    public static Item enderilliumShard;
    public static Item orbaditeIngot;
    public static Item gorbiteGem;
    public static Item desIngot;
    public static Item darkGem;
    
    public static Item ANCIENT_EYE_OF_OPENING;
    
    public static Item LAMENT_DECONSTRUCTOR_NETHER;
    public static Item LAMENT_DECONSTRUCTOR_BOIL;
    public static Item LAMENT_DECONSTRUCTOR_EUCA;
    public static Item LAMENT_DECONSTRUCTOR_DEPTHS;
    public static Item LAMENT_DECONSTRUCTOR_CORBA;
    public static Item LAMENT_DECONSTRUCTOR_TERRANIA;
    public static Item LAMENT_DECONSTRUCTOR_CLOUDIA;
    public static Item LAMENT_DECONSTRUCTOR_SENTRY;
    
    public static Item SENTRY_DISK;
    public static Item SENTERIAN_SOUL;
    public static Item SENTRY_OBSERVER;

    public static Item obsidianRod;

    public static Item ancientPiece_1;
    public static Item ancientPiece_2;
    public static Item ancientPiece_3;
    public static Item ancientPiece_4;

    public static Item bleedstone;
    public static Item smithstone;

    public static Item bleedstonedust;
    public static Item smithstonedust;

    public static Item nethicgemstone;

    public static Item elderKey;
    public static Item boilPowder;
    public static Item blazingFireball;
    public static Item hellTurtleShell;
    public static Item sizzlingEye;

    public static Item sentryEye;
    public static Item boilingSkull;
    public static Item overgrownNatureBall;
    public static Item overseeingTablet;
    public static Item overseeingEye;
    public static Item darkCrystal;
    public static Item blankKnowledge;
    public static Item darkOrb;
    public static Item depthsFlake;
    public static Item beastlyStomach;
    public static Item rocFeather;
    public static Item coldClump;
    public static Item crystalEye;
    public static Item crystalFlake;
    public static Item freezingTablet;
    public static Item frostFlake;
    public static Item frostGem;
    public static Item frozenIceball;
    public static Item snowsheet;
    public static Item gateKeys;
    public static Item goldClump;
    public static Item silverClump;
    public static Item golderDust;
    public static Item shimmerdust;
    public static Item royalDisk;
    public static Item metalDisk;
    public static Item demonicDust;
    public static Item demonicBone;
    public static Item withicDust;
    public static Item cloudiaOrb;
    public static Item fluffyFeather;
    public static Item golemChunk;
    public static Item luniteChunk;
    public static Item corbaStick;
    public static Item spyclopseEye;
    public static Item caveCrystal;
    public static Item caveDust;
    public static Item stoneClump;
    public static Item enchantedLeaf;
    public static Item baseEssence;
    public static Item cloudPuff;
    public static Item collectorRock;
    public static Item natureTablet;
    public static Item horn;
    public static Item scale;
    public static Item reinforcedStoneIngot;
    public static Item reinforcedCrystalIngot;
    public static Item crystalBall;
    public static Item stoneStick;
    public static Item darkTerrarianSoil;
    public static Item earthenCrystal;
    public static Item lightTerrarianSoil;
    public static Item terrastar;
    public static Item purplePowder;
    public static Item hellShards;
    public static Item hellcrustIngot;
    public static Item flamingSprocket;
    public static Item flamingSpring;
    public static Item blood;
    public static Item concentratedBlood;
    public static Item snakeSkin;
    public static Item withicSpine;
    public static Item lostSoul;
    public static Item withicSoul;
    public static Item eucaPortalPiece;
    public static Item eucaPortalPiece_1;
    public static Item eucaPortalPiece_0;
    public static Item flamingHide;
    public static Item boilKey;
    public static Item darkKey;
    public static Item depthsKey;

    public static Item hellstoneDust;
    public static Item shadiumDust;
    public static Item celestiumDust;
    public static Item luniumDust;
    public static Item flairiumDust;
    public static Item ashDust;
    public static Item sapphireDust;
    public static Item enderilliumDust;
    public static Item gorbiteDust;
    public static Item orbaditeDust;
    public static Item diamondDust;
    public static Item goldDust;
    public static Item ironDust;

    public static Item hellstoneClump;
    public static Item shadiumClump;
    public static Item luniumClump;
    public static Item spawnerClump;
    public static Item spawnerBar;

    public static Item flameCoin;
    public static Item essenceDetractor;
    public static Item essenceAttractor;

    public static Item rockChunk;
    public static Item rockShard;
    public static Item slugSlime;

    public static Item eucaPortalGem;
    public static Item depthsPortalGem;
    public static Item corbaPortalGem;
    public static Item terraniaPortalGem;
    public static Item cloudiaPortalGem;
    //public static Item wastelandPortalGem;

    public static Item calciaOrb;
    public static Item netherBeastOrb;
    public static Item witheringBeastOrb;
    public static Item eudorOrb;
    public static Item blazierOrb;
    public static Item rocSpawnEgg;
    public static Item soulWatcherOrb;
    public static Item sentryKingOrb;
    public static Item loggerOrb;
    public static Item thunderbirdOrb;
    public static Item mysteriousDisk;
    public static Item corallatorOrb;
    public static Item scaleOrb;
    public static Item enchantedTerrastar;
    public static Item weakEssencePotion;
    public static Item strongEssencePotion;
    public static Item essenceArrow;
    public static Item tippedEssenceArrow;
    public static Item greenGem;
    public static Item purpleGem;
    public static Item blueGem;
    public static Item yellowGem;
    public static Item eucaTablet;
    public static Item wandBase;
    public static Item staffBase;
    public static Item frostyGift;
    public static Item firestoneClump;

    public static Item underwaterWorldRecord;
    public static Item blueWaterRecord;
    public static Item raceStarRecord;
    public static Item compBeginsRecord;
    public static Item deepBlueRecord;
    public static Item raceShoreRecord;
    public static Item untitled_disc;
    public static Item bogRecord;
    public static Item cloudsRecord;
    public static Item stalactiteRecord;
    public static Item cavernRecord;
    public static Item goldRecord;
    public static Item gateRecord;
    public static Item journeyRecord;
    public static Item sizzleRecord;
    public static Item fireflyRecord;
    public static Item snowbellsRecord;

    public static Item demonicEye;

    public static Item iridium;
    
    public static Item LOOT_POUCH;
    public static Item BALMY_TEARDROP;
    public static Item CHARM_OF_VINE_STRANDING;
    public static Item CHARM_OF_WATER_BENDING;
    public static Item CLOUD_BUCKLER;
    public static Item CURSED_TOMB;
    public static Item DEATH_CAP;
    public static Item DEMONIC_SKULL;
    public static Item ESSENCE_BUCKLER;
    public static Item ESSENCE_CATALYST;
    public static Item ESSENCE_SHURIKEN;
    public static Item FIERY_STABBER;
    public static Item GLACIAL_BLADE;
    public static Item GLOSSY_EYE;
    public static Item HEART_STONE;
    public static Item LIGHT_BUCKLER;
    public static Item MAGIC_DUST;

    public static Item MOON_OF_ETERNAL_NIGHT;
    public static Item NETHIC_OBSTRUCTOR;
    public static Item PICKAXE_OF_GOOD_FORTUNE;
    public static Item SLIME_BERRY;
    public static Item SLIMUN;
    public static Item TERRA_BUCKLER;
    public static Item WITHIC_OBSTRUCTOR;
    public static Item XP_CATALYST;
    public static Item AQUASTONE;
    public static Item VOLCANIC_STONE;
    public static Item CHEST_KEY;

    //public static Item obsidianBoat;

    //public static Item infernoshield;

    public static void init() {

        hellstoneIngot = new ItemMod("hellstoneIngot", "Hellstone Ingot");
        shadiumIngot = new ItemMod("shadiumIngot", "Shadium Ingot");
        celestiumIngot = new ItemMod("celestiumIngot", "Celestium Ingot");
        mekyumIngot = new ItemMod("mekyumIngot", "Mekyum Ingot");
        koriteIngot = new ItemMod("koriteIngot", "Korite Ingot");
        storonIngot = new ItemMod("storonIngot", "Storon Ingot");
        luniumIngot = new ItemMod("luniumIngot", "Lunium Ingot");
        flairiumIngot = new ItemMod("flairiumIngot", "Flairium Ingot");
        ash = new ItemMod("ash", "Ash");
        sapphire = new ItemMod("sapphire", "Sapphire Gem");
        blazium = new ItemMod("blazium", "Blazium Gem");
        enderilliumShard = new ItemMod("enderilliumShard", "Enderillium Shard");
        orbaditeIngot = new ItemMod("orbaditeIngot", "Orbadite Ingot");
        gorbiteGem = new ItemMod("gorbiteGem", "Gorbite Gem");
        desIngot = new ItemMod("desIngot", "Des Ingot");
        bleedstone = new ItemMod("bleedstone", "Bleedstone");
        smithstone = new ItemMod("smithstone", "Smithstone");
        nethicgemstone = new ItemMod("soulstone", "Soulstone");

        ancientPiece_1 = new ItemAncientPiece("ancientpiece_1", "Ancient Piece");
        ancientPiece_2 = new ItemAncientPiece("ancientpiece_2", "Ancient Shard");
        ancientPiece_3 = new ItemAncientPiece("ancientpiece_3", "Ancient Chunk");
        ancientPiece_4 = new ItemAncientPiece("ancientpiece_4", "Ancient Fragment");

        spawnerBar = new ItemMod("spawnerBar", "Spawner Bar");
        spawnerClump = new ItemMod("spawnerClump", "Spawner Clump");
        hellstoneClump = new ItemMod("hellstoneClump", "Hellstone Clump");
        shadiumClump = new ItemMod("shadiumClump", "Shadium Clump");
        luniumClump = new ItemMod("luniumClump", "Lunium Clump");
        elderKey = new ItemMod("elderKey", "Elder Key").setMaxStackSize(1);
        boilPowder = new ItemMod("boilPowder", "Boiling Powder");
        blazingFireball = new ItemMod("blazingFireball", "Blazing Fireball");
        hellTurtleShell = new ItemMod("hellTurtleShell", "Hell Turtle Shell");
        sizzlingEye = new ItemMod("sizzlingEye", "Sizzling Eye");
        sentryEye = new ItemSentryEye("sentryEye", "Sentry Eye");
        boilingSkull = new ItemMod("boilingskull", "Boiling Skull");
        overgrownNatureBall = new ItemMod("overgrownNatureBall", "Overgrown Natureball");
        overseeingTablet = new ItemMod("overseeingTablet", "Overseeing Tablet");
        overseeingEye = new ItemMod("overseeingEye", "Overseeing Eye");
        darkCrystal = new ItemMod("darkCrystal", "Dark Crystal");
        darkOrb = new ItemMod("darkOrb", "Dark Orb");
        depthsFlake = new ItemMod("depthsFlake", "Depths Flake");
        beastlyStomach = new ItemMod("beastlyStomach", "Beastly Stomach");
        rocFeather = new ItemMod("rocFeather", "Essence Feather");
        coldClump = new ItemMod("coldClump", "Cold Clump");
        crystalEye = new ItemMod("crystalEye", "Crystal Eye");
        crystalFlake = new ItemMod("crystalFlake", "Crystal Flake");
        freezingTablet = new ItemMod("freezingTablet", "Freezing Tablet");
        frostFlake = new ItemMod("frostFlake", "Frost Flake");
        frostGem = new ItemMod("frostGem", "Frost Gem");
        frozenIceball = new ItemMod("frozenIceball", "Frozen Iceball");
        snowsheet = new ItemMod("snowsheet", "Snowsheet");
        gateKeys = new ItemMod("gateKeys", "Gate Keys");
        goldClump = new ItemMod("goldClump", "Gold Clump");
        silverClump = new ItemMod("silverClump", "Silver Clump");
        golderDust = new ItemMod("golderDust", "Golder Dust");
        shimmerdust = new ItemMod("shimmerdust", "Shimmer Dust");
        royalDisk = new ItemMod("royalDisk", "Royal Disk");
        metalDisk = new ItemMod("metalDisk", "Metal Disk");
        demonicDust = new ItemMod("demonicDust", "Demonic Dust");
        demonicBone = new ItemMod("demonicBone", "Demonic Bone");
        withicDust = new ItemMod("withicDust", "Withic Dust");
        cloudiaOrb = new ItemMod("cloudiaOrb", "Cloudia Orb");
        fluffyFeather = new ItemMod("fluffyFeather", "Fluffy Feather");
        golemChunk = new ItemMod("golemChunk", "Golem Chunk");
        luniteChunk = new ItemMod("luniteChunk", "Lunite Chunk");
        corbaStick = new ItemMod("corbaStick", "Corba Stick");
        spyclopseEye = new ItemMod("spyclopseEye", "Spyclopse Eye");
        caveCrystal = new ItemMod("caveCrystal", "Cave Crystal");
        caveDust = new ItemMod("caveDust", "Cave Dust");
        stoneClump = new ItemMod("stoneClump", "Stone Clump");
        enchantedLeaf = new ItemMod("enchantedLeaf", "Enchanted Leaf");
        baseEssence = new ItemMod("baseEssence", "Base Essence");
        cloudPuff = new ItemMod("cloudPuff", "Cloud Puff");
        collectorRock = new ItemMod("collectorRock", "Collector Rock");
        natureTablet = new ItemMod("natureTablet", "Nature Tablet");
        horn = new ItemMod("horn", "Horn");
        scale = new ItemMod("scale", "Scale");
        reinforcedStoneIngot = new ItemMod("reinforcedStoneIngot", "Reinforced Stone Ingot");
        reinforcedCrystalIngot = new ItemMod("reinforcedCrystalIngot", "Reinforced Crystal Ingot");
        crystalBall = new ItemMod("crystalBall", "Crystal Ball");
        stoneStick = new ItemMod("stoneStick", "Stone Stick");
        darkTerrarianSoil = new ItemMod("darkTerrarianSoil", "Dark Terrarian Soil");
        earthenCrystal = new ItemMod("earthenCrystal", "EarthenCrystal");
        lightTerrarianSoil = new ItemMod("lightTerrarianSoil", "Light Terrarian Soil");
        terrastar = new ItemMod("terrastar", "Terrastar");
        purplePowder = new ItemMod("purplePowder", "Purple Powder");
        hellShards = new ItemMod("hellShards", "Hell Shards");
        hellcrustIngot = new ItemMod("hellcrustIngot", "Hellcrust Ingot");
        flamingSprocket = new ItemMod("flamingSprocket", "Flaming Sprocket");
        flamingSpring = new ItemMod("flamingSpring", "Flaming Spring");
        blood = new ItemMod("blood", "Blood");
        concentratedBlood = new ItemMod("concentratedBlood", "Concentrated Blood");
        snakeSkin = new ItemMod("snakeSkin", "Snake Skin");
        withicSpine = new ItemMod("withicSpine", "Withic Spine");
        lostSoul = new ItemMod("lostSoul", "Lost Soul");
        withicSoul = new ItemMod("withicSoul", "Withic Soul");
        eucaPortalPiece = new ItemMod("eucaPortalPiece", "Euca Portal Piece");
        eucaPortalPiece_1 = new ItemMod("eucaPortalPiece_1", "Euca Portal Piece");
        eucaPortalPiece_0 = new ItemMod("eucaPortalPiece_0", "Euca Portal Piece");
        flamingHide = new ItemMod("flamingHide", "Flaming Hide");
        boilKey = new ItemMod("boilKey", "Boil Key").setMaxStackSize(1).setMaxDamage(15);
        darkKey = new ItemMod("darkkey", "Dark Key").setMaxStackSize(1);
        depthsKey = new ItemMod("depthskey", "Depths Key").setMaxStackSize(1);

        slugSlime = new ItemMod("slugSlime", "Slug Slime");
        eucaPortalGem = new ItemMod("eucaPortalGem", "Euca Portal Gem");
        depthsPortalGem = new ItemMod("depthsPortalGem", "Depths Portal Gem");
        corbaPortalGem = new ItemMod("corbaPortalGem", "Corba Portal Gem");
        terraniaPortalGem = new ItemMod("terraniaPortalGem", "Terrania Portal Gem");
        cloudiaPortalGem = new ItemMod("cloudiaPortalGem", "Cloudia Portal Gem");
        //wastelandPortalGem = new ItemMod("wastelandPortalGem");
        greenGem = new ItemMod("greenGem", "Green Gem");
        purpleGem = new ItemMod("purpleGem", "Purple Gem");
        blueGem = new ItemMod("blueGem", "Blue Gem");
        yellowGem = new ItemMod("yellowGem", "Yellow Gem");
        eucaTablet = new ItemMod("eucaTablet", "Euca Tablet");
        wandBase = new ItemMod("wandBase", "Wand Base");
        staffBase = new ItemMod("staffBase", "Staff Base");
        firestoneClump = new ItemMod("firestoneClump", "Firestone Clump");
        iridium = new ItemMod("iridium", "Iridium");
        hellstoneDust = new ItemMod("hellstoneDust", "hellstone Dust");
        shadiumDust = new ItemMod("shadiumDust", "Shadium Dust");
        celestiumDust = new ItemMod("celestiumDust", "Celestium Dust");
        luniumDust = new ItemMod("luniumDust", "Lunium Dust");
        flairiumDust = new ItemMod("flairiumDust", "Flairium Dust");
        ashDust = new ItemMod("ashDust", "Ash Dust");
        sapphireDust = new ItemMod("sapphireDust", "Sapphire Dust");
        enderilliumDust = new ItemMod("enderilliumDust", "Enderillium Dust");
        gorbiteDust = new ItemMod("gorbiteDust", "Gorbite Dust");
        orbaditeDust = new ItemMod("orbaditeDust", "Orbadite Dust");
        diamondDust = new ItemMod("diamondDust", "Diamond Dust");
        goldDust = new ItemMod("goldDust", "Gold Dust");
        ironDust = new ItemMod("ironDust", "Iron Dust");
        bleedstonedust = new ItemMod("bleedstonedust", "Bleedstone Dust");
        smithstonedust = new ItemMod("smithstonedust", "Smithstone Dust");

        frostyGift = new ItemPresent("frostyGift", "Frosty Gift");
        flameCoin = new ItemFlameCoin("flameCoin", "Flame Coin");

        calciaOrb = new ItemNetherBossSpawner("calciaOrb", "Calcia Orb");
        netherBeastOrb = new ItemNetherBossSpawner("netherBeastOrb", "Nether Beast Orb");
        witheringBeastOrb = new ItemNetherBossSpawner("witheringBeastOrb", "Withering Soul");
        eudorOrb = new ItemSpecificDimensionSpawner(Config.euca, "eudorOrb", "Valuable Crown", "Euca");
        blazierOrb = new ItemSpecificDimensionSpawner(Config.boil, "blazierOrb", "Burning Fireball", "Boiling Point");
        rocSpawnEgg = new ItemSpecificDimensionSpawner(0, "rocPetSpawnEgg", "Pet Roc Egg", "Overworld");
        soulWatcherOrb = new ItemNetherBossSpawner("soulWatcherOrb", "Soulless Eye");
        sentryKingOrb = new ItemSpecificDimensionSpawner(Config.corba, "sentryKingOrb", "Eye of the Sentry", "Corba");
        loggerOrb = new ItemSpecificDimensionSpawner(Config.corba, "loggerOrb", "Enchanted Log", "Corba");
        thunderbirdOrb = new ItemSpecificDimensionSpawner(Config.depths, "thunderbirdOrb", "Leader's Pearl", "Depths");
        mysteriousDisk = new ItemSpecificDimensionSpawner(Config.cloudia, "mysteriousDisk", "Mysterious Disk", "Cloudia");
        corallatorOrb = new ItemSpecificDimensionSpawner(Config.euca, "corallatorOrb", "Gem of Peculiar Smelting", "Euca");
        scaleOrb = new ItemSpecificDimensionSpawner(Config.depths, "scaleOrb", "Aquatic Egg", "Depths");
        enchantedTerrastar = new ItemSpecificDimensionSpawner(Config.terrania, "enchantedTerrastar", "Enchanted Terrastar", "Terrania");

        weakEssencePotion = new ItemEssencePotion("weakEssencePotion", "Weak Essence Potion", false);
        strongEssencePotion = new ItemEssencePotion("strongEssencePotion", "Strong Essence Potion", true);
        essenceArrow = new ItemEssenceArrow("essenceArrow", "Essence Arrow");

        underwaterWorldRecord = new ItemModRecord("underwaterWorld", "Underwater World", JourneySounds.UNDERWATER_WORLD);
        blueWaterRecord = new ItemModRecord("blueWater", "Blue Water", JourneySounds.BLUE_WATER);
        raceStarRecord = new ItemModRecord("raceStar", "Race Star", JourneySounds.RACE_STAR);
        compBeginsRecord = new ItemModRecord("compBegins", "Competition Begins", JourneySounds.COMPETITION_BEGINS);
        deepBlueRecord = new ItemModRecord("deepBlue", "Deep Blue", JourneySounds.DEEP_BLUE);
        raceShoreRecord = new ItemModRecord("raceShore", "Race to Shore", JourneySounds.RACE_TO_SHORE);
        untitled_disc = new ItemModRecord("untitled_disc", "untitled_disc", JourneySounds.UNTITLED_DISK);
        bogRecord = new ItemModRecord("bog", "Bog", JourneySounds.CORBA_1);
        cloudsRecord = new ItemModRecord("clouds", "Clouds", JourneySounds.CLOUDIA_1);
        stalactiteRecord = new ItemModRecord("stalactite", "Stalactite", JourneySounds.DEPTHS_1);
        cavernRecord = new ItemModRecord("cavern", "Cavern", JourneySounds.DEPTHS_2);
        goldRecord = new ItemModRecord("gold", "Gold", JourneySounds.EUCA_1);
        gateRecord = new ItemModRecord("gate", "Gate", JourneySounds.EUCA_2);
        journeyRecord = new ItemModRecord("journey", "Journey Into the Light", JourneySounds.EUCA_3);
        sizzleRecord = new ItemModRecord("sizzle", "Sizzle", JourneySounds.BOIL_1);
        fireflyRecord = new ItemModRecord("firefly", "Firefly", JourneySounds.TERRANIA_1);
        snowbellsRecord = new ItemModRecord("snowbells", "Snow Bells", JourneySounds.FROZEN_1);

        demonicEye = new ItemDemonicEye("demonicEye", "Demonic Eye");
        darkGem = new ItemDarkGem("darkGem", "Dark Gem");
        ANCIENT_EYE_OF_OPENING = new ItemAncientCatalyst("ancient_eye_of_opening", "Ancient Eye of Opening");
        
        LAMENT_DECONSTRUCTOR_NETHER = new ItemMod("lament_deconstructor_nether", "Lament Deconstructor of Hell");
        LAMENT_DECONSTRUCTOR_BOIL = new ItemMod("lament_deconstructor_boil", "Lament Deconstructor of Fire");
        LAMENT_DECONSTRUCTOR_EUCA = new ItemMod("lament_deconstructor_euca", "Lament Deconstructor of Light");
        LAMENT_DECONSTRUCTOR_DEPTHS = new ItemMod("lament_deconstructor_depths", "Lament Deconstructor of Darkness");
        LAMENT_DECONSTRUCTOR_CORBA = new ItemMod("lament_deconstructor_corba", "Lament Deconstructor of Decay");
        LAMENT_DECONSTRUCTOR_TERRANIA = new ItemMod("lament_deconstructor_terrania", "Lament Deconstructor of Life");
        LAMENT_DECONSTRUCTOR_CLOUDIA = new ItemMod("lament_deconstructor_cloudia", "Lament Deconstructor of Heavan");
        LAMENT_DECONSTRUCTOR_SENTRY = new ItemMod("lament_deconstructor_sentry", "Lament Deconstructor of Death");
        
        SENTRY_DISK = new ItemMod("sentry_disk", "Sentry Disk");
        SENTERIAN_SOUL = new ItemMod("senterian_soul", "Senterian Soul");
        SENTRY_OBSERVER = new ItemMod("sentry_observer", "Sentry Observer");
        
        obsidianRod = new ItemMod("obsidianRod", "Obsidian Rod");
        
        LOOT_POUCH = new ItemLootPouch("loot_pouch", "Loot Pouch");
        BALMY_TEARDROP = new ItemMod("balmy_teardrop", "Balmy Teardrop");
        CHARM_OF_VINE_STRANDING = new ItemMod("charm_of_vine_stranding", "Charm of Vinestranding");
        CHARM_OF_WATER_BENDING = new ItemMod("charm_of_water_bending", "Charm of Waterbending");
        CLOUD_BUCKLER = new ItemMod("cloud_buckler", "Cloud Buckler");
        CURSED_TOMB = new ItemMod("cursed_tomb", "Cursed Tomb");
        DEATH_CAP = new ItemMod("death_cap", "Death Cap");
        DEMONIC_SKULL = new ItemMod("demonic_skull", "Demonic Skull");
        ESSENCE_BUCKLER = new ItemMod("essence_buckler", "Essence Buckler");
        ESSENCE_CATALYST = new ItemAddEssence("essence_catalyst", "Essence Catalyst", 10);
        ESSENCE_SHURIKEN = new ItemMod("essence_shuriken", "Essence Shuriken");
        FIERY_STABBER = new ItemMod("fiery_stabber", "Fiery Stabber");
        GLACIAL_BLADE = new ItemMod("glacial_blade", "Glacial Blade");
        GLOSSY_EYE = new ItemMod("glossy_eye", "Glossy Eye");
        HEART_STONE = new ItemRestoreHealth("heart_stone", "Heart Stone", true);
        LIGHT_BUCKLER = new ItemMod("light_buckler", "Light Buckler");
        MAGIC_DUST = new ItemMod("magic_dust", "Magic Dust");
        MOON_OF_ETERNAL_NIGHT = new ItemEternalNight("moon_of_eternal_night", "Moon of Eternal Night");
        NETHIC_OBSTRUCTOR = new ItemMod("nethic_obstructor", "Nethic Obstructor");
        PICKAXE_OF_GOOD_FORTUNE = new ItemMod("pickaxe_of_good_fortune", "Pickaxe of Good Fortune");
        SLIME_BERRY = new ItemMod("slime_berry", "Slimeberry");
        SLIMUN = new ItemMod("slimun", "Slimun");
        TERRA_BUCKLER = new ItemMod("terra_buckler", "Terra Buckler");
        VOLCANIC_STONE = new ItemMod("volcanic_stone", "Volcanic Stone");
        WITHIC_OBSTRUCTOR = new ItemMod("withic_obstructor", "Withic Obstructor");
        XP_CATALYST = new ItemAddXP("xp_catalyst", "Experience Catalyst", 1);
        CHEST_KEY = new ItemMod("chest_key", "Chest Key");
        AQUASTONE = new ItemMod("aquastone", "Aquastone");
        //obsidianBoat = new ItemObsidianBoat("obsidianboat", "Obsidian Boat");
        //infernoshield = new ItemModShield("infernoshield", "Inferno Shield", 2, false);
    }

    public static ToolMaterial addToolMaterial(int uses, float efficiency, float dam, boolean breakable) {
        return EnumHelper.addToolMaterial("tool", 3, breakable ? uses : -1, efficiency, dam - 4, 30);
    }
}