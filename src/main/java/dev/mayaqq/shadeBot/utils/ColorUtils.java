package dev.mayaqq.shadeBot.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ColorUtils {
    static ArrayList<Color> colors = new ArrayList<>();
    static int colorIndex = 0;

    static {
        colors.add(new Color(228, 3, 3));
        colors.add(new Color(255, 140, 0));
        colors.add(new Color(255, 237, 0));
        colors.add(new Color(0, 128, 38));
        colors.add(new Color(36, 64, 142));
        colors.add(new Color(115, 41, 130));
    }
    public static Color randomColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, colors.size());
        return colors.get(randomNum);
    }

    public static Color nextColor() {
        int currentColor = colorIndex;
        colorIndex++;
        if (colorIndex >= colors.size()) {
            colorIndex = 0;
        }
        return colors.get(currentColor);
    }
}
