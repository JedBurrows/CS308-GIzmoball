package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorChooserExample extends JFrame implements MouseListener {
	Color col;

	public ColorChooserExample() {
		Color initialcolor = Color.RED;
		Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
		col = color;
	}


	public Color getColorGiz() {
		return col;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Color initialcolor = Color.RED;
		Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
		col = color;
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
