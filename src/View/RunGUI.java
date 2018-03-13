package View;


import Controller.KeyPressListener;
import Controller.MagicKeyListener;
import Controller.ModeListener;
import Controller.RunListener;
import Model.IBoard;
import javax.swing.*;
import java.awt.*;

public class RunGUI {

    private JPanel runFrame;
    private BoardPanel boardPanel;
    private IBoard board;
    private RunListener runListener;

    public RunGUI(GBallFrame parent, IBoard b) {
        board = b;
        setBoardPanel(new BoardPanel(board));

        runFrame = new JPanel();


        JPanel panel = new JPanel();
        panel.add(initialiseButtons(parent));
        panel.add(getBoardPanel());
        runFrame.add(panel);
        runFrame.setVisible(true);


    }
    private JPanel initialiseButtons(GBallFrame parent) {
        runListener = new RunListener(board);
        JButton btnStart = new JButton("Start");
        btnStart.setPreferredSize(new Dimension(75, 75));
        btnStart.addActionListener(runListener);
        btnStart.addKeyListener(new MagicKeyListener(new KeyPressListener(board)));

        JButton btnStop = new JButton("Stop");
        btnStop.setPreferredSize(new Dimension(75, 75));
        btnStop.addActionListener(runListener);

        JButton btnTick = new JButton("Tick");
        btnTick.setPreferredSize(new Dimension(75, 75));
        btnTick.addActionListener(runListener);


        JButton btnBuildMode = new JButton("Build");
        btnBuildMode.setPreferredSize(new Dimension(75, 75));


        btnBuildMode.addActionListener(new ModeListener(parent, board));

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
