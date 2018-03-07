package Controller;

import Model.IBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener implements ActionListener {

	private Timer timer;
	private IBoard board;

	public RunListener(IBoard b) {
		board = b;
		timer = new Timer(50, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

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
