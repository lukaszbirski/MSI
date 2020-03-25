package Birski.gui;

import Birski.models.Function;
import Birski.models.Point;
import Birski.models.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Birski.models.Rectangle.SIZE;

public class DrawBoard extends Canvas {

    final static short CUSTOM_WIDTH = SIZE * 100;
    final static short CUSTOM_HEIGHT = SIZE * 100;
    private Function function;

    public DrawBoard(Function function) {
        this.function = function;
    }

    public void paint(Graphics g) {

        double difference = function.getzMax() - function.getzMin();

        for (int indexX = 0; indexX < 100; indexX++) {
            for (int indexY = 0; indexY < 100; indexY++) {
                double value = function.getPoints()[indexX][indexY].getZ() - function.getzMin();
                String test = ""+function.getPoints()[indexX][indexY].getZ() + function.getzMin();
                //todo poprawić kolor jest poza zakresem
                double corrected = setFloatInRGBRange(difference, value);
                //todo wartości są także ujemne a nie powinny, wszystko powinno być dodatnie, trzeba poprawić bo int ujemny nie mieści się w zakresie koloru
                g.setColor(intToColor((int) corrected));
                //String test = function.getPoints()[indexX][indexY].toString();

                g.fillRect(indexX * SIZE, CUSTOM_WIDTH - ((indexY+1) * SIZE), SIZE, SIZE);
            }
        }
    }

    public Color intToColor(int colNum){
        return new Color(colNum, colNum, colNum);
    }

    private int setFloatInRGBRange(double difference, double value){
        return (int) ((255 * value)/difference);
    }

}
