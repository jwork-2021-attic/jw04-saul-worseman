package com.anish.monsters;
import java.util.*;
import java.awt.Color;
public class ColorGenerator {
    static ArrayList<Color> colors = new ArrayList<>();

    static {
        boolean[][][] existed = new boolean[4][4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++)
                    existed[i][j][k] = false;
        }
        int randomR;
        int randomG;
        int randomB;
        while (colors.size() < 50) {
            randomR = (int) (Math.random() * 4);  // 0 to 255
            randomG = (int) (Math.random() * 4);
            randomB = (int) (Math.random() * 4);
            if (!existed[randomR][randomG][randomB]) {
                colors.add(new Color(randomR * 85, randomG * 85, randomB * 85));
                existed[randomR][randomG][randomB] = true;
            }
        }
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++) {
                    if (!existed[i][j][k]) {
                        colors.add(new Color(i * 85, j * 85, k * 85));
                        existed[i][j][k] = true;
                    }
                }

    }

    public static Iterator<Color> iterator() {
        return colors.iterator();
    }
}
