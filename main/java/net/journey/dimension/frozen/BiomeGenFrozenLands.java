package net.journey.dimension.frozen;

import net.journey.JourneyBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.TempCategory;

public class BiomeGenFrozenLands extends Biome {

    private static BiomeProperties properties = new BiomeProperties("Frozen Lands").setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled().setHeightVariation(0.5F);
    
	public BiomeGenFrozenLands() {
		super(properties);
		this.topBlock = JourneyBlocks.frozenGrass.getDefaultState();
		this.fillerBlock = JourneyBlocks.frozenDirt.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
     }
    
    @Override
    public boolean canRain() {
        return false;
    }
    
    @Override
    public TempCategory getTempCategory() {
        return TempCategory.COLD;
    }
	
	@Override
	public boolean getEnableSnow() {
		return true;
	}
}