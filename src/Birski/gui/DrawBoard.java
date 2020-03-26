package Birski.gui;

import Birski.algorithms.ClimbHillAlgorithm;
import Birski.models.Function;
import Birski.models.Point;

import javax.swing.*;
import java.awt.*;

import static Birski.utils.Configs.*;


public class DrawBoard extends JPanel {

    private Function function;
    private ClimbHillAlgorithm climbHillAlgorithm;

    public DrawBoard() {
        this.function = new Function();
        repaint();
    }

    public DrawBoard(ClimbHillAlgorithm climbHillAlgorithm) {
        this.climbHillAlgorithm = climbHillAlgorithm;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoardPainting(g);
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

        if (climbHillAlgorithm != null){
            Point point = climbHillAlgorithm.getRandomPoint();
            g.setColor(COLOR_PROCESSING);
            g.fillRect(point.getIndexX() * RECTANGLE_SIZE,DRAW_BOARD_SIZE - ((point.getIndexY()+1) * RECTANGLE_SIZE),RECTANGLE_SIZE, RECTANGLE_SIZE);
        }
    }

    public Color intToColor(int colNum){
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
}
