package Controller;

import View.BoardPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearBoardPressListener implements ActionListener {
    private BoardPanel panel;


    public ClearBoardPressListener(BoardPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.getBoard().clearGizmos();
        panel.repaint();

        System.out.println("board is clear");
    }
}
