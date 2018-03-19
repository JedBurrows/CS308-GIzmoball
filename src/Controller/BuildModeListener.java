package Controller;

import View.BoardPanel;
import View.BuildGUI;
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
    private MouseListener mouseInputListener;
    private GBallFrame gBallFrame;
    private Color col;
    private ColorChooserExample colorChooserExample;


    public BuildModeListener(GBallFrame gBallFrame) {
        this.gBallFrame = gBallFrame;

//        colorChooserExample = new ColorChooserExample();

    }

    @Override
    public void setMouseListener(MouseListener mouseInputListener) {
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
        BuildGUI buildGUI = gBallFrame.getBuildPanel();
        setFocus(gBallFrame.getBuildPanel().getFrame());

        switch (e.getActionCommand()) {

            case "Add Gizmo":
                if (colorChooserExample != null)
                    this.setMouseListener(new AddGizmoPressListener(buildGUI, colorChooserExample.getColorGiz()));
                else
                    this.setMouseListener(new AddGizmoPressListener(buildGUI, Color.RED));

                break;
            case "Choose Colour":
//				this.setMouseListener(colorChooserExample);
                colorChooserExample = new ColorChooserExample();
//				Color initialcolor=Color.RED;
//				Color color = JColorChooser.showDialog(gBallFrame.getBuildPanel().getFrame(),"Select a color",initialcolor);
//				System.out.println("Color is"+ color);
//				col = color;

                break;
            case "Add Ball":
                this.setMouseListener(new AddBallPressListener(buildGUI));
                break;
            case "Rotate":
                this.setMouseListener(new RotatePressListener(buildGUI));

				break;
			case "Clear Board":
				BoardPanel panel = buildGUI.getBoardPanel();
				panel.getBoard().clearGizmos();
				panel.repaint();
				break;
			case "Delete":
				this.setMouseListener(new DeletePressListener(buildGUI));
				break;
			case "Connect":
				this.setMouseListener(new ConnectPressListener(buildGUI));
				break;
			case "Disconnect":
				this.setMouseListener(new DisconnectPressListener(buildGUI));

                break;
            case "Key Connect":
                System.out.println("here??");
                KeyConnectPressListener k = new KeyConnectPressListener(buildGUI);
                MagicKeyListener m = new MagicKeyListener(k);
//                this.setMouseListener(m);
                this.setKeyBoardListener(m);
                break;

            case "Key Disconnect":

                break;
            case "Run":
                gBallFrame.switchToRun();
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
