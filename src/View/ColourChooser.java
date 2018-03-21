package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColourChooser extends JFrame implements MouseListener {
	Color col;

	public ColourChooser() {
		Color initialcolor = Color.RED;
		JColorChooser jcc = new JColorChooser();
		Color color = jcc.showDialog(this, "Select a color", initialcolor);

		//Color color = JColorChooser.showDialog(this, "Select a color", initialcolor);
		if(color != null) {
			col = color;
		}
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
		if(color != null) {
			col = color;
		}
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
