package Controller;

import Model.Gizmos.IGizmo;
import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class DisconnectPressListener implements MouseInputListener {

	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	private boolean doneFlag;
	private IGizmo source;
	private IGizmo target;

	public DisconnectPressListener(GBallFrame gBallFrame) {
		this.boardPanel = gBallFrame.getBoardPanel();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;
		this.doneFlag = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			removeConnection(e.getX(), e.getY());
			boardPanel.repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

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

	public void removeConnection(int x, int y) {
		try {
			if (doneFlag) {
				source = board.getGizmoByPosition(x / L, y / L);
				System.out.println("Source set as: " + source.getID());
				doneFlag = false;
			} else {
				target = board.getGizmoByPosition(x / L, y / L);
				System.out.println("Target set as: " + target.getID());

				System.out.println("Add Connection was: " + board.removeConnector(target.getID(), source.getID()));
				System.out.println("Connection created.");
				doneFlag = true;

			}
		} catch (NullPointerException e) {
			System.out.println("Not a gizmo.");
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
