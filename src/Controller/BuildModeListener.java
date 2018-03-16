package Controller;

import View.BoardPanel;
import View.BuildGUI;
import View.ColorChooserExample;
import View.GBallFrame;

import java.awt.*;
import java.awt.event.*;

public class BuildModeListener implements GBallListener {

    private KeyListener keyListener;
    private MouseListener mouseInputListener;
    private  GBallFrame gBallFrame;
    private Color col;
    private ColorChooserExample colorChooserExample;


    public BuildModeListener(GBallFrame gBallFrame){
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

        switch(e.getActionCommand()){

            case "Add Gizmo":
                if(colorChooserExample!=null)
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
            case "Key Connect" :

                break;

            case "Key Disconnect":

                break;
            case  "Run":
                gBallFrame.switchToRun();
                break;


        }

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
}
