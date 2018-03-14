package Controller;

import Model.Board;
import Model.IBoard;
import View.BoardPanel;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;

public class RunModeListener implements GBallListener {

	private GBallFrame gBallFrame;
	private Timer timer;



	public RunModeListener(GBallFrame gBallFrame){
		this.gBallFrame = gBallFrame;
		this.timer = new Timer(10, this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IBoard board = gBallFrame.getRunPanel().getBoardPanel().getBoard();
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
						break;
					case "Build":
						gBallFrame.switchToBuild();
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
	public void setMouseListener(MouseListener mouseListener) {

	}

	@Override
	public void setKeyBoardListener(KeyListener keyListener) {

	}
}
