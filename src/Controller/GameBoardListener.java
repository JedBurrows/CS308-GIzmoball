package Controller;


import Model.GizmoCreator;
import Model.IBall;
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
    private float l;
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
        } else if (SwingUtilities.isLeftMouseButton(e)) {
            System.out.println(gui.getMode());
            switch (gui.getMode()){
                case("AddGizmo"):

                    String g = gizmo.getSelectedItem().toString();
                    int x = (int) (e.getX()/l);
                    int y = (int) (e.getY()/l);

                    board.addGizmo(gizmoCreator.createGizmo(g,x,y));
                    boardPanel.repaint();
                    break;
                case("AddBall"):
                    float x1 = e.getX()/l;
                    float y1 = e.getY()/l;
                    System.out.println(e.getX());
                    System.out.println(e.getY());
                    System.out.println(x1);
                    System.out.println(y1);
                    board.addGizmoBall(x1,y1);
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
