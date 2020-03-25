package Birski.models;

import java.awt.*;

public class Rectangle {

    public final static short SIZE = 5;
    private short positionX;
    private short positionY;
    private Color color;

    public Rectangle() {
    }

    public short getPositionX() {
        return positionX;
    }

    public void setPositionX(short positionX) {
        this.positionX = positionX;
    }

    public short getPositionY() {
        return positionY;
    }

    public void setPositionY(short positionY) {
        this.positionY = positionY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
