package Birski.utils;

import java.awt.*;

public class Configs {

    public static final int DRAW_BOARD_SIZE = 500;

    //wartość można zmieniać ale tylko tak by 500/5 było liczbą całkowitą np 1000, 10, 1, 50, 5
    public static final int RECTANGLE_SIZE = 5;

    public static int NUMBERS_OF_RECTANGLES = DRAW_BOARD_SIZE / RECTANGLE_SIZE;

    public static final int COLOR_MAX_VALUE = 255;

    public static final Color COLOR_PROCESSING = Color.YELLOW;

    public static final Color COLOR_PROCESSED = Color.PINK;

    public static final Color COLOR_SELECTED = Color.BLUE;
}
