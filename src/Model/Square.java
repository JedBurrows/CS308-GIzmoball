package Model;

import physics.Circle;

import java.util.ArrayList;

public class Square implements IGizmo {

    int size;
    ArrayList<VerticalLine> lines;
    ArrayList<Circle> circles;

    public Square(){
//        size = 1;
//        Vect v2 = new Vect(x+size, y);
//        Vect v3 = new Vect(x+size, y+size);
//        Vect v4 = new Vect(x, y+size);
//        lines.add(new VerticalLine(x, y, size));
//        lines.add(new VerticalLine(x+size, size,0));
//        lines.add(new VertiaclLine(x, y+size,);
//        lines.add(new LineSegment(v4, pos));
//        circles.add(new Circle(pos,0));
//        circles.add(new Circle(v2,0));
//        circles.add(new Circle(v3,0));
//        circles.add(new Circle(v4,0));
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
    public ArrayList<VerticalLine> getLines() {
        return lines;
    }
}
