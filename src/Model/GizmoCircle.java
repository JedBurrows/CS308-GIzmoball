package Model;

import physics.Circle;
import physics.Vect;

import java.util.ArrayList;

public class GizmoCircle implements IGizmo{
    private int xpos;
    private int ypos;
    private double radius;
    private ComponentCircle circle;

    public GizmoCircle(int x, int y) {
        xpos = x;
        ypos = y;
        radius = 10;
        circle = new ComponentCircle(x, y, radius);
    }

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
    public ArrayList<ComponentCircle> getCircles() {
        ArrayList<ComponentCircle> c = new ArrayList<ComponentCircle>();
        c.add(circle);
        return c;
    }

    @Override
    public ArrayList<VerticalLine> getLines() {
        return new ArrayList<VerticalLine>();
    }
}
