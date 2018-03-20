package View;

import Model.IBoard;

import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class GBallFrame {
	private JFrame frame;
	private RunGUI runPanel;
	private BuildGUI buildPanel;
	private BoardPanel boardPanel;
	private JPanel buildButtons, runButtons, main;
	private JMenuBar buildBar, runBar;
	private CardLayout cardLayout;




	public GBallFrame(IBoard board) {
		frame = new JFrame("Gizmoball");
		boardPanel = new BoardPanel(board);
		buildPanel = new BuildGUI(this, boardPanel);
		runPanel = new RunGUI(this, boardPanel);

		buildButtons = buildPanel.createButtons();
		buildBar = buildPanel.createMenuBar();

		runBar = runPanel.createMenuBar();
		runButtons = runPanel.createButtons();

		frame.setLayout(new GridLayout());
		cardLayout = new CardLayout();
		main = new JPanel(cardLayout);

		main.add(buildButtons, "Build Mode");
		main.add(runButtons, "Run Mode");
		frame.add(main);
		frame.add(boardPanel);


		buildMode();


		frame.setResizable(false);
	//	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				ImageIcon icon = new ImageIcon("Images/saveIcon1.jpg");

				//Custom button text
				Object[] options = {"Yes, please",
						"No, thanks"};
				int n = JOptionPane.showOptionDialog(frame,
						"Are you sure you want to exit?",
						"Remember to Save",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						icon,
						options,
						options[1]);

				if(n == JOptionPane.YES_OPTION){
					System.exit(0);

				}
				
			}
		});





		frame.pack();
		frame.setVisible(true);

		boardPanel.setFocusable(true);

		boardPanel.requestFocusInWindow();
		boardPanel.requestFocus();

	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public BuildGUI getBuildPanel() {
		return buildPanel;
	}

	public RunGUI getRunPanel() {
		return runPanel;
	}

	public void buildMode() {
		cardLayout.show(main, "Build Mode");
		frame.setJMenuBar(buildBar);
		frame.pack();
		frame.revalidate();
		frame.repaint();
	}

	public void runMode() {
		cardLayout.show(main, "Run Mode");
		frame.setJMenuBar(runBar);
		frame.pack();
		frame.revalidate();
		frame.repaint();

		boardPanel.setFocusable(true);

		boardPanel.requestFocusInWindow();
		boardPanel.requestFocus();


	}
}
