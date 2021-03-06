package Model.Gizmos;

import Model.Ball;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;

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
	public double getAngVel() {
		return 0;
	}

	@Override
	public boolean getMoving() {
		return false;
	}

	@Override
	public void action(double d, Ball ball){
		if (ball.getXPos() == pos2.x - 0.5 && ball.getYPos() == pos2.y - 0.25) {
			if (trigger) {
				ball.setXPos((float) (pos2.x - 0.5));
				ball.setYPos((float) (pos1.y - 0.26));
				ball.setVelo(new Vect(0, -50));
			}
		}
	}

	public void createCircles() {
		circles.clear();
		circles.add(new Circle(pos1.x, pos1.y, 0));
		circles.add(new Circle(pos2.x, pos1.y, 0));
		circles.add(new Circle(pos2.x, pos2.y, 0));
		circles.add(new Circle(pos1.x, pos1.y, 0));
	}
}
