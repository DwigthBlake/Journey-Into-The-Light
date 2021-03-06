package net.journey.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.journey.entity.mob.overworld.EntityIceMage;
import net.journey.init.items.JourneyArmory;
import net.journey.init.items.JourneyConsumables;
import net.journey.init.items.JourneyItems;
import net.journey.util.handler.Helper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.slayer.api.PlayerHelper;

public class PlayerEvent {

	public static double rand;
	public static Random random;

	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event) {
		EntityPlayer p = event.getHarvester();
		ItemStack helmet;
		if(event.getHarvester() != null && event.getHarvester() instanceof EntityPlayer && event.getHarvester().getHeldItemMainhand() != null) {
			if(!event.isSilkTouching()) {
				if(event.getHarvester().getHeldItemMainhand().getItem() == JourneyArmory.multiToolOfEternalSmelting) {
					ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.getState().getBlock()));
					if(stack != null && event.getState().getBlock() != Blocks.REDSTONE_ORE && event.getState().getBlock() != Blocks.LAPIS_ORE && event.getState().getBlock() != Blocks.LAPIS_ORE) {
						event.getDrops().clear();
						event.getDrops().add(stack.copy());
					}
				}
				if(event.getHarvester().getHeldItemMainhand().getItem() == JourneyArmory.SLIMY_PICKAXE) {
					for(ItemStack s : event.getDrops()) {
						EntityItem item = new EntityItem(event.getWorld(), p.getPosition().getX(), p.getPosition().getY(), p.getPosition().getZ());
						item.setItem(s);
						event.getWorld().spawnEntity(item);
						event.getDrops().clear();
					}
				}
				helmet = p.inventory.armorInventory.get(3);
				if(helmet.getItem() == JourneyArmory.MASK_OF_HELLMETAL) {
					ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.getState().getBlock()));
					if(stack != null) {
						event.getDrops().clear();
						event.getDrops().add(stack.copy());
						helmet.damageItem(1, p);
					} else if (stack == null) {
						event.getDrops();
					}
				}
				if (event.getHarvester().getHeldItemMainhand().getItem() == JourneyArmory.HOE_OF_EARTH_LOVING) {
					ItemStack item = ForgeHooks.getGrassSeed(random, 1);
					event.getDrops().add(item);
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerLogged(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			NBTTagCompound nbt = PlayerHelper.getPersistedpTag(player);
			if (!event.getWorld().isRemote) {
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
				if (nbt.hasKey("health")) {
					player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(nbt.getDouble("health"));
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.getSource().getDamageType().equals("player")) {
			PlayerEvent.rand = Math.random();
			if (event.getEntityLiving() instanceof EntityGhast) {
				if (PlayerEvent.rand < 3) {
					event.getEntityLiving().dropItem(JourneyConsumables.ghastTentacle, 1);
				}
			}
		}
	}

	/* @SubscribeEvent
	public void bonemealUsed(BonemealEvent event, BlockPos pos) {
		if(event.world.getBlockState(new BlockPos(event.pos.getX(), event.pos.getY(), event.pos.getZ())) == JourneyBlocks.sizzleberryBush) {
			((BlockModBush)JourneyBlocks.sizzleberryBush)
		}
	} */
}