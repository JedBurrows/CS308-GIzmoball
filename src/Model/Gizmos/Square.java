package Model.Gizmos;

import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Square implements IGizmo {

    private String id;
    private int xPos, yPos;



    public Square(String id, int x,int y){
        this.id =id;
        this.xPos = x;
        this.yPos = y;

    }

    @Override
    public void action() {

    }

    @Override
    public void rotate() {
        //No point rotating
    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public ArrayList<Circle> getCircles() {
        return null;
    }

    @Override
    public ArrayList<LineSegment> getLines() {
        return null;
    }

    @Override
    public int getxPos() {
        return xPos;
    }

    @Override
    public int getyPos() {
        return yPos;
    }
}
