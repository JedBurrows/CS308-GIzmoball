package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

	private static final float DEFAULT_GRAVITY = 25f;
	private static final float DEFAULT_MU = 0.025f;
	private static final float DEFAULT_MU2 = 0.025f;

	private boolean playMode;
	private Ball gizmoBall;
	private ArrayList<IGizmo> gizmos;
	private IGizmo[][] grid = new IGizmo[20][20];
	private Wall[] walls = new Wall[4];
	private ArrayList<Chain> chains = new ArrayList<>();
	private float gravity, mu, mu2;
	private HashMap<String,IGizmo> gizmoHashMap = new HashMap<>();
	private ArrayList<Connector> connectors = new ArrayList<>();
	private float gravity, mu, mu2;


	/*
		Creates a default build Board
	 */
	public Board(){
		gravity = DEFAULT_GRAVITY;
		mu = DEFAULT_MU;
		mu2 = DEFAULT_MU2;


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


    public ArrayList<IGizmo> getGizmos() {
        return gizmos;
    }

    public boolean addGizmo(IGizmo gizmo, int x, int y){
		if (grid[x][y]==null){
			grid[x][y] = gizmo;
			return true;
		}
		else{
			return false;
		}
	}

	public boolean moveGizmo(){
    	return false;

	}

	public boolean deleteGizmo(){
		return false;

	}

	//TODO Change to boolean, allow for collection of gizmoballs referenced by HashMap from unique name(key) > ball (value) and return false if ball with specified name already exists.
	public void addGizmoBall(Ball gizmoBall){
    	this.gizmoBall = gizmoBall;


	}
	public IGizmo getGizmoByID(String id){
		if (gizmoHashMap.containsKey(id)){
			return gizmoHashMap.get(id);
		}else {
			return null;
		}


	}

}
