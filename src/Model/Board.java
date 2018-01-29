package Model;

import java.util.ArrayList;

public class Board {

	private boolean playMode;
	private Ball gizmoBall;
	private ArrayList<IGizmo> gizmos;
	private ArrayList<Wall> walls;
	private IGizmo[][] grid = new IGizmo[20][20];
	private Wall[] walls = new Wall[4];
	double gravity;


	/*
		Creates a default build Board
	 */
	public Board(){
		this(false);
	}


	/*
		
	 */
	public Board(boolean playMode){

		this.playMode=playMode;
	}



}
