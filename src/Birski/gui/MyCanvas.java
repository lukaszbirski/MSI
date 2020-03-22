package Birski.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MyCanvas extends Canvas {

    BufferedImage image;
    Graphics2D graphic;

    MyCanvas(short width, short height)
    {
        super();
        setSize(width, height);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphic = (Graphics2D) image.getGraphics();
    }

    public abstract void drawImage();

    /**metoda wyświetla na ekranie grafikę*/
    private void putOnScreen()
    {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    public void run()
    {
        drawImage();
        putOnScreen();
    }
}
