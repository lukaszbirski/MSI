package Birski.gui;

import javax.swing.*;
import java.awt.*;

public class DrawBoard extends JPanel {

    public DrawBoard(){
        repaint();
    }

    public void paint(Graphics g){
        //super.paint(g);
        //g.setColor(Color.BLACK);
        //g.drawLine(200, 500, 200, 500);
        //g.setColor(Color.RED);
        g.drawRect(200, 200, 20, 20);
    }
}
