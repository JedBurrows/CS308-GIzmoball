package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;
import View.GBallFrame;
import View.RunGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModeListener implements ActionListener {

    private GBallFrame frame;
    private IBoard board;

    public ModeListener(GBallFrame frame, IBoard b){
        this.frame =frame;
        board = b;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        System.out.println(arg);
        if (arg.equals("Run")) {
            frame.switchToRun();
            board.setRunMode();
        } else if (arg.equals("Build")) {
            frame.switchToBuild();
            board.setRunMode();
        }


    }

}
