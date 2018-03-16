package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.*;

public class Board extends Observable implements IBoard {

	private static final float DEFAULT_GRAVITY = 25f;
	private static final float DEFAULT_MU = 0.025f;
	private static final float DEFAULT_MU2 = 0.025f;

	double moveTime;

	private boolean runMode;
	private boolean[][] grid;
	private float gravity, mu, mu2;
	private Set<Connector> connectors;
	private HashMap<String, IGizmo> gizmoHashMap;
	private boolean absorbCollide;
	private boolean release;

	//---------------------------------------------

	private Ball ball;
	private Walls walls;


	/*
		Creates a default build Board
	 */
	public Board() {
		gravity = DEFAULT_GRAVITY;
		mu = DEFAULT_MU;
		mu2 = DEFAULT_MU2;

		moveTime = 0.05;

		grid = new boolean[20][20];
		for (boolean[] row : grid) {
			Arrays.fill(row, false);
		}

		connectors = new HashSet<>();
		gizmoHashMap = new HashMap<>();

		runMode = false;

		absorbCollide = false;
		release = false;

		//--------------------------------------------------

		//TODO Change from pixels to float in terms of L grid ie (x = 10.5,y = 5.5) is in centre of 11,6
		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick

		// Wall size 500 x 500 pixels
		walls = new Walls();

		// Lines added in Proto3Main


	}


	public void addGizmoBall(float x, float y) {
		this.ball = new Ball("ball", x, y, 0.1f, 0.1f);
	}

	public void switchMode() {
		runMode = !runMode;
	}



	public boolean hasGizmoBall() {
		return ball != null;
	}

	public void setFriction(float mu, float mu2) {
		this.mu = mu;
		this.mu2 = mu2;
	}

	public void setGravity(float g) {
		this.gravity = g;
	}

	public Ball getGizmoBall() {
		return ball;
	}



	public boolean addConnector(String name1, String name2) {
		try {
			Connector connection = new Connector(getGizmoByID(name1), getGizmoByID(name2));
			System.out.println("Connection hash code = " + connection.hashCode());

			if (connectors.contains(connection)) {
				return false;
			} else {
				connectors.add(connection);
				return true;
			}

		} catch (NoSuchGizmoException e) {
			return false;
		}
	}

	public boolean removeConnector(String name1, String name2) {
		System.out.println("Connectors size before removal = " + connectors.size());
		try {
			Connector connector = new Connector(getGizmoByID(name1), getGizmoByID(name2));

			return connectors.remove(connector);

		} catch (NoSuchGizmoException e) {
			return false;

		} finally {
			System.out.println("Connectors size after removal = " + connectors.size());
		}

	}

	/**
	 * @param gizmo
	 * @return
	 */
	public boolean addGizmo(IGizmo gizmo) {

		int x = gizmo.getPos1().x;
		int y = gizmo.getPos1().y;
		String gizmoClass = gizmo.getClass().getSimpleName();

		if ((x >= 0 && x <= 19) && (y >= 0 && y <= 19)) {
			int w = 0;
			while (w != gizmo.getWidth()) {
				int h = 0;
				while (h != gizmo.getHeight()) {
					if (grid[x + w][y + h]) {
						//something already in space
						return false;
					}
					if (gizmo.getHeight() > 0) {
						h++;
					} else {
						h--;
					}
				}
				if (gizmo.getWidth() > 0) {
					w++;
				} else {
					w--;
				}
			}
			w = 0;
			while (w != gizmo.getWidth()) {
				int h = 0;
				while (h != gizmo.getHeight()) {
					grid[x + w][y + h] = true;
					if (gizmo.getHeight() > 0) {
						h++;
					} else {
						h--;
					}
				}
				if (gizmo.getWidth() > 0) {
					w++;
				} else {
					w--;
				}
			}


			gizmoHashMap.put(gizmo.getID(), gizmo);
			System.out.println(gizmoClass + " gizmo added");
			return true;
		} else

		{
			//Cords out of range
			return false;
		}

	}

