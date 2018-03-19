package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;

public class Absorber extends AbstractGizmo implements IGizmo {

	public Absorber(String id, int x1, int y1, int x2, int y2, Color color) {
		super(id, x1, y1, x2 - x1, y2 - y1, color);


		createLines();
		createCircles();
	}


	public void createLines() {
		lineSegments.clear();
		lineSegments.add(new LineSegment(pos1.x, pos1.y, pos2.x, pos1.y));
		lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x, pos2.y));
		lineSegments.add(new LineSegment(pos2.x, pos1.y, pos2.x, pos2.y));
		lineSegments.add(new LineSegment(pos1.x, pos2.y, pos2.x, pos2.y));


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



	@Override
	public void action(double tickTime) {

	}

	public void createCircles() {
		circles.clear();
		circles.add(new Circle(pos1.x, pos1.y, 0));
		circles.add(new Circle(pos2.x, pos1.y, 0));
		circles.add(new Circle(pos2.x, pos2.y, 0));
		circles.add(new Circle(pos1.x, pos1.y, 0));
	}
}
