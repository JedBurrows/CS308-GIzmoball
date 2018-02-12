package Model;

import Model.Gizmos.IGizmo;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

	/*
		Final values
	 */
	private static final double DEFAULT_GRAVITY = 25;
	private static final double DEFAULT_MU = 0.025;
	private static final double DEFAULT_MU2 = 0.025;



	private boolean playMode;
	private Ball gizmoBall;

	/*
	Grid
			0					X cord			 19
		0	X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
		y	X X X X X X X X X X X X X X X X X X X X
	  cord	X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
			X X X X X X X X X X X X X X X X X X X X
		19	X X X X X X X X X X X X X X X X X X X X
	 */
	private IGizmo[][] grid = new IGizmo[20][20];
	private Wall[] walls = new Wall[4];
	private ArrayList<Connector> connectors = new ArrayList<>();
	private double gravity, mu, mu2;

	private HashMap<String,IGizmo> gizmoHashMap;


	/*
		Creates a default build Board
	 */
	public Board(){
		gravity = DEFAULT_GRAVITY;
		mu = DEFAULT_MU;
		mu2 = DEFAULT_MU2;


	}

	public void setFriction(double mu, double mu2){
		this.mu = mu;
		this.mu2 = mu2;

	}

	public Ball getGizmoBall() {
		return gizmoBall;
	}

	public void setGravity(double gravity){
		this.gravity = gravity;
	}

	public void addConnector(){
	}

	/**
	 *
	 * @param gizmo
	 * @param x coordinate left to right on grid from 0 to 19
	 * @param y coordinate top to bottom on grid from 0 to 19
	 * @return
	 */
	public boolean addGizmo(IGizmo gizmo, int x, int y){
		if ((x >=0 && x <= 19)&& (y >=0 && y <= 19)) {
			if (grid[x][y] != null) {
				grid[x][y] = gizmo;
				return true;
			} else {
				//Grid loc already occupied
				return false;
			}
		}else{
			//Cords out of range
			return false;
		}
	}

	public boolean removeGizmo(int x, int y){
		if ((x >=0 && x <= 19)&& (y >=0 && y <= 19)) {
			grid[x][y] = null;
			return true;
		}else{
			//Cords out of range
			return false;
		}
	}

	public IGizmo getGizmoByID(String id) throws NoSuchGizmoException{

		if (gizmoHashMap.containsKey(id)) {
			return gizmoHashMap.get(id);
		}
		else {
			throw new NoSuchGizmoException("Gizmo with specified ID does not exist.");
		}



	}

	public class NoSuchGizmoException extends Exception{
		public NoSuchGizmoException(){super();}
		public NoSuchGizmoException(String message) { super(message); }
		public NoSuchGizmoException(String message, Throwable cause) { super(message, cause); }
		public NoSuchGizmoException(Throwable cause) { super(cause); }
	}

    public ArrayList<IGizmo> getGizmos() {
        return gizmos;
    }
}
