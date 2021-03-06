package net.journey.api.block.base;

import net.journey.JITL;
import net.journey.api.block.IHasCustomItemPath;
import net.journey.util.StuffConstructor;
import net.minecraft.block.BlockBush;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.slayer.api.EnumMaterialTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Base class for plant blocks.
 * The item model for it should be placed to "models/item/block/plant/" by default.
 */
public class JBlockPlant extends BlockBush implements IHasCustomItemPath {
    private EnumPlantType type = null;

    public JBlockPlant(String name, String enName, CreativeTabs tab) {
        this(EnumMaterialTypes.PLANT, name, enName, tab);
    }

    public JBlockPlant(EnumMaterialTypes type, String name, String enName, CreativeTabs tab) {
        super(type.getMaterial());
        setSoundType(type.getSound());
        StuffConstructor.regAndSetupBlock(this, name, enName, 0.2F, tab);
    }

    @NotNull
    @Override
    public ResourceLocation getItemModelResourceLocation() {
	    return new ResourceLocation(JITL.MOD_ID, "block/plant/" + getRegistryName().getPath());
    }

    public JBlockPlant setType(EnumPlantType type) {
        this.type = type;
        return this;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return type != null ? type : super.getPlantType(world, pos);
    }
}
