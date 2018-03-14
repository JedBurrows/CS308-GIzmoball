package Controller;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public interface GBallListener extends ActionListener,KeyListener,MouseListener {
	void setMouseListener(MouseInputListener mouseInputListener);

	void setKeyBoardListener(KeyListener keyListener);

}
