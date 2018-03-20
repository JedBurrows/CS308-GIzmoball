package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class DeletePressListener implements MouseInputListener {
	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	public DeletePressListener(GBallFrame gBallFrame) {
		this.boardPanel = gBallFrame.getBoardPanel();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		float x2 = e.getX() / L;
		float y2 = e.getY() / L;
		if (board.hasGizmoBall()){
			for(int i = 0; i<board.getNumberBalls();i++){
			if(board.isInsideBall(i,x2, y2)) {
				board.deleteBall(i);
				boardPanel.repaint();
			}
			}
		} else {
			board.deleteGizmo(board.getGizmoByPosition(x2, y2).getID());
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
