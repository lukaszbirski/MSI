package Birski.models;

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
}
