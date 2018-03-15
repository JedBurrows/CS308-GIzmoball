package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class DeletePressListener implements MouseInputListener {
    private BuildGUI buildGUI;
    private BoardPanel boardPanel;
    private float L;
    private IBoard board;

    public DeletePressListener(BuildGUI buildGUI){
        this.buildGUI = buildGUI;
        this.boardPanel = buildGUI.getBoardPanel();
        this.board = boardPanel.getBoard();
        this.L = boardPanel.getDimension()/20;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        float x2 = e.getX() / L;
        float y2 = e.getY() / L;
        if(board.hasGizmoBall() && board.isInsideBall(x2,y2)){
            board.deleteBall();
            boardPanel.repaint();
        }
        else {
            board.deleteGizmo(board.getGizmoByPosition(x2, y2).getID());
            boardPanel.repaint();
        }
        buildGUI.clearSelected();
        buildGUI.setMode("Delete");
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
