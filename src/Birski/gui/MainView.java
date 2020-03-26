package Birski.gui;

import Birski.models.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JPanel implements ActionListener {

    private JLabel formula, xIsInRange, yIsInRange, xMax, xMin, x, yMin, yMax, y;
    private DrawBoard drawBoard;
    private JButton generateButton;

    public MainView(){
        super();
        setBackground(Color.GRAY);
        setLayout(null);
        setSize(200, 200);
        drawBoard = new DrawBoard();
        //function = new Function();
        formula = new JLabel("f(x,y) = x^" + drawBoard.getFunction().getxPower() + " * sin(y/x) * y^" + drawBoard.getFunction().getyPower() + " * (1 + sin(x/y", JLabel.LEFT);
        formula.setForeground(Color.BLACK);
        formula.setBounds(10, 30, 250, 20);
        add(formula);

        xIsInRange = new JLabel("x is in the range of " + drawBoard.getFunction().getxMin() + ".." + drawBoard.getFunction().getxMax(), JLabel.LEFT);
        xIsInRange.setForeground(Color.BLACK);
        xIsInRange.setBounds(10, 60, 150, 20);
        add(xIsInRange);

        yIsInRange = new JLabel("y is in the range of " + drawBoard.getFunction().getyMin() + ".." + drawBoard.getFunction().getyMax(), JLabel.LEFT);
        yIsInRange.setForeground(Color.BLACK);
        yIsInRange.setBounds(10, 90, 150, 20);
        add(yIsInRange);

        xMax = new JLabel(String.valueOf(drawBoard.getFunction().getxMax()), JLabel.RIGHT);
        xMax.setForeground(Color.BLACK);
        xMax.setBounds(220, 10, 20, 20);
        add(xMax);

        xMin = new JLabel(String.valueOf(drawBoard.getFunction().getxMin()), JLabel.RIGHT);
        xMin.setForeground(Color.BLACK);
        xMin.setBounds(220, 510, 20, 20);
        add(xMin);

        x = new JLabel("x", JLabel.RIGHT);
        x.setForeground(Color.BLACK);
        x.setBounds(220, 250, 20, 20);
        add(x);

        yMax = new JLabel(String.valueOf(drawBoard.getFunction().getyMax()), JLabel.RIGHT);
        yMax.setForeground(Color.BLACK);
        yMax.setBounds(730, 520, 20, 20);
        add(yMax);

        yMin = new JLabel(String.valueOf(drawBoard.getFunction().getyMin()), JLabel.RIGHT);
        yMin.setForeground(Color.BLACK);
        yMin.setBounds(240, 520, 20, 20);
        add(yMin);

        y = new JLabel("y", JLabel.RIGHT);
        y.setForeground(Color.BLACK);
        y.setBounds(500, 520, 20, 20);
        add(y);

        drawBoard.setSize(500, 500);
        drawBoard.setBackground(Color.lightGray);
        drawBoard.setLocation(250, 20);
        add(drawBoard);

        generateButton = new JButton("GENERATE");
        generateButton.setBounds(10, 300, 180, 30);
        generateButton.addActionListener(this);
        add(generateButton);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == generateButton){
            drawBoard.setFunction(new Function());
            drawBoard.repaint();
        }
    }
}
