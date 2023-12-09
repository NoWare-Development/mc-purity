package net.minecraft.src;

public class PurMath {
    public int max2(int a, int b) {
        return a > b ? a : b;
    }

    public int max3(int a, int b, int c) {
        return this.max2(a, this.max2(b, c));
    }
}
