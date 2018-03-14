package View;

import Controller.LoadSaveController;
import Model.IBoard;

import javax.swing.*;

public class GBallFrame{
	private JFrame frame;
	private  RunGUI runPanel;
	private  BuildGUI buildPanel;

	private BoardPanel boardPanel;

	private JMenuBar buildBar,runBar;


	public GBallFrame(IBoard board){
		frame = new JFrame("Gizmoball");

		boardPanel = new BoardPanel(board);

		buildPanel = new BuildGUI(this,boardPanel);
		runPanel = new RunGUI(this,boardPanel);

		boardPanel.setColours(buildPanel.getColours());

		buildPanel.getFrame().add(boardPanel);




		buildBar = createBuildBar();
		runBar = createRunBar();

		frame.setJMenuBar(createBuildBar());
		frame.add(buildPanel.getFrame());
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}



	public void switchToRun(){
		buildPanel.close();
		frame.remove(buildPanel.getFrame());
		frame.setJMenuBar(runBar);
		runPanel.getFrame().add(boardPanel);
		runPanel.open();
		frame.add(runPanel.getFrame());
		frame.pack();
		boardPanel.getBoard().switchMode();
	}

	public void switchToBuild(){
		runPanel.close();
		frame.remove(runPanel.getFrame());
		frame.setJMenuBar(buildBar);
		buildPanel.getFrame().add(boardPanel);
		buildPanel.open();
		frame.add(buildPanel.getFrame());
		frame.pack();
		boardPanel.getBoard().switchMode();

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

	public RunGUI getRunPanel() {
		return runPanel;
	}

	public BuildGUI getBuildPanel() {
		return buildPanel;
	}
}
