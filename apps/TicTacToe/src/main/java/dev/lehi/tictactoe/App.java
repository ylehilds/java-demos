package dev.lehi.tictactoe;

import javax.swing.*;

public class App {
    public static void main (String[] args) {

        // The following try catch is only for Macs to display the usual javax swing colors. This makes Swing stop using macOS defaults. It uses Nimbus. Otherwise, the colors look so off.
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TicTacToe ticTacToe = new TicTacToe();
    }
}