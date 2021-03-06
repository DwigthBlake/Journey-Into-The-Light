package net.journey.dimension.overworld.gen;

import net.journey.init.blocks.JourneyBlocks;
import net.journey.util.MathUtils;
import net.journey.util.RandUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

import java.util.Random;

public class WorldGenSmallGlowshrooms extends WorldGenerator {

    @Override
    public boolean generate(World w, Random r, BlockPos zeroPos) {
        boolean generated = false;
        BlockPos genPos = WorldGenAPI.optimizeAndRandomize(zeroPos, r);

        int coercedY = MathUtils.coerceInRange(WorldGenAPI.findPosAboveSurface(w, genPos).getY(), 1, 60);
        int genY = r.nextInt(coercedY) + 1;
        genPos = WorldGenAPI.getPosWithHeight(genPos, genY);

        Block shroom = RandUtils.chooseEqual(r,
                JourneyBlocks.glowshroomRed,
                JourneyBlocks.glowshroomGreen,
                JourneyBlocks.glowshroomBlue);

        if (!w.getBlockState(genPos).getMaterial().isLiquid()
                && w.getBlockState(genPos.down()).getBlock() == Blocks.STONE
                && shroom.canPlaceBlockAt(w, genPos)) {

            setBlockAndNotifyAdequately(w, genPos, shroom.getDefaultState());
            generated = true;
        }

        return generated;
    }
}