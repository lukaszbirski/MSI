package Birski.gui;

import Birski.algorithms.ClimbHillAlgorithm;
import Birski.algorithms.SimulatedAnnealingAlgorithm;
import Birski.models.Function;
import Birski.models.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Birski.utils.Configs.BOLD_FONT;
import static Birski.utils.Configs.PLAIN_FONT;
import static Birski.utils.Strings.SOFTWARE_TITLE;

public class MainView extends JPanel implements ActionListener, Runnable {

    private JLabel formula, xIsInRange, yIsInRange, xMax, xMin, x, yMin, yMax, y, expectedMaximum, expectedMaximumValue, climbLabel, annealingLabel, stepsClimbLabel, extremaClimbLabel, extremumClimbLabel, stepsAnnealingLabel, extremaAnnealingLabel, extremumAnnealingLabel;
    static DrawBoard drawBoard;
    private JButton generateButton, climbButton, annealingButton;

    private String xValue, yValue, zValue, indexX, indexY;

    //static Font font;

    static JFrame window = new JFrame(SOFTWARE_TITLE);
    static MainView mainView = new MainView();
    static Thread thread = new Thread(mainView);

    short op = 500;

    public MainView(){
        super();
        setBackground(Color.GRAY);
        setLayout(null);
        setSize(200, 200);
        //font = new Font("System", Font.PLAIN, 13);
        drawBoard = new DrawBoard();
        formula = new JLabel("z = x^" + drawBoard.getFunction().getxPower() + " * sin(y/x) * y^" + drawBoard.getFunction().getyPower() + " * (1 + sin(x/y)) + y^" + drawBoard.getFunction().getyPower() + " * sin(x/y) * x^" + drawBoard.getFunction().getxPower(), JLabel.LEFT);
        formula.setForeground(Color.BLACK);
        formula.setFont(PLAIN_FONT);
        formula.setBounds(10, 30, 350, 20);
        add(formula);

        xIsInRange = new JLabel("x is in the range of " + drawBoard.getFunction().getxMin() + ".." + drawBoard.getFunction().getxMax(), JLabel.LEFT);
        xIsInRange.setForeground(Color.BLACK);
        xIsInRange.setFont(PLAIN_FONT);
        xIsInRange.setBounds(10, 50, 150, 20);
        add(xIsInRange);

        yIsInRange = new JLabel("y is in the range of " + drawBoard.getFunction().getyMin() + ".." + drawBoard.getFunction().getyMax(), JLabel.LEFT);
        yIsInRange.setForeground(Color.BLACK);
        yIsInRange.setFont(PLAIN_FONT);
        yIsInRange.setBounds(10, 70, 150, 20);
        add(yIsInRange);

        indexX = String.valueOf(drawBoard.getFunction().getzMax().getIndexX());
        indexY = String.valueOf(drawBoard.getFunction().getzMax().getIndexY());
        zValue = String.format("%.6f", (drawBoard.getFunction().getzMax().getZ()));
        xValue = String.format("%.6f", (drawBoard.getFunction().getzMax().getX()));
        yValue = String.format("%.6f", (drawBoard.getFunction().getzMax().getY()));

        expectedMaximumValue = new JLabel("Extremum: (x; y; z) = (" + xValue + "; " + yValue + "; " + zValue + ")", JLabel.LEFT);
        expectedMaximumValue.setForeground(Color.BLACK);
        expectedMaximumValue.setFont(PLAIN_FONT);
        expectedMaximumValue.setBounds(10, 90, 350, 20);
        add(expectedMaximumValue);

        climbLabel = new JLabel("Climb Hill Algorithm", JLabel.CENTER);
        climbLabel.setForeground(Color.BLACK);
        climbLabel.setFont(BOLD_FONT);
        climbLabel.setBounds(10, 150, 250, 20);
        add(climbLabel);

        extremaClimbLabel = new JLabel("Extrema: ", JLabel.LEFT);
        extremaClimbLabel.setForeground(Color.BLACK);
        extremaClimbLabel.setFont(PLAIN_FONT);
        extremaClimbLabel.setBounds(10, 170, 250, 20);
        add(extremaClimbLabel);

        stepsClimbLabel = new JLabel("Steps: ", JLabel.LEFT);
        stepsClimbLabel.setForeground(Color.BLACK);
        stepsClimbLabel.setFont(PLAIN_FONT);
        stepsClimbLabel.setBounds(10, 190, 250, 20);
        add(stepsClimbLabel);

        extremumClimbLabel = new JLabel("Extremum: ", JLabel.LEFT);
        extremumClimbLabel.setForeground(Color.BLACK);
        extremumClimbLabel.setFont(PLAIN_FONT);
        extremumClimbLabel.setBounds(10, 210, 250, 20);
        add(extremumClimbLabel);

        annealingLabel = new JLabel("Annealing Algorithm", JLabel.CENTER);
        annealingLabel.setForeground(Color.BLACK);
        annealingLabel.setFont(BOLD_FONT);
        annealingLabel.setBounds(10, 260, 250, 20);
        add(annealingLabel);

        extremaAnnealingLabel = new JLabel("Extrema: ", JLabel.LEFT);
        extremaAnnealingLabel.setForeground(Color.BLACK);
        extremaAnnealingLabel.setFont(PLAIN_FONT);
        extremaAnnealingLabel.setBounds(10, 280, 250, 20);
        add(extremaAnnealingLabel);

        stepsAnnealingLabel = new JLabel("Steps: ", JLabel.LEFT);
        stepsAnnealingLabel.setForeground(Color.BLACK);
        stepsAnnealingLabel.setFont(PLAIN_FONT);
        stepsAnnealingLabel.setBounds(10, 300, 250, 20);
        add(stepsAnnealingLabel);

        extremumAnnealingLabel = new JLabel("Extremum: ", JLabel.LEFT);
        extremumAnnealingLabel.setForeground(Color.BLACK);
        extremumAnnealingLabel.setFont(PLAIN_FONT);
        extremumAnnealingLabel.setBounds(10, 320, 350, 20);
        add(extremumAnnealingLabel);

        xMax = new JLabel(String.valueOf(drawBoard.getFunction().getxMax()), JLabel.RIGHT);
        xMax.setForeground(Color.BLACK);
        xMax.setBounds(320, 10, 20, 20);
        add(xMax);

        xMin = new JLabel(String.valueOf(drawBoard.getFunction().getxMin()), JLabel.RIGHT);
        xMin.setForeground(Color.BLACK);
        xMin.setBounds(320, 510, 20, 20);
        add(xMin);

        x = new JLabel("x", JLabel.RIGHT);
        x.setForeground(Color.BLACK);
        x.setBounds(320, 250, 20, 20);
        add(x);

        yMax = new JLabel(String.valueOf(drawBoard.getFunction().getyMax()), JLabel.RIGHT);
        yMax.setForeground(Color.BLACK);
        yMax.setBounds(830, 520, 20, 20);
        add(yMax);

        yMin = new JLabel(String.valueOf(drawBoard.getFunction().getyMin()), JLabel.RIGHT);
        yMin.setForeground(Color.BLACK);
        yMin.setBounds(340, 520, 20, 20);
        add(yMin);

        y = new JLabel("y", JLabel.RIGHT);
        y.setForeground(Color.BLACK);
        y.setBounds(600, 520, 20, 20);
        add(y);

        drawBoard.setSize(500, 500);
        drawBoard.setBackground(Color.lightGray);
        drawBoard.setLocation(350, 20);
        add(drawBoard);

        generateButton = new JButton("GENERATE");
        generateButton.setBounds(10, 405, 180, 30);
        generateButton.addActionListener(this);
        add(generateButton);

        climbButton = new JButton("CLIMB");
        climbButton.setBounds(10, 440, 180, 30);
        climbButton.addActionListener(this);
        add(climbButton);

        annealingButton = new JButton("ANNEALING");
        annealingButton.setBounds(10, 475, 180, 30);
        annealingButton.addActionListener(this);
        add(annealingButton);

        setVisible(true);
    }

