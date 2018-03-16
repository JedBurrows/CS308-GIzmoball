package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public interface IGizmo {


	//	  Action performed by gizmo when struck by ball
	void action(double tickTime);

	//	  Rotate gizmo 90 deg
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

/*	int getxPos();

	void setxPos(int xPos);

	int getyPos();

	void setyPos(int yPos);*/

	Point getPos1();

	Point getPos2();

}
