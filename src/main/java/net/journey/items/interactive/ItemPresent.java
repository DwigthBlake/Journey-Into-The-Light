package net.journey.items.interactive;

import net.journey.init.JourneySounds;
import net.journey.init.JourneyTabs;
import net.journey.init.items.JourneyItems;
import net.journey.util.LangHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemPresent extends ItemMod {

    public ItemPresent(String name, String f) {
        super(name, f, JourneyTabs.UTIL);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        Random r = new Random();
        items.add(new ItemStack(JourneyItems.frostFlake, 6));
        items.add(new ItemStack(JourneyItems.blueGem, 8));
        items.add(new ItemStack(JourneyItems.frostGem, 2));
        items.add(new ItemStack(JourneyItems.crystalFlake, 6));
        items.add(new ItemStack(Items.SNOWBALL, 12));
        items.add(new ItemStack(Blocks.ICE, 4));
        items.add(new ItemStack(Items.DIAMOND));
        if (!world.isRemote) {
            JourneySounds.playSound(JourneySounds.WRAPPER, world, player);
            int index = r.nextInt(items.size());
            String name = LangHelper.getFormattedText(items.get(index).getItem().getTranslationKey() + ".name");
            SlayerAPI.addChatMessage(player, "You recieved " + name);
            EntityItem item = new EntityItem(world, player.posX, player.posY, player.posZ, items.get(index));
            world.spawnEntity(item);
        }
        player.getHeldItem(handIn).shrink(1);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
    }

    @Override
    public void addInformation(ItemStack i, World worldIn, List<String> l, ITooltipFlag flagIn) {
        l.add("Right click to open");
    }
}