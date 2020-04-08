package Birski.algorithms;

import Birski.models.Point;

import java.util.List;

public class ClimbHillAlgorithm extends Algorithm {

    private Point extremum;
    public List<Point> neighbours;

    public ClimbHillAlgorithm(Point[][] points) {
        super(points);
    }

    @Override
    public void init() {
        super.init();

        for (int i = 0; i < 10; i++) {

            startingPoints.add(getRandomPoint());
            currentPoint = startingPoints.get(i);
            status.increaseStepCount();

            while(true)
            {
                visitedPoints.add(currentPoint);
                neighbours = getNeighbours(currentPoint);
                status.increaseStepCount();
                if (currentPoint == getTheBestNeighbour(neighbours)){
                    maxPoints.add(extremum);
                    break;
                }
            }
        }

        setStatusValues();
    }

    private Point getTheBestNeighbour(List<Point> neighbours){
        for (Point point : neighbours){
            if (point.getZ() > currentPoint.getZ()){
                extremum = point;
                currentPoint = point;
            }
        }
        return currentPoint;
    }

}