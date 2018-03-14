package View;


import Controller.KeyPressListener;
import Controller.MagicKeyListener;
import Controller.RunModeListener;

import javax.swing.*;
import java.awt.*;

public class RunGUI {

    private JPanel runFrame;
    private BoardPanel boardPanel;
    private RunModeListener runModeListener;

    public RunGUI(GBallFrame parent, BoardPanel boardPanel) {
        setBoardPanel(boardPanel);

        runModeListener = new RunModeListener(parent);

        runFrame = new JPanel();


        JPanel panel = new JPanel();
        panel.add(initialiseButtons());
        panel.add(getBoardPanel());
        runFrame.add(panel);
        runFrame.setVisible(true);


    }
    private JPanel initialiseButtons() {
        JButton btnStart = new JButton("Start");
        btnStart.setPreferredSize(new Dimension(75, 75));
        btnStart.addActionListener(runModeListener);
        btnStart.setActionCommand("Start");
        btnStart.addKeyListener(new MagicKeyListener(new KeyPressListener(boardPanel.getBoard())));

        JButton btnStop = new JButton("Stop");
        btnStop.setPreferredSize(new Dimension(75, 75));
        btnStop.addActionListener(runModeListener);
        btnStop.setActionCommand("Stop");

        JButton btnTick = new JButton("Tick");
        btnTick.setPreferredSize(new Dimension(75, 75));
        btnTick.addActionListener(runModeListener);
        btnTick.setActionCommand("Tick");


        JButton btnBuildMode = new JButton("Build");
        btnBuildMode.setPreferredSize(new Dimension(75, 75));
        btnBuildMode.setActionCommand("Build");


        btnBuildMode.addActionListener(runModeListener);

        JPanel panelBtn = new JPanel();
        panelBtn.setSize(150, 300);
        panelBtn.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 0;

        panelBtn.add(btnStart, c);
        panelBtn.add(btnStop, c);
        panelBtn.add(btnTick, c);
        panelBtn.add(btnBuildMode, c);

        return panelBtn;


    }


        public JPanel getFrame() {
        return runFrame;
    }


    public void close() {
        runFrame.setVisible(false);
    }

    public void open(){
        runFrame.setVisible(true);

    }


    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
}
