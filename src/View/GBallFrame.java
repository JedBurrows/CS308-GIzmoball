package View;

import Controller.LoadSaveController;
import Model.Board;

import javax.swing.*;

public class GBallFrame{
	private JFrame frame;
	private static RunGUI runPanel;
	private static BuildGUI buildPanel;

	private static JMenuBar buildBar,runBar;


	public GBallFrame(Board board){
		frame = new JFrame("Gizmoball");

		buildPanel = new BuildGUI(this,board);

		runPanel = new RunGUI(this,board);

		buildBar = createBuildBar();
		runBar = createRunBar();

		frame.setJMenuBar(createBuildBar());
		frame.add(buildPanel.getFrame());
		frame.pack();
		frame.setResizable(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}



	public void switchToRun(){
		buildPanel.close();
		frame.remove(buildPanel.getFrame());
		frame.setJMenuBar(runBar);
		runPanel.open();
		frame.add(runPanel.getFrame());
		frame.pack();
		//frame.repaint();
	}

	public void switchToBuild(){
		runPanel.close();
		frame.remove(runPanel.getFrame());
		frame.setJMenuBar(buildBar);
		buildPanel.open();
		frame.add(buildPanel.getFrame());
		frame.pack();
		//frame.repaint();
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

	private JMenuBar createRunBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e -> System.exit(0));
		fileMenu.add(exitMenuItem);
		return menuBar;
	}
}
