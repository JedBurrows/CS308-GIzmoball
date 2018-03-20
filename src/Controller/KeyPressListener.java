package Controller;

import Model.Exceptions.NoSuchGizmoException;
import Model.IBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;

public class KeyPressListener implements KeyListener {
	private HashMap<Integer, List<String>> keyPressEvents;
	private HashMap<Integer, List<String>> keyReleaseEvents;

	private IBoard board;


	public KeyPressListener(IBoard b) {
		board = b;
		keyPressEvents = b.getKeyPressEvents();
		keyReleaseEvents = b.getKeyReleaseEvents();
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	//TODO Dup code, cleanup?
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyPressEvents.containsKey(keyCode)) {
			List<String> list = keyPressEvents.get(keyCode);
			for (String id : list) {
				try {
					board.getGizmoByID(id).setTrigger();
				} catch (NoSuchGizmoException ex) {


				}
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyReleaseEvents.containsKey(keyCode)) {

			List<String> list = keyReleaseEvents.get(keyCode);

			for (String id : list) {
				try {
					board.getGizmoByID(id).setTrigger();
				} catch (NoSuchGizmoException ex) {

				}
			}
		}


	}


}

