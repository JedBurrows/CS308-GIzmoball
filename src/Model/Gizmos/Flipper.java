package Model.Gizmos;

import Model.IGizmo;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Flipper implements IGizmo {
	private int xpos;
	private int ypos;
	private int x2pos;
	private int y2pos;

	private int length;

	private double maxAngle;
	private double minAngle;
	private double angle ;
	private double angVel;

	private boolean keyPress;
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
		id = id;

		rotation = 0;

		orientation = orientation;

		//---------------------------
		xpos = x;
		ypos = y;
		x2pos = xpos;
		y2pos = ypos + 2;
		maxAngle = 90;
		minAngle = 0;
		angle = 90;
		angVel = 1080;
		keyPress = false;
	}


	@Override
	public void action(double tickTime) {
		if (!keyPress){
			if (angle < maxAngle) {
				System.out.println("here1");
				angle = angle + (angVel * tickTime);
				if (angle > 90) {
					angle = 90;
				}
				x2pos = xpos + (int) Math.round(length * Math.cos(Math.toRadians(angle)));
				y2pos = ypos + (int) Math.round(length * Math.sin(Math.toRadians(angle)));
				System.out.println("(x2pos, y2pos) (" + x2pos + ", " + y2pos + ")");
				System.out.println("angle: " + angle);
			}
		}else if(keyPress){
			if (angle >= minAngle) {
				System.out.println("here2");
				angle = angle +(-angVel * tickTime);
				if (angle < 0){
					angle = 0;
				}
				x2pos = xpos + (int) Math.round(length * Math.cos(Math.toRadians(angle)));
				y2pos = ypos + (int) Math.round(length * Math.sin(Math.toRadians(angle)));
				System.out.println("(x2pos, y2pos) (" + x2pos + ", " + y2pos + ")");
				System.out.println("angle: " + angle);            }
		}
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
	public int getx2Pos() {
		return x2pos;
	}

	@Override
	public int gety2Pos() {
		return y2pos;
	}

	@Override
	public void setxPos(int x) {
		this.xPos = x;
	}

	@Override
	public void setyPos(int y) {
		this.yPos = y;
	}

	public double getX() {
		return xpos;
	}

	public double getAngle(){
		return angle;
	}

	public double getY() {
		return ypos;
	}

	public void setKeyPress(){
		keyPress = !keyPress;
	}

	public Point[] getPoints() {
		return new Point[] {
				new Point(xpos, ypos),
				new Point(x2pos, y2pos)
		};
	}




}
