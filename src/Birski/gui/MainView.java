package Birski.gui;

import Birski.models.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Birski.gui.DrawBoard.CUSTOM_HEIGHT;
import static Birski.gui.DrawBoard.CUSTOM_WIDTH;
import static Birski.utils.Strings.*;

public class MainView extends JPanel {

    private static final Font font = new Font("System", Font.PLAIN,20);
    static JLabel formula, xIsInRange, yIsInRange, xMax, xMin, x, yMin, yMax, y;
    static JButton generateFunctionButton;
    public Function function;

    public MainView(){
        super();
        setBackground(Color.GRAY);
        setLayout(null);
        setSize(200, 200);
        function = new Function();
        formula = new JLabel("f(x,y) = x^" + function.getxPower() + " * sin(y/x) * y^" + function.getyPower() + " * (1 + sin(x/y", JLabel.LEFT);
        formula.setForeground(Color.BLACK);
        formula.setBounds(10, 30, 250, 20);
        add(formula);

        xIsInRange = new JLabel("x is in the range of " + function.getxMin() + ".." + function.getxMax(), JLabel.LEFT);
        xIsInRange.setForeground(Color.BLACK);
        xIsInRange.setBounds(10, 60, 150, 20);
        add(xIsInRange);

        yIsInRange = new JLabel("y is in the range of " + function.getyMin() + ".." + function.getyMax(), JLabel.LEFT);
        yIsInRange.setForeground(Color.BLACK);
        yIsInRange.setBounds(10, 90, 150, 20);
        add(yIsInRange);

        xMax = new JLabel(String.valueOf(function.getxMax()), JLabel.RIGHT);
        xMax.setForeground(Color.BLACK);
        xMax.setBounds(220, 10, 20, 20);
        add(xMax);

        xMin = new JLabel(String.valueOf(function.getxMin()), JLabel.RIGHT);
        xMin.setForeground(Color.BLACK);
        xMin.setBounds(220, 510, 20, 20);
        add(xMin);

        generateFunctionButton = new JButton("GENERATE");
        generateFunctionButton.setBounds(10, 300, 180, 35);
        add(generateFunctionButton);
//        generateFunctionButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                this.fu
//            }
//        });
        HandlerClass handlerClass = new HandlerClass();
        generateFunctionButton.addActionListener(handlerClass);


        x = new JLabel("x", JLabel.RIGHT);
        x.setForeground(Color.BLACK);
        x.setBounds(220, 250, 20, 20);
        add(x);

        yMax = new JLabel(String.valueOf(function.getyMax()), JLabel.RIGHT);
        yMax.setForeground(Color.BLACK);
        yMax.setBounds(730, 520, 20, 20);
        add(yMax);

        yMin = new JLabel(String.valueOf(function.getyMin()), JLabel.RIGHT);
        yMin.setForeground(Color.BLACK);
        yMin.setBounds(240, 520, 20, 20);
        add(yMin);

        y = new JLabel("y", JLabel.RIGHT);
        y.setForeground(Color.BLACK);
        y.setBounds(500, 520, 20, 20);
        add(y);

        DrawBoard drawBoard = new DrawBoard(function);
        drawBoard.setSize(CUSTOM_WIDTH, CUSTOM_HEIGHT);
        drawBoard.setBackground(Color.lightGray);
        drawBoard.setLocation(250, 20);
        add(drawBoard);




        setVisible(true);

    }
}
