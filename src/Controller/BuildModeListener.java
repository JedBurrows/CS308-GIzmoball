package Controller;

import View.BoardPanel;
import View.BuildGUI;
import View.ColourChooser;
import View.GBallFrame;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class BuildModeListener implements GBallListener {

    private KeyListener keyListener;
    private MouseInputListener mouseInputListener;
    private GBallFrame gBallFrame;
    private Color col;
    private ColourChooser colourChooser;
    String previousCommand;


    public BuildModeListener(GBallFrame gBallFrame) {
        this.gBallFrame = gBallFrame;
        previousCommand = null;
//        colourChooser = new ColourChooser();

    }

    @Override
    public void setMouseListener(MouseInputListener mouseInputListener) {
        BuildGUI buildGUI = gBallFrame.getBuildPanel();
        buildGUI.getBoardPanel().removeMouseListener(this.mouseInputListener);
        this.mouseInputListener = mouseInputListener;
        buildGUI.getBoardPanel().addMouseListener(this.mouseInputListener);


    }

    @Override
    public void setKeyBoardListener(KeyListener keyListener) {
        BuildGUI buildGUI = gBallFrame.getBuildPanel();
        buildGUI.getBoardPanel().removeKeyListener(this.keyListener);
        this.keyListener = keyListener;
        buildGUI.getBoardPanel().addKeyListener(this.keyListener);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Choose Colour")) {
            colourChooser = new ColourChooser();
            command = previousCommand;
        }
        previousCommand = command;
        switch (command) {
            case "Choose Colour":
                colourChooser = new ColourChooser();
            case "Add Gizmo":
                if (colourChooser.getColorGiz() != null)
                    this.setMouseListener(new AddGizmoPressListener(gBallFrame, colourChooser.getColorGiz()));
                else {
                    this.setMouseListener(new AddGizmoPressListener(gBallFrame, Color.RED));
                }
                this.setKeyBoardListener(null);

                break;
            case "Add Ball":
                this.setMouseListener(new AddBallPressListener(gBallFrame));
                this.setKeyBoardListener(null);
                break;
            case "Rotate":
                this.setMouseListener(new RotatePressListener(gBallFrame));
                this.setKeyBoardListener(null);
                break;
            case "Move":
                this.setMouseListener(new MovePressListener(gBallFrame));
                this.setKeyBoardListener(null);
                break;
            case "Clear Board":
                this.setKeyBoardListener(null);
                BoardPanel panel = gBallFrame.getBuildPanel().getBoardPanel();
                panel.getBoard().clearGizmos();
                panel.repaint();
                break;
            case "Delete":
                this.setMouseListener(new DeletePressListener(gBallFrame));
                this.setKeyBoardListener(null);
                break;
            case "Connect":
                this.setMouseListener(new ConnectPressListener(gBallFrame));
                this.setKeyBoardListener(null);
                break;
            case "Disconnect":
                this.setMouseListener(new DisconnectPressListener(gBallFrame));
                this.setKeyBoardListener(null);
                break;
            case "Key Connect":
                KeyConnectPressListener k = new KeyConnectPressListener(gBallFrame);
                this.setMouseListener(k);
                this.setKeyBoardListener(k);
                break;

            case "Key Disconnect":
                KeyDisconnectPressListener kd = new KeyDisconnectPressListener(gBallFrame);
                this.setMouseListener(kd);
                this.setKeyBoardListener(kd);

                break;
            case "Run":
                this.setKeyBoardListener(new MagicKeyListener(new KeyPressListener(gBallFrame.getBoardPanel().getBoard())));
                this.setMouseListener(null);

                gBallFrame.getBoardPanel().getBoard().switchMode();
                gBallFrame.runMode();
                break;


        };
    }

    private void setFocus(JPanel frame) {
        frame.setVisible(true);
        frame.setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
