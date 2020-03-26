package Birski;

import Birski.gui.MainView;

import javax.swing.*;

import static Birski.utils.Strings.SOFTWARE_TITLE;

public class Main  {

    public static void main(String[] args) {
        JFrame window = new JFrame(SOFTWARE_TITLE);
        MainView mainView = new MainView();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(790, 580);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.add(mainView);
        window.setVisible(true);

    }
}
