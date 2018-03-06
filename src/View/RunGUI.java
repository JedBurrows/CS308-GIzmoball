package View;


import Controller.ModeListener;
import Controller.RunListener;
import Model.Model;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RunGUI {

    JFrame runFrame;
    private Model model;
    private Board board;

    public RunGUI(Model m) {
        model = m;
        runFrame = new JFrame("Run Mode!");
        runFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board = new Board(500, 500, model);
        JMenuBar menuBar = new JMenuBar();
        runFrame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem menuItemLoad = new JMenuItem("Load");
        JMenuItem menuItemSave = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(menuItemLoad);
        fileMenu.add(menuItemSave);
        fileMenu.add(exitMenuItem);

        //runFrame.add(menuBar);
        board.setPreferredSize(new Dimension(600, 600));

        board.setVisible(true);
//        JPanel gizmoBoard = new JPanel(new GridLayout(20, 20));
//        gizmoBoard.setPreferredSize(new Dimension(600, 600));
//        gizmoBoard.setBackground(Color.GREEN);
//        gizmoBoard.setVisible(true);

        JButton btnStart = new JButton("Start");
        btnStart.setPreferredSize(new Dimension(75, 75));
        btnStart.addActionListener(new RunListener(model));

        JButton btnStop = new JButton("Stop");
        btnStop.setPreferredSize(new Dimension(75, 75));
        btnStop.addActionListener(new RunListener(model));


        JButton btnTick = new JButton("Tick");
        btnTick.setPreferredSize(new Dimension(75, 75));
        btnTick.addActionListener(new RunListener(model));


        JButton btnBuildMode = new JButton("Build");
        btnBuildMode.setPreferredSize(new Dimension(75, 75));


        btnBuildMode.addActionListener(new ModeListener(model, null, this));


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


        runFrame.add(menuBar);
        JPanel panel = new JPanel();
        panel.add(panelBtn);
        panel.add(board);
        runFrame.add(panel);
        runFrame.pack();
        runFrame.setResizable(false);
        runFrame.setLocationRelativeTo(null);
        runFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        runFrame.setVisible(true);


    }

    public JFrame getFrame() {
        return runFrame;
    }

    public void close() {
        runFrame.setVisible(false);
        runFrame.dispose();
    }


}
