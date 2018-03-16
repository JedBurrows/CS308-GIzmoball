package Controller;

import Model.GizmoCreator;
import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;


public class AddGizmoPressListener implements MouseInputListener {

	private BuildGUI buildGUI;
	private JComboBox<String> gizmo;
	private BoardPanel boardPanel;
	private float L;
	private GizmoCreator gizmoCreator;
	private IBoard board;
	private MouseEvent pressed;
	private MouseEvent released;
	private Color colour;

	public AddGizmoPressListener(BuildGUI gui, Color colour) {
		this.buildGUI = gui;
		this.gizmo = buildGUI.getBoxGizmo();
		this.boardPanel = buildGUI.getBoardPanel();
		this.gizmoCreator = new GizmoCreator();
		this.board = boardPanel.getBoard();
		this.L = boardPanel.getDimension() / 20;
		this.colour = colour;
		System.out.println(this.colour);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click event");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Press event");
		if (!board.isRunMode()) {
			pressed = e;
			boardPanel.setSelectPoint1(e.getPoint());

			if (SwingUtilities.isLeftMouseButton(e)) {
				String g = gizmo.getSelectedItem().toString();
				if (!g.equals("Absorber")) {
					int x = (int) (e.getX() / L);
					int y = (int) (e.getY() / L);

					board.addGizmo(gizmoCreator.createGizmo(g, x, y, colour));
					boardPanel.repaint();
				}
				buildGUI.clearSelected();
				buildGUI.setMode("AddGizmo");
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Release event");
		if (!board.isRunMode()) {
			String g = gizmo.getSelectedItem().toString();
			if (g.equals("Absorber")) {
				released = e;
				int x = (int) (pressed.getX() / L);
				int y = (int) (pressed.getY() / L);
				int i = (int) (released.getX() / L);
				int j = (int) (released.getY() / L);
				if ((j - y) <= (i - x)) {
					board.addGizmo(gizmoCreator.createAbsorber(x, y, i, j, colour));
					buildGUI.clearSelected();
					buildGUI.setMode("AddGizmo");

					//TODO clear point selection on BoardPanel here then repaint
					boardPanel.repaint();
				}
			}
		}


	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//For when mouse enters panel area


	}

	@Override
	public void mouseExited(MouseEvent e) {
		//For when mouse leaves panel


	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Drag Event");
		boardPanel.setSelectPoint2(e.getPoint());
		boardPanel.repaint();


	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("Move event");

	}
}
