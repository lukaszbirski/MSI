package Birski.algorithms;

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
        /////////////////////////////////////////początek/////////////////////////////////////
        int x = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println(points[i][j].toString() + " : " + x);
                x++;
            }
        }
        System.out.println("TO JEST PUNKT STARTOWY: " + startingPoint.toString());
        this.currentPoint = startingPoint;
        System.out.println("TO jest current point: " + currentPoint.toString());
        System.out.println(" ");

        /////////////////////////////////////////tu będzie zaczynać się pętla/////////////////////////////////////
        int i = 1;
        while(true)
        {
            System.out.println("POCZĄTEK PĘTLI: " + i);
            this.neighbours = getNeighbours(currentPoint);
            System.out.println("---------------");
            visitedPoints.add(currentPoint);
            System.out.println("To są punkty sprawdzane przez algorytm do okoła startowego punktu:");
            for (Point point : neighbours){
                System.out.println(point.toString());
            }
            System.out.println("Koniec drukowania punktów sąsiednich");


            if (currentPoint == getTheBestNeighbour(neighbours)){
                System.out.println("Znaleziono extremum: " + currentPoint.toString());
                break;
            }


            System.out.println("To jest nowy aktualny punkt: " + currentPoint.toString());
            System.out.println("KONIEC PĘTLI: " + i);
            System.out.println("");
            i++;
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
