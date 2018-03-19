package Model.Gizmos;

import physics.*;
import physics.Circle;
import physics.LineSegment;

import javax.sound.sampled.Line;
import java.awt.*;
import java.util.ArrayList;

public class RightFlipper extends AbstractGizmo implements IGizmo {
    private double xpos;
    private double ypos;
    private double x2pos;
    private double y2pos;

    private double maxAngle;
    private double minAngle;
    private double angle;
    private double angVel;

    private boolean moving;

    //left = false //right = true
    private boolean direction;
    private boolean keyPress;
    //status of activated or not
    //left and right flipper class


    //In reference to the flipper this is the Northwest corner pos on grid


    public RightFlipper(String id, int x, int y, Color colour, boolean d) {
        super(id, x, y, 2, 2, colour);
        direction = d;
        moving = false;
        xpos = x;
        ypos = y;
        maxAngle = 90;
        minAngle = 0;
        angle = 90;
        angVel = 1080;
        keyPress = false;

        if (direction) {
            width = -width;
        }


        circles.add(new Circle(xpos + 1.75, ypos + 0.25, 0.25));
        circles.add(new Circle(xpos + 1.75, ypos + 1.75, 0.25));

        lineSegments.add(new LineSegment(xpos + 2.0, ypos + 0.25, xpos + 2.0, ypos + 1.75));
        lineSegments.add(new LineSegment(xpos + 1.5, ypos + 0.25, xpos + 1.5, ypos + 1.75));
    }


    @Override
    public void action(double tickTime) {
        moving = false;
        if (!keyPress) {
            if (angle < maxAngle) {
                if (angVel < 0) {
                    angVel = -angVel;
                }
                angle = angle + (angVel * tickTime);

                if (angle > 90) {
                    angle = 90;
                } else {
                    moving = true;
                }
                createCircles(tickTime);
                createLines(tickTime);
            }
        } else if (keyPress) {
            if (angle >= minAngle) {
                if (angVel > 0) {
                    angVel = -angVel;
                }
                angle = angle + (angVel * tickTime);
                if (angle < 0) {
                    angle = 0;
                } else {
                    moving = true;
                }
                createCircles(tickTime);
                createLines(tickTime);
            }
        }
    }


    public void createCircles(double tickTime) {
        ArrayList<Circle> tempC = new ArrayList<>();
        System.out.println(angVel / (1 / tickTime));
        for (physics.Circle c : circles) {
            c = Geometry.rotateAround(c, circles.get(0).getCenter(), new Angle(Math.toRadians(angVel / (1 / tickTime))));
            if (c.getCenter().y() < ypos + 0.25 && rotation == 0) {
                c = new Circle(xpos + 1.75, ypos + 0.25, 0.25);
            } else if (c.getCenter().x() < xpos + 0.25 && rotation == 0) {
                c = new Circle(xpos + 0.25, ypos + 1.75, 0.25);

            } else if (c.getCenter().y() < ypos + 0.25 && rotation == 1) {
                c = new Circle(xpos + 0.25, ypos + 0.25, 0.25);
            } else if (c.getCenter().x() > xpos + 1.75 && rotation == 1) {
                c = new Circle(xpos + 1.75, ypos + 1.75, 0.25);

            } else if (c.getCenter().x() > (xpos + 1.75) && rotation == 2) {
                c = new Circle(xpos + 1.75, ypos + 0.25, 0.25);
            } else if (c.getCenter().y() > (ypos + 1.75) && rotation == 2) {
                c = new Circle(xpos + 0.25, ypos + 1.75, 0.25);

            } else if (c.getCenter().y() > ypos + 1.75 && rotation == 3) {
                c = new Circle(xpos + 1.75, ypos + 1.75, 0.25);
            } else if (c.getCenter().x() < xpos + 0.25 && rotation == 3) {
                c = new Circle(xpos + 0.25, ypos + 0.25, 0.25);
            }
            tempC.add(c);
        }
        circles = tempC;
    }

