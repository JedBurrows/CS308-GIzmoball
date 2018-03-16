package Controller;

import Model.Gizmos.IGizmo;
import Model.IBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeyPressListener implements KeyListener {
    private HashMap<Integer, List<String>> keyPressEvents;
    private HashMap<Integer, List<String>> keyReleaseEvents;

    private IBoard board;


    public KeyPressListener(IBoard b) {
        board = b;
        keyPressEvents = new HashMap<>();
        keyReleaseEvents = new HashMap<>();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //TODO Dup code, cleanup?
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
//		if (keyPressEvents.containsKey(keyCode)) {

//			List<String> list = keyPressEvents.get(keyCode);
        if (keyCode == KeyEvent.VK_LEFT) {
            for (IGizmo g : board.getGizmos()) {

                g.setKeyPress();

            }
//			}
        }
        if(keyCode == KeyEvent.VK_SPACE){
            if(board.getAbsorbCollide()){
                board.release();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            for (IGizmo g : board.getGizmos()) {
                g.setKeyPress();

            }
//			}
        }
//        if (keyReleaseEvents.containsKey(keyCode)) {

//            List<String> list = keyReleaseEvents.get(keyCode);

//            for (String id : list) {
//                try {
//                    board.getGizmoByID(id).setKeyPress();
//                } catch (NoSuchGizmoException ex) {
//
//                }
////            }
//        }

    }

    public boolean addKeyPressEvent(int event, String id) {
        if (keyPressEvents.containsKey(event)) {
            keyPressEvents.get(event).add(id);
        } else {
            List<String> list = new ArrayList<>();
            list.add(id);
            keyPressEvents.put(event, list);
        }
        return true;

    }

    public boolean addKeyReleaseEvent(int event, String id) {

        if (keyReleaseEvents.containsKey(event)) {
            keyReleaseEvents.get(event).add(id);

        } else {
            List<String> list = new ArrayList<>();
            list.add(id);
            keyReleaseEvents.put(event, list);
        }
        return true;

    }
}

