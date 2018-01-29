package View;

import Controller.RightClickListener;
import Controller.SliderChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class BuildGUI implements IModeGUI,ActionListener {
    private JButton  btnGizmo, btnBall, btnClear, btnCon, btnDisc, btnKeyCon, btnKeyDisc, btnRunMode;


    public BuildGUI() {

        JFrame buildFrame = new JFrame("Build Mode!");
        buildFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        buildFrame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem menuItemLoad = new JMenuItem("Load");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(menuItemLoad);
        fileMenu.add(exitMenuItem);


        JPanel panelBtn = new JPanel(new GridLayout(10, 2));
        panelBtn.setSize(150,300);
        panelBtn.setLocation(0,500);
        JPanel gizmoBoard = new JPanel(new GridLayout(20, 20));
        gizmoBoard.setPreferredSize(new Dimension(400,400));
        gizmoBoard.setBackground(Color.blue);
        gizmoBoard.setVisible(true);
        gizmoBoard.addMouseListener(new RightClickListener());



        btnGizmo = new JButton("Gizmo");
        btnGizmo.addActionListener(this);
        JComboBox<String> boxGizmo = new JComboBox<>();
        boxGizmo.addItem("Square");
        boxGizmo.addItem("Circle");
        boxGizmo.addItem("Triangle");
        boxGizmo.addItem("Left Flipper");
        boxGizmo.addItem("Right Flipper");
        boxGizmo.addItem("Absorber");

        btnBall = new JButton("Add Ball");
        btnBall.setPreferredSize(new Dimension(10, 10));
        btnBall.addActionListener(this);
        ////text field for ball////
        btnClear = new JButton("Clear Board");
        btnClear.addActionListener(this);
        btnCon = new JButton("Connect");
        btnCon.addActionListener(this);
        btnDisc = new JButton("Disconnect");
        btnDisc.addActionListener(this);
        btnKeyCon = new JButton("Key Connect");
        btnKeyCon.addActionListener(this);
        btnKeyDisc = new JButton("Key Disconnect");
        btnKeyDisc.addActionListener(this);
        btnRunMode = new JButton("Run");
        btnRunMode.addActionListener(this);

        JSlider frictionSlider1 = new JSlider();
        frictionSlider1.addChangeListener(new SliderChangeListener());
        JLabel frictionLabel1 = new JLabel("Friction");
        JPanel frictionPanel1 = new JPanel();
        frictionPanel1.setLayout(new GridLayout(1,2));
        frictionPanel1.add(frictionSlider1);
        frictionPanel1.add(frictionLabel1,0);

        JSlider frictionSlider2 = new JSlider();
        frictionSlider2.addChangeListener(new SliderChangeListener());
        JLabel frictionLabel2 = new JLabel("Friction");
        JPanel frictionPanel2 = new JPanel();
        frictionPanel2.setLayout(new GridLayout(1,2));
        frictionPanel2.add(frictionSlider2);
        frictionPanel2.add(frictionLabel2,0);

        JSlider gravitySlider = new JSlider();
        gravitySlider.addChangeListener(new SliderChangeListener());
        JLabel gravityLabel = new JLabel("Gravity");
        JPanel gravityPanel = new JPanel();
        gravityPanel.setLayout(new GridLayout(1,2));
        gravityPanel.add(gravitySlider);
        gravityPanel.add(gravityLabel,0);

        JPanel slidersPanel = new JPanel();
        slidersPanel.setLayout(new GridLayout(3, 1));
        slidersPanel.add(frictionPanel1);
        slidersPanel.add(frictionPanel2);
        slidersPanel.add(gravityPanel);

        panelBtn.add(btnGizmo);
        panelBtn.add(boxGizmo);
        panelBtn.add(btnBall);
        panelBtn.add(btnClear);
        panelBtn.add(btnCon);
        panelBtn.add(btnDisc);
        panelBtn.add(btnKeyCon);
        panelBtn.add(btnKeyDisc);
        panelBtn.add(btnRunMode);
        panelBtn.add(frictionPanel1);
        panelBtn.add(frictionPanel2);
        panelBtn.add(gravityPanel);

        buildFrame.add(menuBar);
        

        buildFrame.add(menuBar);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
