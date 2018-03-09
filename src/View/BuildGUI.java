package View;


import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import Model.IBoard;

public class BuildGUI{
	private JToggleButton btnGizmo;
	private JToggleButton btnColor;
	private JToggleButton btnBall;
	private JButton btnClear;
	private JToggleButton btnCon;
	private JToggleButton btnDisc;
	private JToggleButton btnKeyCon;
	private JToggleButton btnKeyDisc;
	private JButton btnRunMode;
	private JComboBox<String> boxGizmo;
	private String mode;
	private Container color;

	private JPanel buildFrame;
	private JPanel frictionPanel1, frictionPanel2, gravityPanel, panelBtn;
	private BoardPanel boardPanel;
	private IBoard board;



	public BuildGUI(GBallFrame parent, IBoard b) {

		buildFrame = new JPanel();

		board = b;

		boardPanel = new BoardPanel(board);
		createMenuBar();
		createGameBoard();
		initialiseButtons(parent);
		initialiseSliders();
		arrangeButtons();
		JPanel panel = new JPanel();
		panel.add(panelBtn);
		panel.add(boardPanel);
		buildFrame.add(panel);
		buildFrame.setVisible(true);

	}

	private void createMenuBar() {

	}

	private void createGameBoard() {

		boardPanel.setVisible(true);


	}

	private void initialiseButtons(GBallFrame parent) {
		btnGizmo = new JToggleButton("Add Gizmo");
		btnGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo = new JComboBox<>();


		btnColor=new JToggleButton("Choose a Colour");
		btnGizmo.setPreferredSize(new Dimension(150, 50));
		btnColor.addActionListener(new ColorChooserExample());

		boxGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo.addItem("Square");
		boxGizmo.addItem("Circle");
		boxGizmo.addItem("Triangle");
		boxGizmo.addItem("Left Flipper");
		boxGizmo.addItem("Right Flipper");
		boxGizmo.addItem("Absorber");

        boardPanel.addMouseListener(new GameBoardListener(boardPanel, board, boxGizmo,this));
		btnGizmo.addActionListener(new AddGizmoPressListener(this));
		//btnGizmo.addMouseListener(new MousePressListener(boxGizmo.getSelectedItem().toString(), this));
		//final MouseInputListener al = new AddAbsorberListener( model, view, messageBoard);
		btnBall = new JToggleButton("Add Ball");
		btnBall.setPreferredSize(new Dimension(150, 50));
		btnBall.addActionListener(new AddBallPressListener(this));

		btnClear = new JButton("Clear Board");
		btnClear.setPreferredSize(new Dimension(150, 50));
		btnClear.addActionListener(new ClearBoardPressListener(board, boardPanel));

		btnCon = new JToggleButton("Connect");
		btnCon.setPreferredSize(new Dimension(150, 50));

		btnDisc = new JToggleButton("Disconnect");
		btnDisc.setPreferredSize(new Dimension(150, 50));

		btnKeyCon = new JToggleButton("Key Connect");
		btnKeyCon.setPreferredSize(new Dimension(150, 50));

		btnKeyDisc = new JToggleButton("Key Disconnect");
		btnKeyDisc.setPreferredSize(new Dimension(150, 50));


		btnRunMode = new JButton("Run");
		btnRunMode.setPreferredSize(new Dimension(150, 50));
		btnRunMode.addActionListener(new ModeListener(parent, board));
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

		panelBtn.add(btnColor,c2);
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


	public JPanel getFrame() {
		return buildFrame;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void close(){
		buildFrame.setVisible(false);
	}

	public void open(){
		buildFrame.setVisible(true);
	}

	public String getMode() {
		System.out.println("mode: " + mode);
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
		clearSelected();

		switch (this.mode){
			case "AddGizmo":
				btnGizmo.setSelected(true);
				break;
			case "AddBall":
				btnBall.setSelected(true);
		}


	}

	private void clearSelected() {

		btnGizmo.setSelected(false);
		btnColor.setSelected(false);
		btnBall.setSelected(false);
		btnCon.setSelected(false);
		btnDisc.setSelected(false);
		btnKeyCon.setSelected(false);
		btnKeyDisc.setSelected(false);

	}




    /*@Override
	public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Run")) {
            IModeGUI run = new RunGUI();

    }*/

}

