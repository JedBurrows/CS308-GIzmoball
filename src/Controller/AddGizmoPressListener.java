package Controller;

import Model.Absorber;
import Model.GizmoCreator;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AddGizmoPressListener implements MouseInputListener {

    private BuildGUI buildGUI;
    private JComboBox<String> gizmo;
    private BoardPanel boardPanel;
    private float L;
    private GizmoCreator gizmoCreator;
    private IBoard board;
    private MouseEvent pressed;
    private MouseEvent released;

    public AddGizmoPressListener(BuildGUI gui  ){
        this.buildGUI = gui;
        this.gizmo = buildGUI.getBoxGizmo();
        this.boardPanel = buildGUI.getBoardPanel();
        this.gizmoCreator = new GizmoCreator();
        this.board = boardPanel.getBoard();
        this.L = boardPanel.getDimension()/20;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = e;
        if (SwingUtilities.isLeftMouseButton(e)){
            String g = gizmo.getSelectedItem().toString();
            if(!g.equals("Absorber")){
                int x = (int) (e.getX()/L);
                int y = (int) (e.getY()/L);

                board.addGizmo(gizmoCreator.createGizmo(g,x,y));
                boardPanel.repaint();
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        String g = gizmo.getSelectedItem().toString();
        if(g.equals("Absorber")) {
            released = e;
            System.out.println("Mouse Released");
            System.out.println("Abosrber");
            int x = (int) (pressed.getX() / L);
            int y = (int) (pressed.getY() / L);
            int i = (int) (released.getX() / L);
            int j = (int) (released.getY() / L);
            board.setAbsorber(new Absorber("Ab", x, y, i, j));
            boardPanel.repaint();
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

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
