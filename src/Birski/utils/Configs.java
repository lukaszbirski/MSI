package Birski.utils;

import java.awt.*;

public class Configs {

    public static final int DRAW_BOARD_SIZE = 500;

    //wartość można zmieniać ale tylko tak by 500/5 było liczbą całkowitą np 1000, 10, 1, 50, 5
    public static final int RECTANGLE_SIZE = 50;

    public static int NUMBERS_OF_RECTANGLES = DRAW_BOARD_SIZE / RECTANGLE_SIZE;

    public static final int COLOR_MAX_VALUE = 255;

    public static final Color COLOR_PROCESSING = Color.YELLOW;

    public static final Color COLOR_STARTING = Color.BLUE;

    public static final Color COLOR_SELECTED = Color.RED;

    public static final Color COLOR_MAXIMUM = Color.GREEN;

    public static final Font PLAIN_FONT = new Font("System", Font.PLAIN, 12);

    public static final Font BOLD_FONT = new Font("System", Font.BOLD, 12);

    public static String stringFormatter(double value){
        return String.format("%.6f", value);
    }

}
