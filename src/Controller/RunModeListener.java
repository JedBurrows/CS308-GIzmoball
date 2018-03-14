package Controller;

import View.GBallFrame;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class RunModeListener implements GBallListener {

	private GBallFrame gBallFrame;

	public RunModeListener(GBallFrame gBallFrame){
		this.gBallFrame = gBallFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case "Start":

				break;

			case "Stop":

				break;

			case "Tick":
				break;

			case "Build":
				gBallFrame.switchToBuild();
				break;


		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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

	@Override
	public void setMouseListener(MouseInputListener mouseInputListener) {

	}

	@Override
	public void setKeyBoardListener(KeyListener keyListener) {

	}
}
