package net.journey.entity.mob.overworld;

import net.journey.entity.MobStats;
import net.journey.entity.projectile.EntityFireBall;
import net.journey.init.JourneySounds;
import net.journey.init.items.JourneyWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

import javax.annotation.Nullable;

public class EntityFireMage extends EntityModMob implements IRangedAttackMob {


    public EntityFireMage(World par1World) {
        super(par1World);
    }

    @Override
    protected void initEntityAI() {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 0.27F, 30, 10.0F));
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(JourneyWeapons.fireWand));
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setEquipmentBasedOnDifficulty(difficulty);
        return livingdata;
    }

    @Override
    public ItemStack getHeldItem(EnumHand hand) {
        return new ItemStack(JourneyWeapons.fireWand);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        EntityFireBall b = new EntityFireBall(this.world, this, 1.0F);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - b.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        b.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float) (14 - this.world.getDifficulty().getId() * 4));
        JourneySounds.playSound(JourneySounds.MAGIC_SPARKLE, world, this);
        this.world.spawnEntity(b);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.isValidLightLevel() &&
                this.world.getBlockState(new BlockPos(this.posX, this.posY - 1, this.posZ)).isFullBlock() && this.dimension == 0 || this.dimension == 1;
    }

    @Override
    public double setAttackDamage(MobStats s) {
        return 0;
    }

    @Override
    public double setMaxHealth(MobStats s) {
        return MobStats.FireMageHealth;
    }

    @Override
    public SoundEvent setLivingSound() {
        return JourneySounds.INSECTO;
    }

    @Override
    public SoundEvent setHurtSound() {
        return JourneySounds.INSECTO_HURT;
    }

    @Override
    public SoundEvent setDeathSound() {
        return JourneySounds.INSECTO_HURT;
    }

    @Override
    public Item getItemDropped() {
        return null;
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {

    }
}