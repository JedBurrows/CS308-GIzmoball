package Controller;


import View.IModeGUI;
import View.RunGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class ButtonListener implements MouseListener {
    public enum Type {ADD_GIZMO, ADD_BALL, CLEAR_BOARD, CONNECT, DISCONNECT, KEY_CONNECT, KEY_DISCONNECT, RUN }
    private IModeGUI buildView;
    private Type button;
    String gizmoType= null;

    public ButtonListener(Type buttonClicked, String gizmoType, IModeGUI build) {
        button = buttonClicked;
        this.gizmoType= gizmoType;
        buildView = build;
    }

    public ButtonListener(Type buttonClicked, IModeGUI build){
        button = buttonClicked;
        buildView = build;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (button){
            case ADD_GIZMO:
                //add gizmo of type gizmoType
                break;
            case RUN:
                buildView.getFrame().setVisible(false);
                IModeGUI run = new RunGUI();
                break;

        }
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
