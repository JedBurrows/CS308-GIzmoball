package Model;

import physics.LineSegment;

import java.util.ArrayList;

public interface IAbsorber {

	int getX1();

	void setX1(int x1);

	int getX2();

	void setX2(int x2);

	int getY();

	void setY(int y);

	ArrayList<LineSegment> getLineSegment();
}
