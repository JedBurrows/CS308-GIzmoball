package Model;


import physics.Circle;
import physics.Vect;

import java.util.ArrayList;

public class ComponentCircle implements IGizmo {
    private int xpos;
    private int ypos;
    private double radius;
    private Circle circle;

    public ComponentCircle(int x, int y) {
        xpos = x;
        ypos = y;
        radius = 10;
        circle = new Circle(new Vect(xpos, ypos), radius);
    }

    public Circle getCirle(){return circle;}

    public int getX() {
        return xpos;
    }

    public int getY() {
        return ypos;
    }

    public double getRadius() {
        return radius;
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
        return null;
    }

    @Override
    public ArrayList<VerticalLine> getLines() {
        return null;
    }
}
