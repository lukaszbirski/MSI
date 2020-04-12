package Birski.algorithms;

import Birski.models.Point;
import Birski.models.Status;

import java.util.*;

import static Birski.utils.Configs.NUMBERS_OF_RECTANGLES;

public abstract class Algorithm {

    protected Random random;
    protected Point[][] points;
    protected List<Point> startingPoints;
    protected Point currentPoint;
    protected List<Point> visitedPoints;
    protected List<Point> maxPoints;
    protected Status status;

    public Algorithm(Point[][] points) {
        this.random = new Random();
        this.visitedPoints = new ArrayList<>();
        this.startingPoints = new ArrayList<>();
        this.maxPoints = new ArrayList<>();
        this.points = points;
        this.status = new Status();
    }

    /**Metoda używana przez klasy rozszerzające klasę Algorithm do wywoływania innych metod*/
    public void init() {}

    /**Metoda losuje punkt startowy*/
    public Point getRandomPoint(){
        int indexX, indexY;
        indexX = random.nextInt(NUMBERS_OF_RECTANGLES);
        indexY = random.nextInt(NUMBERS_OF_RECTANGLES);
        Point startingPoint = points[indexX][indexY];
    return startingPoint;
    }

    /**Metoda wzraca punkty sąsiednie w stosunku do zadanego punktu*/
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

    /**Metoda zwraca sąsiada zadanego punktu*/
    private Point getNeighbour(Point current, int xOffset, int yOffset){
        if (current.getIndexX() + xOffset < 0 || current.getIndexX() + xOffset >= NUMBERS_OF_RECTANGLES || current.getIndexY() + yOffset < 0 || current.getIndexY() + yOffset >= NUMBERS_OF_RECTANGLES){
            return null;
        }
        return points[current.getIndexX() + xOffset][current.getIndexY() + yOffset];
    }

    public List<Point> getVisitedPoints() {
        return visitedPoints;
    }

    public List<Point> getStartingPoints() {
        return startingPoints;
    }

    public List<Point> getMaxPoints() {
        return maxPoints;
    }

    public Status getStatus() {
        return status;
    }

    /**Metoda znajduje maksimum globalne z listy znalezionych maksimów*/
    public Point getFoundMaximum(List<Point> points) {
        Point max = maxPoints.get(0);
        for (Point point : maxPoints){
            if (point.getZ() > max.getZ()) max = point;
        }
        return max;
    }

    /**Metoda zmienia Liste punktów na Set punktów*/
    public Set<Point> listToSet(List<Point> points){
        Set<Point> pointSet = new HashSet<>();
        for (Point point : points){
            pointSet.add(point);
        }
        return pointSet;
    }

    /**Metoda ustawia wartości znalezionych ekstremów do zmiennej status*/
    protected void setStatusValues(){
        status.setExtremum(getFoundMaximum(maxPoints));
        status.setExtremumCount(listToSet(maxPoints).size());
        status.setArraysCount(listToSet(visitedPoints).size());
    }
}
