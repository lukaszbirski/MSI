package Birski;

import Birski.gui.MainView;

import javax.swing.*;

import static Birski.utils.Strings.SOFTWARE_TITLE;

//public class Main implements Runnable {

//    static JFrame window = new JFrame(SOFTWARE_TITLE);
//    static MainView mainView = new MainView();
//    static Thread watek = new Thread(mainView);
//
//    short op = 50;
//
//    public static void main(String[] args) {
//
//
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setSize(790, 580);
//        window.setLocationRelativeTo(null);
//        window.setResizable(false);
//        mainView.run();
//        watek.run();
//        window.add(mainView);
//        window.setVisible(true);
//    }

//    @Override
//    public void run() {
//
//        long wait, startCzas, cyklCzas;
//
//        while (true){
//                startCzas = System.nanoTime();
//                cyklCzas = startCzas - System.nanoTime();
//                wait = op - cyklCzas/1000000;
//                if (wait <=0 )wait = 3;
//                try {watek.sleep(op);} catch (InterruptedException e) {e.printStackTrace();}
//                System.out.println(op + " > " + wait);
//        }
//
//    }
//}
