package Controller;

import Model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener implements ActionListener {

	private Timer timer;
	private Model model;

	public RunListener(Model m) {
		model = m;
		timer = new Timer(50, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.moveBall();
		} else
			switch (e.getActionCommand()) {
				case "Start":
					System.out.println("hello");
					timer.start();
					break;
				case "Stop":
					timer.stop();
					break;
				case "Tick":
					model.moveBall();
					break;
				case "Quit":
					System.exit(0);
					break;
			}
	}
}
