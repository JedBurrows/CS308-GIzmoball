package Model.Gizmos;

import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public class Flipper implements IGizmo {

	//status of activated or not
	//left and right flipper class

	public static final int FLIPPER_LEFT = 0;
	public static final int FLIPPER_RIGHT = 1;

	private String id;

	//In reference to the flipper this is the Northwest corner pos on grid
	private int xPos, yPos, orientation;


	public Flipper(String id,int x,int y,int orientation){
		this.id = id;
		this.xPos =x;
		this.yPos = y;
		this.orientation=orientation;

	}


	@Override
	public void action() {

	}

	@Override
	public void rotate() {

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
