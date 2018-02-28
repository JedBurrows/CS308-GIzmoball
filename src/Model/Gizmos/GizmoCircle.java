package Model.Gizmos;


import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class GizmoCircle implements IGizmo {

	private String id;
	private int xPos, yPos;

	public GizmoCircle(String id, int x, int y) {
		this.id = id;
		this.xPos = x;
		this.yPos = y;
	}

	public Circle getCircle() {
		return circle;
	}

	private Circle circle;


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
	public ArrayList<Circle> getCircles() {
		return null;
	}

	@Override
	public ArrayList<LineSegment> getLines() {
		return null;
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
