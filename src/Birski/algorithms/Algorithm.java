package Birski.algorithms;

import Birski.gui.DrawBoard;
import Birski.models.Function;
import Birski.models.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Birski.utils.Configs.NUMBERS_OF_RECTANGLES;

public abstract class Algorithm {

    protected Random random;
    protected Point[][] points;
    public Point startingPoint;
    protected Point currentPoint;
    protected List<Point> visitedPoints;
    //protected DrawBoard drawBoard;

    public Algorithm(Point[][] points) {
        this.random = new Random();
        this.visitedPoints = new ArrayList<>();
        this.points = points;
        //this.drawBoard = drawBoard;
        this.startingPoint = getRandomPoint();
    }

    public void init() {

    }

    public Point getRandomPoint(){
        int indexX, indexY;
        indexX = random.nextInt(NUMBERS_OF_RECTANGLES);
        indexY = random.nextInt(NUMBERS_OF_RECTANGLES);
        startingPoint = points[indexX][indexY];
    return startingPoint;
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
        if (current.getIndexX() + xOffset < 0 || current.getIndexX() + xOffset >= NUMBERS_OF_RECTANGLES || current.getIndexY() + yOffset < 0 || current.getIndexY() + yOffset >= NUMBERS_OF_RECTANGLES){
            return null;
        }
        return points[current.getIndexX() + xOffset][current.getIndexY() + yOffset];
    }

    public List<Point> getVisitedPoints() {
        return visitedPoints;
    }
}
