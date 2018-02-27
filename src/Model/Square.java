package Model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Square implements IGizmo {

    int x,y,size;
    ArrayList<LineSegment> lines;
    ArrayList<Circle> circles;

    public Square(int x, int y){
        size = 20;
        this.x = x;
        this.y = y;
        lines = new ArrayList<LineSegment>();
        circles = new ArrayList<Circle>();

        lines.add(new LineSegment(x, y, x+ size, y));
        lines.add(new LineSegment(x+size, y,x, (y-size)));
        lines.add(new LineSegment(x+size, y-size,(x-size),y));
        lines.add(new LineSegment(x,y-size,x,y+size));
        circles.add(new Circle(x,y,0));
        circles.add(new Circle(x+size, y, 0));
        circles.add(new Circle(x+size, y-size, 0));
        circles.add(new Circle(x, y-size,0));
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
        return false;
    }

    @Override
    public ArrayList<Circle> getCircles() {return circles;}

    @Override
    public ArrayList<LineSegment> getLines() {
        return lines;
    }



}
