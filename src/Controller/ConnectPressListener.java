package Controller;

import Model.Gizmos.IGizmo;
import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

//public class ConnectPressListener implements MouseListener {
public class ConnectPressListener implements MouseInputListener {
	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	private boolean doneFlag;
	private IGizmo source;
	private IGizmo target;

	public ConnectPressListener(GBallFrame gBallFrame) {
		this.boardPanel = gBallFrame.getBoardPanel();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;
		this.doneFlag = true;


	}

	@Override
	public void mouseClicked(MouseEvent e) {



	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			setConnection(e.getX(), e.getY());
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

	private void setConnection(int x, int y) {
		try {
			if (doneFlag) {
				source = board.getGizmoByPosition(x / L, y / L);
				doneFlag = false;
			} else {
				target = board.getGizmoByPosition(x / L, y / L);
				doneFlag = true;

			}
		} catch (NullPointerException e) {
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