    public void createLines(double tickTime) {
        ArrayList<LineSegment> tempL = new ArrayList<>();

        for (physics.LineSegment l : lineSegments) {
            l = Geometry.rotateAround(l, circles.get(0).getCenter(), new Angle(Math.toRadians(angVel / (1 / tickTime))));
            tempL.add(l);
        }
//        System.out.println("tempL: " + tempL.get(0).p2().y());
//        System.out.println("ypos: " + (ypos));

        if (tempL.get(0).p2().x() < xpos && rotation == 0) {
            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos, ypos + 0.25, xpos, ypos + 1.75)); //1
            lineSegments.add(new LineSegment(xpos + 0.5, ypos + 0.25, xpos + 0.5, ypos + 1.75)); //2
        } else if (tempL.get(1).p2().y() < ypos && rotation == 0) {
            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos + 0.25, ypos + 0.5, xpos + 1.75, ypos + 0.5)); //1
            lineSegments.add(new LineSegment(xpos + 0.25, ypos, xpos + 1.75, ypos)); //2
        }
        //rotation 1
        else if (tempL.get(1).p2().y() < ypos && rotation == 1) {
            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos + 1.75, ypos, xpos + 0.25, ypos)); //1
            lineSegments.add(new LineSegment(xpos + 1.75, ypos + 0.5, xpos + 0.25, ypos + 0.5)); //2

        } else if (tempL.get(1).p2().x() > (xpos + 1.5) && rotation == 1) {

            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos + 2.0, ypos + 0.25, xpos + 2.0, ypos + 1.75)); //2
            lineSegments.add(new LineSegment(xpos + 1.5, ypos + 0.25, xpos + 1.5, ypos + 1.75)); //1

        }//rotation 2
        else if (tempL.get(0).p2().x() > (xpos + 2.0) && rotation == 2) {
            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos + 2.0, ypos + 1.75, xpos + 2.0, ypos + 0.25)); //1
            lineSegments.add(new LineSegment(xpos + 1.5, ypos + 1.75, xpos + 1.5, ypos + 0.25)); //2

        } else if (tempL.get(1).p2().y() > (ypos + 2.0) && rotation == 2) {

            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos + 1.75, ypos + 1.5, xpos + 0.25, ypos + 1.5)); //2
            lineSegments.add(new LineSegment(xpos + 1.75, ypos + 2.0, xpos + 0.25, ypos + 2.0)); //1

        }//rotation 3
        else if (tempL.get(0).p2().y() > (ypos + 2.0) && rotation == 3) {
            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos + 0.25, ypos + 2.0, xpos + 1.75, ypos + 2.0)); //2
            lineSegments.add(new LineSegment(xpos + 0.25, ypos + 1.5, xpos + 1.75, ypos + 1.5)); //1

        } else if (tempL.get(1).p2().x() < xpos && rotation == 3) {

            lineSegments.clear();
            lineSegments.add(new LineSegment(xpos + 0.5, ypos + 1.75, xpos + 0.5, ypos + 0.25)); //2
            lineSegments.add(new LineSegment(xpos, ypos + 1.75, xpos, ypos + 0.25)); //1


        } else {
            lineSegments = tempL;
        }
    }

    @Override
    public void setKeyPress() {
        keyPress = !keyPress;
    }


    @Override
    public double getAngVel() {
        return angVel;
    }

    @Override
    public boolean getMoving() {
        return moving;
    }


    @Override
    protected void createCircles() {

    }

    @Override
    public void rotate() {
        rotation = (++rotation) % 4;
        circles.clear();
        lineSegments.clear();

        if (rotation == 0) {
            circles.add(new Circle(xpos + 1.75, ypos + 0.25, 0.25));
            circles.add(new Circle(xpos + 1.75, ypos + 1.75, 0.25));

            lineSegments.add(new LineSegment(xpos + 2.0, ypos + 0.25, xpos + 2.0, ypos + 1.75));
            lineSegments.add(new LineSegment(xpos + 1.5, ypos + 0.25, xpos + 1.5, ypos + 1.75));
        } else if (rotation == 1) {
            circles.add(new Circle(xpos + 1.75, ypos + 1.75, 0.25));
            circles.add(new Circle(xpos + 0.25, ypos + 1.75, 0.25));

            lineSegments.add(new LineSegment(xpos + 1.75, ypos + 2.0, xpos + 0.25, ypos + 2.0));
            lineSegments.add(new LineSegment(xpos + 1.75, ypos + 1.5, xpos + 0.25, ypos + 1.5));
        } else if (rotation == 2) {

            circles.add(new Circle(xpos + 0.25, ypos + 1.75, 0.25));
            circles.add(new Circle(xpos + 0.25, ypos + 0.25, 0.25));

            lineSegments.add(new LineSegment(xpos, ypos + 0.25, xpos, ypos + 1.75));
            lineSegments.add(new LineSegment(xpos + 0.5, ypos + 0.25, xpos + 0.5, ypos + 1.75));
        } else if (rotation == 3) {
            circles.add(new Circle(xpos + 1.75, ypos + 0.25, 0.25));
            circles.add(new Circle(xpos + 0.25, ypos + 0.25, 0.25));

            lineSegments.add(new LineSegment(xpos, ypos + 1.75, xpos, ypos + 0.25));
            lineSegments.add(new LineSegment(xpos + 1.5, ypos + 0.25, xpos + 1.5, ypos + 1.75));
        }

    }

    @Override
    protected void createLines() {

    }
}
