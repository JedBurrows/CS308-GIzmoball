package Model;

import physics.LineSegment;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public interface IAbsorber {

    public int getX1();

    public int getX2();

    public int getY();

    public ArrayList<LineSegment> getLineSegment();
}
