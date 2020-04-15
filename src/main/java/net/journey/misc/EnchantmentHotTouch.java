package net.journey.misc;

import net.journey.init.JourneyEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

public class EnchantmentHotTouch extends Enchantment {

    public EnchantmentHotTouch() {
        super(Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        this.setName("Hot Touch");
        setRegistryName(new ResourceLocation(SlayerAPI.MOD_ID, "Hot Touch"));
        JourneyEnchantments.enchantments.add(this);
    }

    @Override
    public boolean canApply(ItemStack par1ItemStack) {
        return par1ItemStack.getItem() instanceof ItemTool;
    }

    @Override
    public int getMaxEnchantability(int par1) {
        return super.getMinEnchantability(par1) + 50;
    }

    @Override
    public int getMinEnchantability(int par1) {
        return 20;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canApplyTogether(Enchantment e) {
        return super.canApplyTogether(e) && e != this && e != Enchantments.FORTUNE && e != Enchantments.SILK_TOUCH;
    }
}