package Birski.algorithms;

import Birski.models.Point;

import java.util.Random;

import static Birski.utils.Configs.NUMBERS_OF_RECTANGLES;

public abstract class Algorithm {

    protected Random random;
    protected Point[][] points;
    protected Point startingPoint;

    public Algorithm(Point[][] points) {
        this.random = new Random();
        this.points = points;
    }

    public Point getRandomPoint(){
        short indexX, indexY;
        indexX = (short) (random.nextInt(NUMBERS_OF_RECTANGLES));
        indexY = (short) (random.nextInt(NUMBERS_OF_RECTANGLES));
        Point point = new Point(indexX, indexY);
    return point;
    }
}
