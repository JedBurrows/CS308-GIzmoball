package Controller;

import View.BoardPanel;
import View.ColorChooserExample;
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
    private ColorChooserExample colorChooserExample;
    String previousCommand;


    public BuildModeListener(GBallFrame gBallFrame) {
        this.gBallFrame = gBallFrame;
        previousCommand = null;
//        colorChooserExample = new ColorChooserExample();

    }

    @Override
    public void setMouseListener(MouseInputListener mouseInputListener) {
        gBallFrame.getBoardPanel().removeMouseListener(this.mouseInputListener);
        this.mouseInputListener = mouseInputListener;
        gBallFrame.getBoardPanel().addMouseListener(this.mouseInputListener);


    }

    @Override
    public void setKeyBoardListener(KeyListener keyListener) {
        gBallFrame.getBoardPanel().removeMouseListener(this.mouseInputListener);
        this.keyListener = keyListener;
        gBallFrame.getBoardPanel().addKeyListener(this.keyListener);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Choose Colour")){
            colorChooserExample = new ColorChooserExample();
            command = previousCommand;
        }
        previousCommand = command;

        switch (command) {

            case "Choose Colour":
//				this.setMouseListener(colorChooserExample);
                colorChooserExample = new ColorChooserExample();
//				Color initialcolor=Color.RED;
//				Color color = JColorChooser.showDialog(gBallFrame.getBuildPanel().getFrame(),"Select a color",initialcolor);
//				System.out.println("Color is"+ color);
//				col = color;

            case "Add Gizmo":
                if (colorChooserExample != null)
                    this.setMouseListener(new AddGizmoPressListener(gBallFrame, colorChooserExample.getColorGiz()));
                else
                    this.setMouseListener(new AddGizmoPressListener(gBallFrame, Color.RED));

                break;

            case "Add Ball":
                this.setMouseListener(new AddBallPressListener(gBallFrame));
                break;
            case "Rotate":
                this.setMouseListener(new RotatePressListener(gBallFrame));
                break;
            case "Move":
                this.setMouseListener(new MovePressListener(gBallFrame, colorChooserExample.getColorGiz()));
                break;
			case "Clear Board":
                BoardPanel panel = gBallFrame.getBoardPanel();
                panel.getBoard().clearGizmos();
				panel.repaint();
				break;
			case "Delete":
                this.setMouseListener(new DeletePressListener(gBallFrame));
                break;
			case "Connect":
                this.setMouseListener(new ConnectPressListener(gBallFrame));
                break;
			case "Disconnect":
                this.setMouseListener(new DisconnectPressListener(gBallFrame));

                break;
            case "Key Connect":
                System.out.println("here??");
                KeyConnectPressListener k = new KeyConnectPressListener(gBallFrame);
                MagicKeyListener m = new MagicKeyListener(k);
                this.setKeyBoardListener(m);
                break;

            case "Key Disconnect":

                break;
            case "Run":
                gBallFrame.getBoardPanel().getBoard().switchMode();
                gBallFrame.runMode();
                break;


        }

    }

    private void setFocus(JPanel frame){
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
