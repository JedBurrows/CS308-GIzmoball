package Controller;

import Model.IBoard;
import View.BuildGUI;
import View.RunGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModeListener implements ActionListener {

    private BuildGUI build;
    private RunGUI run;
    private IBoard board;

    public ModeListener(BuildGUI bG, RunGUI rG, IBoard b){
        build = bG;
        run = rG;
        board = b;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        System.out.println(arg);
        if (arg.equals("Run")) {
            build.close();
            RunGUI run = new RunGUI(board);

        } else if (arg.equals("Build")) {
            run.close();
            BuildGUI run = new BuildGUI(board);
        }


    }

}
