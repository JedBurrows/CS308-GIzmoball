package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class KeyConnectPressListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String keyP = JOptionPane.showInputDialog("Select Key to Connect");

	}

	public void keyPressed(KeyEvent e) {
		int keys = e.getKeyCode();
		int clicked;
		if (keys == KeyEvent.VK_A) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_B) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_C) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_D) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_E) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_F) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_G) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_H) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_I) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_J) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_K) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_L) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_M) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_N) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_O) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_P) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_Q) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_R) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_S) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_T) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_U) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_V) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_W) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_X) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_Y) {
			clicked = keys;
		}
		if (keys == KeyEvent.VK_Z) {
			clicked = keys;
		}

	}
}
