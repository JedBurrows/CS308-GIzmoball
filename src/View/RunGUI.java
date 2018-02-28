package View;


import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RunGUI implements IModeGUI {

	JFrame runFrame;

	public RunGUI() {

		runFrame = new JFrame("Run Mode!");
		runFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		runFrame.setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem menuItemLoad = new JMenuItem("Load");
		JMenuItem menuItemSave = new JMenuItem("Save");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e -> System.exit(0));
		fileMenu.add(menuItemLoad);
		fileMenu.add(menuItemSave);
		fileMenu.add(exitMenuItem);

		//runFrame.add(menuBar);


		JPanel gizmoBoard = new JPanel(new GridLayout(20, 20));
		gizmoBoard.setPreferredSize(new Dimension(600, 600));
		gizmoBoard.setBackground(Color.black);
		gizmoBoard.setVisible(true);

		JButton btnStart = new JButton("Start");
		btnStart.setPreferredSize(new Dimension(75, 75));
		JButton btnStop = new JButton("Stop");
		btnStop.setPreferredSize(new Dimension(75, 75));
		JButton btnTick = new JButton("Tick");
		btnTick.setPreferredSize(new Dimension(75, 75));
		JButton btnBuildMode = new JButton("Build");
		btnBuildMode.setPreferredSize(new Dimension(75, 75));


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


		runFrame.add(menuBar);
		JPanel panel = new JPanel();
		panel.add(panelBtn);
		panel.add(gizmoBoard);
		runFrame.add(panel);
		runFrame.pack();
		runFrame.setResizable(false);
		runFrame.setLocationRelativeTo(null);
		runFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		runFrame.setVisible(true);


	}

	@Override
	public JFrame getFrame() {
		return runFrame;
	}


}
