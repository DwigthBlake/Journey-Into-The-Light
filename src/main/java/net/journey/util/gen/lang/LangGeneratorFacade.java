package net.journey.util.gen.lang;

import net.journey.JITL;
import net.journey.util.SideExecutor;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.function.Supplier;

/**
 * Generates lang entries and places them in en_us.lang.
 * It doesn't delete en_us.lang!
 * If you don't have any special marks in your lang file,
 * it will generate stuff in its end.
 * <p>
 * All public methods here are runtime-safely. While it works in dev workspace, it will be quietly turned off in runtime.
 * <p>
 * If you have stuff to be generated not in the end of the file, you should place
 * <b>#MARK AUTO GEN START</b> and <b>#MARK AUTO GEN END</b> on any two lines of file, where you want to see generated stuff.
 * Be careful, all lines that are between these two marks will be deleted before generating, so don't place custom lang entries there.
 * <p>
 * Example:
 * <blockquote>
 * <pre>
 *  entity.journey.sentrywalker.name=Sentry Walker
 *
 *  #MARK AUTO GEN START
 *  <- (here generator will create all its entries) ->
 *  #MARK AUTO GEN END
 *
 *  advancement.journey.hello=Hello!
 *  </pre>
 * </blockquote>
 *
 * <p>
 * All lang changes will be applied the next launch after being generated.
 */
public class LangGeneratorFacade {
	private static final LangGenerator generator = JITL.IN_JOURNEY_DEV && FMLCommonHandler.instance().getSide() == Side.CLIENT ? new LangGenerator() : null;

	public static void addBlockEntry(Block block, String enName) {
		SideExecutor.runWhenOn(Side.CLIENT, () -> () -> addLangEntry(LangSection.BLOCKS, block, enName));
	}

	public static void addItemEntry(Item item, String enName) {
		SideExecutor.runWhenOn(Side.CLIENT, () -> () -> addLangEntry(LangSection.ITEMS, item, enName));
	}

	public static void addEntityEntry(EntityEntry entityEntry, String enName) {
		SideExecutor.runWhenOn(Side.CLIENT, () -> () -> addLangEntry(LangSection.ENTITIES, entityEntry, enName));
	}

	public static void addCreativeTabEntry(CreativeTabs creativeTab, String enName) {
		SideExecutor.runWhenOn(Side.CLIENT, () -> () -> addLangEntry(LangSection.CREATIVE_TABS, creativeTab, enName));
	}

	public static void addArmorEntry(ItemArmor item, String enName) {
		SideExecutor.runWhenOn(Side.CLIENT, () -> () -> {
			EntityEquipmentSlot equipmentSlot = item.armorType;

			String suffix;
			switch (equipmentSlot) {
				case HEAD:
					suffix = "Helmet";
					break;
				case CHEST:
					suffix = "Chestplate";
					break;
				case LEGS:
					suffix = "Leggings";
					break;
				case FEET:
					suffix = "Boots";
					break;
				default:
					throw new IllegalStateException("Unsupported equipment slot: " + equipmentSlot);
			}

			addLangEntry(LangSection.ARMOR, item, enName + " " + suffix);
		});
	}

	public static void addMiscEntry(String key, String name) {
		SideExecutor.runWhenOn(Side.CLIENT, () -> () -> addLangEntry(LangSection.MISC, key, name));
	}

	public static void save() {
		if (exists()) generator.save();
	}

	/**
	 * Adds lang entry to provided section.
	 * <p>
	 * <b>SHOULD BE USED ONLY INSIDE {@link SideExecutor#runWhenOn(Side, Supplier)} with {@link Side#CLIENT}, OTHERWISE IT'LL CRASH GAME!</b>
	 */
	private static <T> void addLangEntry(LangSection<T> section, T entry, String enName) {
		if (exists()) generator.addLangEntry(section, entry, enName);
	}

	private static boolean exists() {
		return generator != null;
	}
}
