package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Triangle implements IGizmo {

    int size, x, y;
    ArrayList<LineSegment> lines;
    ArrayList<Circle> circles;

    public Triangle(int x, int y){
        size = 20;
        this.x = x;
        this.y = y;
        lines = new ArrayList<LineSegment>();
        circles = new ArrayList<Circle>();

        lines.add(new LineSegment(x, y, x, (y-size)));
        lines.add(new LineSegment(x, y-size,x+size,y-size));
        lines.add(new LineSegment(x,y,x+size,y-size));
        circles.add(new Circle(x,y,0));
        circles.add(new Circle(x+size, y-size, 0));
        circles.add(new Circle(x, y-size, 0));
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
    public ArrayList<Circle> getCircles() {return circles;}

    @Override
    public ArrayList<LineSegment> getLines() {
        return lines;
    }


}