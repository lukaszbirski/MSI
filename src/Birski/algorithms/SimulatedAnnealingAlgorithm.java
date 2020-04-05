package Birski.algorithms;

import Birski.models.Point;

import java.util.List;

public class SimulatedAnnealingAlgorithm extends Algorithm {

    private double INITIAL_TEMP = 10;
    private double TEMP_DECREASE = 0.05;
    private Point currentPoint;
    private Point maximumPoint;

    public SimulatedAnnealingAlgorithm(Point[][] points) {
        super(points);
    }

    @Override
    public void init() {
        super.init();
        currentPoint = startingPoint;
        maximumPoint = currentPoint;
        visitedPoints.add(currentPoint);

        for (double temp = INITIAL_TEMP; temp > 0; temp-= TEMP_DECREASE) {
            Point nextPoint = getRandomNeighbour();

            double delta = nextPoint.getZ() - currentPoint.getZ();

            if (delta > 0){
                setCurrentPoint(nextPoint);
            }else {
                Point nextRandomPoint = getRandomPoint();
                if (probability(currentPoint, nextRandomPoint, temp) == random.nextInt(2)) {
                    setCurrentPoint(nextRandomPoint);
                }
            }
            visitedPoints.add(currentPoint);
        }
    }

    private Point getRandomNeighbour() {
        List<Point> neighbours = getNeighbours(currentPoint);
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    private void setCurrentPoint(Point next){
        currentPoint = next;
        if (maximumPoint.getZ() < currentPoint.getZ()) maximumPoint = currentPoint;
    }

    private long probability(Point current, Point next, double temp) {
        if (next.getZ() > current.getZ()) return 1;
        else return Math.round(Math.exp(current.getZ() - next.getZ()) / temp);
    }
}
