package Model;

import java.util.ArrayList;

public class Board {

	private static final double DEFAULT_GRAVITY = 25;
	private static final double DEFAULT_MU = 0.025;
	private static final double DEFAULT_MU2 = 0.025;


	private boolean playMode;
	private Ball gizmoBall;
	private ArrayList<IGizmo> gizmos;
	private IGizmo[][] grid = new IGizmo[20][20];
	private Wall[] walls = new Wall[4];
	private ArrayList<Chain> chains = new ArrayList<>();
	private double gravity;
	private double mu;
	private double mu2;


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

	public void setGravity(){
		this.gravity = gravity;
	}

	public void addChain(){


	}



}
