package net.minecraft.src;

public class GuiGuiSettings extends GuiScreen {
  private GuiScreen parent;
  protected String title = "GUI Settings";
  private GameSettings gameSettings;
  private static EnumOptions[] options = new EnumOptions[]{EnumOptions.GUI_GAP_HORIZONTAL, EnumOptions.GUI_GAP_VERTICAL, EnumOptions.GUI_SCALE};

  public GuiGuiSettings(GuiScreen p, GameSettings gs) {
    this.parent = p;
    this.gameSettings = gs;
  }

  public void initGui() {
    StringTranslate inst = StringTranslate.getInstance();
    this.title = inst.translateKey("options.guiSettingsTitle");
    int index = 0;
    EnumOptions[] opts = options;
    int len = opts.length;

    for (int i = 0; i < len; i++) {
      EnumOptions option = opts[i];
      if (!option.getEnumFloat()) {
        this.controlList.add(new GuiSmallButton(option.returnEnumOrdinal(), this.width / 2 - 155 + index % 2 * 160, this.height / 6 + 24 * (index >> 1), option, this.gameSettings.getKeyBinding(option)));
      } else {
        this.controlList.add(new GuiSlider(option.returnEnumOrdinal(), this.width / 2 - 155 + index % 2 * 160, this.height / 6 + 24 * (index >> 1), option, this.gameSettings.getKeyBinding(option), this.gameSettings.getOptionFloatValue(option)));
      }

      index++;
    }

    this.controlList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, inst.translateKey("gui.done")));
  }

  protected void actionPerformed(GuiButton b) {
    if (b.enabled) {
      if (b.id < 100 && b instanceof GuiSmallButton) {
        this.gameSettings.setOptionValue(((GuiSmallButton)b).returnEnumOptions(), 1);
        b.displayString = this.gameSettings.getKeyBinding(EnumOptions.getEnumOptions(b.id));
      }

      if (b.id == 200) {
        this.mc.gameSettings.saveOptions();
        this.mc.displayGuiScreen(this.parent);
      }

      if (b instanceof GuiSlider) return;

      ScaledResolution sr = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
      int width = sr.getScaledWidth();
      int height = sr.getScaledHeight();
      this.setWorldAndResolution(this.mc, width, height);
    }
  }

  public void drawScreen(int var1, int var2, float var3) {
    this.drawDefaultBackground();
    this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
    super.drawScreen(var1, var2, var3);
  }
}
