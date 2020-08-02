package org.dynmap;

/**
 * Simple replacement for java.awt.Color for dynmap - it's not an invariant, so we don't make millions
 * of them during rendering
 */
public class Color {
    /* ARGB value */
    private int val;

    public static final int TRANSPARENT = 0;

    public Color(int red, int green, int blue, int alpha) {
        setRGBA(red, green, blue, alpha);
    }
    public Color(int red, int green, int blue) {
        setRGBA(red, green, blue, 0xFF);
    }
    public Color() {
        setTransparent();
    }
    public final int getRed() {
        return (val >> 16) & 0xFF;
    }
    public final int getGreen() {
        return (val >> 8) & 0xFF;
    }
    public final int getBlue() {
        return val & 0xFF;
    }
    public final int getAlpha() {
        return ((val >> 24) & 0xFF);
    }
    public final boolean isTransparent() {
        return (val == TRANSPARENT);
    }
    public final void setTransparent() {
        val = TRANSPARENT;
    }
    public final void setColor(Color c) {
        val = c.val;
    }
    public final void setRGBA(int red, int green, int blue, int alpha) {
        val = ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF);
    }
    public final int getARGB() {
        return val;
    }
    public final void setARGB(int c) {
        val = c;
    }
    public final int getComponent(int idx) {
        return 0xFF & (val >> ((3-idx)*8));
    }
}
