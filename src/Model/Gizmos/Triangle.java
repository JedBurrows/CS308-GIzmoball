package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Triangle extends AbstractGizmo implements IGizmo {

    private String id;
    private int rotation;
    private Color colour;
    private static final int size = 1;

	public Triangle(String id, int x, int y, Color colour) {
		super(id, x, y, 1, 1, colour);
        createLines();
		createCircles();
	}


	@Override
	public void action(double tickTime) {
    }

    @Override
    public void createLines() {
        lineSegments.clear();
        if (rotation == 0) {
            lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + size, pos1.y));
            lineSegments.add(new LineSegment(pos1.x + size, pos1.y, pos1.x, pos1.y + size));
            lineSegments.add(new LineSegment(pos1.x, pos1.y + size, pos1.x, pos1.y));
        }else if(rotation == 1){
            lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + size, pos1.y));
            lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + size, pos1.y + size));
            lineSegments.add(new LineSegment(pos1.x + size, pos1.y, pos1.x + size, pos1.y + size));
        }else if(rotation == 2){
            lineSegments.add(new LineSegment(pos1.x + size, pos1.y, pos1.x, pos1.y + size));
            lineSegments.add(new LineSegment(pos1.x + size, pos1.y, pos1.x + size, pos1.y + size));
            lineSegments.add(new LineSegment(pos1.x, pos1.y +size, pos1.x + size, pos1.y + size));
        }else if(rotation == 3){
            lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x, pos1.y + size));
            lineSegments.add(new LineSegment(pos1.x, pos1.y, pos1.x + size, pos1.y + size));
            lineSegments.add(new LineSegment(pos1.x, pos1.y + size, pos1.x + size, pos1.y + size));
        }
    }

    @Override
    public void createCircles() {
        circles.clear();
        if (rotation == 0) {
            circles.add(new Circle(pos1.x, pos2.x, 0));
            circles.add(new Circle(pos1.x + size, pos2.x, 0));
            circles.add(new Circle(pos1.x, pos2.x + size, 0));
        }else if (rotation == 1){
            circles.add(new Circle(pos1.x, pos2.x, 0));
            circles.add(new Circle(pos1.x + size, pos2.x, 0));
            circles.add(new Circle(pos1.x + size, pos2.x + size, 0));
        }else if (rotation == 2){
            circles.add(new Circle(pos1.x, pos2.x + size, 0));
            circles.add(new Circle(pos1.x + size, pos2.x, 0));
            circles.add(new Circle(pos1.x + size, pos2.x + size, 0));
        }else if (rotation == 3){
            circles.add(new Circle(pos1.x, pos2.x, 0));
            circles.add(new Circle(pos1.x, pos2.x + size, 0));
            circles.add(new Circle(pos1.x + size, pos2.x + size, 0));
        }
    }
    @Override
	public void setKeyPress() {
	}

	@Override
	public double getAngVel() {
		return 0;
	}

	@Override
	public boolean getMoving() {
		return false;
	}

}
