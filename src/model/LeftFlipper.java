package model;

import physics.LineSegment;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class LeftFlipper {

    private int xpos;
    private int ypos;
    private int x2pos;
    private int y2pos;

    private int length;
    private int id;
    private boolean onOff;

    private double maxAngle;
    private double minAngle;
    private double angle ;
    private double angVel;

    private boolean keyPress;

    public LeftFlipper(int i, int x, int y, int l) {
        id = i;
        xpos = x;
        ypos = y;
        x2pos = xpos;
        y2pos = ypos + l;
        length = l;
        maxAngle = 90;
        minAngle = 0;
        angle = 90;
        angVel = 90;

        keyPress = false;

    }

    public int getId() {
        return id;
    }

    public void flip(double tickTime){
        if (!keyPress){
            if (angle < maxAngle) {
                System.out.println("here1");
                angle = angle + (angVel * tickTime);
                if (angle > 90) {
                    angle = 90;
                }
                x2pos = xpos + (int) Math.round(length * Math.cos(Math.toRadians(angle)));
                y2pos = ypos + (int) Math.round(length * Math.sin(Math.toRadians(angle)));
                System.out.println("(x2pos, y2pos) (" + x2pos + ", " + y2pos + ")");
                System.out.println("angle: " + angle);
            }
        }else if(keyPress){
            if (angle >= minAngle) {
                System.out.println("here2");
                angle = angle +(-angVel * tickTime);
                if (angle < 0){
                    angle = 0;
                }
                x2pos = xpos + (int) Math.round(length * Math.cos(Math.toRadians(angle)));
                y2pos = ypos + (int) Math.round(length * Math.sin(Math.toRadians(angle)));
                System.out.println("(x2pos, y2pos) (" + x2pos + ", " + y2pos + ")");
                System.out.println("angle: " + angle);            }
        }

    }
    public double getX() {
        return xpos;
    }

    public double getAngle(){
        return angle;
    }

    public double getY() {
        return ypos;
    }

    public void setkeyPress(){
        keyPress = !keyPress;
    }


    public Point[] getPoints() {
        return new Point[] {
                new Point(xpos, ypos),
                new Point(x2pos, y2pos)
        };
    }

}
