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

    public ArrayList<LineSegment> getLineSegment(){
        return lines;
    }

    private void createLines(){
        lines.add(new LineSegment(x1,y,x2,y));
        lines.add(new LineSegment(x1,y,x2,y+1));
        lines.add(new LineSegment(x2,y,x1,y+1));
        lines.add(new LineSegment(x1,y+1,x2,y+1));
    }
}
