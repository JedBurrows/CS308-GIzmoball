package View;


import Controller.BuildModeListener;
import Controller.SliderChangeListener;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class BuildGUI {
	private JButton btnGizmo, btnBall, btnDelete, btnRotate,btnMove, btnCon, btnDisc, btnKeyCon, btnKeyDisc;
	private JButton btnRunMode, btnColor, btnClear;
	private JComboBox<String> boxGizmo;
	private String mode;


	private BuildModeListener buildModeListener;

	private JPanel buildFrame;
	private JPanel frictionPanel1, frictionPanel2, gravityPanel, panelBtn;
	private BoardPanel boardPanel;


	public BuildGUI(GBallFrame parent, BoardPanel boardPanel) {
		buildModeListener = new BuildModeListener(parent);

		buildFrame = new JPanel();
		setBoardPanel(boardPanel);
		createGameBoard();
		initialiseButtons(parent);
		initialiseSliders();
		arrangeButtons();
		JPanel panel = new JPanel();
		panel.add(panelBtn);
		panel.add(getBoardPanel());
		buildFrame.add(panel);
		buildFrame.setVisible(true);

	}

	private void createGameBoard() {

		getBoardPanel().setVisible(true);


	}

	private void initialiseButtons(GBallFrame parent) {
		boxGizmo = new JComboBox<>();


		btnColor = new JButton("Choose a Colour");
		btnColor.addActionListener(buildModeListener);
		btnColor.setActionCommand("Choose Colour");

		boxGizmo.setPreferredSize(new Dimension(150, 50));


		boxGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo.addItem("Square");
		boxGizmo.addItem("Circle");
		boxGizmo.addItem("Triangle");
		boxGizmo.addItem("LeftFlipper");
		boxGizmo.addItem("RightFlipper");
		boxGizmo.addItem("Absorber");

		btnGizmo = new JButton("Add Gizmo");
		btnGizmo.setPreferredSize(new Dimension(150, 50));

		btnColor = new JButton("Choose a Colour");
		btnColor.setPreferredSize(new Dimension(150, 50));

		btnBall = new JButton("Add Ball");
		btnBall.setPreferredSize(new Dimension(150, 50));

		btnRotate = new JButton("Rotate");
		btnRotate.setPreferredSize(new Dimension(150, 50));

		btnMove = new JButton("Move");
		btnMove.setPreferredSize(new Dimension(150,50));

		btnClear = new JButton("Clear Board");
		btnClear.setPreferredSize(new Dimension(150, 50));

		btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(150, 50));

		btnCon = new JButton("Connect");
		btnCon.setPreferredSize(new Dimension(150, 50));

		btnDisc = new JButton("Disconnect");
		btnDisc.setPreferredSize(new Dimension(150, 50));

		btnKeyCon = new JButton("Key Connect");
		btnKeyCon.setPreferredSize(new Dimension(150, 50));

		btnKeyDisc = new JButton("Key Disconnect");
		btnKeyDisc.setPreferredSize(new Dimension(150, 50));


		btnRunMode = new JButton("Run");
		btnRunMode.setPreferredSize(new Dimension(150, 50));

		btnGizmo.addActionListener(buildModeListener);
		btnGizmo.setActionCommand("Add Gizmo");

		btnColor.addActionListener(buildModeListener);
		btnColor.setActionCommand("Choose Colour");

		btnBall.addActionListener(buildModeListener);
		btnBall.setActionCommand("Add Ball");

		btnRotate.addActionListener(buildModeListener);
		btnRotate.setActionCommand("Rotate");

		btnMove.addActionListener(buildModeListener);
		btnMove.setActionCommand("Move");

		btnClear.addActionListener(buildModeListener);
		btnClear.setActionCommand("Clear Board");

		btnDelete.addActionListener(buildModeListener);
		btnDelete.setActionCommand("Delete");

		btnCon.addActionListener(buildModeListener);
		btnCon.setActionCommand("Connect");

		btnDisc.addActionListener(buildModeListener);
		btnDisc.setActionCommand("Disconnect");

		btnKeyCon.addActionListener(buildModeListener);
		btnKeyCon.setActionCommand("Key Connect");

		btnKeyDisc.addActionListener(buildModeListener);
		btnKeyDisc.setActionCommand("Key Disconnect");

		btnRunMode.addActionListener(buildModeListener);
		btnRunMode.setActionCommand("Run");
	}

	private void initialiseSliders() {
		JSlider frictionSlider1 = new JSlider();
		frictionSlider1.addChangeListener(new SliderChangeListener());
		JLabel frictionLabel1 = new JLabel("Friction mu");
		frictionPanel1 = new JPanel();
		frictionPanel1.setLayout(new GridLayout(1, 2));
		frictionPanel1.add(frictionSlider1);
		frictionPanel1.add(frictionLabel1, 0);

		JSlider frictionSlider2 = new JSlider();
		frictionSlider2.addChangeListener(new SliderChangeListener());
		JLabel frictionLabel2 = new JLabel("Friction mu\u2082");
		frictionPanel2 = new JPanel();
		frictionPanel2.setLayout(new GridLayout(1, 2));
		frictionPanel2.add(frictionSlider2);
		frictionPanel2.add(frictionLabel2, 0);

		JSlider gravitySlider = new JSlider();
		gravitySlider.setMinimum(0);
		gravitySlider.setMajorTickSpacing(25);
		gravitySlider.setPaintTicks(true);
		gravitySlider.setMaximum(50);
		gravitySlider.setValue(25);
		Hashtable<Integer, JLabel> table = new Hashtable<>();
		table.put(0, new JLabel("0 L/sec\u00b2"));
		table.put(25, new JLabel("25 L/sec\u00b2"));
		table.put(50, new JLabel("50 L/sec\u00b2"));
		gravitySlider.setLabelTable(table);
		gravitySlider.setPaintLabels(true);
		gravitySlider.addChangeListener(new SliderChangeListener());
		JLabel gravityLabel = new JLabel("Gravity");
		gravityPanel = new JPanel();
		gravityPanel.setLayout(new GridLayout(1, 2));
		gravityPanel.add(gravitySlider);
		gravityPanel.add(gravityLabel, 0);

		JPanel slidersPanel = new JPanel();
		slidersPanel.setLayout(new GridLayout(3, 1));
		slidersPanel.add(frictionPanel1);
		slidersPanel.add(frictionPanel2);
		slidersPanel.add(gravityPanel);

	}

	private void arrangeButtons() {

		panelBtn = new JPanel();
		panelBtn.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.insets = new Insets(5, 0, 5, 0);
		c1.gridwidth = 1;

		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = new Insets(5, 0, 5, 0);
		c2.gridwidth = 0;

		panelBtn.add(btnColor, c2);
		panelBtn.add(btnGizmo, c1);
		panelBtn.add(boxGizmo, c2);
		panelBtn.add(btnBall, c1);
		panelBtn.add(btnClear, c2);
		panelBtn.add(btnDelete, c1);
		panelBtn.add(btnRotate, c2);
		panelBtn.add(btnMove,c1);
		panelBtn.add(btnCon, c2);
		panelBtn.add(btnKeyCon, c1);
		panelBtn.add(btnDisc, c2);

		panelBtn.add(btnKeyDisc, c1);

		panelBtn.add(frictionPanel2, c2);
		panelBtn.add(gravityPanel, c2);
		panelBtn.add(frictionPanel1, c2);
		panelBtn.add(btnRunMode, c2);

	}


	public JPanel getFrame() {
		return buildFrame;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void close() {
		buildFrame.setVisible(false);
	}

	public void open() {
		buildFrame.setVisible(true);
	}

	public String getMode() {
		System.out.println("mode: " + mode);
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
		clearSelected();
		switch (this.mode) {
			case "AddGizmo":
				btnGizmo.setSelected(true);

				break;
			case "AddBall":
				btnBall.setSelected(true);
				break;
			case "Delete":
				btnDelete.setSelected(true);
				break;

			case "Move":
				btnRotate.setSelected(true);
				break;
		}


	}


	public void clearSelected() {

		btnGizmo.setSelected(false);
		btnBall.setSelected(false);
		btnCon.setSelected(false);
		btnDisc.setSelected(false);
		btnKeyCon.setSelected(false);
		btnKeyDisc.setSelected(false);
		btnDelete.setSelected(false);
		btnRotate.setSelected(false);

	}

	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	public JComboBox<String> getBoxGizmo() {
		return boxGizmo;
	}
	// public ColorChooserExample getColours(){
//	    return colourChoser;
//   }


    /*@Override
	public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Run")) {
            IModeGUI run = new RunGUI();

    }*/

}

