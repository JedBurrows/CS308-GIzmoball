package View;

import Controller.LoadSaveController;
import Model.Board;

import javax.swing.*;

public class GBallFrame {
	private JFrame frame;
	private static RunGUI runPanel;
	private static BuildGUI buildPanel;


	public GBallFrame(){
		frame = new JFrame("Gizmoball");
		buildPanel = new BuildGUI(new Board());
		/*
			Should create new run Gui but with no ref to board.

			runPanel = new RunGUI();
		 */
		frame.setJMenuBar(createBuildBar());
		frame.add(buildPanel.getFrame());
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}



	public void switchToRun(){

	}

	public void switchToBuild(){

	}

	private JMenuBar createBuildBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem menuItemLoad = new JMenuItem("Load");
		menuItemLoad.addActionListener(new LoadSaveController(buildPanel.getBoardPanel()));

		JMenuItem menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(new LoadSaveController(buildPanel.getBoardPanel()));

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e -> System.exit(0));


		fileMenu.add(menuItemLoad);
		fileMenu.add(menuItemSave);
		fileMenu.add(exitMenuItem);

		return menuBar;
	}
}
