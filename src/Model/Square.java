package Model;

import physics.Circle;

import java.util.ArrayList;

public class Square implements IGizmo {

    int size;
    ArrayList<VerticalLine> lines;
    ArrayList<ComponentCircle> circles;

    public Square(int x, int y){
        size = 1;

        lines.add(new VerticalLine(x, y, size, 0));
        lines.add(new VerticalLine(x+size, y-size,0, size));
        lines.add(new VerticalLine(x, y-size,size,0));
        lines.add(new VerticalLine(x,y-size,0,size));
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
    public ArrayList<VerticalLine> getLines() {
        return lines;
    }
}
