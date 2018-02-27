package Model;

import java.awt.*;
import java.util.ArrayList;

public class Triangle implements IGizmo {

    int size, x, y;
    ArrayList<Line> lines;
    ArrayList<ComponentCircle> circles;

    public Triangle(int x, int y){
        size = 20;
        this.x = x;
        this.y = y;
        lines = new ArrayList<Line>();
        circles = new ArrayList<ComponentCircle>();

        lines.add(new Line(x, y, size, (-size)));
        lines.add(new Line(x, y-size,size,0));
        lines.add(new Line(x,y-size,0,size));
        circles.add(new ComponentCircle(x,y,0));
        circles.add(new ComponentCircle(x+size, y-size, 0));
        circles.add(new ComponentCircle(x, y-size, 0));
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
    public ArrayList<ComponentCircle> getCircles() {return circles;}

    @Override
    public ArrayList<Line> getLines() {
        return lines;
    }


}
