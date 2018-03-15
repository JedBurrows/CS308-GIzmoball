package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddBallPressListener implements MouseInputListener {

    private BuildGUI buildGUI;
    private BoardPanel boardPanel;
    private float L;
    private IBoard board;


    public AddBallPressListener(BuildGUI buildGUI){
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
        if(!board.isRunMode()) {
            float x1 = e.getX() / L;
            float y1 = e.getY() / L;
            System.out.println(e.getX());
            System.out.println(e.getY());
            System.out.println(x1);
            System.out.println(y1);
            board.addGizmoBall(x1, y1);
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

