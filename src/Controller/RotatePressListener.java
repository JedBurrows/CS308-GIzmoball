package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class RotatePressListener implements MouseInputListener {
	private BuildGUI buildGUI;
	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	public RotatePressListener(BuildGUI buildGUI){
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
		board.getGizmoByPosition(x2, y2).rotate();
		boardPanel.repaint();


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
