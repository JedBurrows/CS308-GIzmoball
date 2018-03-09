package Model.Gizmos;

import View.ColorChooserExample;
import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Square implements IGizmo {

    private String id;
    private int xPos, yPos;

    private ArrayList<LineSegment> lines;
    private ArrayList<Circle> circles;
    private static final int size = 1;



    public Square(String id, int x, int y) {
        this.id = id;
        this.xPos = x;
        this.yPos = y;

        lines = new ArrayList<LineSegment>();
        circles = new ArrayList<Circle>();

        createCircles();
        createLineSegments();
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
    public void createLineSegments() {
        lines.add(new LineSegment(xPos, yPos, xPos + size, yPos));
        lines.add(new LineSegment(xPos + size, yPos - size, xPos + size, yPos));
        lines.add(new LineSegment(xPos, yPos, (xPos), yPos - size));
        lines.add(new LineSegment(xPos, yPos - size, xPos + size, yPos - size));
    }

    @Override
    public void createCircles() {
        circles.add(new Circle(xPos, yPos, 0));
        circles.add(new Circle(xPos + size, yPos, 0));
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
    public void setColor() {

    }
}
