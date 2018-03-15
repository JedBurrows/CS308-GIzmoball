package View;

import javax.swing.*;


public class RightClickMenu extends JPopupMenu {

	private JMenuItem delete, move, rotate;

	public RightClickMenu() {

		delete = new JMenuItem("Delete Gizmo");


		add(delete);


		move = new JMenuItem("Move Gizmo");
		add(move);

		rotate = new JMenuItem("Rotate Gizmo");
		add(rotate);
	}

}
