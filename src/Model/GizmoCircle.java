package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class GizmoCircle implements IGizmo{
    private int xpos;
    private int ypos;
    private double radius;
    private Circle circle;

    public GizmoCircle(int x, int y) {
        xpos = x;
        ypos = y;
        radius = 10;
        circle = new Circle(x, y, radius);
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
    public ArrayList<Circle> getCircles() {
        ArrayList<Circle> c = new ArrayList<Circle>();
        c.add(circle);
        return c;
    }

    @Override
    public ArrayList<LineSegment> getLines() {
        return new ArrayList<LineSegment>();
    }



}
