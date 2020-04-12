package Birski.algorithms;

import Birski.models.Point;

import java.util.List;

public class SimulatedAnnealingAlgorithm extends Algorithm {

    private double INITIAL_TEMP = 10;
    private double TEMP_DECREASE = 0.05;
    private Point maximumPoint;

    public SimulatedAnnealingAlgorithm(Point[][] points) {
        super(points);
    }

    @Override
    public void init() {
        super.init();
        startingPoints.add(getRandomPoint());
        currentPoint = startingPoints.get(0);
        maximumPoint = currentPoint;
        visitedPoints.add(currentPoint);
        status.increaseStepCount();

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
            status.increaseStepCount();
        }
        maxPoints.add(currentPoint);
        setStatusValues();
    }

    /**Metoda zwraca losowo wybrany punkt sąsiedni*/
    private Point getRandomNeighbour() {
        List<Point> neighbours = getNeighbours(currentPoint);
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    /**Metoda ustawia punkt jako aktualny*/
    private void setCurrentPoint(Point next){
        currentPoint = next;
        if (maximumPoint.getZ() < currentPoint.getZ()) maximumPoint = currentPoint;
    }

    /**Metoda liczy prawdopodobieństwo wg wzoru exp(deltaE/T)*/
    private long probability(Point current, Point next, double temp) {
        if (next.getZ() > current.getZ()) return 1;
        else return Math.round(Math.exp(current.getZ() - next.getZ()) / temp);
    }

}
