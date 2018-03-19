package Controller;

import Model.Gizmos.IGizmo;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;

public class KeyConnectPressListener implements KeyListener, MouseListener {
	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	private boolean doneFlag;
	private int sourceKey;
	private IGizmo target;

	public KeyConnectPressListener(BuildGUI buildGUI) {
		this.boardPanel = buildGUI.getBoardPanel();
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
			System.out.println("target: " + target.getID());
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
		System.out.println("key");

		if (target != null) {
			sourceKey = e.getKeyCode();
			System.out.println("key: " + sourceKey);
			setKeyConnection();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	private void setKeyConnection() {
		try {
			board.addKeyConnector(sourceKey, target.getID());
		} catch (NullPointerException e) {
			System.out.println("Not a gizmo.");
		}
	}
}
