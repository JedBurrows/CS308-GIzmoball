package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;
import View.GBallFrame;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeListener implements ChangeListener {
	private IBoard board;
	private BoardPanel boardPanel;
	private BuildGUI buildGUI;

	public SliderChangeListener(GBallFrame gBallFrame) {
		boardPanel = gBallFrame.getBoardPanel();
		buildGUI = gBallFrame.getBuildPanel();
		board = boardPanel.getBoard();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		board.setGravity(buildGUI.getGravity());
		board.setFriction(buildGUI.getMu(),buildGUI.getMU2());
	}
}
