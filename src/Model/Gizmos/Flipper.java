package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;

public class Flipper extends AbstractGizmo implements IGizmo {
	private double xpos;
	private double ypos;
	private double x2pos;
	private double y2pos;

	private double maxAngle;
	private double minAngle;
	private double angle;
	private double angVel;

	private boolean moving;

	//left = false //right = true
	private boolean direction;
	private boolean keyPress;
	//status of activated or not
	//left and right flipper class


	//In reference to the flipper this is the Northwest corner pos on grid


	public Flipper(String id, int x, int y, Color colour, boolean d) {
		super(id, x, y, 2, 2, colour);
		direction = d;

		moving = false;
		xpos = x;
		ypos = y;
		x2pos = xpos;
		y2pos = ypos + 2;
		maxAngle = 90;
		minAngle = 0;
		angle = 90;
		angVel = 1080;
		keyPress = false;

		circles.add(new Circle(xpos + 0.125, ypos + 0.125, 0.25));
		circles.add(new Circle(x2pos + 0.125, y2pos - 0.125, 0.25));
		lineSegments.add(new LineSegment(xpos + 0.5, ypos + 0.25, x2pos + 0.5, y2pos - 0.25));
		lineSegments.add(new LineSegment(x2pos, y2pos + 0.25, x2pos, y2pos - 0.25));


		createCircles();
		createLines();

	}


	@Override
	public void action(double tickTime) {
		moving = false;
		if (!keyPress) {
			if (angle < maxAngle) {
				if (angVel < 0) {
					angVel = -angVel;
				}
				angle = angle + (angVel * tickTime);
				if (angle >= 90) {
					angle = 90;
				} else {
					moving = true;
				}
				if (!direction) {
					x2pos = xpos + (2.0 * Math.cos(Math.toRadians(angle)));
				} else {
					x2pos = xpos - (2.0 * Math.cos(Math.toRadians(angle)));
				}
				y2pos = ypos + (2.0 * Math.sin(Math.toRadians(angle)));
			}
		} else if (keyPress) {
			if (angle >= minAngle) {
				if (angVel > 0) {
					angVel = -angVel;
				}
				angle = angle + (angVel * tickTime);
				if (angle < 0) {
					angle = 0;
				} else {
					moving = true;
				}
				if (!direction) {
					x2pos = xpos + (2.0 * Math.cos(Math.toRadians(angle)));
				} else {
					x2pos = xpos - (2.0 * Math.cos(Math.toRadians(angle)));
				}
				y2pos = ypos + (2.0 * Math.sin(Math.toRadians(angle)));


			}
		}
		createCircles();
		createLines();
	}


	@Override
	public void createCircles() {
		circles.clear();
		double angleDivider = angle / 90.0;


		if (!direction) {
			double xDivider = (angleDivider * 0.5) - 0.25;
			double yDivider = 0.25 - (angleDivider * 0.5);
			circles.add(new Circle(xpos + 0.25, ypos + 0.25, 0.25));
			circles.add(new Circle(x2pos + xDivider, y2pos + yDivider, 0.25));
		} else {
			double xDivider = 1.25 - (angleDivider * 0.5);
			double yDivider = 0.25 - (angleDivider * 0.5);
			circles.add(new Circle(xpos + 0.75, ypos + 0.25, 0.25));
			circles.add(new Circle(x2pos + xDivider, y2pos + yDivider, 0.25));

		}
	}

	@Override
	public void createLines() {
		lineSegments.clear();

		double angleDivider = angle / 90.0;

		if (!direction) {
			double l1x1Divider = 0.25 - (angleDivider * 0.25);
			double l1y1Divider = 0.5 - (angleDivider * 0.25);
			double l1x2Divider = (angleDivider * 0.25) - 0.25;
			double l1y2Divider = 0.5 - (angleDivider * 0.75);

			double l2x1Divider = (angleDivider * 0.25) + 0.25;
			double l2y1Divider = (angleDivider * 0.25);
			double l2x2Divider = (angleDivider * 0.75) - 0.25;
			double l2y2Divider = -(angleDivider * 0.25);

			lineSegments.add(new LineSegment(xpos + l1x1Divider, ypos + l1y1Divider, x2pos + l1x2Divider, y2pos + l1y2Divider));
			lineSegments.add(new LineSegment(xpos + l2x1Divider, ypos + l2y1Divider, x2pos + l2x2Divider, y2pos + l2y2Divider));
		} else {
			double l1x1Divider = 0.75 - (angleDivider * 0.25);
			double l1y1Divider = (angleDivider * 0.25);
			double l1x2Divider = 1.25 - (angleDivider * 0.75);
			double l1y2Divider = -(angleDivider * 0.25);

			double l2x1Divider = (angleDivider * 0.25) + 0.75;
			double l2y1Divider = 0.5 - (angleDivider * 0.25);
			double l2x2Divider = 1.25 - (angleDivider * 0.25);
			double l2y2Divider = 0.5 - (angleDivider * 0.75);

			lineSegments.add(new LineSegment(xpos + l1x1Divider, ypos + l1y1Divider, x2pos + l1x2Divider, y2pos + l1y2Divider));
			lineSegments.add(new LineSegment(xpos + l2x1Divider, ypos + l2y1Divider, x2pos + l2x2Divider, y2pos + l2y2Divider));

		}

	}


	public double getY() {
		return ypos;
	}

	public void setKeyPress() {
		keyPress = !keyPress;
	}


	@Override
	public double getAngVel() {
		return angVel;
	}

	@Override
	public boolean getMoving() {
		return moving;
	}


}
