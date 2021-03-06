package net.journey.blocks.plant;

import net.journey.JITL;
import net.journey.init.JourneyTabs;
import net.journey.init.blocks.JourneyBlocks;
import net.journey.init.items.JourneyItems;
import net.journey.util.gen.lang.LangGeneratorFacade;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

import java.util.Random;

public class BlockDarkbloom extends Block {

    public String name;

    public BlockDarkbloom(String name, String f, boolean top) {
	    super(EnumMaterialTypes.PLANT.getMaterial());
	    this.name = name;
	    setSoundType(EnumMaterialTypes.PLANT.getSound());
	    setCreativeTab(JourneyTabs.DECORATION);
	    setHardness(0.0F);
	    setLightLevel(0.6F);
	    setTickRandomly(true);
	    setTranslationKey(name);
	    setRegistryName(JITL.MOD_ID, name);
	    LangGeneratorFacade.addBlockEntry(this, f);
	    JourneyBlocks.blocks.add(this);
	    JourneyBlocks.blockName.add(SlayerAPI.PREFIX + name);

	    JourneyItems.items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos) {
        return 220;
    }

    @Override
    public void onPlayerDestroy(World w, BlockPos pos, IBlockState state) {
        checkDestroyed(w, pos, JourneyBlocks.darkbloomTop, JourneyBlocks.darkbloomBottom);
    }

    public void checkDestroyed(World w, BlockPos pos, Block top, Block bottom) {
        if (w.getBlockState(pos.up()) == bottom.getDefaultState() || w.getBlockState(pos.up()) == top.getDefaultState())
            w.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
        if (w.getBlockState(pos.down()) == bottom.getDefaultState() || w.getBlockState(pos.down()) == top.getDefaultState())
            w.setBlockState(pos.down(), Blocks.AIR.getDefaultState());
    }

    @Override
    public boolean canPlaceBlockAt(World w, BlockPos pos) {
        return w.getBlockState(pos.down()).getBlock() == JourneyBlocks.depthsGrass
                || w.getBlockState(pos.down()).getMaterial() == Material.PLANTS;
    }

    @Override
    public void updateTick(World w, BlockPos pos, IBlockState s, Random r) {
        this.checkAndDropBlock(w, pos, s);
    }

    public void checkAndDropBlock(World w, BlockPos pos, IBlockState s) {
        if (!this.canBlockStay(w, pos)) {
            this.dropBlockAsItem(w, pos, s, 0);
            w.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }

    public boolean canBlockStay(World w, BlockPos pos) {
        return canPlaceBlockAt(w, pos);
    }
}