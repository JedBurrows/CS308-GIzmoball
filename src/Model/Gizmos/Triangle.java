package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Triangle implements IGizmo {

    private String id;
    private int xPos, yPos;
    private int rotation;
    private Color colour;
    private ArrayList<LineSegment> lines;
    private ArrayList<Circle> circles;
    private static final int size = 1;

    public Triangle(String id, int x, int y, Color colour) {
        this.id = id;
        this.xPos = x;
        this.yPos = y;
        this.rotation = 0;
        this.colour = colour;
        lines = new ArrayList<LineSegment>();
        circles = new ArrayList<Circle>();

        createLines();
        createCircles();
    }

    @Override
    public void action(double tickTime) {

    }

    @Override
    public void rotate() {
        rotation = (rotation + 1) % 4;
        createLines();
        createCircles();
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void createLines() {
        lines.removeAll(lines);
        if (rotation == 0) {
            lines.add(new LineSegment(xPos, yPos, xPos + size, yPos));
            lines.add(new LineSegment(xPos + size, yPos, xPos, yPos + size));
            lines.add(new LineSegment(xPos, yPos + size, xPos, yPos));
        }else if(rotation == 1){
            lines.add(new LineSegment(xPos, yPos, xPos + size, yPos));
            lines.add(new LineSegment(xPos, yPos, xPos + size, yPos + size));
            lines.add(new LineSegment(xPos + size, yPos, xPos + size, yPos + size));
        }else if(rotation == 2){
            lines.add(new LineSegment(xPos + size, yPos, xPos, yPos + size));
            lines.add(new LineSegment(xPos + size, yPos, xPos + size, yPos + size));
            lines.add(new LineSegment(xPos, yPos +size, xPos + size, yPos + size));
        }else if(rotation == 3){
            lines.add(new LineSegment(xPos, yPos, xPos, yPos + size));
            lines.add(new LineSegment(xPos, yPos, xPos + size, yPos + size));
            lines.add(new LineSegment(xPos, yPos + size, xPos + size, yPos + size));
        }
    }

    @Override
    public void createCircles() {
        circles.removeAll(circles);
        if (rotation == 0) {
            circles.add(new Circle(xPos, yPos, 0));
            circles.add(new Circle(xPos + size, yPos, 0));
            circles.add(new Circle(xPos, yPos + size, 0));
        }else if (rotation == 1){
            circles.add(new Circle(xPos, yPos, 0));
            circles.add(new Circle(xPos + size, yPos, 0));
            circles.add(new Circle(xPos + size, yPos + size, 0));
        }else if (rotation == 2){
            circles.add(new Circle(xPos, yPos + size, 0));
            circles.add(new Circle(xPos + size, yPos, 0));
            circles.add(new Circle(xPos + size, yPos + size, 0));
        }else if (rotation == 3){
            circles.add(new Circle(xPos, yPos, 0));
            circles.add(new Circle(xPos, yPos + size, 0));
            circles.add(new Circle(xPos + size, yPos + size, 0));
        }
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
        return xPos + 1;
    }

    @Override
    public int gety2Pos() {
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

    @Override
    public double getAngVel() {
        return 0;
    }
    @Override
    public boolean getMoving() {
        return false;
    }

    public int getRotation() {
        return rotation;
    }

    @Override
    public Color getColour() {
        return colour;
    }
}
