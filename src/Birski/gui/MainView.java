package Birski.gui;

import Birski.algorithms.ClimbHillAlgorithm;
import Birski.algorithms.SimulatedAnnealingAlgorithm;
import Birski.models.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Birski.utils.Strings.SOFTWARE_TITLE;

public class MainView extends JPanel implements ActionListener, Runnable {

    private JLabel formula, xIsInRange, yIsInRange, xMax, xMin, x, yMin, yMax, y, expectedMaximum;
    static DrawBoard drawBoard;
    private JButton generateButton, climbButton, annealingButton;

    static JFrame window = new JFrame(SOFTWARE_TITLE);
    static MainView mainView = new MainView();
    static Thread thread = new Thread(mainView);

    short op = 500;

    public MainView(){
        super();
        setBackground(Color.GRAY);
        setLayout(null);
        setSize(200, 200);
        drawBoard = new DrawBoard();
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

        expectedMaximum = new JLabel("Expected maximum: " + String.format("%.5f", (drawBoard.getFunction().getzMax())), JLabel.LEFT);
        expectedMaximum.setForeground(Color.BLACK);
        expectedMaximum.setBounds(10, 120, 250, 20);
        add(expectedMaximum);

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

//        drawBoard.setSize(500, 500);
//        drawBoard.setBackground(Color.lightGray);
//        drawBoard.setLocation(250, 20);
//        add(drawBoard);

        generateButton = new JButton("GENERATE");
        generateButton.setBounds(10, 300, 180, 30);
        generateButton.addActionListener(this);
        add(generateButton);

        climbButton = new JButton("CLIMB");
        climbButton.setBounds(10, 335, 180, 30);
        climbButton.addActionListener(this);
        add(climbButton);

        annealingButton = new JButton("ANNEALING");
        annealingButton.setBounds(10, 370, 180, 30);
        annealingButton.addActionListener(this);
        add(annealingButton);

        setVisible(true);

    }

    public static void main(String[] args) {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(790, 580);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        window.add(mainView);
        window.setVisible(true);

        drawBoard.setSize(500, 500);
        drawBoard.setBackground(Color.lightGray);
        drawBoard.setLocation(250, 20);
        mainView.add(drawBoard);

        thread.start();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == generateButton){
            refreshManiViewWhileGenerating();
        }
        else if (source == climbButton){
            drawBoard.setClimbHillAlgorithm(new ClimbHillAlgorithm(drawBoard.getFunction().getPoints()));
            drawBoard.setSimulatedAnnealingAlgorithm(null);
            drawBoard.repaint();
        }
        else if (source == annealingButton){
            drawBoard.setSimulatedAnnealingAlgorithm(new SimulatedAnnealingAlgorithm(drawBoard.getFunction().getPoints()));
            drawBoard.setClimbHillAlgorithm(null);
            drawBoard.repaint();
        }
    }

    private void refreshManiViewWhileGenerating(){
        drawBoard.setFunction(new Function());
        drawBoard.setClimbHillAlgorithm(null);
        drawBoard.repaint();
        xMax.setText(String.valueOf(drawBoard.getFunction().getxMax()));
        xMin.setText(String.valueOf(drawBoard.getFunction().getxMin()));
        yMax.setText(String.valueOf(drawBoard.getFunction().getyMax()));
        yMin.setText(String.valueOf(drawBoard.getFunction().getyMin()));
        xIsInRange.setText("x is in the range of " + drawBoard.getFunction().getxMin() + ".." + drawBoard.getFunction().getxMax());
        yIsInRange.setText("y is in the range of " + drawBoard.getFunction().getyMin() + ".." + drawBoard.getFunction().getyMax());
        expectedMaximum.setText("Expected maximum: " + String.format("%.5f", (drawBoard.getFunction().getzMax())));
    }

    @Override
    public void run() {

        long wait, startCycle, timeCycle;

        while (true){
            startCycle = System.nanoTime();
            drawBoard.repaint();
            timeCycle = startCycle - System.nanoTime();
            wait = op - timeCycle/1000000;
            if (wait <=0 )wait = 3;
            try {thread.sleep(wait);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(op + " > " + wait);
            //drawBoard.
        }

    }
}
