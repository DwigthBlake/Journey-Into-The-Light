package net.journey.items.swords;

import net.journey.client.render.particles.EntityFloroWaterFX;
import net.journey.util.JourneyToolMaterial;
import net.journey.util.PotionEffects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemModSword;

import java.util.List;
import java.util.Random;

public class ItemFireHealthSword extends ItemModSword {

    private float health;

    public ItemFireHealthSword(String name, String f, JourneyToolMaterial toolMaterial, float health) {
        super(name, f, toolMaterial);
        this.health = health;
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase hit, EntityLivingBase player) {
        Random r = new Random();
        hit.setFire(10);
        float hearts = player.getHealth();
        if ((hearts >= 1F) & (hearts < 20F)) {
            player.setHealth(hearts + this.health);
        }
        else if(r.nextInt(4) == 0) {
        	player.setHealth(hearts - 10);
        }
        player.addPotionEffect(new PotionEffect(PotionEffects.setPotionEffect(PotionEffects.moveSlow, 100, 2)));
        addParticles(hit);
        return super.hitEntity(par1ItemStack, hit, player);
    }

    @SideOnly(Side.CLIENT)
    public void addParticles(EntityLivingBase hit) {
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(new EntityFloroWaterFX(hit.world, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0.0D, 0.0D, 0.0D));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, World player, List<String> infoList, ITooltipFlag par4) {
        infoList.add(SlayerAPI.Colour.DARK_GREEN + "On hit: Sets enemies ablaze and heals player " + health / 2 + " heart(s)");
        infoList.add(SlayerAPI.Colour.RED + "Drawback: slows the user on hit");
        infoList.add(SlayerAPI.Colour.RED + "Random chance to steal 5 full hearts from the user on hit");
        if (item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        else infoList.add(SlayerAPI.Colour.GREEN + "Infinite Uses");
    }
}