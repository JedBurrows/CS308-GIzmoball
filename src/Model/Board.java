package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.*;

public class Board extends Observable implements IBoard{

	private static final float DEFAULT_GRAVITY = 25f;
	private static final float DEFAULT_MU = 0.025f;
	private static final float DEFAULT_MU2 = 0.025f;

	private boolean playMode;
	private boolean[][] grid;
	private float gravity, mu, mu2;
	private ArrayList<Connector> connectors;
	private HashMap<String, IGizmo> gizmoHashMap;
	private Absorber absorber;
	private Observer observer;
	
	//---------------------------------------------
	private ArrayList<LineSegment> lines;
	private ArrayList<Circle> circles;
	private Ball ball;
	private Walls walls;
	private int L;

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

		//--------------------------------------------------

		//TODO Change from pixels to float in terms of L grid ie (x = 10.5,y = 5.5) is in centre of 11,6
		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		ball = new Ball("1",25, 25, 1000, 1000);

		// Wall size 500 x 500 pixels
		walls = new Walls(0, 0, 500, 500);

		// Lines added in Proto3Main
		lines = new ArrayList<LineSegment>();
		circles = new ArrayList<Circle>();
	}

	public void addGizmoBall(Ball ball) {
		this.ball = ball;

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
		return absorber != null;
	}

	public boolean hasGizmoBall() {
		return ball != null;
	}

	public void setFriction(float mu, float mu2) {
		this.mu = mu;
		this.mu2 = mu2;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public Ball getGizmoBall() {
		return ball;
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

		//TODO Not used
        GizmoCreator gizmoCreator = new GizmoCreator();
		//TODO Clean these if statements works well for now

        String gizmoClass = gizmo.getClass().getSimpleName();
        System.out.println(gizmoClass);
		if ((x >= 0 && x <= 19) && (y >= 0 && y <= 19)) {

			if (gizmoClass.equals("Flipper") && (x < 19 && y < 19)) {
				if ((grid[x][y] == false) && (grid[x][y + 1] == false) && (grid[x + 1][y] == false) && (grid[x + 1][y + 1] == false)) {
					grid[x][y] = true;
					grid[x][y + 1] = true;
					grid[x + 1][y] = true;
					grid[x + 1][y + 1] = true;
					gizmoHashMap.put(gizmo.getID(), gizmo);  //ToDo add back in after flipper class fixed

					gizmoAddLinesAndCicles(gizmo);
					return true;
				} else {
					//One of 4 grid locs required for flipper is occupied
					return false;
				}
			} else if (grid[x][y] == false) {

				grid[x][y] = true;
				gizmoHashMap.put(gizmo.getID(), gizmo);
				gizmoAddLinesAndCicles(gizmo);
                System.out.println(gizmoClass + " gizmo added");
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

	private void gizmoAddLinesAndCicles(IGizmo g){
		for (LineSegment l : g.getLines()) {
			lines.add(l);
		}
		for (Circle c : g.getCircles()) {
			circles.add(c);
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
			ball.setXPos(x);
			ball.setYPos(y);
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

	public boolean isPlayMode() {
		return playMode;
	}

	public ArrayList<IGizmo> getGizmos() {
		return new ArrayList<>(gizmoHashMap.values());
	}

	public ArrayList<Connector> getConnectors() {
		return new ArrayList<>(connectors);
	}
	
	
	//-------------------------------------------------------------------------------------------


	public void moveBall() {

		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball

		if (ball != null && !ball.stopped()) {

			CollisionDetails cd = timeUntilCollision();
			double tuc = cd.getTuc();
			if (tuc > moveTime) {
				// No collision ...
				ball = movelBallForTime(ball, moveTime);
			} else {
				// We've got a collision in tuc
				ball = movelBallForTime(ball, tuc);
				// Post collision velocity ...
				ball.setVelo(cd.getVelo());
			}

			// Notify observers ... redraw updated view
			this.setChanged();
			this.notifyObservers();
		}

	}

	private Ball movelBallForTime(Ball ball, double time) {

		float newX = 0.0f;
		float newY = 0.0f;
		float xVel = (float) ball.getVelo().x();
		float yVel = (float) ball.getVelo().y();
		newX = ball.getXPos() + (xVel * (float) time);
		newY = ball.getYPos() + (yVel * (float) time);
		ball.setXPos(newX);
		ball.setYPos(newY);

		applyGravity(time);
		applyFriction(time);
		System.out.println(ball.getXPos());
		return ball;
	}

	private void applyGravity(double time){
		double oldSpeed = ball.getVelo().y();
		double newSpeed = oldSpeed + (DEFAULT_GRAVITY * time * L);

		ball.setVelo(new Vect(ball.getVelo().x(),newSpeed));
	}

	private void applyFriction(double time){
		double mu = 0.025 / 20; //0.025 per second
		double mu2 = 0.025 / L; //0.025 per L

		double newSpeedX = ball.getVelo().x() * (1 - (mu * time) - (mu2 * Math.abs(ball.getVelo().x())) * time) ;
		double newSpeedY = ball.getVelo().y() * (1 - (mu * time) - (mu2 * Math.abs(ball.getVelo().y())) * time);

		ball.setVelo(new Vect(newSpeedX,newSpeedY));
	}

	private CollisionDetails timeUntilCollision() {
		// Find Time Until Collision and also, if there is a collision, the new speed vector.
		// Create a physics.Circle from Ball
		Circle ballCircle = ball.getCircle();
		Vect ballVelocity = ball.getVelo();
		Vect newVelo = new Vect(0, 0);

		// Now find shortest time to hit a vertical line or a wall line
		double shortestTime = Double.MAX_VALUE;
		double time = 0.0;

		// Time to collide with 4 walls
		ArrayList<LineSegment> lss = walls.getLineSegments();
		for (LineSegment line : lss) {
			time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
			}
		}

//		ArrayList<LineSegment> gizmoLines = new ArrayList<LineSegment>();
//		ArrayList<Circle> gizmoCircle = new ArrayList<Circle>();
//
//		for (IGizmo g: gizmos){
//			for (g1 )
//			gizmoLines.add(g.getLines());
//			g.getCircles();
//		}

//		for (LineSegment gc : gizmoLines) {
//			time = Geometry.timeUntilWallCollision(gc, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(gc, ball.getVelo(), 1.0);
//			}
//		}


		for (LineSegment line : lss) {
			time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
			}
		}

		// Time to collide with any vertical lines
		for (LineSegment ls : lines) {
			time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
			}
		}

		// Time to collide with circles
		for (Circle c : circles) {
			time = Geometry.timeUntilCircleCollision(c, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectCircle(c.getCenter(), ballCircle.getCenter(), ballVelocity);
			}
		}


		return new CollisionDetails(shortestTime, newVelo);
	}

	public Ball getBall() {
		return ball;
	}

	public ArrayList<LineSegment> getLines() {
		return lines;
	}

	public ArrayList<Circle> getCircles() {
		return circles;
	}

	public void addLine(LineSegment l) {
		lines.add(l);
	}

	public void addCircle(Circle c) {
		circles.add(c);
	}

	@Override
	public void addGizmo(IGizmo g) {

	}

	public void setL(double width){
		L = (int) width/20;
	}

	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}




}
