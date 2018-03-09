package Controller;

import View.BuildGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddGizmoPressListener implements ActionListener {

    BuildGUI gui;

    public AddGizmoPressListener(BuildGUI gui){
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.setMode("AddGizmo");
    }
}
