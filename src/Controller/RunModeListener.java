package Controller;

import Model.IBoard;
import View.BuildGUI;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class RunModeListener implements GBallListener {

	private GBallFrame gBallFrame;
	private Timer timer;
	private KeyListener keyListener;


	public RunModeListener(GBallFrame gBallFrame) {
		this.gBallFrame = gBallFrame;
		this.timer = new Timer(10, this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IBoard board = gBallFrame.getBoardPanel().getBoard();
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
					case "Build":
						gBallFrame.getBoardPanel().getBoard().switchMode();
						gBallFrame.buildMode();
						timer.stop();
						break;
				}


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
		/*
			No MouseListener in run
		*/

	}

	@Override
	public void setKeyBoardListener(KeyListener keyListener) {
		BuildGUI buildGUI = gBallFrame.getBuildPanel();
		buildGUI.getBoardPanel().removeKeyListener(this.keyListener);
		this.keyListener = keyListener;
		buildGUI.getBoardPanel().addKeyListener(this.keyListener);

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
