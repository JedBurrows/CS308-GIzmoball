package Model;

import java.awt.*;
import java.util.ArrayList;

public class Square implements IGizmo {

    int x,y,size;
    ArrayList<Line> lines;
    ArrayList<ComponentCircle> circles;

    public Square(int x, int y){
        size = 20;
        this.x = x;
        this.y = y;
        lines = new ArrayList<Line>();
        circles = new ArrayList<ComponentCircle>();

        lines.add(new Line(x, y, size, 0));
        lines.add(new Line(x+size, y,0, (-size)));
        lines.add(new Line(x+size, y-size,(-size),0));
        lines.add(new Line(x,y-size,0,size));
        circles.add(new ComponentCircle(x,y,0));
        circles.add(new ComponentCircle(x+size, y, 0));
        circles.add(new ComponentCircle(x+size, y-size, 0));
        circles.add(new ComponentCircle(x, y-size,0));
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
    public ArrayList<ComponentCircle> getCircles() {return circles;}

    @Override
    public ArrayList<Line> getLines() {
        return lines;
    }



}