    public static void main(String[] args) {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(880, 580);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.add(mainView);
        window.setVisible(true);

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

        }
        else if (source == annealingButton){
            drawBoard.setSimulatedAnnealingAlgorithm(new SimulatedAnnealingAlgorithm(drawBoard.getFunction().getPoints()));
            drawBoard.setClimbHillAlgorithm(null);

//            Point annealingMaximum = drawBoard.getSimulatedAnnealingAlgorithm().getFoundMaximum();
//            extremumAnnealingLabel.setText(String.format("%.6f", "Extremum: (x; y; z) = (" + annealingMaximum.getX() + "; " + annealingMaximum.getY() + "; " + annealingMaximum.getZ() + ")"));
        }
    }

    private void refreshManiViewWhileGenerating(){
        drawBoard.setFunction(new Function());
        drawBoard.setClimbHillAlgorithm(null);
        drawBoard.setSimulatedAnnealingAlgorithm(null);
        xMax.setText(String.valueOf(drawBoard.getFunction().getxMax()));
        xMin.setText(String.valueOf(drawBoard.getFunction().getxMin()));
        yMax.setText(String.valueOf(drawBoard.getFunction().getyMax()));
        yMin.setText(String.valueOf(drawBoard.getFunction().getyMin()));
        formula.setText("z = x^" + drawBoard.getFunction().getxPower() + " * sin(y/x) * y^" + drawBoard.getFunction().getyPower() + " * (1 + sin(x/y)) + y^" + drawBoard.getFunction().getyPower() + " * sin(x/y) * x^" + drawBoard.getFunction().getxPower());
        xIsInRange.setText("x is in the range of " + drawBoard.getFunction().getxMin() + ".." + drawBoard.getFunction().getxMax());
        yIsInRange.setText("y is in the range of " + drawBoard.getFunction().getyMin() + ".." + drawBoard.getFunction().getyMax());
        indexX = String.valueOf(drawBoard.getFunction().getzMax().getIndexX());
        indexY = String.valueOf(drawBoard.getFunction().getzMax().getIndexY());
        zValue = String.format("%.6f", (drawBoard.getFunction().getzMax().getZ()));
        xValue = String.format("%.6f", (drawBoard.getFunction().getzMax().getX()));
        yValue = String.format("%.6f", (drawBoard.getFunction().getzMax().getY()));
        expectedMaximumValue.setText("Extremum: (x; y; z) = (" + xValue + "; " + yValue + "; " + zValue + ")");
        extremumAnnealingLabel.setText("Extremum:");
    }

    //todo należy troche poczyścić tu kod, jest za dużo powtórzeń

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
        }

    }
}