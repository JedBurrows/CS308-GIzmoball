package Model;


import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class GizmoCircle implements IGizmo {

    private String id;

    public GizmoCircle(String id){
        this.id = id;
    }

    public Circle getCircle() {
        return circle;
    }

    private Circle circle;


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
