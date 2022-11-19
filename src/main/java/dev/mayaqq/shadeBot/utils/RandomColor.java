package dev.mayaqq.shadeBot.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomColor {
    static ArrayList<Color> colors = new ArrayList<>();
    //add colors to arraylist colors
    public static Color RandomColor() {
        colors.add(new Color(228, 3, 3));
        colors.add(new Color(255, 140, 0));
        colors.add(new Color(255, 237, 0));
        colors.add(new Color(0, 128, 38));
        colors.add(new Color(36, 64, 142));
        colors.add(new Color(115, 41, 130));
        int randomNum = ThreadLocalRandom.current().nextInt(0, colors.size());
        return colors.get(randomNum);
    }
}
