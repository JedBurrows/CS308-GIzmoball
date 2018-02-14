package Model;

import physics.LineSegment;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Line {

	private int xpos;
	private int ypos;
	private int length;
	private int height;
	private LineSegment ls;

	public Line(int x, int y, int l, int h) {
		xpos = x;
		ypos = y;
		length = l;
		ls = new LineSegment(x, y, x + l, y + h);
	}


	public LineSegment getLineSeg() {
		return ls;
	}

	public int getX() {
		return xpos;
	}

	public int getY() {
		return ypos;
	}


	public int getLength() {
		return length;
	}

	public int getHeight(){
		return height;
	}
}
