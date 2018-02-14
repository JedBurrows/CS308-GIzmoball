package Model;

import java.awt.*;
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
    public ArrayList<Line> getLines() {
        return new ArrayList<Line>();
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.fillOval((int) (xpos-radius), (int) (ypos-radius), (int) (2*radius), (int) (2*radius));
    }
}
