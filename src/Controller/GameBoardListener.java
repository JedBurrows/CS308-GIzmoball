package Controller;


import View.IModeGUI;
import View.RightClickMenu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoardListener implements MouseListener {
	IModeGUI gui;

	public GameBoardListener(IModeGUI gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			RightClickMenu gizmoMenu = new RightClickMenu();
			gizmoMenu.show(e.getComponent(), e.getX(), e.getY());
		} else if (SwingUtilities.isLeftMouseButton(e)) {

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
}
