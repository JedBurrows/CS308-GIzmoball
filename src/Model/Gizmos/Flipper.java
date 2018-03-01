package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Flipper implements IGizmo {

	//status of activated or not
	//left and right flipper class

	public static final int FLIPPER_LEFT = 0;
	public static final int FLIPPER_RIGHT = 1;

	private String id;
	private ArrayList<LineSegment> lines;
	private ArrayList<Circle> circles;

	//In reference to the flipper this is the Northwest corner pos on grid
	private int xPos, yPos, rotation, orientation;


	public Flipper(String id, int x, int y, int orientation) {
		this.id = id;
		this.xPos = x;
		this.yPos = y;

		this.rotation = 0;

		this.orientation = orientation;

	}


	@Override
	public void action() {

	}

	@Override
	public void rotate() {
		rotation = (rotation + 1) % 4;

	}

	@Override
	public int getRotation() {
		return rotation;
	}

	public int getOrientation() {
		return orientation;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void createLineSegments() {}

	@Override
	public void createCircles() {}

	@Override
	public ArrayList<Circle> getCircles() {
		return circles;
	}

	@Override
	public ArrayList<LineSegment> getLines() {
		return lines;
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
