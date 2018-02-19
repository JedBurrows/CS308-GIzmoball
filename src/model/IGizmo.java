package model;

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
	 * GizmoCircle 'C'+ number
	 * Square 'S'+ number
	 * Flippers 'RF' /'LF' + number
	 * Balls 'B' + number
	 *
	 */
	public String getID();

	public Boolean move(int x, int y);













}
