package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.Absorber;
import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Board extends Observable implements IBoard {

	private static final float DEFAULT_GRAVITY = 25f;
	private static final float DEFAULT_MU = 0.025f;
	private static final float DEFAULT_MU2 = 0.025f;

	double moveTime;

    private boolean runMode;
    private boolean[][] grid;
    private float gravity, mu, mu2;
    private Set<IConnector> connectors;

    private HashMap<Integer, List<String>> keyPressEvents;
    private HashMap<Integer, List<String>> keyReleaseEvents;


    private HashMap<String, IGizmo> gizmoHashMap;
    private IGizmo collideGizmo;

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

        collideGizmo = null;

        walls = new Walls();

        keyPressEvents = new HashMap<>();
        keyReleaseEvents = new HashMap<>();


    }


	public boolean addGizmoBall(String name, float x, float y, float vx, float vy) {
	    if(!isInside(x,y)) {
            this.ball = new Ball(name, x, y, vx, vy);
            return true;
        }
        return false;
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
        try {
            Connector connector = new Connector(getGizmoByID(name1), getGizmoByID(name2));

            return connectors.remove(connector);

        } catch (NoSuchGizmoException e) {
            return false;

        } finally {

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

        if ((x >= 0 && x <= 19) && (y >= 0 && y <= 19) && !isOccupiedByBall(x,y)) {
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
            return true;
        } else {
            //Cords out of range
            return false;
        }

    }

    private boolean isOccupiedByBall(int x, int y) {
        if(hasGizmoBall()) {
            return x == (int) ball.getXPos() && y == (int) ball.getYPos();
        }
        return false;
    }

    public boolean deleteGizmo(String id) {
        if (gizmoHashMap.containsKey(id)) {
            IGizmo deletedGizmo = gizmoHashMap.remove(id);
            int x = deletedGizmo.getPos1().x, y = deletedGizmo.getPos1().y;


            int w = 0;
            while (w != deletedGizmo.getWidth()) {
                int h = 0;
                while (h != deletedGizmo.getHeight()) {
                    grid[x + w][y + h] = false;
                    if (deletedGizmo.getHeight() > 0) {
                        h++;
                    } else {
                        h--;
                    }
                }
                if (deletedGizmo.getWidth() > 0) {
                    w++;
                } else {
                    w--;
                }
            }
            return true;
        } else {
            //Doesnt exist
            return false;
        }

	}

	public boolean moveGizmo(String id, int newX, int newY) {

        try {

			if ((newX >= 0 && newX <= 19) && (newY >= 0 && newY <= 19)) {

				if (grid[newX][newY] == false) {
					grid[newY][newY] = true;
                    IGizmo gizmo = getGizmoByID(id);
                    GizmoCreator gc = new GizmoCreator();

                    addGizmo(gc.createGizmo(gizmo.getClass().getSimpleName(), id, newX, newY, gizmo.getColor()));
                    deleteGizmo(id);
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

    public Set<IConnector> getConnectors() {
        return connectors;
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

    @Override
    public float getMU() {
        return mu;
    }

    @Override
    public float getMU2() {
        return  mu2;
    }

    @Override
    public float getGravity() {
        return gravity;
    }

    public void gizmoAction(double moveTime) {
        for (IGizmo g : gizmoHashMap.values()) {
            g.action(moveTime, ball);
        }
    }


    public void moveBall() {

        //TODO Check for if in playMode then can move ball.
        // 0.05 = 20 times per second as per Gizmoball

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

                    if (collideGizmo!=null) {
                        for (IConnector c : connectors) {
                            if (c.getSource().getID().equals(collideGizmo.getID())) {
                                c.execute();
                            }
                        }
                    }
                    if(collideGizmo instanceof Absorber){
                        absorbBall(collideGizmo);
                    }
                    else{
                        ball.setVelo(cd.getVelo());
                    }
                    collideGizmo = null;

                }
                applyGravity(moveTime);
                applyFriction(moveTime);
                // Notify observers ... redraw updated view

            }
            this.setChanged();
            this.notifyObservers();
        }

    }

    public void absorbBall(IGizmo g){
        ball.setXPos((float)(g.getPos2().x - 0.5));
        ball.setYPos((float)(g.getPos2().y - 0.25));
        ball.setVelo(new Vect(0, 0));
    }


    private Ball movelBallForTime(Ball ball, double time) {

        float newX = 0.025f;
        float newY = 0.025f;
        float xVel = (float) ball.getVelo().x();
        float yVel = (float) ball.getVelo().y();
        newX = ball.getXPos() + (xVel * (float) time);
        newY = ball.getYPos() + (yVel * (float) time);
        ball.setXPos(newX);
        ball.setYPos(newY);

        return ball;
    }

    private void applyGravity(double time) {
        double oldSpeed = ball.getVelo().y();
        double newSpeed = oldSpeed + (gravity * time);

        ball.setVelo(new Vect(ball.getVelo().x(),newSpeed));
    }

    private void applyFriction(double time) {
        float mu = DEFAULT_MU; //0.025 per second
        float mu2 = DEFAULT_MU2; //0.025 per L

        mu /= moveTime;

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

        for (IGizmo g : gizmoHashMap.values()) {
            for (LineSegment line : g.getLineSegments()) {
                if (g.getMoving()) {
                    time = Geometry.timeUntilRotatingWallCollision(line, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
                } else {
                    time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
                }
                if (time < shortestTime) {
                    collideGizmo = g;
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
                    collideGizmo = g;
                    shortestTime = time;

                    if (g.getMoving()) {
                        newVelo = Geometry.reflectRotatingCircle(c, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
                    } else {
                        newVelo = Geometry.reflectCircle(c.getCenter(), ballCircle.getCenter(), ballVelocity);
                    }
                }
            }
        }

        ArrayList<LineSegment> lss = walls.getLineSegments();
        for (LineSegment line : lss) {
            time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
            if (time < shortestTime) {
                collideGizmo = null;
                shortestTime = time;
                newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
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

    public boolean addKeyPressEvent(int event, String id) {
        if (keyPressEvents.containsKey(event)) {
            keyPressEvents.get(event).add(id);
        } else {
            List<String> list = new ArrayList<>();
            list.add(id);
            keyPressEvents.put(event, list);
        }
        return true;

    }

    public boolean addKeyReleaseEvent(int event, String id) {

        if (keyReleaseEvents.containsKey(event)) {
            keyReleaseEvents.get(event).add(id);

        } else {
            List<String> list = new ArrayList<>();
            list.add(id);
            keyReleaseEvents.put(event, list);
        }
        return true;

    }

    private boolean isInside(float x,float y){
        for(IGizmo g : gizmoHashMap.values()){
            if(x >= g.getPos1().x && x <= g.getPos2().x && y >= g.getPos1().y && y <= g.getPos2().y){
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, List<String>> getKeyPressEvents() {
        return keyPressEvents;
    }

    public HashMap<Integer, List<String>> getKeyReleaseEvents() {
        return keyReleaseEvents;
    }
}
