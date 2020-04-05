package Birski.models;

import java.util.Random;

import static Birski.utils.Configs.NUMBERS_OF_RECTANGLES;
import static java.lang.Math.*;

public class Function {

    private int xPower;
    private int yPower;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private Point[][] points;
    private Point zMin;
    private Point zMax;

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
        Point [][] points = new Point[NUMBERS_OF_RECTANGLES][NUMBERS_OF_RECTANGLES];

        double x = xMin;
        double y = yMin;

        double stepX = (xMax - xMin) / (float) (NUMBERS_OF_RECTANGLES - 1);
        double stepY = (yMax - yMin) / (float) (NUMBERS_OF_RECTANGLES - 1);

        for (short indexX = 0; indexX < NUMBERS_OF_RECTANGLES; indexX++) {
            for (short indexY = 0; indexY < NUMBERS_OF_RECTANGLES; indexY++) {
                points[indexX][indexY] = new Point(x, y, calculateZ(x, y, xPower, yPower), indexX, indexY);
                y += stepY;
            }
            y = yMin;
            x += stepX;
        }
        return points;
    }

    private Point[] getZMaxAndMin(Point[][] points){
        Point[] values = new Point[2];
        values[0] = values[1] = points[0][0];
        for (short indexX = 0; indexX < NUMBERS_OF_RECTANGLES; indexX++) {
            for (short indexY = 0; indexY < NUMBERS_OF_RECTANGLES; indexY++) {
                if (points[indexX][indexY].getZ() > values[0].getZ()) values[0] = points[indexX][indexY];
                if (points[indexX][indexY].getZ() < values[1].getZ()) values[1] = points[indexX][indexY];
            }
        }
        return values;
    }

    public int getxPower() {
        return xPower;
    }

    public int getyPower() {
        return yPower;
    }

    public int getxMin() {
        return xMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMin() {
        return yMin;
    }

    public int getyMax() {
        return yMax;
    }

    public Point[][] getPoints() {
        return points;
    }

    public Point getzMin() {
        return zMin;
    }

    public Point getzMax() {
        return zMax;
    }
}
