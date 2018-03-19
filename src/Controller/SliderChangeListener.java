package Controller;

import Model.IBoard;
import View.BoardPanel;
import View.BuildGUI;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeListener implements ChangeListener {
	private IBoard board;
	private BoardPanel boardPanel;
	private BuildGUI buildGUI;

	public SliderChangeListener(BuildGUI buildGUI){
		this.buildGUI = buildGUI;
		boardPanel = buildGUI.getBoardPanel();
		board = boardPanel.getBoard();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		board.setGravity(buildGUI.getGravity());
		board.setFriction(buildGUI.getMu(),buildGUI.getMU2());
	}
}
