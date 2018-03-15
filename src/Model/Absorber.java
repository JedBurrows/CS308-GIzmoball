package Model;

import physics.Circle;
import physics.LineSegment;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Absorber implements IAbsorber{
    private int x1, x2, y1, y2;
    private String id;
    private ArrayList<LineSegment> lines;
    private ArrayList<Circle> circles;

    public Absorber(String id, int x1, int x2, int y1, int y2) {
        this.id = id;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        createLines();
        createCircles();
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2(){return y2;}

    @Override
    public void setX1(int x1) {
        this.x1 = x1;
        createLines();
        createCircles();
    }

    @Override
    public void setX2(int x2) {
        this.x2 = x2;
        createLines();
        createCircles();
    }

    @Override
    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public void setY2(int y2) {
        this.y2 = y2;
    }

    public ArrayList<LineSegment> getLineSegment(){
        return lines;
    }

    private void createLines(){
        lines.clear();
        lines.add(new LineSegment(x1,y1,x2,y1));
        lines.add(new LineSegment(x1,y1,x2,y2));
        lines.add(new LineSegment(x2,y1,x1,y2));
        lines.add(new LineSegment(x1,y2,x2,y2));
    }

    private void createCircles(){
        circles.clear();
        circles.add(new Circle(x1, y1, 0));
        circles.add(new Circle(x2, y1, 0));
        circles.add(new Circle(x2, y2, 0));
        circles.add(new Circle(x1, y2, 0));
    }
}
