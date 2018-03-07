package View;


import Controller.ModeListener;
import Controller.RunListener;
import Model.IBoard;
import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RunGUI {

    private JPanel runFrame;
    private BoardPanel boardPanel;
    private IBoard board;

    public RunGUI(IBoard b) {
        board = b;
        boardPanel = new BoardPanel(board);

        runFrame = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem menuItemLoad = new JMenuItem("Load");
        JMenuItem menuItemSave = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(menuItemLoad);
        fileMenu.add(menuItemSave);
        fileMenu.add(exitMenuItem);

        JButton btnStart = new JButton("Start");
        btnStart.setPreferredSize(new Dimension(75, 75));
        btnStart.addActionListener(new RunListener(board));

        JButton btnStop = new JButton("Stop");
        btnStop.setPreferredSize(new Dimension(75, 75));
        btnStop.addActionListener(new RunListener(board));


        JButton btnTick = new JButton("Tick");
        btnTick.setPreferredSize(new Dimension(75, 75));
        btnTick.addActionListener(new RunListener(board));


        JButton btnBuildMode = new JButton("Build");
        btnBuildMode.setPreferredSize(new Dimension(75, 75));


        btnBuildMode.addActionListener(new ModeListener(null, this, board));


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
        panel.add(boardPanel);
        runFrame.add(panel);
        runFrame.setVisible(true);


    }

    public JPanel getFrame() {
        return runFrame;
    }

    public void close() {
        runFrame.setVisible(false);
    }


}
