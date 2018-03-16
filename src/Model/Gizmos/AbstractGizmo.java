package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractGizmo {

	protected Point pos1, pos2;
	protected ArrayList<LineSegment> lineSegments;
	protected ArrayList<Circle> circles;
	private String ID;
	protected int width, height, rotation;
	private Color color;

	public AbstractGizmo(String id, int x, int y, int width, int height, Color color) {
		this.ID = id;
		this.pos1 = new Point(x, y);
		this.pos2 = new Point(x + width, y + width);
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

	public void rotate() {
		rotation = (++rotation) % 4;
		createLines();
		createCircles();
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

	public Point getPos1() {
		return pos1;
	}

	public Point getPos2() {
		return pos2;
	}

	protected abstract void createCircles();

	protected abstract void createLines();
}
