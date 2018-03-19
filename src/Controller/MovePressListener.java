package Controller;

import Model.GizmoCreator;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MovePressListener implements MouseInputListener {


    private BuildGUI buildGUI;
    private JComboBox<String> gizmo;
    private BoardPanel boardPanel;
    private float L;
    private GizmoCreator gizmoCreator;
    private IBoard board;
    private MouseEvent pressed;
    private MouseEvent released;
    private Color colour;

    public MovePressListener(BuildGUI gui, Color colour) {
        this.buildGUI = gui;
        this.gizmo = buildGUI.getBoxGizmo();
        this.boardPanel = buildGUI.getBoardPanel();
        this.gizmoCreator = new GizmoCreator();
        this.board = boardPanel.getBoard();
        this.L = boardPanel.getDimension() / 20;
        this.colour = colour;
        System.out.println(this.colour);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click event");

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Release event");
        if (!board.isRunMode()) {
            String g = gizmo.getSelectedItem().toString();
            if (!g.equals("Absorber")) {
                released = e;
                int x = (int) (pressed.getX() / L);
                int y = (int) (pressed.getY() / L);
                int i = (int) (released.getX() / L) + 1;
                int j = (int) (released.getY() / L) + 1;
                if ((j - y) <= (i - x)) {
                    board.addGizmo(gizmoCreator.createGizmo(g,x,y,colour));
                    buildGUI.clearSelected();
                    buildGUI.setMode("AddGizmo");

                    //TODO clear point selection on BoardPanel here then repaint
                    boardPanel.removedSelected();
                    boardPanel.repaint();
                }
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Drag Event");
        boardPanel.setSelectPoint2(e.getPoint());
        boardPanel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
