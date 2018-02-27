package Model;


import physics.Circle;
import physics.Vect;

import java.util.ArrayList;

public class ComponentCircle {
    private int xpos;
    private int ypos;
    private double radius;
    private Circle circle;

    public ComponentCircle(int x, int y, double r) {
        xpos = x;
        ypos = y;
        radius = r;
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

}
