package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {

    private JFrame frame, buildFrame, runFrame;
    private JPanel p,p1, GizmoBoard, panelBtn;
    private JButton btnBuild, btnRun, btnGizmo, btnBall, btnAbsorb, btnLFlipper, btnRFlipper, btnRotate,
            btnDel, btnMove, btnClear, btnCon, btnDisc, btnKeyCon, btnKeyDisc, btnRunMode;
    private JMenuBar menuBuild;
    private JMenu menuFile;
    private JMenuItem menuItem;
    private JComboBox boxGizmo;


    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        frame = new JFrame("GIZMOBALL!");
        frame.setLayout(new GridLayout(1,2));

        p=new JPanel(new FlowLayout());
        p1 = new JPanel(new FlowLayout());

        btnBuild = new JButton("Build Mode");
        btnBuild.addActionListener(this);

        btnRun = new JButton("Run Mode");
        btnRun.addActionListener(this);

        p.add(btnBuild);
        p1.add(btnRun);

        frame.add(p);
        frame.add(p1);
        frame.setSize(350,80);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String arg = e.getActionCommand();
        if(arg.equals("Build Mode")){
            JOptionPane.showMessageDialog(null,"Going to Build Mode...");
            //buildGUI();
            frame.setVisible(false);
            frame.dispose();
            IModeGUI build = new BuildGUI();


        }
        else if(arg.equals("Run Mode")){
            JOptionPane.showMessageDialog(null,"Going to Run Mode...");
        }
    }

    /*public void buildGUI(){
        buildFrame = new JFrame("Build Mode!");
        buildFrame.setLayout(new GridLayout(1,2));


        panelBtn = new JPanel(new GridLayout(10,2));
        panelBtn.setSize(150,800);
        GizmoBoard = new JPanel(new GridLayout(20,20));

        menuBuild = new JMenuBar();
        menuFile = new JMenu("File");
        menuBuild.add(menuFile);
        menuItem = new JMenuItem("Load");
        menuBuild.add(menuItem);



        btnGizmo = new JButton("Gizmo");
        btnGizmo.addActionListener(this);
        boxGizmo = new JComboBox();
        btnBall = new JButton("Add Ball");
        btnBall.addActionListener(this);
        ////text field for ball////
        btnAbsorb = new JButton("Add Absorber");
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
        btnMove.addActionListener(this);
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
        panelBtn.add(btnAbsorb);
        panelBtn.add(btnLFlipper);
        panelBtn.add(btnRFlipper);
        panelBtn.add(btnRotate);
        panelBtn.add(btnDel);
        panelBtn.add(btnMove);
        panelBtn.add(btnClear);
        panelBtn.add(btnCon);
        panelBtn.add(btnDisc);
        panelBtn.add(btnKeyCon);
        panelBtn.add(btnKeyDisc);
        panelBtn.add(btnRunMode);

        buildFrame.add(menuBuild);
        buildFrame.add(panelBtn);
        buildFrame.add(GizmoBoard);
        buildFrame.setSize(800,800);
        buildFrame.setResizable(false);
        buildFrame.setLocationRelativeTo(null);
        buildFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildFrame.setVisible(true);

    }*/
}

