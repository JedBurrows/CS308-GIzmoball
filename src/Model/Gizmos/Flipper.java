package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Flipper implements IGizmo {
	private double xpos;
	private double ypos;
	private double x2pos;
	private double y2pos;

	private double maxAngle;
	private double minAngle;
	private double angle ;
	private double angVel;

	//left = false //right = true
	private boolean direction;
	private boolean keyPress;
	//status of activated or not
	//left and right flipper class

	private String id;
	private ArrayList<LineSegment> lines;
	private ArrayList<Circle> circles;

	//In reference to the flipper this is the Northwest corner pos on grid
	private int xPos, yPos, rotation, orientation;


	public Flipper(String i, int x, int y, boolean d) {
		id = i;

		rotation = 0;

		direction = d;

		orientation = 0;

		xpos = x;
		ypos = y;
		x2pos = xpos;
		y2pos = ypos + 2;
		maxAngle = 90;
		minAngle = 0;
		angle = 90;
		angVel = 1080;
		keyPress = false;

		lines = new ArrayList<>();
		circles = new ArrayList<>();

		createLineSegments();


	}


	@Override
	public void action(double tickTime) {
		if (!keyPress){ //if flipper is going down
			if (angle < maxAngle) {
				angle = angle + (angVel * tickTime);
				if (angle > 90) {
					angle = 90;
				}
				if (!direction) {
					x2pos = xpos + (2.0 * Math.cos(Math.toRadians(angle)));
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! Angle: "+angle);
				}else{
					x2pos = xpos - (2.0 * Math.cos(Math.toRadians(angle)));
				}
				y2pos = ypos +  (2.0 * Math.sin(Math.toRadians(angle)));

			}
		}else if(keyPress){
			if (angle >= minAngle) {
				angle = angle +(-angVel * tickTime);
				if (angle < 0){
					angle = 0;
				}
				if (!direction) {
					x2pos = xpos + (2.0 * Math.cos(Math.toRadians(angle)));
				}else{
					x2pos = xpos - (2.0 * Math.cos(Math.toRadians(angle)));
				}
				y2pos = ypos +  (2.0 * Math.sin(Math.toRadians(angle)));

			}
		}
		updateLineSegments();
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
	public void createLineSegments() {
		lines.add(new LineSegment(xpos,ypos , x2pos , y2pos ));

	}

	public void updateLineSegments(){
		lines.clear();
		createLineSegments();
	}

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
	public double getxPos() {
		return xpos;
	}

	@Override
	public double getyPos() {
		return ypos;
	}

	@Override
	public double getx2Pos() {
		return x2pos;
	}

	@Override
	public double gety2Pos() {
		return y2pos;
	}

	@Override
	public int getWidth() {
		return 2;
	}

	@Override
	public int getHeight() {
		return 2;
	}

	@Override
	public void setxPos(int x) {
		this.xPos = x;
	}

	@Override
	public void setyPos(int y) {
		this.yPos = y;
	}

	public double getAngle(){
		return angle;
	}

	@Override
	public void removeCircle(Circle c) {
		circles.remove(c);
	}

	@Override
	public void removeLine(LineSegment l) {
		lines.remove(l);
	}

	public double getY() {
		return ypos;
	}

	public void setKeyPress(){keyPress = !keyPress;	}

	@Override
	public boolean getDirection() {
		return direction;
	}

}
