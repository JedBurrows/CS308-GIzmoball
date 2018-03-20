package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class AddBallPressListener implements MouseInputListener {

	private BoardPanel boardPanel;
	private float L;
	private IBoard board;


	public AddBallPressListener(GBallFrame gBallFrame) {
		this.boardPanel = gBallFrame.getBoardPanel();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!board.isRunMode()) {
			float x1 = e.getX() / L;
			float y1 = e.getY() / L;
			System.out.println(e.getX());
			System.out.println(e.getY());
			System.out.println(x1);
			System.out.println(y1);
			board.addGizmoBall("Ball", x1, y1, 0f, 0f);
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

