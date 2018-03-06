package View;


import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import Model.Model;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class BuildGUI{
	private JButton btnGizmo, btnBall, btnClear, btnCon, btnDisc, btnKeyCon, btnKeyDisc, btnRunMode;
	private JComboBox<String> boxGizmo;


	private JFrame buildFrame;
	private JPanel frictionPanel1, frictionPanel2, gravityPanel, panelBtn, gizmoBoard;
	private Board board;
	private BoardPanel boardPanel;
	private Model model;




	public BuildGUI(Model m) {

		buildFrame = new JFrame("Build Mode!");
		buildFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		model = m;


		board = new Board(20,20, model);
//		boardPanel = new BoardPanel();
		createMenuBar();
		createGameBoard();
		initialiseButtons();
		initialiseSliders();
		arrangeButtons();
		JPanel panel = new JPanel();
		panel.add(panelBtn);
		panel.add(gizmoBoard);
		buildFrame.add(panel);
		buildFrame.pack();
		buildFrame.setResizable(false);
		buildFrame.setLocationRelativeTo(null);
		buildFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildFrame.setVisible(true);

	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		buildFrame.setJMenuBar(menuBar);
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
		buildFrame.add(menuBar);
	}

	private void createGameBoard() {

		gizmoBoard = new JPanel(new GridLayout(20, 20));
//        gizmoBoard.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		for (int i = 0; i < (20 * 20); i++) {
			final JLabel label = new JLabel();
			label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			gizmoBoard.add(label);
		}


		gizmoBoard.setPreferredSize(new Dimension(600, 600));
		gizmoBoard.setBackground(Color.black);
		gizmoBoard.setVisible(true);
//        gizmoBoard.addMouseListener(new GameBoardListener(this));
//		gizmoBoard.addKeyListener(new KeyPressListener());

	}

	private void initialiseButtons() {
		btnGizmo = new JButton("Add Gizmo");
		btnGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo = new JComboBox<>();
		boxGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo.addItem("Square");
		boxGizmo.addItem("ComponentCircle");
		boxGizmo.addItem("Triangle");
		boxGizmo.addItem("Left Flipper");
		boxGizmo.addItem("Right Flipper");
		boxGizmo.addItem("Absorber");
		//btnGizmo.addMouseListener(new MousePressListener(boxGizmo.getSelectedItem().toString(), this));
		//final MouseInputListener al = new AddAbsorberListener( model, view, messageBoard);
		btnBall = new JButton("Add Ball");
		btnBall.setPreferredSize(new Dimension(150, 50));
		//btnBall.addMouseListener(new MousePressListener(MousePressListener.Type.ADD_BALL, this));;
		////text field for ball////


		btnClear = new JButton("Clear Board");
		btnClear.setPreferredSize(new Dimension(150, 50));

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
		btnRunMode.addActionListener(new ModeListener(model, this, null));
	}

	private void initialiseSliders() {
		JSlider frictionSlider1 = new JSlider();
		frictionSlider1.addChangeListener(new SliderChangeListener());
		JLabel frictionLabel1 = new JLabel("Friction");
		frictionPanel1 = new JPanel();
		frictionPanel1.setLayout(new GridLayout(1, 2));
		frictionPanel1.add(frictionSlider1);
		frictionPanel1.add(frictionLabel1, 0);

		JSlider frictionSlider2 = new JSlider();
		frictionSlider2.addChangeListener(new SliderChangeListener());
		JLabel frictionLabel2 = new JLabel("Friction");
		frictionPanel2 = new JPanel();
		frictionPanel2.setLayout(new GridLayout(1, 2));
		frictionPanel2.add(frictionSlider2);
		frictionPanel2.add(frictionLabel2, 0);

		JSlider gravitySlider = new JSlider();
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

		panelBtn.add(btnGizmo, c1);
		panelBtn.add(boxGizmo, c2);
		panelBtn.add(btnBall, c1);
		panelBtn.add(btnClear, c2);
		panelBtn.add(btnCon, c1);
		panelBtn.add(btnDisc, c2);
		panelBtn.add(btnKeyCon, c1);
		panelBtn.add(btnKeyDisc, c2);

		panelBtn.add(frictionPanel2, c2);
		panelBtn.add(gravityPanel, c2);
		panelBtn.add(frictionPanel1, c2);
		panelBtn.add(btnRunMode, c2);

	}


	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		if (arg.equals("Add Ball")) {
			//Ball paintComponent = new Ball();
		}


	}


	public JFrame getFrame() {
		return buildFrame;
	}

	public void close(){
		buildFrame.setVisible(false);
		buildFrame.dispose();
	}


    /*@Override
	public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Run")) {
            IModeGUI run = new RunGUI();

    }*/

}

