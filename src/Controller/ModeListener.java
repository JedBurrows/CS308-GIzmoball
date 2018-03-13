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
    private BoardPanel panel;

    public ModeListener(GBallFrame frame, BoardPanel panel){
        this.frame =frame;
        this.panel = panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        System.out.println(arg);
        if (arg.equals("Run")) {
            frame.switchToRun();
            //panel.getBoard().setRunMode();

        } else if (arg.equals("Build")) {
            frame.switchToBuild();
            //panel.getBoard();
        }


    }

}
