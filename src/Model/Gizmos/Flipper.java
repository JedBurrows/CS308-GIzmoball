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


	public Flipper(String id,int orientation){
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
