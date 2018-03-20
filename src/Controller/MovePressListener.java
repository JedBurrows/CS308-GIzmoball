package Controller;

import Model.Connector;
import Model.GizmoCreator;
import Model.Gizmos.IGizmo;
import Model.IBoard;
import Model.IConnector;
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
            IGizmo gizmo = board.getGizmoByPosition(x1, y1);
            if (x2 >= 0 && x2 <= gizmo.getWidth() + 18 && y2 >= 0 && y2 <= 18 + gizmo.getHeight()) {
                String gID = gizmo.getClass().getSimpleName();
                Color color = gizmo.getColor();

//               IGizmo newGizmo = gizmoCreator.createGizmo(gID, x2, y2, color);
               board.deleteGizmo(board.getGizmoByPosition(x1, y1).getID());

                IGizmo newGizmo = gizmoCreator.createGizmo(gID, gizmo.getID(), x2, y2, color);

                //String type, String id, int x, int y, Color colour
                board.addGizmo(newGizmo);
                for (IConnector c: board.getConnectors()) {
                    if (c.getSource().getID().equals(gizmo.getID())) {
                    }
                }
                    boardPanel.repaint();
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
        boardPanel.setSelectPoint2(e.getPoint());
        boardPanel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
