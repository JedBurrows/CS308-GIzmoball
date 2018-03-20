package View;


import Controller.KeyPressListener;
import Controller.RunModeListener;

import javax.swing.*;
import java.awt.*;

public class RunGUI implements IGUI {

	private BoardPanel boardPanel;
	private RunModeListener runModeListener;

	public RunGUI(GBallFrame parent, BoardPanel boardPanel) {
		setBoardPanel(boardPanel);

		runModeListener = new RunModeListener(parent);




	}


	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	@Override
	public JPanel createButtons() {
		JButton btnStart = new JButton("Start");
		btnStart.setPreferredSize(new Dimension(75, 75));
		btnStart.addActionListener(runModeListener);
		btnStart.setActionCommand("Start");
		btnStart.setFocusable(false);

		JButton btnStop = new JButton("Stop");
		btnStop.setPreferredSize(new Dimension(75, 75));
		btnStop.addActionListener(runModeListener);
		btnStop.setActionCommand("Stop");
		btnStop.setFocusable(false);

		JButton btnTick = new JButton("Tick");
		btnTick.setPreferredSize(new Dimension(75, 75));
		btnTick.addActionListener(runModeListener);
		btnTick.setActionCommand("Tick");
		btnTick.setFocusable(false);


		JButton btnBuildMode = new JButton("Build");
		btnBuildMode.setPreferredSize(new Dimension(75, 75));
		btnBuildMode.setActionCommand("Build");
		btnBuildMode.addActionListener(runModeListener);
		btnBuildMode.setFocusable(false);


		JPanel panelBtn = new JPanel();
		panelBtn.setSize(150, 300);
		panelBtn.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		c.gridwidth = 0;

		panelBtn.add(btnStart, c);
		panelBtn.add(btnStop, c);
		panelBtn.add(btnTick, c);
		panelBtn.add(btnBuildMode, c);


		return panelBtn;
	}

	@Override
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e -> System.exit(0));
		fileMenu.add(exitMenuItem);
		return menuBar;
	}
}
