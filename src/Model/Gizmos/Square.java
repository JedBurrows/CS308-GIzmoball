package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;

public class Square extends AbstractGizmo implements IGizmo {

	//Todo remove then use width and height instead
	private static final int size = 1;

	public Square(String id, int x, int y, Color colour) {
		super(id, x, y, 1, 1, colour);
		createCircles();
		createLines();
	}

	@Override
	public void action(double tickTime) {

	}


	@Override
	public void createLines() {
		lineSegments.clear();
		lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + size, pos1.y));
		lineSegments.add(new LineSegment(pos1.x + size, pos1.y, pos1.x + size, pos1.y + size));
		lineSegments.add(new LineSegment(pos1.x + size, pos1.y + size, pos1.x, pos1.y + size));
		lineSegments.add(new LineSegment(pos1.x, pos1.y + size, pos1.x, pos1.y));

	}

	@Override
	public void createCircles() {
		circles.clear();
		circles.add(new Circle(pos1.x, pos1.y, 0));
		circles.add(new Circle(pos1.x + size, pos1.y, 0));
		circles.add(new Circle(pos1.x + size, pos1.y + size, 0));
		circles.add(new Circle(pos1.x, pos1.y + size, 0));
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
