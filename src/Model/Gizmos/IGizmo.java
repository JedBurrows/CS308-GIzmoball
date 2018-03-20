package Model.Gizmos;

import Model.Ball;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public interface IGizmo {

	void action(double tickTime, Ball ball);

	void rotate();

	int getRotation();
	
	ArrayList<Circle> getCircles();

	ArrayList<LineSegment> getLineSegments();

	int getWidth();

	int getHeight();

	void setTrigger();

	double getAngVel();

	boolean getMoving();

	Color getColor();

	void setColor(Color c);

	String getID();

	Point getPos1();

	Point getPos2();

	void setPos1(double x, double y);

}
