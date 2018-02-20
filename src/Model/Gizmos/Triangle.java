package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Triangle implements IGizmo {

    private String id;
    private int xPos, yPos;
    private int rotation;

    public Triangle(String id, int x, int y){
        this.id = id;
        this.xPos =x;
        this.yPos =y;
        this.rotation = 0;
    }


    @Override
    public void action() {

    }

    @Override
    public void rotate() {
        rotation = (rotation+1)%4;


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

    @Override
    public void setxPos(int x) {
        this.xPos =x;
    }

    @Override
    public void setyPos(int y) {
        this.yPos =y;
    }

    public int getRotation() {
        return rotation;
    }
}
