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

}

