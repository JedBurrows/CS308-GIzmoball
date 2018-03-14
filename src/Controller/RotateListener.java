package Controller;

import View.BuildGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotateListener implements ActionListener {


    BuildGUI gui;

    public RotateListener(BuildGUI gui){
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.setMode("Rotate");
    }
}
