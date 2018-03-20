package Model.Gizmos;

import Model.Ball;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;

public class Square extends AbstractGizmo implements IGizmo {

	//Todo remove then use width and height instead

	public Square(String id, int x, int y, Color colour) {
		super(id, x, y, 1, 1, colour);
		createCircles();
		createLines();
	}


	@Override
	public void createLines() {
		lineSegments.clear();
		lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + width, pos1.y));
		lineSegments.add(new LineSegment(pos1.x + width, pos1.y, pos1.x + width, pos1.y + width));
		lineSegments.add(new LineSegment(pos1.x + width, pos1.y + width, pos1.x, pos1.y + width));
		lineSegments.add(new LineSegment(pos1.x, pos1.y + width, pos1.x, pos1.y));
	}

	@Override
	public void createCircles() {
		circles.clear();
		circles.add(new Circle(pos1.x, pos1.y, 0));
		circles.add(new Circle(pos1.x + width, pos1.y, 0));
		circles.add(new Circle(pos1.x + width, pos1.y + width, 0));
		circles.add(new Circle(pos1.x, pos1.y + width, 0));
	}








}
