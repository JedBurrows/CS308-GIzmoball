package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.*;

public class Board extends Observable implements IBoard {

    private static final float DEFAULT_GRAVITY = 25f;
    private static final float DEFAULT_MU = 0.025f;
    private static final float DEFAULT_MU2 = 0.025f;

    double moveTime;

    private boolean runMode;
    private boolean[][] grid;
    private float gravity, mu, mu2;
    private ArrayList<Connector> connectors;
    private HashMap<String, IGizmo> gizmoHashMap;
    private Absorber absorber;
    private Observer observer;

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

        connectors = new ArrayList<>();
        gizmoHashMap = new HashMap<>();

        runMode = false;

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

    public boolean setAbsorber(Absorber absorber) {
        if (this.absorber == null && absorber.getyPos1() == absorber.getyPos2()) {
            int x1 = absorber.getxPos1(), y1 = absorber.getyPos1(), x2 = absorber.getxPos2(), y2 = absorber.getyPos2();
            for (int xPos = x1; xPos < x2; xPos++) {
                for (int yPos = y1; yPos < y2; yPos++) {
                    grid[xPos][yPos] = true;
                }

            }
            this.absorber = absorber;
            return true;
        }
        return false;
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

    public void setGravity(float g) {
        this.gravity = g;
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
     * @return
     */
    public boolean addGizmo(IGizmo gizmo) {

        int x = (int) gizmo.getxPos();
        int y = (int) gizmo.getyPos();
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

            int x = (int) deletedGizmo.getxPos(), y = (int) deletedGizmo.getyPos();
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

                        addGizmo(gizmo);

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
            if (x > g.getxPos() && x < (g.getxPos() + g.getWidth()) && y > g.getyPos() && y < (g.getyPos() + g.getHeight())) {
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
        }else{
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

        for (IGizmo g : gizmoHashMap.values()) {
            for (LineSegment line : g.getLines()) {
                if (g.getMoving()) {
                    time = Geometry.timeUntilRotatingWallCollision(line, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
                } else {
                    time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
                }
                if (time < shortestTime) {
                    shortestTime = time;

                    if (g.getMoving()) {
                        newVelo = Geometry.reflectRotatingWall(line, g.getCircles().get(0).getCenter(), Math.toRadians(g.getAngVel()), ballCircle, ballVelocity);
                    }else{
                        newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);

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


}
