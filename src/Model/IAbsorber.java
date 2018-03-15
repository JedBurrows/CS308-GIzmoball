package Model;

import physics.LineSegment;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public interface IAbsorber {

    public int getX1();

    public int getX2();

    public int getY1();

    public int getY2();

    public void setX1(int x1);

    public void setX2(int x2);

    public void setY1(int y1);

    public void setY2(int y2);

    public ArrayList<LineSegment> getLineSegment();
}
