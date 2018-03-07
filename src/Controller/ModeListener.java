package Controller;

import Model.IBoard;
import View.BuildGUI;
import View.GBallFrame;
import View.RunGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModeListener implements ActionListener {

    private IBoard board;
    private GBallFrame frame;

    public ModeListener(GBallFrame frame, IBoard b){
        board = b;
        this.frame =frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        System.out.println(arg);
        if (arg.equals("Run")) {
            frame.switchToRun();

        } else if (arg.equals("Build")) {
            frame.switchToBuild();
        }


    }

}
