package net.journey.client.render.block;

import net.journey.blocks.tileentity.TileEntitySenterianAltar;
import net.journey.client.render.Textures;
import net.journey.client.render.model.block.ModelSenterianAltar;
import net.journey.init.blocks.JourneyBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.slayer.api.SlayerAPI;
import org.lwjgl.opengl.GL11;

public class SenterianAltarRenderer extends TileEntitySpecialRenderer {

    private Minecraft mc = Minecraft.getMinecraft();
    private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    private ModelSenterianAltar altar = new ModelSenterianAltar();

    @Override
    public void render(TileEntity e, double x, double y, double z, float f, int i1, float i) {
    	TileEntitySenterianAltar te = (TileEntitySenterianAltar)e;
        float scale = 1.0F;
	    GL11.glPushMatrix();
	    GL11.glTranslated(x + 0.5, y + 1.5, z + 0.5);
	    GL11.glRotatef(180F, 0.0F, 0F, 2.0F);
	    bindTexture(Textures.senterianAltar);
	    GL11.glScalef(scale, scale, scale);
	    altar.render(0.0625F, te.getHasOrb());
	    //Helper.print(te.getHasOrb());
	    GL11.glPopMatrix();
    }

//	public static class AltarTEISR extends TileEntityItemStackRenderer {
//
//		private final TileEntitySenterianAltar altar = new TileEntitySenterianAltar();
//
//		@Override
//		public void renderByItem(ItemStack itemStackIn, float partialTicks) {
//			TileEntityRendererDispatcher.instance.render(altar, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks);
//		}
//	}

	public static class SenterianAltarTEISR extends TileEntityItemStackRenderer {

		private final ModelSenterianAltar model = new ModelSenterianAltar();

		@Override
		public void renderByItem(ItemStack itemStackIn) {
			if (itemStackIn.getItem() == SlayerAPI.toItem(JourneyBlocks.senterianAltar)) {
				this.model.render(1.0F, true);
			}
		}
	}
}
