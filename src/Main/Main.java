package Main;

import Model.*;
import View.BuildGUI;
import View.GBallFrame;
import View.RunGUI;

import javax.swing.*;

public class Main {

    public static void main(String args[]){

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Board board = new Board();
                GBallFrame frame = new GBallFrame(board);
            }
        });






    }
}
