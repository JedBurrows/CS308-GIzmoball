package Model;

import physics.LineSegment;

public class Absorber implements IAbsorber{
    private int xPos1, yPos1, xPos2, yPos2;
    private String id;
    private LineSegment ls;

    public Absorber(String id, int x1, int y1, int x2, int y2) {
        this.id = id;
        this.xPos1 = x1;
        this.xPos2 = x2;
        this.yPos1 = y1;
        this.yPos2 = y2;
        ls = new LineSegment(x1,y1,x2,y2);
    }

    public int getxPos1() {
        return xPos1;
    }

    public int getxPos2() {
        return xPos2;
    }

    public int getyPos1() {
        return yPos1;
    }

    public int getyPos2() {
        return yPos2;
    }

    public LineSegment getLineSegment(){
        return ls;
    }
}
