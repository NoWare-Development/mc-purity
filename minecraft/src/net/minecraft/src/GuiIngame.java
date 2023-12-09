package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiIngame extends Gui {
	private static RenderItem itemRenderer = new RenderItem();
	private List chatMessageList = new ArrayList();
	private Random rand = new Random();
	private Minecraft mc;
	public String field_933_a = null;
	private int updateCounter = 0;
	private String recordPlaying = "";
	private int recordPlayingUpFor = 0;
	private boolean field_22065_l = false;
	public float damageGuiPartialTime;
	float prevVignetteBrightness = 1.0F;
	private boolean shouldDrawItem = false;

	public GuiIngame(Minecraft var1) {
		this.mc = var1;
	}

	public void renderGameOverlay(float var1, boolean var2, int var3, int var4) {
		ScaledResolution var5 = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		int var6 = var5.getScaledWidth();
		int var7 = var5.getScaledHeight();

		int sWidth = var6;
		int sHeight = var7;

		int[] gap = {(int)(this.mc.gameSettings.guiGapHorizontal * 10), (int)(this.mc.gameSettings.guiGapVertical * 10)};

		FontRenderer var8 = this.mc.fontRenderer;
		this.mc.entityRenderer.func_905_b();
		GL11.glEnable(GL11.GL_BLEND);
		if(Minecraft.isFancyGraphicsEnabled()) {
			this.renderVignette(this.mc.thePlayer.getEntityBrightness(var1), var6, var7);
		}

		ItemStack var9 = this.mc.thePlayer.inventory.armorItemInSlot(3);
		if(!this.mc.gameSettings.thirdPersonView && var9 != null && var9.itemID == Block.pumpkin.blockID) {
			this.renderPumpkinBlur(var6, var7);
		}

		float var10 = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * var1;
		if(var10 > 0.0F) {
			this.renderPortalOverlay(var10, var6, var7);
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/gui/gui.png"));
		InventoryPlayer var11 = this.mc.thePlayer.inventory;
		this.zLevel = -90.0F;
		this.drawTexturedModalRect(var6 / 2 - 91, (var7 - gap[1]) - 22, 0, 0, 182, 22);
		this.drawTexturedModalRect(var6 / 2 - 91 - 1 + var11.currentItem * 20, (var7 - gap[1]) - 22 - 1, 0, 22, 24, 22);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/gui/icons.png"));
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE_MINUS_DST_COLOR, GL11.GL_ONE_MINUS_SRC_COLOR);
		this.drawTexturedModalRect(var6 / 2 - 7, (var7 - gap[1]) / 2 - 7, 0, 0, 16, 16);
		GL11.glDisable(GL11.GL_BLEND);
		boolean var12 = this.mc.thePlayer.heartsLife / 3 % 2 == 1;
		if(this.mc.thePlayer.heartsLife < 10) {
			var12 = false;
		}

		int var13 = this.mc.thePlayer.health;
		int var14 = this.mc.thePlayer.prevHealth;
		this.rand.setSeed((long)(this.updateCounter * 312871));
		int var15;
		int var16;
		int var17;
		if(this.mc.playerController.shouldDrawHUD()) {
			var15 = this.mc.thePlayer.getPlayerArmorValue();

			/*
			int var18;
			for(var16 = 0; var16 < 10; ++var16) {
				var17 = var7 - 32;
				if(var15 > 0) {
					var18 = var6 / 2 + 91 - var16 * 8 - 9;
					if(var16 * 2 + 1 < var15) {
						this.drawTexturedModalRect(var18, var17, 34, 9, 9, 9);
					}

					if(var16 * 2 + 1 == var15) {
						this.drawTexturedModalRect(var18, var17, 25, 9, 9, 9);
					}

					if(var16 * 2 + 1 > var15) {
						this.drawTexturedModalRect(var18, var17, 16, 9, 9, 9);
					}
				}

				byte var28 = 0;
				if(var12) {
					var28 = 1;
				}

				int var19 = var6 / 2 - 91 + var16 * 8;
				if(var13 <= 4) {
					var17 += this.rand.nextInt(2);
				}

				this.drawTexturedModalRect(var19, var17, 16 + var28 * 9, 0, 9, 9);
				if(var12) {
					if(var16 * 2 + 1 < var14) {
						this.drawTexturedModalRect(var19, var17, 70, 0, 9, 9);
					}

					if(var16 * 2 + 1 == var14) {
						this.drawTexturedModalRect(var19, var17, 79, 0, 9, 9);
					}
				}

				if(var16 * 2 + 1 < var13) {
					this.drawTexturedModalRect(var19, var17, 52, 0, 9, 9);
				}

				if(var16 * 2 + 1 == var13) {
					this.drawTexturedModalRect(var19, var17, 61, 0, 9, 9);
				}
			}
			*/

			// Rendering updated stats
			/* Bars variant */
			boolean shouldRenderArmor = this.mc.thePlayer.getPlayerArmorValue() > 0 ? true : false;
			boolean shouldRenderAir = this.mc.thePlayer.isInsideOfMaterial(Material.water);

			int yOffset = sHeight - 32 - gap[1];
			int xOffsetHealth = sWidth / 2 - 91;
			int xOffsetArmor = sWidth / 2 + 17;

			// Health
			this.drawTexturedModalRect(xOffsetHealth, yOffset, 0, 32, 74, 7);
			int renderingHealth = (int)(this.mc.thePlayer.health * 3.6F);
			if (renderingHealth > 72) renderingHealth = 72;
			if (!var12)
				GL11.glColor4f(0.50F, 0.0F, 0.0F, 1.0F);
			else
				GL11.glColor4f(0.88F, 0.22F, 0.22F, 1.0F);
			this.drawTexturedModalRect(xOffsetHealth, yOffset, 0, 39, 1 + renderingHealth, 7);
			GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

			// Armor
			if (shouldRenderArmor) {
				this.drawTexturedModalRect(xOffsetArmor, yOffset, 0, 32, 74, 7);
				int renderingArmor = (int)(this.mc.thePlayer.getPlayerArmorValue() * 3.6F);
				if (renderingArmor > 72) renderingArmor = 72;
				GL11.glColor4f(0.47F, 0.47F, 0.47F, 1.0f);
				this.drawTexturedModalRect(xOffsetArmor, yOffset, 0, 39, 1 + renderingArmor, 7);
				GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
			}

			// Air
			if (shouldRenderAir) {
				int yOffsetAir = shouldRenderArmor ? yOffset - 9 : yOffset;
				this.drawTexturedModalRect(xOffsetArmor, yOffsetAir, 0, 32, 74, 7);
				int targetAir = (int)(this.mc.thePlayer.air * 10 / 50);
				if (targetAir < 0) targetAir = 0;
				int renderingAir = (int)(targetAir * 1.2);
				if (renderingAir > 72) renderingAir = 72;
				GL11.glColor4f(0.0f, 0.42F, 0.50F, 1.0f);
				this.drawTexturedModalRect(xOffsetArmor, yOffsetAir, 0, 39, 1 + renderingAir, 7);
				GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
			}

			// Text stats
			// health
			int xOffsetText = this.mc.thePlayer.health > 9 ? xOffsetHealth + 31 : xOffsetHealth + 35;
			var8.drawStringWithShadow(String.valueOf(this.mc.thePlayer.health),
									  xOffsetText, yOffset, 0xFFFFFF);
			// armor
			if (shouldRenderArmor) {
				xOffsetText = this.mc.thePlayer.getPlayerArmorValue() > 9 ? xOffsetArmor + 31 : xOffsetArmor + 35;
				var8.drawStringWithShadow(String.valueOf(this.mc.thePlayer.getPlayerArmorValue()),
										  xOffsetText, yOffset, 0xFFFFFF);
			}
			// air
			if (shouldRenderAir) {
				int targetAir = (int)(this.mc.thePlayer.air * 10 / 150);
				if (targetAir < 0) targetAir = 0;
				xOffsetText = targetAir > 9 ? xOffsetArmor + 31 : xOffsetArmor + 35;
				int yOffsetAir = shouldRenderArmor ? yOffset - 9 : yOffset;
				var8.drawStringWithShadow(String.valueOf(targetAir),
										  xOffsetText, yOffsetAir, 0xFFFFFF);
			}

			/*
			if(this.mc.thePlayer.isInsideOfMaterial(Material.water)) {
				var16 = (int)Math.ceil((double)(this.mc.thePlayer.air - 2) * 10.0D / 300.0D);
				var17 = (int)Math.ceil((double)this.mc.thePlayer.air * 10.0D / 300.0D) - var16;

				for(var18 = 0; var18 < var16 + var17; ++var18) {
					if(var18 < var16) {
						this.drawTexturedModalRect(var6 / 2 - 91 + var18 * 8, var7 - 32 - 9, 16, 18, 9, 9);
					} else {
						this.drawTexturedModalRect(var6 / 2 - 91 + var18 * 8, var7 - 32 - 9, 25, 18, 9, 9);
					}
				}
			}
			*/

			// Compass stats
			if (this.mc.thePlayer.hasItemInInventory(Item.compass.shiftedIndex)) {
				int offset = this.mc.gameSettings.showDebugInfo ? 12: 2;

				// drawing coords
				//var8.drawStringWithShadow("x: " + String.valueOf(MathHelper.floor_double(this.mc.thePlayer.posX)), 2, offset, 0xFFFFFF);
				//var8.drawStringWithShadow("y: " + String.valueOf(MathHelper.floor_double(this.mc.thePlayer.posY)), 2, offset + 8, 0xFFFFFF);
				//var8.drawStringWithShadow("z: " + String.valueOf(MathHelper.floor_double(this.mc.thePlayer.posZ)), 2, offset + 16, 0xFFFFFF);

				var8.drawStringWithShadow("x: " + String.valueOf(MathHelper.floor_double(this.mc.thePlayer.posX)) +
																	"  y: " + String.valueOf(MathHelper.floor_double(this.mc.thePlayer.posY)) +
																	"  z: " + String.valueOf(MathHelper.floor_double(this.mc.thePlayer.posZ)),
																	2 + gap[0], offset + gap[1], 0xFFFFFF);

				// facing
				int facing = (MathHelper.floor_double((double)(this.mc.thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
				String facingStr = "";
				switch (facing) {
				case 0:
					facingStr = "north";
					break;
				case 1:
					facingStr = "east";
					break;
				case 2:
					facingStr = "south";
					break;
				case 3:
					facingStr = "west";
					break;
				default:
					facingStr = "?";
					break;
				}
				var8.drawStringWithShadow(facingStr, 2 + gap[0], offset + 9 + gap[1] /*24 if old variant*/, 0xFFFFFF);
			}
		}

		Purity pur = new Purity();
		if (pur.isDebug())
			var8.drawStringWithShadow("DEBUG BUILD",
									  (sWidth / 2) - (var8.getStringWidth("DEBUG BUILD") / 2),
									  2 + gap[1], 0xFFFFFF);

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glPushMatrix();
		GL11.glRotatef(120.0F, 1.0F, 0.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();

		for(var15 = 0; var15 < 9; ++var15) {
			var16 = var6 / 2 - 90 + var15 * 20 + 2;
			var17 = (var7 - gap[1]) - 16 - 3;
			this.renderInventorySlot(var15, var16, var17, var1);
		}

		/* Render picked up item */
		if (this.itemToRender != null) {
			this.renderPickedUp();
		}

		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		if(this.mc.thePlayer.func_22060_M() > 0) {
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			var15 = this.mc.thePlayer.func_22060_M();
			float var27 = (float)var15 / 100.0F;
			if(var27 > 1.0F) {
				var27 = 1.0F - (float)(var15 - 100) / 10.0F;
			}

			var17 = (int)(220.0F * var27) << 24 | 1052704;
			this.drawRect(0, 0, var6, (var7 - gap[1]), var17);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
		}

		String var23;
		if(this.mc.gameSettings.showDebugInfo) {
			GL11.glPushMatrix();
			if(Minecraft.hasPaidCheckTime > 0L) {
				GL11.glTranslatef(0.0F, 32.0F, 0.0F);
			}

			Purity instance = new Purity();
			var8.drawStringWithShadow("Minecraft Purity " + instance.getVersion() + " (" + this.mc.debug + ")", 2 + gap[0], 2 + gap[1], 0xFFFFFF);

			long var24 = Runtime.getRuntime().maxMemory();
			long var29 = Runtime.getRuntime().totalMemory();
			long var30 = Runtime.getRuntime().freeMemory();
			long var21 = var29 - var30;
			var23 = "Used memory: " + var21 * 100L / var24 + "% (" + var21 / 1024L / 1024L + "MB) of " + var24 / 1024L / 1024L + "MB";
			this.drawString(var8, var23, var6 - var8.getStringWidth(var23) - 2 - gap[0], 2 + gap[1], 14737632);
			var23 = "Allocated memory: " + var29 * 100L / var24 + "% (" + var29 / 1024L / 1024L + "MB)";
			this.drawString(var8, var23, var6 - var8.getStringWidth(var23) - 2 - gap[0], 12 + gap[1], 14737632);
			GL11.glPopMatrix();
		}

		if(this.recordPlayingUpFor > 0) {
			float var25 = (float)this.recordPlayingUpFor - var1;
			var16 = (int)(var25 * 256.0F / 20.0F);
			if(var16 > 255) {
				var16 = 255;
			}

			if(var16 > 0) {
				GL11.glPushMatrix();
				GL11.glTranslatef((float)(var6 / 2), (float)(var7 - gap[1] - 48), 0.0F);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				var17 = 16777215;
				if(this.field_22065_l) {
					var17 = Color.HSBtoRGB(var25 / 50.0F, 0.7F, 0.6F) & 16777215;
				}

				var8.drawString(this.recordPlaying, -var8.getStringWidth(this.recordPlaying) / 2, -4, var17 + (var16 << 24));
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
		}

		byte var26 = 10;
		boolean var31 = false;
		if(this.mc.currentScreen instanceof GuiChat) {
			var26 = 20;
			var31 = true;
		}

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, (float)(var7 - gap[1] - 48), 0.0F);

		for(var17 = 0; var17 < this.chatMessageList.size() && var17 < var26; ++var17) {
			if(((ChatLine)this.chatMessageList.get(var17)).updateCounter < 200 || var31) {
				double var32 = (double)((ChatLine)this.chatMessageList.get(var17)).updateCounter / 200.0D;
				var32 = 1.0D - var32;
				var32 *= 10.0D;
				if(var32 < 0.0D) {
					var32 = 0.0D;
				}

				if(var32 > 1.0D) {
					var32 = 1.0D;
				}

				var32 *= var32;
				int var20 = (int)(255.0D * var32);
				if(var31) {
					var20 = 255;
				}

				if(var20 > 0) {
					byte var33 = 2;
					int var22 = -var17 * 9;
					var23 = ((ChatLine)this.chatMessageList.get(var17)).message;
					this.drawRect(var33, var22 - 1, var33 + 320, var22 + 8, var20 / 2 << 24);
					GL11.glEnable(GL11.GL_BLEND);
					var8.drawStringWithShadow(var23, var33, var22, 16777215 + (var20 << 24));
				}
			}
		}

		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);
	}

	private void renderPumpkinBlur(int var1, int var2) {
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("%blur%/misc/pumpkinblur.png"));
		Tessellator var3 = Tessellator.instance;
		var3.startDrawingQuads();
		var3.addVertexWithUV(0.0D, (double)var2, -90.0D, 0.0D, 1.0D);
		var3.addVertexWithUV((double)var1, (double)var2, -90.0D, 1.0D, 1.0D);
		var3.addVertexWithUV((double)var1, 0.0D, -90.0D, 1.0D, 0.0D);
		var3.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		var3.draw();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	private void renderVignette(float var1, int var2, int var3) {
		var1 = 1.0F - var1;
		if(var1 < 0.0F) {
			var1 = 0.0F;
		}

		if(var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.prevVignetteBrightness = (float)((double)this.prevVignetteBrightness + (double)(var1 - this.prevVignetteBrightness) * 0.01D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_ZERO, GL11.GL_ONE_MINUS_SRC_COLOR);
		GL11.glColor4f(this.prevVignetteBrightness, this.prevVignetteBrightness, this.prevVignetteBrightness, 1.0F);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("%blur%/misc/vignette.png"));
		Tessellator var4 = Tessellator.instance;
		var4.startDrawingQuads();
		var4.addVertexWithUV(0.0D, (double)var3, -90.0D, 0.0D, 1.0D);
		var4.addVertexWithUV((double)var2, (double)var3, -90.0D, 1.0D, 1.0D);
		var4.addVertexWithUV((double)var2, 0.0D, -90.0D, 1.0D, 0.0D);
		var4.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		var4.draw();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	private void renderPortalOverlay(float var1, int var2, int var3) {
		if(var1 < 1.0F) {
			var1 *= var1;
			var1 *= var1;
			var1 = var1 * 0.8F + 0.2F;
		}

		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, var1);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/terrain.png"));
		float var4 = (float)(Block.portal.blockIndexInTexture % 16) / 16.0F;
		float var5 = (float)(Block.portal.blockIndexInTexture / 16) / 16.0F;
		float var6 = (float)(Block.portal.blockIndexInTexture % 16 + 1) / 16.0F;
		float var7 = (float)(Block.portal.blockIndexInTexture / 16 + 1) / 16.0F;
		Tessellator var8 = Tessellator.instance;
		var8.startDrawingQuads();
		var8.addVertexWithUV(0.0D, (double)var3, -90.0D, (double)var4, (double)var7);
		var8.addVertexWithUV((double)var2, (double)var3, -90.0D, (double)var6, (double)var7);
		var8.addVertexWithUV((double)var2, 0.0D, -90.0D, (double)var6, (double)var5);
		var8.addVertexWithUV(0.0D, 0.0D, -90.0D, (double)var4, (double)var5);
		var8.draw();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	private void renderInventorySlot(int var1, int var2, int var3, float var4) {
		ItemStack var5 = this.mc.thePlayer.inventory.mainInventory[var1];
		if(var5 != null) {
			float var6 = (float)var5.animationsToGo - var4;
			if(var6 > 0.0F) {
				GL11.glPushMatrix();
				float var7 = 1.0F + var6 / 5.0F;
				GL11.glTranslatef((float)(var2 + 8), (float)(var3 + 12), 0.0F);
				GL11.glScalef(1.0F / var7, (var7 + 1.0F) / 2.0F, 1.0F);
				GL11.glTranslatef((float)(-(var2 + 8)), (float)(-(var3 + 12)), 0.0F);
			}

			itemRenderer.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, var5, var2, var3);
			if(var6 > 0.0F) {
				GL11.glPopMatrix();
			}
			itemRenderer.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, var5, var2, var3);
		}
	}

	public void updateTick() {
		if(this.recordPlayingUpFor > 0) {
			--this.recordPlayingUpFor;
		}

		++this.updateCounter;

		for(int var1 = 0; var1 < this.chatMessageList.size(); ++var1) {
			++((ChatLine)this.chatMessageList.get(var1)).updateCounter;
		}

	}

	public void clearChatMessages() {
		this.chatMessageList.clear();
	}

	public void addChatMessage(String var1) {
		while(this.mc.fontRenderer.getStringWidth(var1) > 320) {
			int var2;
			for(var2 = 1; var2 < var1.length() && this.mc.fontRenderer.getStringWidth(var1.substring(0, var2 + 1)) <= 320; ++var2) {
			}

			this.addChatMessage(var1.substring(0, var2));
			var1 = var1.substring(var2);
		}

		this.chatMessageList.add(0, new ChatLine(var1));

		while(this.chatMessageList.size() > 50) {
			this.chatMessageList.remove(this.chatMessageList.size() - 1);
		}

	}

	public void setRecordPlayingMessage(String var1) {
		this.recordPlaying = "Now playing: " + var1;
		this.recordPlayingUpFor = 60;
		this.field_22065_l = true;
	}

	public void addChatMessageTranslate(String var1) {
		StringTranslate var2 = StringTranslate.getInstance();
		String var3 = var2.translateKey(var1);
		this.addChatMessage(var3);
	}

	private EntityItem itemToRender;
	private int itemAmount = 0;
	private int renderingTime;

	public void setItemToRender(Entity item, int amount) {
		if (item instanceof EntityItem) {
			this.renderingTime = 0;

			if (this.itemToRender != null && this.itemToRender.item.itemID == ((EntityItem)item).item.itemID && this.itemAmount != 0) {
				this.itemAmount += amount;
			}
			else
				this.itemAmount = amount;

			this.itemToRender = (EntityItem)item;
		}
	}

	public void renderPickedUp() {
		ScaledResolution sr = new ScaledResolution(this.mc.gameSettings,
																							 this.mc.displayWidth,
																							 this.mc.displayHeight);
		int[] gap = {(int)(this.mc.gameSettings.guiGapHorizontal * 10), (int)(this.mc.gameSettings.guiGapVertical * 10)};

		int sHeight = sr.getScaledHeight();

		if (this.renderingTime < 2500) {
			String fullString = "+ " + String.valueOf(this.itemAmount) + " " +
				StringTranslate.getInstance().translateNamedKey(this.itemToRender.item.getItemName());

			this.drawGradientRect(2 + gap[0], sHeight - 19 - gap[1],
														this.mc.fontRenderer.getStringWidth(fullString) + 22 + gap[0],
														sHeight - 1 - gap[1], -1073741824, -1073741824);
			this.itemRenderer.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, this.itemToRender.item,
																					2 + gap[0], sHeight - 18 - gap[1]);
			this.mc.fontRenderer.drawStringWithShadow(fullString,
																								21 + gap[0], sHeight - 13 - gap[1], 0xFFFFFF);
			this.renderingTime++;
		}
		else {
			this.renderingTime = 0;
			this.itemToRender = null;
			this.itemAmount = 0;
		}
	}
}
