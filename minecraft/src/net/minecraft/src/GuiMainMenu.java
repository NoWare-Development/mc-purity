package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class GuiMainMenu extends GuiScreen {
	private static final Random rand = new Random();
	private float updateCounter = 0.0F;
	private String splashText = "missingno";
	private GuiButton multiplayerButton;
	private boolean easter_egg = false;

	public GuiMainMenu() {
		try {
			ArrayList var1 = new ArrayList();
			BufferedReader var2 = new BufferedReader(new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
			String var3 = "";

			while(true) {
				var3 = var2.readLine();
				if(var3 == null) {
					this.splashText = (String)var1.get(rand.nextInt(var1.size()));
					break;
				}

				var3 = var3.trim();
				if(var3.length() > 0) {
					var1.add(var3);
				}
			}
		} catch (Exception var4) {
		}

		this.easter_egg = this.rand.nextInt(10) == 1;
	}

	public void updateScreen() {
		++this.updateCounter;
	}

	protected void keyTyped(char var1, int var2) {
	}

	public void initGui() {
		Calendar var1 = Calendar.getInstance();
		var1.setTime(new Date());
		if(var1.get(2) + 1 == 11 && var1.get(5) == 9) {
			this.splashText = "Happy birthday, ez!";
		} else if(var1.get(2) + 1 == 6 && var1.get(5) == 1) {
			this.splashText = "Happy birthday, Notch!";
		} else if(var1.get(2) + 1 == 12 && var1.get(5) == 24) {
			this.splashText = "Merry X-mas!";
		} else if(var1.get(2) + 1 == 1 && var1.get(5) == 1) {
			this.splashText = "Happy new year!";
		}

		StringTranslate var2 = StringTranslate.getInstance();
		int var4 = this.height / 4 + 48;
		this.controlList.add(new GuiButton(1, this.width / 2 - 100, var4, var2.translateKey("menu.singleplayer")));
		this.controlList.add(this.multiplayerButton = new GuiButton(2, this.width / 2 - 100, var4 + 24, var2.translateKey("menu.multiplayer")));
		this.controlList.add(new GuiButton(3, this.width / 2 - 100, var4 + 48, var2.translateKey("menu.mods")));
		if(this.mc.hideQuitButton) {
			this.controlList.add(new GuiButton(0, this.width / 2 - 100, var4 + 72, var2.translateKey("menu.options")));
		} else {
			this.controlList.add(new GuiButton(0, this.width / 2 - 100, var4 + 72 + 12, 98, 20, var2.translateKey("menu.options")));
			this.controlList.add(new GuiButton(4, this.width / 2 + 2, var4 + 72 + 12, 98, 20, var2.translateKey("menu.quit")));
		}

		if(this.mc.session == null) {
			this.multiplayerButton.enabled = false;
		}

	}

	protected void actionPerformed(GuiButton var1) {
		if(var1.id == 0) {
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
		}

		if(var1.id == 1) {
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
		}

		if(var1.id == 2) {
			this.mc.displayGuiScreen(new GuiMultiplayer(this));
		}

		if(var1.id == 3) {
			this.mc.displayGuiScreen(new GuiTexturePacks(this));
		}

		if(var1.id == 4) {
			this.mc.shutdown();
		}

	}

	public void drawScreen(int var1, int var2, float var3) {
		Purity inst = new Purity();
		this.drawDefaultBackground();
		Tessellator var4 = Tessellator.instance;
		short var5 = 274;
		int var6 = this.width / 2 - var5 / 2;
		byte var7 = 30;
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.mc.renderEngine.getTexture("/title/mclogo.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(var6 + 0, var7 + 0, 0, 0, 155, 44);
		this.drawTexturedModalRect(var6 + 155, var7 + 0, 0, 45, 155, 44);
		this.drawTexturedModalRect(this.width / 2 - 35, var7 + 35, 155, 0, 70, 13);

		if (this.easter_egg || inst.isDebug()) {
			GL11.glPushMatrix();
			GL11.glScalef(2, 2, 1);
			this.drawTexturedModalRect((((this.width / 2) - 4) / 2) - 4, (var7 / 2) - 7, 225, 0, 8, 7);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(2, 2, 1);
			float flies = 1.8F - MathHelper.abs(
				MathHelper.sin((float)(System.currentTimeMillis() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) / 0.5F);

			int[] fstFly = {1, -5};
			int[] sndFly = {-5, -8};
			GL11.glTranslatef((float)((this.width / 2) - 4) / 2, (var7 / 2) - flies, 0.0F);

			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.35F);
			GL11.glTranslatef(0, flies * -0.05F, 0);
			this.drawTexturedModalRect(-4, -12, 236, 0, 8, 10);
			GL11.glPopMatrix();

			GL11.glDisable(GL11.GL_BLEND);
			GL11.glTranslatef(0, flies * 1.25F, 0);
			GL11.glTranslatef(0, -0.15F, 0);

			int spr = 0;
			float temp = MathHelper.sin((float)(System.currentTimeMillis() % 1000L) / 250.0F * (float)Math.PI * 2.0F) / 0.5F;
			if (temp > 0) spr = 1;
			if (spr == 0)
				this.drawTexturedModalRect(fstFly[0], fstFly[1], 233, 2, 3, 2);
			else
				this.drawTexturedModalRect(fstFly[0], fstFly[1], 233, 0, 3, 2);

			spr = 0;
			if (temp <= 0) spr = 1;
			if (spr == 0)
				this.drawTexturedModalRect(sndFly[0], sndFly[1], 233, 2, 3, 2);
			else
				this.drawTexturedModalRect(sndFly[0], sndFly[1], 233, 0, 3, 2);

			GL11.glPopMatrix();
		}

		var4.setColorOpaque_I(16777215);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(this.width / 2 + 90), 70.0F, 0.0F);
		GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
		float var8 = 1.8F - MathHelper.abs(MathHelper.sin((float)(System.currentTimeMillis() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
		var8 = var8 * 100.0F / (float)(this.fontRenderer.getStringWidth(this.splashText) + 32);
		GL11.glScalef(var8, var8, var8);
		this.drawCenteredString(this.fontRenderer, this.splashText, 0, -8, 16776960);
		GL11.glPopMatrix();
		this.drawString(this.fontRenderer, inst.getTitle(), 2, 2, 5263440);
		String var9 = "Copyright Mojang AB. Do not distribute.";
		this.drawString(this.fontRenderer, var9, this.width - this.fontRenderer.getStringWidth(var9) - 2, this.height - 10, 16777215);
		super.drawScreen(var1, var2, var3);
	}
}
