package Model;

import Model.Gizmos.IGizmo;
import java.util.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

public class Board extends Observable{

	private static final float DEFAULT_GRAVITY = 25f;
	private static final float DEFAULT_MU = 0.025f;
	private static final float DEFAULT_MU2 = 0.025f;

	private boolean playMode;
	private Ball gizmoBall;
	private IGizmo[][] grid;
	private Wall[] walls ;
	private float gravity, mu, mu2;
	private ArrayList<Connector> connectors;

	private HashMap<String,IGizmo> gizmoHashMap;

	private Absorber absorber;

	private Observer observer;


	/*
		Creates a default build Board
	 */
	public Board(){
		gravity = DEFAULT_GRAVITY;
		mu = DEFAULT_MU;
		mu2 = DEFAULT_MU2;

		grid = new IGizmo[20][20];
		connectors = new ArrayList<>();
		gizmoHashMap = new HashMap<>();

		walls = new Wall[4];

		playMode = false;


	}

	public void addGizmoBall(Ball ball){
		this.gizmoBall = ball;

	}

	public int addAbsorber(){

	}

	public void setFriction(float mu, float mu2){
		this.mu = mu;
		this.mu2 = mu2;
	}

	public void setGravity(float gravity){
		this.gravity = gravity;
	}

	public Ball getGizmoBall() {
		return gizmoBall;
	}


	public boolean addConnector(String name1, String name2){
		IGizmo gizmoSource, gizmoTarget;

		try{
			gizmoSource = getGizmoByID(name1);
			gizmoTarget = getGizmoByID(name2);

			connectors.add(new Connector(gizmoSource,gizmoTarget));
			return true;

		}catch (NoSuchGizmoException e){
			return false;
		}
	}

	public void removeConnector(IGizmo gizmo){
		for (Connector connection: connectors) {
			if (connection.getSource().equals(gizmo)||connection.getTarget().equals(gizmo)){
				connectors.remove(connection);
			}
		}
	}

	/**
	 *
	 * @param gizmo
	 * @param x coordinate left to right on grid from 0 to 19
	 * @param y coordinate top to bottom on grid from 0 to 19
	 * @return
	 */
	public boolean addGizmo(IGizmo gizmo, int x, int y){

		//TODO Clean these if statements works well for now
		if ((x >=0 && x <= 19)&& (y >=0 && y <= 19)) {
			String gizmoClass = gizmo.getClass().getSimpleName();
			if ((gizmoClass.equals("LeftFlipper") || gizmoClass.equals("RightFlipper"))&& (x <19 && y<19)){
				if ((grid[x][y] ==null) && (grid[x][y+1] ==null) && (grid[x+1][y] ==null) && (grid[x+1][y+1]==null)){
					grid[x][y] = gizmo;
					grid[x][y+1] = gizmo;
					grid[x+1][y] = gizmo;
					grid[x+1][y+1] = gizmo;

					return true;
				}else{
					//One of 4 grid locs required for flipper is occupied
					return false;
				}
			}else if(grid[x][y] == null) {
				grid[x][y] = gizmo;
				gizmoHashMap.put(gizmo.getID(),gizmo);
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

	public boolean deleteGizmo(int x, int y){
		if ((x >=0 && x <= 19)&& (y >=0 && y <= 19)) {
			grid[x][y] = null;
			return true;
		}else{
			//Cords out of range
			return false;
		}
	}

	public boolean deleteGizmo(String id){
	return false;
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

	public boolean isPlayMode() {
		return playMode;
	}
	public ArrayList<IGizmo> getGizmos(){return new ArrayList<>(gizmoHashMap.values());}
	public ArrayList<Connector> getConnectors(){return new ArrayList<>(connectors);}


}
