package net.minecraft.src;

public class Purity {
    public static int majorVersion = 1;
    public static int minorVersion = 0;
    public static int revision = 0;

    public static String name = "Purity";

    public static String title = "Minecraft Purity";

    public String getTitle() {
        return this.title + " [" +
            String.valueOf(this.majorVersion) + "." +
            String.valueOf(this.minorVersion) + "." +
            String.valueOf(this.revision) + "]";
    }
}
