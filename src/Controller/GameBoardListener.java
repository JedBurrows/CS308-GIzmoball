package Controller;


import Model.Absorber;
import Model.GizmoCreator;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;
import View.RightClickMenu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoardListener implements MouseListener {

    private JComboBox<String> gizmo;
    private String mode;
    private BoardPanel boardPanel;
    private float l;
    private GizmoCreator gizmoCreator;
    private BuildGUI gui;
    private DeletePressListener deletePressListener;
    private MouseEvent mousePressed;
    private MouseEvent mouseReleased;
    private IBoard board;

    public GameBoardListener(BoardPanel bP,JComboBox<String> gizmo, BuildGUI gui) {
        this.boardPanel = bP;
        board = boardPanel.getBoard();
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
        mousePressed = e;
        if(!board.isRunMode()){
            if (SwingUtilities.isRightMouseButton(e)) {
                RightClickMenu gizmoMenu = new RightClickMenu();

                gizmoMenu.show(e.getComponent(), e.getX(), e.getY());
                switch(gui.getMode()){
                    case("Delete"):
                        String d = gizmo.getSelectedItem().toString();
                        System.out.println(d);
                        System.out.println("Delete gizmo");
                        board.deleteGizmo(d);
                        boardPanel.repaint();

                }
            } else if (SwingUtilities.isLeftMouseButton(e)) {
                System.out.println(gui.getMode());
                System.out.println("Left clicked");
                switch (gui.getMode()) {
                    case ("AddGizmo"):

                        String g = gizmo.getSelectedItem().toString();
                        int x = (int) (mousePressed.getX() / l);
                        int y = (int) (mousePressed.getY() / l);

                        if(g.equals("Absorber")){
                            break;

                        }
                        board.addGizmo(gizmoCreator.createGizmo(g, x, y));
                        boardPanel.repaint();

                        break;
                    case ("AddBall"):
                        float x1 = mousePressed.getX() / l;
                        float y1 = mousePressed.getY() / l;
                        System.out.println(e.getX());
                        System.out.println(e.getY());
                        System.out.println(x1);
                        System.out.println(y1);
                        board.addGizmoBall(x1, y1);
                        boardPanel.repaint();
                        break;
                    case ("Delete"):
                        float x2 = mousePressed.getX() / l;
                        float y2 = mousePressed.getY() / l;
                        if (board.isInsideBall(x2, y2)) {
                            board.deleteBall();
                            boardPanel.repaint();
                        } else {
                            System.out.println("Gizmo Delete");
                            board.deleteGizmo(board.getGizmoByPosition(x2, y2).getID());
                            boardPanel.repaint();
                        }
                        break;

                    case ("Move"):
                    default:
                        break;
                }
            }

        }

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        String g = gizmo.getSelectedItem().toString();
        if(g.equals("Absorber")) {
            mouseReleased = e;
            System.out.println("Mouse Released");
            System.out.println("Abosrber");
            int x = (int) (mousePressed.getX() / l);
            int y = (int) (mousePressed.getY() / l);
            int i = (int) (mouseReleased.getX() / l);
            int j = (int) (mouseReleased.getY() / l);
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
