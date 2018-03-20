package Controller;

import Model.GizmoCreator;
import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;


public class AddGizmoPressListener implements MouseInputListener {

	private JComboBox<String> gizmo;
	private BoardPanel boardPanel;
	private float L;
	private GizmoCreator gizmoCreator;
	private IBoard board;
	private MouseEvent pressed;
	private MouseEvent released;
	private Color colour;

	public AddGizmoPressListener(GBallFrame gBallFrame, Color colour) {
		//TODO NEEDS RESOLVED
		this.gizmo = gBallFrame.getBuildPanel().getBoxGizmo();
		this.boardPanel = gBallFrame.getBoardPanel();
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
					int x;
					int y;
					if (g.equals("RightFlipper")){
						System.out.println("here1");
						x = (int) (e.getX() / L) - 1;
					}else {
						x = (int) (e.getX() / L);
					}
					y = (int) (e.getY() / L);

					board.addGizmo(gizmoCreator.createGizmo(g, x, y, colour));
					boardPanel.removedSelected();
					boardPanel.repaint();
				}
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
				int i = (int) (released.getX() / L) + 1;
				int j = (int) (released.getY() / L) + 1;
				if ((j - y) <= (i - x)) {
					board.addGizmo(gizmoCreator.createAbsorber(x, y, i, j, colour));

					//TODO clear point selection on BoardPanel here then repaint
					boardPanel.removedSelected();
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

	public void setColour(Color colour) {
		this.colour = colour;
	}
}
