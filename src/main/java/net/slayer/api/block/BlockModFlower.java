package net.slayer.api.block;

import net.journey.init.JourneyTabs;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockModFlower extends BlockMod implements IPlantable {

    protected static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);
    protected boolean damageWhenContact = false;
    private boolean isTallGrass = false;
    private boolean isFrozenPlant = false;

    public BlockModFlower(String name, String finalName) {
        super(EnumMaterialTypes.PLANT, name, finalName, 0.0F);
        this.setTickRandomly(true);
        this.setCreativeTab(JourneyTabs.DECORATION);
    }

    public BlockModFlower(String name, String finalName, boolean tallgrass) {
        super(EnumMaterialTypes.PLANT, name, finalName, 0.0F);
        this.setTickRandomly(true);
        this.setCreativeTab(JourneyTabs.DECORATION);
        this.isTallGrass = tallgrass;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BUSH_AABB;
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public BlockModFlower setContactDamage() {
        damageWhenContact = true;
        return this;
    }

    public BlockModFlower setFrozenPlant() {
        isFrozenPlant = true;
        return this;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (isTallGrass) {
            return null;
        } else {
            return SlayerAPI.toItem(this);
        }
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
            player.addStat(StatList.getBlockStats(this));
            spawnAsEntity(worldIn, pos, new ItemStack(this, 1));
        } else {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World w, BlockPos pos, Random random) {
        if (isFrozenPlant) {
            if (random.nextInt(15) == 0) {
                for (int i = 0; i < 6; ++i) {
                    double d0 = (double) pos.getX() + rand.nextDouble();
                    double d1 = (double) pos.getY() + rand.nextDouble() * 0.5D + 0.7D;
                    double d2 = (double) pos.getZ() + rand.nextDouble();
                    w.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    @Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (damageWhenContact) entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
    }

    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
        this.checkAndDropBlock(worldIn, pos, state);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.checkAndDropBlock(worldIn, pos, state);
    }

    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!this.canBlockStay(worldIn, pos, state)) {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getBlock() == this) {
            IBlockState soil = worldIn.getBlockState(pos.down());
            return soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
        }
        return this.canSustainBush(worldIn.getBlockState(pos.down()));
    }

    public boolean canBlockStay(World w, BlockPos pos) {
        return canPlaceBlockAt(w, pos);
    }

    @Override
    public BlockModFlower setLightLevel(float value) {
        this.lightValue = (int) (15.0F * value);
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return getDefaultState();
    }
}