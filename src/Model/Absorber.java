package Model;

import physics.LineSegment;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Absorber implements IAbsorber{
    private int x1, x2, y;
    private String id;
    private ArrayList<LineSegment> lines;

    public Absorber(String id, int x1, int x2, int y) {
        this.id = id;
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
        lines = new ArrayList<>();
        createLines();
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY() {
        return y;
    }

    @Override
    public void setX1(int x1) {
        this.x1 = x1;
        createLines();
    }

    @Override
    public void setX2(int x2) {
        this.x2 = x2;
        createLines();
    }

    @Override
    public void setY(int y) {
        this.y = y;
        createLines();
    }

    public ArrayList<LineSegment> getLineSegment(){
        return lines;
    }

    private void createLines(){
        lines.clear();
        lines.add(new LineSegment(x1,y,x2,y));
        lines.add(new LineSegment(x1,y,x2,y+1));
        lines.add(new LineSegment(x2,y,x1,y+1));
        lines.add(new LineSegment(x1,y+1,x2,y+1));
    }
}
