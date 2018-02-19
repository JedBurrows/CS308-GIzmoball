package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressListener implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        if(key == KeyEvent.VK_ENTER){
            System.out.println("hello");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

