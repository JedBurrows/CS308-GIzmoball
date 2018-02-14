package Model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public interface IGizmo {

	/**
	 * Action performed by gizmo when struck by ball
	 */
	public void action();


	/**
	 * Rotate gizmo 90 deg
	 */
	public void rotate();


	/**
	 * Retruns ID of GIZMO
	 *
	 * ID's:
	 * Triangle 'T'+ number
	 * Circle 'C'+ number
	 * Square 'S'+ number
	 * Flippers 'RF' /'LF' + number
	 * Balls 'B' + number
	 *
	 */
	public String getID();


    ArrayList<Circle> getCircles();

	ArrayList<LineSegment> getLines();
}
