package Birski.algorithms;

import Birski.gui.DrawBoard;
import Birski.models.Function;
import Birski.models.Point;

import java.util.List;

public class ClimbHillAlgorithm extends Algorithm {

    private double extremum;
    public List<Point> neighbours;

    public ClimbHillAlgorithm(Point[][] points) {
        super(points);
    }

    @Override
    public void init() {
        super.init();

        currentPoint = startingPoint;

        while(true)
        {
            visitedPoints.add(currentPoint);

            neighbours = getNeighbours(currentPoint);

            if (currentPoint == getTheBestNeighbour(neighbours)){
                break;
            }
        }
    }

    private Point getTheBestNeighbour(List<Point> neighbours){

        for (Point point : neighbours){
            if (point.getZ() > currentPoint.getZ()){
                extremum = point.getZ();
                currentPoint = point;
            }
        }

        return currentPoint;
    }

}