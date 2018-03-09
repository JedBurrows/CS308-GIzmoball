package View;

import Controller.GameBoardListener;

import javax.swing.*;
import java.awt.event.ActionListener;


public class RightClickMenu extends JPopupMenu {

	JMenuItem delete, move, rotate;

	public RightClickMenu() {
		delete = new JMenuItem("Delete Gizmo");
		add(delete);

		move = new JMenuItem("Move Gizmo");
		add(move);

		rotate = new JMenuItem("Rotate Gizmo");
		add(rotate);
	}

}
