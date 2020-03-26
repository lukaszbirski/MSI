package Birski.models;

public class Point {

    private double x;
    private double y;
    private double z;
    private short indexX;
    private short indexY;

    public Point(double x, double y, double z, short indexX, short indexY) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.indexX = indexX;
        this.indexY = indexY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public short getIndexX() {
        return indexX;
    }

    public short getIndexY() {
        return indexY;
    }

}
