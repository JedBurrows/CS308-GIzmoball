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
		lineSegments.add(new LineSegment(xPos, yPos, xPos + size, yPos));
		lineSegments.add(new LineSegment(xPos + size, yPos, xPos + size, yPos + size));
		lineSegments.add(new LineSegment(xPos + size, yPos + size, xPos, yPos + size));
		lineSegments.add(new LineSegment(xPos, yPos + size, xPos, yPos));

	}

	@Override
	public void createCircles() {
		circles.clear();
		circles.add(new Circle(xPos, yPos, 0));
		circles.add(new Circle(xPos + size, yPos, 0));
		circles.add(new Circle(xPos + size, yPos + size, 0));
		circles.add(new Circle(xPos, yPos + size, 0));
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
