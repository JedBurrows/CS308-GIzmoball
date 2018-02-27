package Model;

import java.awt.*;
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
	 * ComponentCircle 'C'+ number
	 * Square 'S'+ number
	 * Flippers 'RF' /'LF' + number
	 * Balls 'B' + number
	 *
	 */
	public String getID();

	public Boolean move(int x, int y);


    ArrayList<ComponentCircle> getCircles();

	ArrayList<Line> getLines();

	void draw(Graphics2D g2);

}