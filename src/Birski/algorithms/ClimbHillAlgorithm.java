package Birski.algorithms;

import Birski.models.Point;

import java.util.List;

public class ClimbHillAlgorithm extends Algorithm {

    private double extremum;

    public ClimbHillAlgorithm(Point[][] points) {
        super(points);
    }

    @Override
    public void init() {
        super.init();
    //todo sprawdzić w mainie za pomocą sout czy to faktycznie punkt startowy i czy pobiera okoliczne punkty do sprawdzenia
        startingPoint = getRandomPoint();
        List<Point> neighbours = getNeighbours(startingPoint);
//        currentPoint = getTheBestNeighbour(neighbours);
//        return currentPoint;
    }

    private Point getTheBestNeighbour(List<Point> neighbours){
        Point bestNeighbour = null;

        for (Point point : neighbours){
            if (isNeighbourBetter(point)){
                extremum = point.getZ();
                bestNeighbour = point;
            }
        }

        return bestNeighbour;
    }

    private boolean isNeighbourBetter(Point neighbour){
        return neighbour.getZ() > extremum;
    }

}
