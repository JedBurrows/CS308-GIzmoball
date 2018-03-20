package Model.Gizmos;


import Model.Ball;

import java.awt.*;

public class Circle extends AbstractGizmo implements IGizmo {

	private static final double radius = 0.5;

	public Circle(String ID, int x, int y, Color color) {
		super(ID, x, y, 1, 1, color);
		createCircles();
	}

	@Override
	protected void createCircles() {
		circles.clear();
		circles.add(new physics.Circle(pos1.x + 0.5, pos1.y + 0.5, radius));
	}

	@Override
	public void createLines() {

	}

}
