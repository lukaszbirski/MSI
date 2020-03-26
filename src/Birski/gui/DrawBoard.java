package Birski.gui;

import Birski.models.Function;

import javax.swing.*;
import java.awt.*;


public class DrawBoard extends JPanel {

    short CUSTOM_WIDTH = 5 * 100;
    private Function function;

    public DrawBoard() {
        this.function = new Function();
        repaint();
    }

//    public void paintFunction(){
//        Object g;
//        paintComponent(Graphics g);
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double difference = function.getzMax() - function.getzMin();

        for (int indexX = 0; indexX < 100; indexX++) {
            for (int indexY = 0; indexY < 100; indexY++) {
                double value = function.getPoints()[indexX][indexY].getZ() - function.getzMin();
                double corrected = setFloatInRGBRange(difference, value);
                g.setColor(intToColor((int) corrected));
                g.fillRect(indexX * 5, CUSTOM_WIDTH - ((indexY+1) * 5), 5, 5);
            }
        }
    }

    public Color intToColor(int colNum){
        return new Color(colNum, colNum, colNum);
    }

    private int setFloatInRGBRange(double difference, double value){
        return (int) ((255 * value)/difference);
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
