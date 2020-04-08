package Birski.models;

import static Birski.utils.Configs.stringFormatter;

public class Point {

    private double x;
    private double y;
    private double z;
    private int indexX;
    private int indexY;

    public Point(double x, double y, double z, int indexX, int indexY) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.indexX = indexX;
        this.indexY = indexY;
    }

    public double getZ() {
        return z;
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(x; y; z) = (" + stringFormatter(x) + "; " + stringFormatter(y) + "; " + stringFormatter(z) + ")";
    }
}
