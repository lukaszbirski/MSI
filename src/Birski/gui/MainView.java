package Birski.gui;

import Birski.algorithms.ClimbHillAlgorithm;
import Birski.algorithms.SimulatedAnnealingAlgorithm;
import Birski.models.Function;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Birski.utils.Configs.BOLD_FONT;
import static Birski.utils.Configs.PLAIN_FONT;
import static Birski.utils.Strings.*;

public class MainView extends JPanel implements ActionListener, Runnable {

    private JLabel formula, xIsInRange, yIsInRange, xMax, xMin, x, yMin, yMax, y, expectedMaximumValue, climbLabel, annealingLabel,
            stepsClimbLabel, extremaClimbLabel, extremumClimbLabel, stepsAnnealingLabel, extremaAnnealingLabel, extremumAnnealingLabel,
            functionParameters, arrayAccessedAnnealingLabel, arrayAccessedClimbLabel;
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
        drawBoard = new DrawBoard();

        functionParameters = new JLabel(FUNCTION_PARAMETERS, JLabel.CENTER);
        functionParameters.setFont(BOLD_FONT);
        functionParameters.setForeground(Color.BLACK);
        functionParameters.setBounds(10, 10, 250, 20);
        add(functionParameters);

        formula = new JLabel(drawBoard.getFunction().getFunctionAsString(), JLabel.LEFT);
        formula.setForeground(Color.BLACK);
        formula.setFont(PLAIN_FONT);
        formula.setBounds(10, 30, 330, 20);
        add(formula);

        xIsInRange = new JLabel(X_IN_THE_RANGE_STRING + drawBoard.getFunction().getxMin() + DOTS + drawBoard.getFunction().getxMax(), JLabel.LEFT);
        xIsInRange.setForeground(Color.BLACK);
        xIsInRange.setFont(PLAIN_FONT);
        xIsInRange.setBounds(10, 50, 150, 20);
        add(xIsInRange);

        yIsInRange = new JLabel(Y_IN_THE_RANGE_STRING + drawBoard.getFunction().getyMin() + DOTS + drawBoard.getFunction().getyMax(), JLabel.LEFT);
        yIsInRange.setForeground(Color.BLACK);
        yIsInRange.setFont(PLAIN_FONT);
        yIsInRange.setBounds(10, 70, 150, 20);
        add(yIsInRange);

        expectedMaximumValue = new JLabel(EXTREMUM + drawBoard.getFunction().getzMax().toString(), JLabel.LEFT);
        expectedMaximumValue.setForeground(Color.BLACK);
        expectedMaximumValue.setFont(PLAIN_FONT);
        expectedMaximumValue.setBounds(10, 90, 330, 20);
        add(expectedMaximumValue);

        climbLabel = new JLabel(ALGORITHM_CLIMB_LABEL, JLabel.CENTER);
        climbLabel.setForeground(Color.BLACK);
        climbLabel.setFont(BOLD_FONT);
        climbLabel.setBounds(10, 150, 250, 20);
        add(climbLabel);

        extremaClimbLabel = new JLabel(EXTREMA, JLabel.LEFT);
        extremaClimbLabel.setForeground(Color.BLACK);
        extremaClimbLabel.setFont(PLAIN_FONT);
        extremaClimbLabel.setBounds(10, 170, 330, 20);
        add(extremaClimbLabel);

        stepsClimbLabel = new JLabel(STEPS, JLabel.LEFT);
        stepsClimbLabel.setForeground(Color.BLACK);
        stepsClimbLabel.setFont(PLAIN_FONT);
        stepsClimbLabel.setBounds(10, 190, 330, 20);
        add(stepsClimbLabel);

        extremumClimbLabel = new JLabel(EXTREMUM, JLabel.LEFT);
        extremumClimbLabel.setForeground(Color.BLACK);
        extremumClimbLabel.setFont(PLAIN_FONT);
        extremumClimbLabel.setBounds(10, 210, 330, 20);
        add(extremumClimbLabel);

        arrayAccessedClimbLabel = new JLabel(ARRAYS_ACCESSED, JLabel.LEFT);
        arrayAccessedClimbLabel.setForeground(Color.BLACK);
        arrayAccessedClimbLabel.setFont(PLAIN_FONT);
        arrayAccessedClimbLabel.setBounds(10, 230, 330, 20);
        add(arrayAccessedClimbLabel);

        annealingLabel = new JLabel(ALGORITHM_ANNEALING_LABEL, JLabel.CENTER);
        annealingLabel.setForeground(Color.BLACK);
        annealingLabel.setFont(BOLD_FONT);
        annealingLabel.setBounds(10, 280, 250, 20);
        add(annealingLabel);

        extremaAnnealingLabel = new JLabel(EXTREMA, JLabel.LEFT);
        extremaAnnealingLabel.setForeground(Color.BLACK);
        extremaAnnealingLabel.setFont(PLAIN_FONT);
        extremaAnnealingLabel.setBounds(10, 300, 330, 20);
        add(extremaAnnealingLabel);

        stepsAnnealingLabel = new JLabel(STEPS, JLabel.LEFT);
        stepsAnnealingLabel.setForeground(Color.BLACK);
        stepsAnnealingLabel.setFont(PLAIN_FONT);
        stepsAnnealingLabel.setBounds(10, 320, 330, 20);
        add(stepsAnnealingLabel);

        extremumAnnealingLabel = new JLabel(EXTREMUM, JLabel.LEFT);
        extremumAnnealingLabel.setForeground(Color.BLACK);
        extremumAnnealingLabel.setFont(PLAIN_FONT);
        extremumAnnealingLabel.setBounds(10, 340, 330, 20);
        add(extremumAnnealingLabel);

