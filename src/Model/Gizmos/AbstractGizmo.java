package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractGizmo {

	protected int xPos, yPos;
	protected ArrayList<LineSegment> lineSegments;
	protected ArrayList<Circle> circles;
	private String ID;
	private int width, height, rotation;
	private Color color;

	public AbstractGizmo(String id, int x, int y, int width, int height, Color color) {
		this.ID = id;
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.color = color;
		rotation = 0;
		lineSegments = new ArrayList<>();
		circles = new ArrayList<>();

	}


	public String getID() {
		return ID;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void rotate() {
		rotation = (rotation + 1) % 4;
	}

	public int getRotation() {
		return rotation;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<Circle> getCircles() {
		return circles;
	}

	public ArrayList<LineSegment> getLineSegments() {
		return lineSegments;
	}

	public Color getColor() {
		return color;
	}

	public abstract void createCircles();

	public abstract void createLines();
}
