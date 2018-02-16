package View;


import Controller.KeyPressListener;
import Controller.LoadSaveController;
import Model.Ball;
import Model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LSProtoGUI implements IModeGUI {


	private JFrame buildFrame;
	private BoardPanel gizmoBoard;


	public LSProtoGUI() {

		buildFrame = new JFrame("Build Mode!");
		buildFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createGameBoard();
		createMenuBar();


		JPanel panel = new JPanel();
		panel.add(gizmoBoard);
		buildFrame.add(panel);
		buildFrame.pack();
		buildFrame.setResizable(false);
		buildFrame.setLocationRelativeTo(null);
		buildFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildFrame.setVisible(true);
	}

	private void createMenuBar() {
		ActionListener lsListener = new LoadSaveController(gizmoBoard);
		JMenuBar menuBar = new JMenuBar();
		buildFrame.setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem menuItemLoad = new JMenuItem("Load");
		JMenuItem menuItemSave = new JMenuItem("Save");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e -> System.exit(0));
		menuItemLoad.addActionListener(lsListener);
		menuItemSave.addActionListener(lsListener);
		menuItemLoad.setActionCommand("load");
		menuItemSave.setActionCommand("save");
		fileMenu.add(menuItemLoad);
		fileMenu.add(menuItemSave);
		fileMenu.add(exitMenuItem);
	}

	private void createGameBoard() {

		gizmoBoard = new BoardPanel(new Board());

		gizmoBoard.setVisible(true);





		gizmoBoard.setFocusable(true);
		gizmoBoard.setFocusCycleRoot(true);
		gizmoBoard.setVisible(true);
//        gizmoBoard.addMouseListener(new GameBoardListener(this));
		gizmoBoard.addKeyListener(new KeyPressListener());

	}


	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		if (arg.equals("Add Ball")) {
			Ball paintComponent = new Ball("B", 5f, 5f, 5f, 5f);
		}


	}

	@Override
	public JFrame getFrame() {
		return buildFrame;
	}

    /*@Override
	public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Run")) {
            IModeGUI run = new RunGUI();

    }*/

}

