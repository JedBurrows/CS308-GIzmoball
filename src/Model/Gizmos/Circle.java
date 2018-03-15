package Model.Gizmos;


import java.awt.*;

public class Circle extends AbstractGizmo implements IGizmo {

	private static final double radius = 0.5;

	public Circle(String ID, int x, int y, Color color) {
		super(ID, x, y, 1, 1, color);
		createCircles();
	}

	@Override
	public void action(double tickTime) {

	}


	@Override
	public void createCircles() {
		circles.clear();
		circles.add(new physics.Circle(super.getxPos() + 0.5, super.getyPos() + 0.5, radius));

	}

	@Override
	public void createLines() {

	}


	@Override
	public void setKeyPress() {

	}

	@Override
	public double getAngVel() {
		return 0;
	}

	@Override
	public boolean getMoving() {
		return false;
	}

}
