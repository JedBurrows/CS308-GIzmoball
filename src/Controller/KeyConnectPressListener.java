package Controller;

import Model.Gizmos.IGizmo;
import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyConnectPressListener implements KeyListener, MouseInputListener {
	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	private int sourceKey;
	private IGizmo target;

	public KeyConnectPressListener(GBallFrame gBallFrame) {
		this.boardPanel = gBallFrame.getBoardPanel();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;
		target = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			target = board.getGizmoByPosition(e.getX() / L, e.getY() / L);
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
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (target != null) {
			sourceKey = e.getKeyCode();
			setKeyConnection();
			target = null;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	private void setKeyConnection() {
		try {
			board.addKeyPressEvent(sourceKey, target.getID());
			board.addKeyReleaseEvent(sourceKey, target.getID());
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
