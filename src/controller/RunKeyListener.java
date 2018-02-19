package controller;

import model.LeftFlipper;
import model.Model;
import model.RightFlipper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RunKeyListener implements KeyListener {

    private Model model;

    public RunKeyListener(Model m) {
        model = m;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println("Got a key...");
        if (key == KeyEvent.VK_LEFT) {
            for (LeftFlipper lf : model.getLeftFlippers()) {
                lf.setkeyPress();
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            for (RightFlipper rf : model.getRightFlippers()) {
                rf.setkeyPress();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("Released a key...");

        if (key == KeyEvent.VK_LEFT) {
            for (LeftFlipper lf : model.getLeftFlippers()) {
                lf.setkeyPress();
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
            for (RightFlipper rf : model.getRightFlippers()) {
                rf.setkeyPress();
            }
        }
    }
}
