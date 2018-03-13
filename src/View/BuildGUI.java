package View;


import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

import Model.IBoard;

public class BuildGUI{
	private JToggleButton btnGizmo, btnBall, btnDelete, btnRotate, btnCon, btnDisc, btnKeyCon, btnKeyDisc;
	private JButton btnRunMode, btnColor, btnClear;
	private JComboBox<String> boxGizmo;
	private String mode;
	private Container color;

	private JPanel buildFrame;
	private JPanel frictionPanel1, frictionPanel2, gravityPanel, panelBtn;
	private BoardPanel boardPanel;



	public BuildGUI(GBallFrame parent, BoardPanel boardPanel) {

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
		btnGizmo = new JToggleButton("Add Gizmo");
		btnGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo = new JComboBox<>();


		btnColor=new JButton("Choose a Colour");
		btnGizmo.setPreferredSize(new Dimension(150, 50));
		btnColor.addActionListener(new ColorChooserExample());

		boxGizmo.setPreferredSize(new Dimension(150, 50));
		boxGizmo.addItem("Square");
		boxGizmo.addItem("Circle");
		boxGizmo.addItem("Triangle");
		boxGizmo.addItem("LeftFlipper");
		boxGizmo.addItem("RightFlipper");
		boxGizmo.addItem("Absorber");

        getBoardPanel().addMouseListener(new GameBoardListener(getBoardPanel(), boxGizmo,this));
		btnGizmo.addActionListener(new AddGizmoPressListener(this));
		//btnGizmo.addMouseListener(new MousePressListener(boxGizmo.getSelectedItem().toString(), this));
		//final MouseInputListener al = new AddAbsorberListener( model, view, messageBoard);
		btnBall = new JToggleButton("Add Ball");
		btnBall.setPreferredSize(new Dimension(150, 50));
		btnBall.addActionListener(new AddBallPressListener(this));

		btnRotate = new JToggleButton("Rotate");
		btnRotate.setPreferredSize(new Dimension(150, 50));

		btnClear = new JButton("Clear Board");
		btnClear.setPreferredSize(new Dimension(150, 50));
		btnClear.addActionListener(new ClearBoardPressListener(getBoardPanel()));

		btnDelete= new JToggleButton("Delete");
		btnDelete.setPreferredSize(new Dimension(150, 50));
		btnDelete.addActionListener(new DeletePressListener(this));

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
		btnRunMode.addActionListener(new ModeListener(parent, boardPanel));
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
		Hashtable<Integer,JLabel> table = new Hashtable<>();
		table.put(0,new JLabel("0 L/sec\u00b2"));
		table.put(25,new JLabel("25 L/sec\u00b2"));
		table.put(50,new JLabel("50 L/sec\u00b2"));
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
		slidersPanel.add(frictionPanel1 );
		slidersPanel.add(frictionPanel2 );
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
		panelBtn.add(btnDelete, c1);
		panelBtn.add(btnRotate, c2);
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
				break;
			case "Delete":
				btnDelete.setSelected(true);
				break;
		}


	}

	private void clearSelected() {

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


}

