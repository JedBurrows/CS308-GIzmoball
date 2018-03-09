package Controller;

import Model.Board;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClearBoardPressListener implements ActionListener {
    BuildGUI gui;
    IBoard board;
    BoardPanel panel;


    public ClearBoardPressListener(IBoard board, BoardPanel panel){
        this.gui = gui;
        this.board = board;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        board.clearGizmos();
        panel.repaint();

        System.out.println("board is clear");
    }
}
