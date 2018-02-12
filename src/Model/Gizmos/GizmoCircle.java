package Model.Gizmos;


import physics.LineSegment;
import physics.Circle;

import java.util.ArrayList;

public class GizmoCircle implements IGizmo {

	public physics.Circle getCircle() {
		return circle;
	}

	private physics.Circle circle;

	private static final String TYPE = "Circle";


	@Override
	public void action() {

	}

	@Override
	public void rotate() {

	}

	@Override
	public String getID() {
		return null;
	}

	@Override
	public Boolean move(int x, int y) {
		return null;
	}

	@Override
	public ArrayList<Circle> getCircles() {
		return null;
	}

	@Override
	public ArrayList<LineSegment> getLines() {
		return null;
	}

	@Override
	public String getType() {
		return TYPE;
	}
}
