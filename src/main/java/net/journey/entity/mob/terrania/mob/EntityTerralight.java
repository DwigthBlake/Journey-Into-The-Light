package net.journey.entity.mob.terrania.mob;

import net.journey.JITL;
import net.journey.entity.MobStats;
import net.journey.init.JourneySounds;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModFlying;

import java.util.Random;

public class EntityTerralight extends EntityModFlying {

    public EntityTerralight(World par1World) {
        super(par1World);
        this.moveHelper = new EntityTerralight.ShattererMoveHelper();
        setSize(1F, 1F);
        initEntityAI();
        this.tasks.addTask(5, new EntityTerralight.AIRandomFly());
        setSize(0.5F, 0.5F);
    }

    public void initEntityAI() {
        this.tasks.addTask(5, new EntityTerralight.AIRandomFly());
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
    }

    public int getBrightnessForRender(float p_70070_1_) {
        return 15728880;
    }

    public float getBrightness(float p_70013_1_) {
        return 10.0F;
    }

    @Override
    public double setMaxHealth(MobStats s) {
        return MobStats.TerralightDamage;
    }

    @Override
    public SoundEvent setLivingSound() {
        return JourneySounds.EMPTY;
    }

    @Override
    public SoundEvent setHurtSound() {
        return JourneySounds.EMPTY;
    }

    @Override
    public SoundEvent setDeathSound() {
        return JourneySounds.EMPTY;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        double d1 = this.posX;
        double d2 = this.posY;
        double d3 = this.posZ;
        for (int i = 0; i < 1; ++i) {
        	JITL.proxy.spawnOreParticle(this.world, d1, d2, d3, 1.5F, 0.1F, 1.6F);
        }
    }

    @Override
    public Item getItemDropped() {
        return null;
    }

    @Override
    public boolean shouldRenderInPass(int pass) {
        return pass == 1;
    }

    private class AIRandomFly extends EntityAIBase {
        private EntityTerralight e = EntityTerralight.this;

        public AIRandomFly() {
            this.setMutexBits(1);
        }

        @Override
        public boolean shouldExecute() {
            EntityMoveHelper entitymovehelper = this.e.getMoveHelper();
            if (!entitymovehelper.isUpdating()) {
                return true;
            } else {
                double d0 = entitymovehelper.getX() - this.e.posX;
                double d1 = entitymovehelper.getY() - this.e.posY;
                double d2 = entitymovehelper.getZ() - this.e.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        @Override
        public boolean shouldContinueExecuting() {
            return false;
        }

        @Override
        public void startExecuting() {
            Random random = this.e.getRNG();
            double d0 = this.e.posX + (random.nextFloat() * 2.0F - 1.0F) * 4.0F;
            double d1 = this.e.posY + (random.nextFloat() * 2.0F - 1.0F) * 4.0F;
            double d2 = this.e.posZ + (random.nextFloat() * 2.0F - 1.0F) * 4.0F;
            this.e.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
        }
    }

    private class ShattererMoveHelper extends EntityMoveHelper {
        private EntityTerralight e = EntityTerralight.this;
        private int height;

        public ShattererMoveHelper() {
            super(EntityTerralight.this);
        }

        @Override
        public void onUpdateMoveHelper() {
            if (this.action == Action.MOVE_TO) {
                double d0 = this.posX - this.e.posX;
                double d1 = this.posY - this.e.posY;
                double d2 = this.posZ - this.e.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if (this.height-- <= 0) {
                    this.height += this.e.getRNG().nextInt(5) + 2;
                    d3 = MathHelper.sqrt(d3);
                    if (this.canMove(this.posX, this.posY, this.posZ, d3)) {
                        this.e.motionX += d0 / d3 * 0.1D;
                        this.e.motionY += d1 / d3 * 0.1D;
                        this.e.motionZ += d2 / d3 * 0.1D;
                    } else {
                        this.action = Action.WAIT;
                    }
                }
            }
        }

        private boolean canMove(double x, double y, double z, double h) {
            double d4 = (x - this.e.posX) / h;
            double d5 = (y - this.e.posY) / h;
            double d6 = (z - this.e.posZ) / h;
            AxisAlignedBB axisalignedbb = this.e.getEntityBoundingBox();
            for (int i = 1; i < h; ++i) {
                axisalignedbb = axisalignedbb.offset(d4, d5, d6);
                if (!this.e.world.getCollisionBoxes(this.e, axisalignedbb).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }
}