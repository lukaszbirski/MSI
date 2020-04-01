package Birski.gui;

import Birski.algorithms.ClimbHillAlgorithm;
import Birski.algorithms.SimulatedAnnealingAlgorithm;
import Birski.models.Function;
import Birski.models.Point;

import javax.swing.*;
import java.awt.*;

import static Birski.utils.Configs.*;


public class DrawBoard extends JPanel {

    private Function function;
    private ClimbHillAlgorithm climbHillAlgorithm;
    private SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm;

    public DrawBoard() {
        this.function = new Function();
        repaint();
    }

    public DrawBoard(ClimbHillAlgorithm climbHillAlgorithm) {
        //if (simulatedAnnealingAlgorithm != null) simulatedAnnealingAlgorithm = null;
        this.climbHillAlgorithm = climbHillAlgorithm;

        repaint();
    }

    public DrawBoard(SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm) {
        //if (climbHillAlgorithm != null) climbHillAlgorithm = null;
        this.simulatedAnnealingAlgorithm = simulatedAnnealingAlgorithm;

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoardPainting(g);
        printClimbHillAlgorithm(g);
        printAnnealingAlgorithm(g);
    }

    private void drawBoardPainting(Graphics g){
        double difference = function.getzMax() - function.getzMin();

        for (int indexX = 0; indexX < NUMBERS_OF_RECTANGLES; indexX++) {
            for (int indexY = 0; indexY < NUMBERS_OF_RECTANGLES; indexY++) {
                double value = function.getPoints()[indexX][indexY].getZ() - function.getzMin();
                double corrected = setFloatInRGBRange(difference, value);
                g.setColor(intToColor((int) corrected));
                g.fillRect(indexX * RECTANGLE_SIZE, DRAW_BOARD_SIZE - ((indexY+1) * RECTANGLE_SIZE), RECTANGLE_SIZE, RECTANGLE_SIZE);
            }
        }
    }


    private void printClimbHillAlgorithm(Graphics g){

//        if (simulatedAnnealingAlgorithm != null) simulatedAnnealingAlgorithm = null;

        if (climbHillAlgorithm != null){
            climbHillAlgorithm.init();

        }
    }

    private void printAnnealingAlgorithm(Graphics g){

//        if (climbHillAlgorithm != null) climbHillAlgorithm = null;

        if (simulatedAnnealingAlgorithm != null){
            simulatedAnnealingAlgorithm.init();
        }
    }

    private Color intToColor(int colNum){
        return new Color(colNum, colNum, colNum);
    }

    private int setFloatInRGBRange(double difference, double value){
        return (int) ((COLOR_MAX_VALUE * value)/difference);
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void setClimbHillAlgorithm(ClimbHillAlgorithm climbHillAlgorithm) {
        this.climbHillAlgorithm = climbHillAlgorithm;
    }

    public void setSimulatedAnnealingAlgorithm(SimulatedAnnealingAlgorithm simulatedAnnealingAlgorithm) {
        this.simulatedAnnealingAlgorithm = simulatedAnnealingAlgorithm;
    }

    private void paintInit(Graphics g){
        //climbHillAlgorithm.init();
        //climbHillAlgorithm.getVisitedPoints();
        //g.setColor(COLOR_PROCESSING);
        //g.fillRect(point.getIndexX() * RECTANGLE_SIZE,DRAW_BOARD_SIZE - ((point.getIndexY()+1) * RECTANGLE_SIZE),RECTANGLE_SIZE, RECTANGLE_SIZE);
    }
}
