package Model;

import physics.LineSegment;

import java.util.ArrayList;

public interface IAbsorber {

	int getX1();

	void setX1(int x1);

    public int getY1();

    public int getY2();

	void setX2(int x2);

    public void setY1(int y1);

    public void setY2(int y2);

	ArrayList<LineSegment> getLineSegment();
}
