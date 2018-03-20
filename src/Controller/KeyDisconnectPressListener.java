package Controller;

import Model.Gizmos.IGizmo;
import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;

public class KeyDisconnectPressListener implements KeyListener, MouseInputListener {

	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	private int sourceKey;
	private IGizmo target;

	public KeyDisconnectPressListener(GBallFrame gBallFrame){
		this.boardPanel = gBallFrame.getBoardPanel();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;
		target = null;
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (target != null) {
			sourceKey = e.getKeyCode();
			removeKeyConnection();
			target = null;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

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

	private void removeKeyConnection() {
		HashMap<Integer,List<String>> pressEvents = board.getKeyPressEvents();
		HashMap<Integer,List<String>> releaseEvents = board.getKeyReleaseEvents();

		pressEvents.get(sourceKey).remove(target.getID());
		releaseEvents.get(sourceKey).remove(target.getID());





	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
