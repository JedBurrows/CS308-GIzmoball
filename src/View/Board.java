package View;

import Model.Ball;
import Model.Gizmos.IGizmo;
import Model.Model;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Board extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private MouseListener listener;
	protected int width;
	protected int height;
	protected Model gm;

	public Board(int w, int h, Model m) {
		// Observe changes in Model
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		gm.setL(width);
	}

	// Fix onscreen size
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		ArrayList<LineSegment> lines;
		ArrayList<Circle> circles;

		for (IGizmo gizmo : gm.getGizmos()) {
			lines = gizmo.getLines();
			circles = gizmo.getCircles();
			for (LineSegment l : lines) {
				Vect p1 = l.p1();
				Vect p2 = l.p2();
				g2.drawLine((int) (p1.x()), (int) (p1.y()), (int) (p2.x()), (int) (p2.y()));
			}
			for (Circle c : circles)
				g2.drawOval((int) (c.getCenter()).x(), (int) (c.getCenter().y()), (int) (c.getRadius()), (int) (c.getRadius()));

		}
//		for (ComponentCircle c : gm.getCircles()) {
//			int d = (int) (2*c.getRadius());
//			g2.fillOval(c.getX(), c.getY(), d, d);
//		}

		Ball b = gm.getBall();
		if (b != null) {
			g2.setColor(b.getColour());
			int x = (int) (b.getXPos() - b.getRadius());
			int y = (int) (b.getYPos() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

    public MouseListener getListener() {
        return listener;
    }

    public void setListener(MouseListener listener) {
        this.listener = listener;
    }
}
