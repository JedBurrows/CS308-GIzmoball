package Controller;

import View.BuildGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBallPressListener implements ActionListener {

    BuildGUI gui;

    public AddBallPressListener(BuildGUI gui){
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.setMode("AddBall");
        System.out.println(gui.getMode());
    }
}

