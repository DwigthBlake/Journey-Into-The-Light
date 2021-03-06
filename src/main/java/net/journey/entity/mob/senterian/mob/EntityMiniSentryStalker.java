package net.journey.entity.mob.senterian.mob;

import net.journey.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityMiniSentryStalker extends EntityModMob {

	public EntityMiniSentryStalker(World par1World) {
		super(par1World);
		this.setSize(0.5F, 1.4F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return 0;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return 0;
	}

	@Override
	public SoundEvent setLivingSound() {
		return null;
	}

	@Override
	public SoundEvent setHurtSound() {
		return null;
	}

	@Override
	public SoundEvent setDeathSound() {
		return null;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}