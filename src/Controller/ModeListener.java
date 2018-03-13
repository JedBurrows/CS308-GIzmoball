package Controller;

import View.BoardPanel;
import View.GBallFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModeListener implements ActionListener {

    private GBallFrame frame;
    private BoardPanel boardPanel;

    public ModeListener(GBallFrame frame, BoardPanel boardPanel){
        this.frame =frame;
        this.boardPanel = boardPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        System.out.println(arg);
        if (arg.equals("Run")) {
            frame.switchToRun();
            boardPanel.getBoard().switchMode();
        } else if (arg.equals("Build")) {
            frame.switchToBuild();
            boardPanel.getBoard().switchMode();
        }


    }

}
