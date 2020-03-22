package Birski.gui;

import javax.swing.*;

import java.awt.*;

import static Birski.utils.Strings.*;

public class MainView extends JPanel {

    private static final Font font = new Font("System", Font.PLAIN,20);
    static JLabel formula, xIsInRange, yIsInRange;

    public MainView(){
        super();
        setBackground(Color.GRAY);
        setLayout(null);
        //testuje wymiary
        setSize(200, 200);
        formula = new JLabel(FORMULA_STRING, JLabel.LEFT);
        formula.setForeground(Color.BLACK);
        formula.setBounds(10, 30, 100, 20);
        add(formula);

        xIsInRange = new JLabel(X_IN_THE_RANGE_STRING, JLabel.LEFT);
        xIsInRange.setForeground(Color.BLACK);
        xIsInRange.setBounds(10, 60, 100, 20);
        add(xIsInRange);

        yIsInRange = new JLabel(Y_IN_THE_RANGE_STRING, JLabel.LEFT);
        yIsInRange.setForeground(Color.BLACK);
        yIsInRange.setBounds(10, 90, 100, 20);
        add(yIsInRange);

        DrawBoard drawBoard = new DrawBoard();
        drawBoard.setSize(400, 400);
        drawBoard.setBackground(Color.lightGray);
        drawBoard.setLocation(150, 0);
        add(drawBoard);

//        drawBoard.setLocation(150, 150);
//        add(drawBoard);

        setVisible(true);

    }
}
