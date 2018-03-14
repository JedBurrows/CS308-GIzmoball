package Model;

import physics.LineSegment;

public interface IAbsorber {

    public int getxPos1();

    public int getxPos2();

    public int getyPos1();

    public int getyPos2();

    public LineSegment getLineSegment();
}
