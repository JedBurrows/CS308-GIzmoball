package Controller;

import Model.GizmoCreator;
import Model.Gizmos.Absorber;
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

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!board.isRunMode()) {
			pressed = e;
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
		if (!board.isRunMode()) {
			String g = gizmo.getSelectedItem().toString();
			if (g.equals("Absorber")) {
				released = e;
				int x = (int) (pressed.getX() / L);
				int y = (int) (pressed.getY() / L);
				int i = (int) (released.getX() / L);
				int j = (int) (released.getY() / L);
				if ((j - y) <= (i - x)) {
					board.addGizmo(new Absorber("A", x, i, y, j, Color.GRAY));
					buildGUI.clearSelected();
					buildGUI.setMode("AddGizmo");
					boardPanel.repaint();
				}
			}
		}

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
