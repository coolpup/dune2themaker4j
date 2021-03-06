package com.fundynamic.d2tm.utils;


import org.newdawn.slick.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>General purpose</h1>
 * <p>
 *     Easy color management & caching of colors that are being created - to prevent recreation of Color classes all the time.
 * </p>
 * <h2>Usage</h2>
 * <p>
 *     Get a color by one of the static final fields.
 *
 *     Or use the {@link #create(int, int, int, int)} to create a new color.
 * </p>
 */
public class Colors {

    public static final Color BLACK = Color.black;
    public static final Color WHITE = Color.white;
    public static final Color GREEN_ALPHA_128 = new Color(0,255,0,128);
    public static final Color YELLOW_ALPHA_32 = new Color(255, 255, 0, 32);
    public static final Color YELLOW_ALPHA_128 = new Color(255, 255, 0, 128);
    public static final Color RED_ALPHA_128 = new Color(255,0,0,128);
    public static final Color RED = new Color(255, 0, 0, 255);
    public static final Color RED_BRIGHT = new Color(255, 60, 60, 255);
    public static final Color DARK_RED_ALPHA_128 = new Color(200, 0, 0, 128);
    public static final Color BLACK_ALPHA_128 = new Color(0,0,0,128);
    public static final Color WHITE_ALPHA_128 = new Color(255, 255, 255, 128);
    public static final Color LIGHT_BLUE = new Color(104, 102, 255, 255);

    public static Map<String,Color> colorMap = new HashMap<>();

    /**
     * Creates a color and caches it. Cache-key is determined by rgba.
     * @param r
     * @param g
     * @param b
     * @param a
     * @return
     */
    public static Color create(int r, int g, int b, int a) {
        String key = "" + r + "-" + g + "-" + b + "-" + a;
        if (!colorMap.containsKey(key)) {
            colorMap.put(key, makeColor(r, g, b, a));
        }
        return colorMap.get(key);
    }

    private static Color makeColor(int r, int g, int b, int a) {
        if (a > -1) {
            return new Color(r, g, b, a);
        }
        return new Color(r, g, b);
    }

    /**
     * Shorthand for {@link #create(float, float, float, -1)} but with ints instead of floats
     * @param r
     * @param g
     * @param b
     * @return
     */
    public static Color create(int r, int g, int b) {
        return create(r, g, b, -1);
    }

    /**
     * Shorthand for {@link #create(int, int, int, -1)}
     * @param r
     * @param g
     * @param b
     * @return
     */
    public static Color create(float r, float g, float b) {
        return create((int)(r * 255.0f), (int)(g * 255.0f), (int)(b * 255.0f), -1);
    }

    public static String toString(Color c) {
        return "Color(" + c.getRed() + "," + c.getGreen() + "," + c.getBlue() + "," + c.getAlpha() + ")";
    }

}
