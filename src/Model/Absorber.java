package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Absorber implements IAbsorber {
	private int x1, x2, y;
	private String id;
	private ArrayList<LineSegment> lines;
	private ArrayList<Circle> circles;

	public Absorber(String id, int x1, int x2, int y) {
		this.id = id;
		this.x1 = x1;
		this.x2 = x2;
		this.y = y;
		lines = new ArrayList<>();
		circles = new ArrayList<>();
		createLines();
		createCircles();
	}

	public int getX1() {
		return x1;
	}

	@Override
	public void setX1(int x1) {
		this.x1 = x1;
		createLines();
		createCircles();
	}

	public int getX2() {
		return x2;
	}

	@Override
	public void setX2(int x2) {
		this.x2 = x2;
		createLines();
		createCircles();
	}

	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
		createLines();
		createCircles();
	}

	public ArrayList<LineSegment> getLineSegment() {
		return lines;
	}

	private void createLines() {
		lines.clear();
		lines.add(new LineSegment(x1, y, x2, y));
		lines.add(new LineSegment(x1, y, x2, y + 1));
		lines.add(new LineSegment(x2, y, x1, y + 1));
		lines.add(new LineSegment(x1, y + 1, x2, y + 1));
	}

	private void createCircles() {
		circles.clear();
		circles.add(new Circle(x1, y, 0));
		circles.add(new Circle(x2, y, 0));
		circles.add(new Circle(x2, y + 1, 0));
		circles.add(new Circle(x1, y + 1, 0));
	}
}
