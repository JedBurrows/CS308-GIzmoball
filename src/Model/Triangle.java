package Model;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Triangle implements IGizmo {

    private String id;

    public Triangle(String id){
        this.id = id;
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
    public ArrayList<Circle> getCircles() {
        return null;
    }

    @Override
    public ArrayList<LineSegment> getLines() {
        return null;
    }
}
