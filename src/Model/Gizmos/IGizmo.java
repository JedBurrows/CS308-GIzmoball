package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public interface IGizmo {


	//	  Action performed by gizmo when struck by ball
	void action(double tickTime);

	void rotate();

	int getRotation();


	ArrayList<Circle> getCircles();

	ArrayList<LineSegment> getLineSegments();

	int getWidth();

	int getHeight();

	void setKeyPress();

	double getAngVel();

	boolean getMoving();

	Color getColor();

	String getID();

	Point getPos1();

	Point getPos2();

}
