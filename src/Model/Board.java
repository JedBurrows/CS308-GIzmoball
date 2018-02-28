package Model;

import Model.Gizmos.IGizmo;

import java.util.*;

public class Board extends Observable {

	private static final float DEFAULT_GRAVITY = 25f;
	private static final float DEFAULT_MU = 0.025f;
	private static final float DEFAULT_MU2 = 0.025f;

	private boolean playMode;
	private Ball gizmoBall;
	private boolean[][] grid;
	private Walls walls;
	private float gravity, mu, mu2;
	private ArrayList<Connector> connectors;

	private HashMap<String, IGizmo> gizmoHashMap;

	private Absorber absorber;

	private Observer observer;


	/*
		Creates a default build Board
	 */
	public Board() {
		gravity = DEFAULT_GRAVITY;
		mu = DEFAULT_MU;
		mu2 = DEFAULT_MU2;

		grid = new boolean[20][20];
		for (boolean[] row : grid) {
			Arrays.fill(row, false);
		}

		connectors = new ArrayList<>();
		gizmoHashMap = new HashMap<>();

		walls = new Walls(0, 0, 20, 20);

		playMode = false;


	}

	public void addGizmoBall(Ball ball) {
		this.gizmoBall = ball;

	}

	public boolean setAbsorber(Absorber absorber) {
		int x1 = absorber.getxPos1(), y1 = absorber.getyPos1(), x2 = absorber.getxPos2(), y2 = absorber.getyPos2();
		for (int xPos = x1; xPos < x2; xPos++) {
			for (int yPos = y1; yPos < y2; yPos++) {
				grid[xPos][yPos] = true;
			}

		}
		this.absorber = absorber;
		return true;
	}

	public boolean hasAbsorber() {
		if (absorber != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasGizmoBall() {
		if (gizmoBall != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setFriction(float mu, float mu2) {
		this.mu = mu;
		this.mu2 = mu2;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public Ball getGizmoBall() {
		return gizmoBall;
	}

	public Absorber getAbsorber() {
		return absorber;
	}


	public boolean addConnector(String name1, String name2) {
		IGizmo gizmoSource, gizmoTarget;

		try {
			gizmoSource = getGizmoByID(name1);
			gizmoTarget = getGizmoByID(name2);

			connectors.add(new Connector(gizmoSource, gizmoTarget));
			return true;

		} catch (NoSuchGizmoException e) {
			return false;
		}
	}

	public void removeConnector(IGizmo gizmo) {
		for (Connector connection : connectors) {
			if (connection.getSource().equals(gizmo) || connection.getTarget().equals(gizmo)) {
				connectors.remove(connection);
			}
		}
	}

	/**
	 * @param gizmo
	 * @param x     coordinate left to right on grid from 0 to 19
	 * @param y     coordinate top to bottom on grid from 0 to 19
	 * @return
	 */
	public boolean addGizmo(IGizmo gizmo, int x, int y) {

		//TODO Clean these if statements works well for now
		if ((x >= 0 && x <= 19) && (y >= 0 && y <= 19)) {
			String gizmoClass = gizmo.getClass().getSimpleName();
			if (gizmoClass.equals("Flipper") && (x < 19 && y < 19)) {
				if ((grid[x][y] == false) && (grid[x][y + 1] == false) && (grid[x + 1][y] == false) && (grid[x + 1][y + 1] == false)) {
					grid[x][y] = true;
					grid[x][y + 1] = true;
					grid[x + 1][y] = true;
					grid[x + 1][y + 1] = true;
					gizmoHashMap.put(gizmo.getID(), gizmo);


					return true;
				} else {
					//One of 4 grid locs required for flipper is occupied
					return false;
				}
			} else if (grid[x][y] == false) {
				grid[x][y] = true;
				gizmoHashMap.put(gizmo.getID(), gizmo);
				return true;
			} else {
				//Grid loc already occupied
				return false;
			}
		} else {
			//Cords out of range
			return false;
		}
	}


	public boolean deleteGizmo(String id) {
		if (gizmoHashMap.containsKey(id)) {
			IGizmo deletedGizmo = gizmoHashMap.remove(id);

			String type = deletedGizmo.getClass().getSimpleName();

			int x = deletedGizmo.getxPos(), y = deletedGizmo.getyPos();
			grid[x][y] = false;

			if (type.equals("Flipper")) {
				grid[x][y + 1] = false;
				grid[x + 1][y] = false;
				grid[x + 1][y + 1] = false;
			}
			return true;
		} else {
			//Doesnt exist
			return false;
		}

	}

	public boolean moveGizmo(String id, int newX, int newY) {
		try {
			IGizmo gizmo = getGizmoByID(id);
			String type = gizmo.getClass().getSimpleName();
			if ((newX >= 0 && newX <= 19) && (newY >= 0 && newY <= 19)) {
				String gizmoClass = gizmo.getClass().getSimpleName();
				if (gizmoClass.equals("Flipper") && (newX < 19 && newY < 19)) {
					if ((grid[newX][newY] == false) && (grid[newX][newY + 1] == false) && (grid[newX + 1][newY] == false) && (grid[newX + 1][newY + 1] == false)) {
						grid[newX][newY] = true;
						grid[newX][newY + 1] = true;
						grid[newX + 1][newY] = true;
						grid[newX + 1][newY + 1] = true;

						deleteGizmo(id);

						gizmo.setxPos(newX);
						gizmo.setyPos(newY);

						addGizmo(gizmo, newX, newY);

						return true;
					} else {
						//One of 4 grid locs required for flipper is occupied
						return false;
					}
				} else if (grid[newX][newY] == false) {
					grid[newY][newY] = true;

					deleteGizmo(id);

					gizmo.setxPos(newX);
					gizmo.setyPos(newY);

					addGizmo(gizmo, newX, newY);
					return true;
				} else {
					//Grid loc already occupied
					return false;
				}
			} else {
				//Cords out of range
				return false;
			}
		} catch (NoSuchGizmoException e) {
			return false;
		}
	}

	public boolean moveGizmoBall(String name, float x, float y) {

		if ((x >= 0.5 && x <= 19.5) && (y >= 0.5 && y <= 19.5)) {
			gizmoBall.setXPos(x);
			gizmoBall.setYPos(y);
			return true;

		} else {
			return false;
		}

	}

	public IGizmo getGizmoByID(String id) throws NoSuchGizmoException {

		if (gizmoHashMap.containsKey(id)) {
			return gizmoHashMap.get(id);
		} else {
			throw new NoSuchGizmoException("Gizmo with specified ID does not exist.");
		}


	}

	public class NoSuchGizmoException extends Exception {
		public NoSuchGizmoException() {
			super();
		}

		public NoSuchGizmoException(String message) {
			super(message);
		}

		public NoSuchGizmoException(String message, Throwable cause) {
			super(message, cause);
		}

		public NoSuchGizmoException(Throwable cause) {
			super(cause);
		}
	}

	public boolean isPlayMode() {
		return playMode;
	}

	public ArrayList<IGizmo> getGizmos() {
		return new ArrayList<>(gizmoHashMap.values());
	}

	public ArrayList<Connector> getConnectors() {
		return new ArrayList<>(connectors);
	}


}
