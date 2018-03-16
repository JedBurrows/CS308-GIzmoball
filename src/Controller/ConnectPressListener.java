package Controller;

import Model.Gizmos.IGizmo;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ConnectPressListener implements MouseListener {
	private BuildGUI buildGUI;
	private BoardPanel boardPanel;
	private float L;
	private IBoard board;

	private boolean doneFlag;
	private IGizmo source;
	private IGizmo target;

	public ConnectPressListener(BuildGUI buildGUI) {
		this.buildGUI = buildGUI;
		this.boardPanel = buildGUI.getBoardPanel();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;
		this.doneFlag = true;


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			setConnection(e.getX(), e.getY());
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

	private void setConnection(int x, int y) {
		try {
			if (doneFlag) {
				source = board.getGizmoByPosition(x / L, y / L);
				System.out.println("Source set as: " + source.getID());
				doneFlag = false;
			} else {
				target = board.getGizmoByPosition(x / L, y / L);
				System.out.println("Target set as: " + target.getID());

				System.out.println("Add Connection was: " + board.addConnector(source.getID(), target.getID()));
				System.out.println("Connection created.");
				doneFlag = true;

			}
		} catch (NullPointerException e) {
			System.out.println("Not a gizmo.");
		}


	}
}
