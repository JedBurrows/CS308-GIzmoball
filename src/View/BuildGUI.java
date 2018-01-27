package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class BuildGUI implements IModeGUI,ActionListener {
    private JButton  btnGizmo, btnBall, btnAbsorb, btnLFlipper, btnRFlipper, btnRotate,
            btnDel, btnMove, btnClear, btnCon, btnDisc, btnKeyCon, btnKeyDisc, btnRunMode;


    public BuildGUI() {

        JFrame buildFrame = new JFrame("Build Mode!");
        buildFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        panelBtn.setSize(150,400);
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
        btnBall.addActionListener(this);
        ////text field for ball////
        /*btnAbsorb = new JButton("Add Absorber");
        btnAbsorb.addActionListener(this);
        btnLFlipper = new JButton("Add Left Flipper");
        btnLFlipper.addActionListener(this);
        btnRFlipper = new JButton("Add Right Flipper");
        btnRFlipper.addActionListener(this);
        btnRotate = new JButton("Rotate");
        btnRotate.addActionListener(this);
        btnDel = new JButton("Delete");
        btnDel.addActionListener(this);
        btnMove = new JButton("Move");
        btnMove.addActionListener(this);*/
        btnClear = new JButton("Clear Board");
        btnClear.addActionListener(this);
        ///Sliders for Friction and Gravity///
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


        panelBtn.add(btnGizmo);
        panelBtn.add(boxGizmo);
        panelBtn.add(btnBall);
       /* panelBtn.add(btnAbsorb);
        panelBtn.add(btnLFlipper);
        panelBtn.add(btnRFlipper);
        panelBtn.add(btnRotate);
        panelBtn.add(btnDel);
        panelBtn.add(btnMove);*/
        panelBtn.add(btnClear);
        panelBtn.add(btnCon);
        panelBtn.add(btnDisc);
        panelBtn.add(btnKeyCon);
        panelBtn.add(btnKeyDisc);
        panelBtn.add(btnRunMode);


        buildFrame.add(menuBar);
        JPanel panel = new JPanel();
        //panel.setPreferredSize(new Dimension(800, 800));
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
