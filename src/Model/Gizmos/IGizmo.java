package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public interface IGizmo {


//	  Action performed by gizmo when struck by ball
	void action(double tickTime);

//	  Rotate gizmo 90 deg
	void rotate();
	int getRotation();

	/**
	 * Returns ID of GIZMO
	 * <p>
	 * ID's:
	 * Triangle 'T'+ number
	 * ComponentCircle 'C'+ number
	 * Square 'S'+ number
	 * Flippers 'RF' /'LF' + number
	 * Balls 'B' + number
	 */
	String getID();

	void createLineSegments();

	void createCircles();

	ArrayList<Circle> getCircles();

	ArrayList<LineSegment> getLines();

	double getxPos();

	double getyPos();

	double getx2Pos();

	double gety2Pos();

	int getWidth();

	int getHeight();

	void setxPos(int x);

	void setyPos(int y);

	void setKeyPress();

	boolean getDirection();

	double getAngle();

    void removeCircle(Circle c);

	void removeLine(LineSegment l);
}
