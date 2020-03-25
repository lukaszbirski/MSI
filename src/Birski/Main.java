package Birski;

import Birski.gui.MainView;
import Birski.models.Function;

import javax.swing.*;

import java.awt.*;

import static Birski.utils.Strings.SOFTWARE_TITLE;

public class Main  {

    static MainView mainView = new MainView();
    static JFrame window = new JFrame(SOFTWARE_TITLE);
    //static public Function function = new Function();

    public static void main(String[] args) {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(790, 580);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.add(mainView);
        window.setVisible(true);

        //Function function = new Function();
        //System.out.println();



	// write your code here
    }
}
