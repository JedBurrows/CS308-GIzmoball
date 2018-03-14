package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyEvents extends KeyAdapter {

    public void keyPressed(KeyEvent e){
        int keys = e.getKeyCode();
        int clicked;
        if(keys == KeyEvent.VK_A){
            clicked = keys;
        }
        if(keys==KeyEvent.VK_B){
            clicked = keys;
        }
        
    }
}
