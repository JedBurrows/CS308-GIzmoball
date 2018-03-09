package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Triangle implements IGizmo {

    private String id;
    private int xPos, yPos;
    private int rotation;
    private ArrayList<LineSegment> lines;
    private ArrayList<Circle> circles;
    private static final int size = 1;

    public Triangle(String id, int x, int y) {
        this.id = id;
        this.xPos = x;
        this.yPos = y;
        this.rotation = 0;

        lines = new ArrayList<LineSegment>();
        circles = new ArrayList<Circle>();
    }

    @Override
    public void action(double tickTime) {

    }

    @Override
    public void rotate() {
        rotation = (rotation + 1) % 4;


    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void createLineSegments() {
        lines.add(new LineSegment(xPos, yPos, xPos, (yPos - size)));
        lines.add(new LineSegment(xPos, yPos - size, xPos + size, yPos - size));
        lines.add(new LineSegment(xPos, yPos, xPos + size, yPos - size));
    }

    @Override
    public void createCircles() {
        circles.add(new Circle(xPos, yPos, 0));
        circles.add(new Circle(xPos + size, yPos - size, 0));
        circles.add(new Circle(xPos, yPos - size, 0));
    }

    @Override
    public ArrayList<Circle> getCircles() {
        return circles;
    }

    @Override
    public ArrayList<LineSegment> getLines() {
        return lines;
    }

    @Override
    public double getxPos() {
        return xPos;
    }

    @Override
    public double getyPos() {
        return yPos;
    }

    @Override
    public double getx2Pos() {
        //No x2pos
        return xPos + 1;
    }

    @Override
    public double gety2Pos() {
        //No y2pos
        return yPos + 1;
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

    public int getRotation() {
        return rotation;
    }
}
