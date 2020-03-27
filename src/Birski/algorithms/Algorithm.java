package Birski.algorithms;

import Birski.models.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Birski.utils.Configs.NUMBERS_OF_RECTANGLES;

public abstract class Algorithm {

    protected Random random;
    protected Point[][] points;
    protected Point startingPoint;
    protected Point currentPoint;
    protected List<Point> visitedPoints;

    public Algorithm(Point[][] points) {
        this.random = new Random();
        this.visitedPoints = new ArrayList<>();
        this.points = points;
    }

    public void init(){

    }

    public Point getRandomPoint(){
        int indexX, indexY;
        indexX = (int) (random.nextInt(NUMBERS_OF_RECTANGLES));
        indexY = (int) (random.nextInt(NUMBERS_OF_RECTANGLES));
        Point point = new Point(indexX, indexY);
    return point;
    }

    protected List<Point> getNeighbours(Point current){
        List<Point> neighbours = new ArrayList<>();

        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                Point neighbour = getNeighbour(current, xOffset, yOffset);
                if (neighbour != null)
                    neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    private Point getNeighbour(Point current, int xOffset, int yOffset){
        return new Point(current.getIndexX() + xOffset, current.getIndexY() + yOffset);
    }


}
