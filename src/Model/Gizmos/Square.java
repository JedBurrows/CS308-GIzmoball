package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Square implements IGizmo {

    private static final String TYPE = "Square";

    @Override
    public void action() {

    }

    @Override
    public void rotate() {

    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public Boolean move(int x, int y) {
        return null;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public ArrayList<Circle> getCircles() {
        return null;
    }

    @Override
    public ArrayList<LineSegment> getLines() {
        return null;
    }
}
