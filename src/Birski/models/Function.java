package Birski.models;

import java.util.Random;

import static java.lang.Math.*;

public class Function {

    private short xPower;
    private short yPower;
    private short xMin;
    private short xMax;
    private short yMin;
    private short yMax;
    private Point[][] points;
    private double zMin;
    private double zMax;

    public Function() {
        Random random = new Random();
        xPower = (short) (random.nextInt(2) + 1);
        yPower = (short) (random.nextInt(2) + 1);

        xMin = (short) -(random.nextInt(9) + 1);
        xMax = (short) (random.nextInt(9) + 1);

        yMin = (short) -(random.nextInt(9) + 1);
        yMax = (short) (random.nextInt(9) + 1);

        points = calculatePoints();

        zMin = getZMaxAndMin(points)[1];

        zMax = getZMaxAndMin(points)[0];
    }

    public double calculateZ(double x, double y, double xPower, double yPower){
        return pow(x, xPower) * sin(y/x) * pow(y, yPower) + (1 + sin(x/y)) + pow(y, yPower) * sin(x/y) * pow(x, xPower) * (sin(y/x));
    }

    private Point[][] calculatePoints(){
        Point [][] points = new Point[100][100];

        double x = xMin;
        double y = yMin;

        double stepX = (xMax - xMin) / (float) (100 - 1);
        double stepY = (yMax - yMin) / (float) (100 - 1);

        for (short indexX = 0; indexX < 100; indexX++) {
            for (short indexY = 0; indexY < 100; indexY++) {
                points[indexX][indexY] = new Point(x, y, calculateZ(x, y, xPower, yPower), indexY, indexY);
                y += stepY;
            }
            y = yMin;
            x += stepX;
        }
        return points;
    }

    private double[] getZMaxAndMin(Point[][] points){
        double[] values = new double[2];
        for (short indexX = 0; indexX < 100; indexX++) {
            for (short indexY = 0; indexY < 100; indexY++) {
                if (points[indexX][indexY].getZ() > values[0]) values[0] = points[indexX][indexY].getZ();
                if (points[indexX][indexY].getZ() < values[1]) values[1] = points[indexX][indexY].getZ();
            }
        }
        return values;
    }

    public short getxPower() {
        return xPower;
    }

    public short getyPower() {
        return yPower;
    }

    public short getxMin() {
        return xMin;
    }

    public short getxMax() {
        return xMax;
    }

    public short getyMin() {
        return yMin;
    }

    public short getyMax() {
        return yMax;
    }

    public Point[][] getPoints() {
        return points;
    }

    public double getzMin() {
        return zMin;
    }

    public double getzMax() {
        return zMax;
    }
}
