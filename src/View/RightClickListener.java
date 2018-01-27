package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RightClickListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        RightClickMenu gizmoMenu = new RightClickMenu();
        gizmoMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
