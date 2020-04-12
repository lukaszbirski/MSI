package Birski.gui;

import Birski.algorithms.ClimbHillAlgorithm;
import Birski.algorithms.SimulatedAnnealingAlgorithm;
import Birski.models.Function;
import Birski.models.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static Birski.utils.Configs.*;


public class DrawBoard extends JPanel {

    private Function function;
    private ClimbHillAlgorithm climbHillAlgorithm;
    private SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm;
    private Graphics2D graphic;

    public DrawBoard() {
        this.function = new Function();
    }

    /**Rysowanie wszystkich elementów graficznych*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphic = (Graphics2D) g;
        drawBoardPainting();
        paintClimbHillAlgorithm();
        paintSimulatedAnnealingAlgorithm();
    }

    /**Metoda rysuje tablice punktów w formie mapy 2D*/
    private void drawBoardPainting(){
        double difference = function.getzMax().getZ() - function.getzMin().getZ();

        for (int indexX = 0; indexX < NUMBERS_OF_RECTANGLES; indexX++) {
            for (int indexY = 0; indexY < NUMBERS_OF_RECTANGLES; indexY++) {
                double value = function.getPoints()[indexX][indexY].getZ() - function.getzMin().getZ();
                graphic.setColor(intToColor(setFloatInRGBRange(difference, value)));
                graphic.fillRect(indexX * RECTANGLE_SIZE, DRAW_BOARD_SIZE - ((indexY+1) * RECTANGLE_SIZE), RECTANGLE_SIZE, RECTANGLE_SIZE);
            }
        }
    }

    /**Metoda zwraca kolor w skali szarości dla danej liczby*/
    private Color intToColor(int colNum){
        return new Color(colNum, colNum, colNum);
    }

    /**Metoda zwraca zadaną wartość w zakresie 0-255 w stosunku do Zmin i Zmax */
    private int setFloatInRGBRange(double difference, double value){
        return (int) ((COLOR_MAX_VALUE * value)/difference);
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    /**Metoda wywołuje algorytm wspinania*/
    public void setClimbHillAlgorithm(ClimbHillAlgorithm climbHillAlgorithm) {
        this.climbHillAlgorithm = climbHillAlgorithm;
        if (climbHillAlgorithm != null) this.climbHillAlgorithm.init();

    }

    /**Metoda wywołuje algorytm symulowanego wyżarzania*/
    public void setSimulatedAnnealingAlgorithm(SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm) {
        this.simulatedAnnealingAlgorithm = simulatedAnnealingAlgorithm;
        if (simulatedAnnealingAlgorithm != null) this.simulatedAnnealingAlgorithm.init();
    }

    /**Metoda maluje wynik działania algorytmu wspinania*/
    private void paintClimbHillAlgorithm(){
        if (this.climbHillAlgorithm != null){
            paintVisited(climbHillAlgorithm.getVisitedPoints());
            paintStartingPoints(climbHillAlgorithm.getStartingPoints());
            paintMaxima(climbHillAlgorithm.getMaxPoints());
            paintMaximum(climbHillAlgorithm.getFoundMaximum(climbHillAlgorithm.getMaxPoints()));
        }
    }

    /**Metoda maluje wynik działania algorytmu symulowanego wyżarzania*/
    private void paintSimulatedAnnealingAlgorithm(){
        if (this.simulatedAnnealingAlgorithm != null){
            paintVisited(simulatedAnnealingAlgorithm.getVisitedPoints());
            paintStartingPoints(simulatedAnnealingAlgorithm.getStartingPoints());
            paintMaximum(simulatedAnnealingAlgorithm.getFoundMaximum(simulatedAnnealingAlgorithm.getMaxPoints()));
        }
    }

    /**Metoda maluje pojedyńczy punkt*/
    private void paintRect(Point point){
        graphic.fillRect(point.getIndexX() * RECTANGLE_SIZE,DRAW_BOARD_SIZE - ((point.getIndexY()+1) * RECTANGLE_SIZE),RECTANGLE_SIZE, RECTANGLE_SIZE);
    }

    /**Metoda maluje punkty*/
    private void paintRectangles(List<Point> points){
        for (Point point : points){
            paintRect(point);
        }
    }

    /**Metoda maluje wszystkie odwiedzone punkty*/
    private void paintVisited(List<Point> points){
        graphic.setColor(COLOR_PROCESSING);
        paintRectangles(points);
    }

    /**Metoda maluje punkty startowe*/
    private void paintStartingPoints(List<Point> points){
        graphic.setColor(COLOR_STARTING);
        paintRectangles(points);
    }

    /**Metoda maluje wszystkie znalezione maksima*/
    private void paintMaxima(List<Point> points){
        graphic.setColor(COLOR_SELECTED);
        paintRectangles(points);
    }

    /**Metoda maluje znalezione maksimum globalne*/
    private void paintMaximum(Point point){
        graphic.setColor(COLOR_MAXIMUM);
        paintRect(point);
    }

    public ClimbHillAlgorithm getClimbHillAlgorithm() {
        return climbHillAlgorithm;
    }

    public SimulatedAnnealingAlgorithm getSimulatedAnnealingAlgorithm() {
        return simulatedAnnealingAlgorithm;
    }
}