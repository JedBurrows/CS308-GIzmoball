package Controller;

import View.BuildGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePressListener implements ActionListener {
    BuildGUI gui;

    public DeletePressListener(BuildGUI gui){
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.setMode("Delete");
    }
}