        arrayAccessedAnnealingLabel = new JLabel(ARRAYS_ACCESSED, JLabel.LEFT);
        arrayAccessedAnnealingLabel.setForeground(Color.BLACK);
        arrayAccessedAnnealingLabel.setFont(PLAIN_FONT);
        arrayAccessedAnnealingLabel.setBounds(10, 360, 330, 20);
        add(arrayAccessedAnnealingLabel);

        xMax = new JLabel(String.valueOf(drawBoard.getFunction().getxMax()), JLabel.RIGHT);
        xMax.setForeground(Color.BLACK);
        xMax.setBounds(830, 520, 20, 20);
        add(xMax);

        xMin = new JLabel(String.valueOf(drawBoard.getFunction().getxMin()), JLabel.RIGHT);
        xMin.setForeground(Color.BLACK);
        xMin.setBounds(340, 520, 20, 20);
        add(xMin);

        x = new JLabel(X, JLabel.RIGHT);
        x.setForeground(Color.BLACK);
        x.setBounds(600, 520, 20, 20);
        add(x);

        yMax = new JLabel(String.valueOf(drawBoard.getFunction().getyMax()), JLabel.RIGHT);
        yMax.setForeground(Color.BLACK);
        yMax.setBounds(320, 10, 20, 20);
        add(yMax);

        yMin = new JLabel(String.valueOf(drawBoard.getFunction().getyMin()), JLabel.RIGHT);
        yMin.setForeground(Color.BLACK);
        yMin.setBounds(320, 510, 20, 20);
        add(yMin);

        y = new JLabel(Y, JLabel.RIGHT);
        y.setForeground(Color.BLACK);
        y.setBounds(320, 250, 20, 20);
        add(y);

        drawBoard.setSize(500, 500);
        drawBoard.setBackground(Color.lightGray);
        drawBoard.setLocation(350, 20);
        add(drawBoard);

        generateButton = new JButton(ALGORITHM_GENERATE);
        generateButton.setBounds(10, 405, 180, 30);
        generateButton.addActionListener(this);
        add(generateButton);

        climbButton = new JButton(ALGORITHM_CLIMB);
        climbButton.setBounds(10, 440, 180, 30);
        climbButton.addActionListener(this);
        add(climbButton);

        annealingButton = new JButton(ALGORITHM_ANNEALING );
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
            refreshMainViewWhileGenerating();
        }
        else if (source == climbButton){
            clickClimbButton();
        }
        else if (source == annealingButton){
            clickAnnealingButton();
        }
    }


    private void refreshMainViewWhileGenerating(){
        drawBoard.setFunction(new Function());
        drawBoard.setClimbHillAlgorithm(null);
        drawBoard.setSimulatedAnnealingAlgorithm(null);
        xMax.setText(String.valueOf(drawBoard.getFunction().getxMax()));
        xMin.setText(String.valueOf(drawBoard.getFunction().getxMin()));
        yMax.setText(String.valueOf(drawBoard.getFunction().getyMax()));
        yMin.setText(String.valueOf(drawBoard.getFunction().getyMin()));
        formula.setText(drawBoard.getFunction().getFunctionAsString());
        xIsInRange.setText(X_IN_THE_RANGE_STRING + drawBoard.getFunction().getxMin() + DOTS + drawBoard.getFunction().getxMax());
        yIsInRange.setText(Y_IN_THE_RANGE_STRING + drawBoard.getFunction().getyMin() + DOTS + drawBoard.getFunction().getyMax());
        expectedMaximumValue.setText(EXTREMUM + drawBoard.getFunction().getzMax().toString());
        extremaAnnealingLabel.setText(EXTREMA);
        stepsAnnealingLabel.setText(STEPS);
        stepsClimbLabel.setText(STEPS);
        extremaClimbLabel.setText(EXTREMA);
        extremumClimbLabel.setText(EXTREMUM);
        extremumAnnealingLabel.setText(EXTREMUM);
        arrayAccessedClimbLabel.setText(ARRAYS_ACCESSED);
        arrayAccessedAnnealingLabel.setText(ARRAYS_ACCESSED);
    }

    private void clickAnnealingButton(){
        drawBoard.setSimulatedAnnealingAlgorithm(new SimulatedAnnealingAlgorithm(drawBoard.getFunction().getPoints()));
        drawBoard.setClimbHillAlgorithm(null);
        stepsAnnealingLabel.setText(STEPS + drawBoard.getSimulatedAnnealingAlgorithm().getStatus().getStepCount());
        extremaAnnealingLabel.setText(EXTREMA + drawBoard.getSimulatedAnnealingAlgorithm().getStatus().getExtremumCount());
        extremumAnnealingLabel.setText(EXTREMUM + drawBoard.getSimulatedAnnealingAlgorithm().getStatus().getExtremum().toString());
        arrayAccessedAnnealingLabel.setText(ARRAYS_ACCESSED + drawBoard.getSimulatedAnnealingAlgorithm().getStatus().getArraysCount());
    }

    private void clickClimbButton(){
        drawBoard.setClimbHillAlgorithm(new ClimbHillAlgorithm(drawBoard.getFunction().getPoints()));
        drawBoard.setSimulatedAnnealingAlgorithm(null);
        stepsClimbLabel.setText(STEPS + drawBoard.getClimbHillAlgorithm().getStatus().getStepCount());
        extremaClimbLabel.setText(EXTREMA + drawBoard.getClimbHillAlgorithm().getStatus().getExtremumCount());
        extremumClimbLabel.setText(EXTREMUM + drawBoard.getClimbHillAlgorithm().getStatus().getExtremum().toString());
        arrayAccessedClimbLabel.setText(ARRAYS_ACCESSED + drawBoard.getClimbHillAlgorithm().getStatus().getArraysCount());
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
        }

    }
}