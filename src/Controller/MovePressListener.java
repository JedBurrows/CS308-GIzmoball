package Controller;

import Model.GizmoCreator;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;
import View.GBallFrame;

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

    private float x1;
    private float y1;

    public MovePressListener(GBallFrame gBallFrame) {
        this.buildGUI =gBallFrame.getBuildPanel();
        this.boardPanel = buildGUI.getBoardPanel();
        this.gizmoCreator = new GizmoCreator();
        this.board = boardPanel.getBoard();
        this.L = boardPanel.getDimension() / 20;
        System.out.println(this.colour);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!board.isRunMode()) {
            x1 = e.getX() / L;
            y1 = e.getY() / L;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!board.isRunMode()) {
            int x2 = (int)(e.getX() / L);
            int y2 = (int)(e.getY() / L);
//            if (x2 >= 0 && x2 <= 19 && y2 >= 0 && y2 <= 19) {
                String g = board.getGizmoByPosition(x1, y1).getClass().getSimpleName();
//                Color c = board.getGizmoByPosition(x1, y1).getColor();
//                System.out.println("sting: " + g);
//                board.deleteGizmo(board.getGizmoByPosition(x1, y1).getID());
//
//                board.addGizmo(gizmoCreator.createGizmo(g, x2, y2, c));
//                boardPanel.repaint();
//            }
            try {
                board.getGizmoByPosition(x1, y1).setPos1(x2, y2);
                boardPanel.repaint();
            }catch (Exception ex){

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
