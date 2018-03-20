package Model.Gizmos;

import Model.Ball;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractGizmo {

    protected Point pos1, pos2;
    protected ArrayList<LineSegment> lineSegments;
    protected ArrayList<Circle> circles;
    private String ID;
    protected int width, height, rotation;
    private Color color;
    protected boolean trigger;

    public AbstractGizmo(String id, int x, int y, int width, int height, Color color) {
        this.ID = id;
        this.pos1 = new Point(x, y);
        this.pos2 = new Point(x + width, y + height);
        this.width = width;
        this.height = height;
        this.color = color;
        trigger = false;
        rotation = 0;
        lineSegments = new ArrayList<>();
        circles = new ArrayList<>();

    }

    public void action(double tickTime, Ball ball) {
        if (trigger) {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);

            setColor(randomColor);
        }
    }
    public String getID() {
        return ID;
    }

    public void rotate() {
        rotation = (++rotation) % 4;
        createLines();
        createCircles();
    }

    public int getRotation() {
        return rotation;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public ArrayList<LineSegment> getLineSegments() {
        return lineSegments;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Point getPos1() {
        return pos1;
    }

    public Point getPos2() {
        return pos2;
    }

    public void setTrigger() {
        trigger = !trigger;
    }

    public double getAngVel() {
        return 0;
    }

    public boolean getMoving() {
        return false;
    }

    public void setPos1(double x, double y) {
        if (x >= 0 && x <=19 && y >= 0 && y <=19) {
            pos1.setLocation(x, y);
        }
    }

    protected abstract void createCircles();

    protected abstract void createLines();

}
