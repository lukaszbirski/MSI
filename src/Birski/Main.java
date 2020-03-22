package Birski;

import Birski.gui.DrawBoard;
import Birski.gui.MainView;

import javax.swing.*;

import static Birski.utils.Strings.SOFTWARE_TITLE;

public class Main  {

    static MainView mainView = new MainView();
    static JFrame window = new JFrame(SOFTWARE_TITLE);

    public static void main(String[] args) {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(900, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        window.add(mainView);

	// write your code here
    }
}
