package Controller;

import Model.IBoard;
import View.BoardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener implements ActionListener {

	private Timer timer;
	private BoardPanel boardPanel;

	public RunListener(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
		this.timer = new Timer(10, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {
		IBoard board = boardPanel.getBoard();
		if (board.isRunMode()) {
			if (e.getSource() == timer) {
				board.moveBall();
			} else
				switch (e.getActionCommand()) {
					case "Start":
						timer.start();
						break;
					case "Stop":
						timer.stop();
						break;
					case "Tick":
						board.moveBall();
						break;
					case "Quit":
						System.exit(0);
						break;
				}
		}
	}
}
