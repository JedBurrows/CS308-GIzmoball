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
    private int l;
    private GizmoCreator gizmoCreator;
    private BuildGUI gui;

    public GameBoardListener(BoardPanel bP, IBoard b,JComboBox<String> gizmo, BuildGUI gui) {
        this.boardPanel = bP;
        board = b;
        this.gizmo = gizmo;
        l=boardPanel.getDimension()/20;
        gizmoCreator = new GizmoCreator();
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            RightClickMenu gizmoMenu = new RightClickMenu();
            gizmoMenu.show(e.getComponent(), e.getX(), e.getY());
            switch(gui.getMode()){
                case("Delete Gizmo"):
                    String d = gizmo.getSelectedItem().toString();
                    System.out.println(d);
                    System.out.println("Delete gizmo");

                    board.deleteGizmo(d);
                    boardPanel.repaint();
            }
        } else if (SwingUtilities.isLeftMouseButton(e)) {
            switch (gui.getMode()){
                case("AddGizmo"):

                    String g = gizmo.getSelectedItem().toString();
                    System.out.println(g);
                    int x = e.getX()/l;
                    int y = e.getY()/l;

                    board.addGizmo(gizmoCreator.createGizmo(g,x,y));
                    boardPanel.repaint();
                    break;
                default:
                    break;



            }


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
