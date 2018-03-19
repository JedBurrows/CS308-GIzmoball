package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;

public class Triangle extends AbstractGizmo implements IGizmo {

	public Triangle(String id, int x, int y, Color colour) {
		super(id, x, y, 1, 1, colour);
		createLines();
		createCircles();
	}


	@Override
	public void createLines() {
		lineSegments.clear();
		if (rotation == 0) {
			lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + width, pos1.y));
			lineSegments.add(new LineSegment(pos1.x + width, pos1.y, pos1.x, pos1.y + height));
			lineSegments.add(new LineSegment(pos1.x, pos1.y + height, pos1.x, pos1.y));
		} else if (rotation == 1) {
			lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + width, pos1.y));
			lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + width, pos1.y + height));
			lineSegments.add(new LineSegment(pos1.x + width, pos1.y, pos1.x + width, pos1.y + height));
		} else if (rotation == 2) {
			lineSegments.add(new LineSegment(pos1.x + width, pos1.y, pos1.x, pos1.y + height));
			lineSegments.add(new LineSegment(pos1.x + width, pos1.y, pos1.x + width, pos1.y + height));
			lineSegments.add(new LineSegment(pos1.x, pos1.y + height, pos1.x + width, pos1.y + height));
		} else if (rotation == 3) {
			lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x, pos1.y + height));
			lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + width, pos1.y + height));
			lineSegments.add(new LineSegment(pos1.x, pos1.y + height, pos1.x + width, pos1.y + height));
		}
	}

	@Override
	public void createCircles() {
		circles.clear();
		if (rotation == 0) {
			circles.add(new Circle(pos1.x, pos1.y, 0));
			circles.add(new Circle(pos1.x + width, pos1.y, 0));
			circles.add(new Circle(pos1.x, pos1.y + height, 0));
		} else if (rotation == 1) {
			circles.add(new Circle(pos1.x, pos1.y, 0));
			circles.add(new Circle(pos1.x + width, pos1.y, 0));
			circles.add(new Circle(pos1.x + width, pos1.y + height, 0));
		} else if (rotation == 2) {
			circles.add(new Circle(pos1.x, pos1.y + width, 0));
			circles.add(new Circle(pos1.x + width, pos1.y, 0));
			circles.add(new Circle(pos1.x + width, pos1.y + height, 0));
		} else if (rotation == 3) {
			circles.add(new Circle(pos1.x, pos1.y, 0));
			circles.add(new Circle(pos1.x, pos1.y + height, 0));
			circles.add(new Circle(pos1.x + width, pos1.y + height, 0));
		}
	}
}
