package Controller;


import Model.GizmoCreator;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;
import View.RightClickMenu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoardListener implements MouseListener {

    private IBoard board;
    private JComboBox<String> gizmo;
    private String mode;
    private BoardPanel boardPanel;

    public GameBoardListener(BoardPanel boardPanel, IBoard b,JComboBox<String> gizmo) {
        this.boardPanel = boardPanel;
        board = b;
        this.gizmo = gizmo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            RightClickMenu gizmoMenu = new RightClickMenu();
            gizmoMenu.show(e.getComponent(), e.getX(), e.getY());
        } else if (SwingUtilities.isLeftMouseButton(e)) {

            GizmoCreator gizmoCreator = new GizmoCreator();
            String g = gizmo.getSelectedItem().toString();
            System.out.println(g);
            int x = e.getX()/40;
            int y = e.getY()/40;
            System.out.println(x);
            System.out.println(y);
            System.out.println("Add was: " +board.addGizmo(gizmoCreator.createGizmo(g,x,y),x,y));
            boardPanel.repaint();
        }

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
