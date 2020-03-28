package Birski;

import Birski.gui.MainView;

import javax.swing.*;

import static Birski.utils.Strings.SOFTWARE_TITLE;

public class Main  {

    static JFrame window = new JFrame(SOFTWARE_TITLE);
    static MainView mainView = new MainView();

    public static void main(String[] args) {


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(790, 580);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.add(mainView);
        window.setVisible(true);
        //test();

    }

    public static void test(){
        if (mainView.getDrawBoard().getClimbHillAlgorithm() != null) {
            System.out.println(mainView.getDrawBoard().getClimbHillAlgorithm().startingPoint.toString());
        }
    }
}
