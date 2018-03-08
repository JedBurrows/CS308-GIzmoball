package Model;

import physics.Circle;
import physics.Vect;

import java.awt.*;


public class Ball implements IBall{

    private String name;
    private float x;
    private float y;
    private Vect velocity;
    private double radius;
    private Color colour;
    private boolean stopped;

    public Ball(String n, float x1, float y1, float vx, float vy) {
        name = n;
        x = x1;
        y = y1;
        velocity = new Vect(vx, vy);
        radius = 0.25;
        stopped = false;

    }

    public Vect getVelo() {
        return velocity;
    }

    public void setVelo(Vect v) {
        velocity = v;
    }

    public double getRadius() {
        return radius;
    }

    public Circle getCircle() {
        return new Circle(x, y, radius);

    }

    // Ball specific methods that deal with double precision.
    public float getXPos() {
        return x;
    }

    public float getYPos() {
        return y;
    }


    public String getName() {
        return name;
    }


    public void setXPos(float x1) {
        x = x1;
    }

    public void setYPos(float y1) {
        y = y1;
    }

    public void stop() {
        stopped = true;
    }

    public void start() {
        stopped = false;
    }

    public boolean stopped() {
        return stopped;
    }

    public Color getColour() {
        return colour;
    }

}