	public boolean deleteGizmo(String id) {
		if (gizmoHashMap.containsKey(id)) {
			IGizmo deletedGizmo = gizmoHashMap.remove(id);
			System.out.println("hereeeeeeee");
			String type = deletedGizmo.getClass().getSimpleName();

			int x = deletedGizmo.getPos1().x, y = deletedGizmo.getPos1().y;
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

						gizmo.getPos1().setLocation(newX, newY);
						gizmo.getPos1().setLocation(newX + gizmo.getWidth(), newY + gizmo.getHeight());

						addGizmo(gizmo);

						return true;
					} else {
						//One of 4 grid locs required for flipper is occupied
						return false;
					}
				} else if (grid[newX][newY] == false) {
					grid[newY][newY] = true;

					deleteGizmo(id);

					gizmo.getPos1().setLocation(newX, newY);
					gizmo.getPos1().setLocation(newX + gizmo.getWidth(), newY + gizmo.getHeight());

					addGizmo(gizmo);
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

	public IGizmo getGizmoByID(String id) throws NoSuchGizmoException {

		if (gizmoHashMap.containsKey(id)) {
			return gizmoHashMap.get(id);
		} else {
			throw new NoSuchGizmoException("Gizmo with specified ID does not exist.");
		}
	}

	public boolean isRunMode() {
		return runMode;
	}

	public ArrayList<IGizmo> getGizmos() {
		return new ArrayList<>(gizmoHashMap.values());
	}

	public ArrayList<Connector> getConnectors() {
		return new ArrayList<>(connectors);
	}

	public IGizmo getGizmoByPosition(double x, double y) {
		for (IGizmo g : gizmoHashMap.values()) {
			Point pos1 = g.getPos1(), pos2 = g.getPos2();
			if ((x > pos1.x && x < pos2.x) && (y > pos1.y && y < pos2.y)) {
				return g;
			}
		}
		return null;
	}

	@Override
	public void deleteBall() {
		ball = null;
	}

	public boolean isInsideBall(float x, float y) {
		if (hasGizmoBall()) {
			return (x >= ball.getXPos() - ball.getRadius() && x <= ball.getXPos() + ball.getRadius() && y >= ball.getYPos() - ball.getRadius() && y <= ball.getYPos() + ball.getRadius());
		} else {
			return false;
		}
	}

	//-------------------------------------------------------------------------------------------
	public void gizmoAction(double moveTime) {
		for (IGizmo g : gizmoHashMap.values()) {
			g.action(moveTime);
		}
	}


	public void moveBall() {

		//TODO Check for if in playMode then can move ball.
		// 0.05 = 20 times per second as per Gizmoball
		System.out.println("ball: " + ball);
		System.out.println("runMode: " + runMode);

		if (runMode) {
			double moveTime = 0.01;
			gizmoAction(moveTime);
			this.setChanged();
			this.notifyObservers();
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
					/*if (absorbCollide) {
						if (!release) {
							ball.setVelo(new Vect(0, 0));
							ball.setXPos(absorber.getPos2().x - 1);
							ball.setYPos(absorber.getPos1().y + 0.5f);
						} else {
							ball.setXPos(absorber.getPos2().x - 1);
							ball.setYPos(absorber.getPos1().y - 3);
							ball.setVelo(new Vect(-10, -40));
							absorbCollide = false;
							release = false;
						}
					}*/
				}

				// Notify observers ... redraw updated view

			}
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

		return ball;
	}

	private void applyGravity(double time) {
		double oldSpeed = ball.getVelo().y();
		double newSpeed = oldSpeed + (gravity * time);

		ball.setVelo(new Vect(ball.getVelo().x(), newSpeed));
	}

	private void applyFriction(double time) {
		double mu = DEFAULT_MU; //0.025 per second
		double mu2 = DEFAULT_MU2; //0.025 per L

		double newSpeedX = ball.getVelo().x() * (1 - (mu * time) - (mu2 * Math.abs(ball.getVelo().x())) * time);
		double newSpeedY = ball.getVelo().y() * (1 - (mu * time) - (mu2 * Math.abs(ball.getVelo().y())) * time);

		ball.setVelo(new Vect(newSpeedX, newSpeedY));
	}

	private CollisionDetails timeUntilCollision() {
		// Find Time Until Collision and also, if there is a collision, the new speed vector.
		// Create a Circle from Ball
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

		//Check if it's the abosrber
	/*	if (hasAbsorber()) {
			ArrayList<LineSegment> absorbLines = absorber.getLineSegments();
			for (LineSegment ls : absorbLines) {
				time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
				if (time < shortestTime) {
					shortestTime = time;
					absorbCollide = true;
					newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
				}
			}
		}*/

		for (IGizmo g : gizmoHashMap.values()) {
			for (LineSegment line : g.getLineSegments()) {
				if (g.getMoving()) {
					time = Geometry.timeUntilRotatingWallCollision(line, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
				} else {
					time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
				}
				if (time < shortestTime) {
					shortestTime = time;

					if (g.getMoving()) {
						newVelo = Geometry.reflectRotatingWall(line, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
					} else {
						newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);

					}
				}
			}
			for (Circle c : g.getCircles()) {
				if (g.getMoving()) {
					time = Geometry.timeUntilRotatingCircleCollision(c, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
				} else {
					time = Geometry.timeUntilCircleCollision(c, ballCircle, ballVelocity);
				}
				if (time < shortestTime) {

					shortestTime = time;

					if (g.getMoving()) {
						newVelo = Geometry.reflectRotatingCircle(c, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
					} else {
						newVelo = Geometry.reflectCircle(c.getCenter(), ballCircle.getCenter(), ballVelocity);
					}
				}
			}
		}

		return new CollisionDetails(shortestTime, newVelo);
	}

	public Ball getBall() {
		return ball;
	}

	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}


	public void clearGizmos() {
		ball = null;
		connectors.clear();
		gizmoHashMap.clear();
		for (boolean[] row : grid) {
			Arrays.fill(row, false);
		}

	}

	public boolean getAbsorbCollide() {
		return absorbCollide;
	}

	public void setRelease(boolean r) {
	}

	public void release() {
		release = true;
	}
}
