package Model.Gizmos;


import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class GizmoCircle implements IGizmo {

	private String id;
	private int xPos, yPos;
	private Circle circle;
	private static int radius = 10;

	public GizmoCircle(String id, int x, int y) {
		this.id = id;
		this.xPos = x;
		this.yPos = y;
		circle = new Circle(xPos, yPos, radius);

	}

	@Override
	public void action() {

	}

	@Override
	public void rotate() {
		//No point rotating

	}

	@Override
	public int getRotation() {
		return 0;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void createLineSegments() {

	}

	@Override
	public void createCircles() {

	}

	@Override
	public ArrayList<Circle> getCircles() {
		ArrayList<Circle> c = new ArrayList<Circle>();
		c.add(circle);
		return c;
	}

	@Override
	public ArrayList<LineSegment> getLines() {
		return new ArrayList<LineSegment>();
	}

	@Override
	public int getxPos() {
		return xPos;
	}

	@Override
	public int getyPos() {
		return yPos;
	}

	@Override
	public void setxPos(int x) {
		this.xPos = x;
	}

	@Override
	public void setyPos(int y) {
		this.yPos = y;
	}
}
