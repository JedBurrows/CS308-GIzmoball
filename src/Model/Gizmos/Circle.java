package Model.Gizmos;


import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Circle implements IGizmo {

    private String id;
    private int xPos, yPos;
    private physics.Circle circle;
    private static final double radius = 0.5;
    private Color colour;

    public Circle(String id, int x, int y, Color colour) {
        this.id = id;
        this.xPos = x;
        this.yPos = y;
        circle = new physics.Circle(xPos + 0.5, yPos + 0.5, radius);
        this.colour = colour;
    }

    @Override
    public void action(double tickTime) {

    }

    @Override
    public void rotate() {
        //No point rotating
    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public String getID() {
        return id;
    }

      @Override
    public void createCircles() {

    }

    @Override
    public void createLines() {

    }

    @Override
    public ArrayList<physics.Circle> getCircles() {
        ArrayList<physics.Circle> c = new ArrayList<physics.Circle>();
        c.add(circle);
        return c;
    }

    @Override
    public ArrayList<LineSegment> getLines() {
        return new ArrayList<LineSegment>();
    }

    @Override
    public int getxPos() {
        return xPos;
    }

    @Override
    public int getyPos() {
        return yPos;
    }

    @Override
    public int getx2Pos() {
        //No x2pos
        return -1;
    }

    @Override
    public int gety2Pos() {
        //No y2pos
        return -1;
    }

    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public void setxPos(int x) {
        this.xPos = x;
    }

    @Override
    public void setyPos(int y) {
        this.yPos = y;
    }

    @Override
    public void setKeyPress() {

    }

    @Override
    public boolean getDirection() {
        return false;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public double getAngVel() {
        return 0;
    }

    @Override
    public boolean getMoving() {
        return false;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }
}
