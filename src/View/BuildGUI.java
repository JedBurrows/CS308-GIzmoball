package View;


import Controller.BuildModeListener;
import Controller.LoadSaveController;
import Controller.SliderChangeListener;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class BuildGUI implements IGUI {
	private JButton btnGizmo, btnBall, btnDelete, btnRotate,btnMove, btnCon, btnDisc, btnKeyCon, btnKeyDisc;
	private JButton btnRunMode, btnColor, btnClear;
	private JComboBox<String> boxGizmo;


	private BuildModeListener buildModeListener;

	private JPanel frictionPanel1, frictionPanel2, gravityPanel, panelBtn;
	private BoardPanel boardPanel;
	private GBallFrame gBallFrame;
	private JSlider gravitySlider,frictionSlider1,frictionSlider2;


	public BuildGUI(GBallFrame parent, BoardPanel boardPanel) {
		buildModeListener = new BuildModeListener(parent);
		this.gBallFrame = parent;
		this.boardPanel = boardPanel;


	}


	@Override
	public JPanel createButtons() {

		btnColor = new JButton("Choose a Colour");
		btnColor.setPreferredSize(new Dimension(150, 50));
		btnColor.addActionListener(buildModeListener);
		btnColor.setActionCommand("Choose Colour");


		boxGizmo = new JComboBox<>();
		boxGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo.addItem("Square");
		boxGizmo.addItem("Circle");
		boxGizmo.addItem("Triangle");
		boxGizmo.addItem("LeftFlipper");
		boxGizmo.addItem("RightFlipper");
		boxGizmo.addItem("Absorber");

		btnGizmo = new JButton("Add Gizmo");
		btnGizmo.setPreferredSize(new Dimension(150, 50));
		btnGizmo.addActionListener(buildModeListener);
		btnGizmo.setActionCommand("Add Gizmo");

		btnBall = new JButton("Add Ball");
		btnBall.setPreferredSize(new Dimension(150, 50));
		btnBall.addActionListener(buildModeListener);
		btnBall.setActionCommand("Add Ball");

		btnRotate = new JButton("Rotate");
		btnRotate.setPreferredSize(new Dimension(150, 50));
		btnRotate.addActionListener(buildModeListener);
		btnRotate.setActionCommand("Rotate");

		btnMove = new JButton("Move");
		btnMove.setPreferredSize(new Dimension(150, 50));
		btnMove.addActionListener(buildModeListener);
		btnMove.setActionCommand("Move");


		btnClear = new JButton("Clear Board");
		btnClear.setPreferredSize(new Dimension(150, 50));
		btnClear.addActionListener(buildModeListener);
		btnClear.setActionCommand("Clear Board");

		btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(150, 50));
		btnDelete.addActionListener(buildModeListener);
		btnDelete.setActionCommand("Delete");

		btnCon = new JButton("Connect");
		btnCon.setPreferredSize(new Dimension(150, 50));
		btnCon.addActionListener(buildModeListener);
		btnCon.setActionCommand("Connect");

		btnDisc = new JButton("Disconnect");
		btnDisc.setPreferredSize(new Dimension(150, 50));
		btnDisc.addActionListener(buildModeListener);
		btnDisc.setActionCommand("Disconnect");

		btnKeyCon = new JButton("Key Connect");
		btnKeyCon.setPreferredSize(new Dimension(150, 50));
		btnKeyCon.addActionListener(buildModeListener);
		btnKeyCon.setActionCommand("Key Connect");

		btnKeyDisc = new JButton("Key Disconnect");
		btnKeyDisc.setPreferredSize(new Dimension(150, 50));
		btnKeyDisc.addActionListener(buildModeListener);
		btnKeyDisc.setActionCommand("Key Disconnect");


		btnRunMode = new JButton("Run");
		btnRunMode.setPreferredSize(new Dimension(150, 50));
		btnRunMode.addActionListener(buildModeListener);
		btnRunMode.setActionCommand("Run");

		frictionSlider1 = new JSlider();
		frictionSlider1.addChangeListener(new SliderChangeListener(gBallFrame));
		JLabel frictionLabel1 = new JLabel("Friction mu");
		frictionPanel1 = new JPanel();
		frictionPanel1.setLayout(new GridLayout(1, 2));
		frictionPanel1.add(frictionSlider1);
		frictionPanel1.add(frictionLabel1, 0);

		frictionSlider2 = new JSlider();
		frictionSlider2.addChangeListener(new SliderChangeListener(gBallFrame));
		JLabel frictionLabel2 = new JLabel("Friction mu\u2082");
		frictionPanel2 = new JPanel();
		frictionPanel2.setLayout(new GridLayout(1, 2));
		frictionPanel2.add(frictionSlider2);
		frictionPanel2.add(frictionLabel2, 0);

		gravitySlider = new JSlider();
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
		gravitySlider.addChangeListener(new SliderChangeListener(gBallFrame));
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

		panelBtn.add(btnRunMode, c2);

		GridBagConstraints c3 = new GridBagConstraints();
		c3.insets = new Insets(5, 0, 5, 0);
		c3.gridwidth = 0;

		panelBtn.add(gravityPanel, c3);
		panelBtn.add(frictionPanel1, c3);
		panelBtn.add(frictionPanel2, c3);


		return panelBtn;

	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}





	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	public JComboBox<String> getBoxGizmo() {
		return boxGizmo;
	}

    public int getGravity(){
    	return gravitySlider.getValue();
	}
	public int getMu(){
    	return frictionSlider1.getValue();
	}
	public int getMU2(){
		return frictionSlider2.getValue();
	}


	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem menuItemLoad = new JMenuItem("Load");
		menuItemLoad.addActionListener(new LoadSaveController(boardPanel));

		JMenuItem menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(new LoadSaveController(boardPanel));

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e -> System.exit(0));

		fileMenu.add(menuItemLoad);
		fileMenu.add(menuItemSave);
		fileMenu.add(exitMenuItem);

		return menuBar;
	}

}

