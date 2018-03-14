package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Flipper implements IGizmo {
	private double xpos;
	private double ypos;
	private double x2pos;
	private double y2pos;

	private double maxAngle;
	private double minAngle;
	private double angle ;
	private double angVel;

	private boolean moving;

	//left = false //right = true
	private boolean direction;
	private boolean keyPress;
	//status of activated or not
	//left and right flipper class

    private String id;
    private ArrayList<LineSegment> lines;
    private ArrayList<Circle> circles;

	//In reference to the flipper this is the Northwest corner pos on grid
	private int rotation, orientation;


	public Flipper(String i, int x, int y, boolean d) {
		id = i;

		rotation = 0;

		direction = d;

		orientation = 0;
		moving = false;
		xpos = x;
		ypos = y;
		x2pos = xpos;
		y2pos = ypos + 2;
		maxAngle = 90;
		minAngle = 0;
		angle = 90;
		angVel = 1080;
		keyPress = false;

        System.out.println("xpos: " + xpos);
        System.out.println("ypos: " + ypos);
        System.out.println("x2pos: " + x2pos);
        System.out.println("y2pos: " + y2pos);
        circles = new ArrayList<>();
        lines = new ArrayList<>();
        circles.add(new Circle(xpos+ 0.125, ypos + 0.125, 0.25));
        circles.add(new Circle(x2pos+ 0.125, y2pos -0.125, 0.25));
        lines.add(new LineSegment(xpos + 0.5, ypos + 0.25, x2pos + 0.5, y2pos -0.25));
        lines.add(new LineSegment(x2pos, y2pos + 0.25, x2pos, y2pos -0.25));


        createCircles();
        createLines();

	}


    @Override
    public void action(double tickTime) {
		moving = false;
		if (!keyPress) {
            if (angle < maxAngle) {
				if (angVel < 0){
					angVel = - angVel;
				}
                angle = angle + (angVel * tickTime);
                if (angle >= 90) {
                    angle = 90;
                }else{
                	moving = true;
				}
                if (!direction) {
                    x2pos = xpos + (2.0 * Math.cos(Math.toRadians(angle)));
                } else {
                    x2pos = xpos - (2.0 * Math.cos(Math.toRadians(angle)));
                }
                y2pos = ypos + (2.0 * Math.sin(Math.toRadians(angle)));
            }
        } else if (keyPress) {
			if (angle >= minAngle) {
				if (angVel > 0){
					angVel = - angVel;
				}
				angle = angle + (angVel * tickTime);
                if (angle < 0) {
                    angle = 0;
                }else{
                	moving = true;
				}
                if (!direction) {
                    x2pos = xpos + (2.0 * Math.cos(Math.toRadians(angle)));
				} else {
                    x2pos = xpos - (2.0 * Math.cos(Math.toRadians(angle)));
				}
				y2pos = ypos + (2.0 * Math.sin(Math.toRadians(angle)));



			}
        }
        createCircles();
        createLines();
    }

	@Override
	public void rotate() {
		rotation = (rotation + 1) % 4;

	}

	@Override
	public int getRotation() {
		return rotation;
	}

	public int getOrientation() {
		return orientation;
	}

	@Override
	public String getID() {
		return id;
	}

    @Override
    public void createCircles() {
        circles.removeAll(circles);
        double angleDivider = angle / 90.0;


		if (!direction) {
			double xDivider = (angleDivider * 0.5) - 0.25;
			double yDivider = 0.25 - (angleDivider * 0.5);
			circles.add(new Circle(xpos+ 0.25, ypos + 0.25, 0.25));
			circles.add(new Circle(x2pos+ xDivider, y2pos + yDivider, 0.25));
        }else{
			double xDivider = 1.25-(angleDivider * 0.5);
			double yDivider = 0.25 - (angleDivider * 0.5);
			circles.add(new Circle(xpos+ 0.75, ypos + 0.25, 0.25));
			circles.add(new Circle(x2pos+ xDivider, y2pos + yDivider, 0.25));

		}
    }

    @Override
    public void createLines() {
        lines.removeAll(lines);

        double angleDivider = angle / 90.0;

        if (!direction) {
        	double l1x1Divider = 0.25 - (angleDivider * 0.25);
			double l1y1Divider = 0.5 - (angleDivider * 0.25);
			double l1x2Divider = (angleDivider * 0.25) - 0.25;
			double l1y2Divider = 0.5 - (angleDivider * 0.75);

			double l2x1Divider = (angleDivider * 0.25) + 0.25 ;
			double l2y1Divider = (angleDivider * 0.25);
			double l2x2Divider = (angleDivider * 0.75) - 0.25;
			double l2y2Divider = -(angleDivider * 0.25);

           lines.add(new LineSegment(xpos + l1x1Divider, ypos + l1y1Divider, x2pos + l1x2Divider, y2pos + l1y2Divider));
           lines.add(new LineSegment(xpos + l2x1Divider, ypos + l2y1Divider, x2pos + l2x2Divider, y2pos + l2y2Divider));
        }else{
			double l1x1Divider = 0.75 - (angleDivider * 0.25);
			double l1y1Divider = (angleDivider * 0.25);
			double l1x2Divider = 1.25 - (angleDivider * 0.75);
			double l1y2Divider = -(angleDivider * 0.25);

			double l2x1Divider = (angleDivider * 0.25) + 0.75 ;
			double l2y1Divider = 0.5- (angleDivider * 0.25);
			double l2x2Divider = 1.25 - (angleDivider * 0.25);
			double l2y2Divider = 0.5 -(angleDivider * 0.75);

			lines.add(new LineSegment(xpos + l1x1Divider, ypos + l1y1Divider, x2pos + l1x2Divider, y2pos + l1y2Divider));
			lines.add(new LineSegment(xpos + l2x1Divider, ypos + l2y1Divider, x2pos + l2x2Divider, y2pos + l2y2Divider));

		}

    }

	@Override
	public ArrayList<Circle> getCircles() {
		return circles;
	}

	@Override
	public ArrayList<LineSegment> getLines() {
		return lines;
	}

	@Override
	public int getxPos() {
		return (int)xpos;
	}

	@Override
	public int getyPos() {
		return (int)ypos;
	}

	@Override
	public int getx2Pos() {
		return (int)x2pos;
	}

	@Override
	public int gety2Pos() {
		return(int)y2pos;
	}

	@Override
	public int getWidth() {
		if (direction){
			return -2;
		}
		return 2;
	}

	@Override
	public int getHeight() {

		return 2;
	}

	@Override
	public void setxPos(int x) {
		this.xpos = x;
	}

	@Override
	public void setyPos(int y) {
		this.ypos = y;
	}

	public double getAngle(){
		return angle;
	}

    public double getY() {
        return ypos;
    }

	public void setKeyPress(){
		keyPress = !keyPress;
	}

    @Override
	public boolean getDirection() {
		return direction;
	}

	@Override
	public double getAngVel() {
		return angVel;
	}

	@Override
	public boolean getMoving() {
		return moving;
	}


}
