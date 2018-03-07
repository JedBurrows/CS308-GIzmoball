package Main;

import Model.*;
import View.RunGUI;

public class Main {
    public static void main(String args[]){
        Board board = new Board();
//        BuildGUI b = new BuildGUI(model);
        RunGUI g = new RunGUI(board);

//        model.addGizmoball();
    }
}
