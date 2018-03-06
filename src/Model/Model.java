package Model;

import Model.Gizmos.GizmoCircle;
import Model.Gizmos.IGizmo;
import Model.Gizmos.Square;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.Observable;


public class Model extends Observable {

	private ArrayList<IGizmo> gizmos;
	private ArrayList<LineSegment> lines;
	private ArrayList<Circle> circles;
	private Ball ball;
	private Walls walls;
	private static final double GRAVITY = 20;
	private int L;

	public Model() {

		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		ball = new Ball("1",25, 25, 1000, 1000);

		// Wall size 500 x 500 pixels
		walls = new Walls(0, 0, 500, 500);

		// Lines added in Proto3Main
		lines = new ArrayList<LineSegment>();
		circles = new ArrayList<Circle>();
		gizmos = new ArrayList<IGizmo>();

		gizmos.add(new Square("1", 150, 200));
		gizmos.add(new Square("2", 250, 200));
		gizmos.add(new Square("3", 350, 200));
		gizmos.add(new Square("4", 450, 200));
		gizmos.add(new Square("5", 10, 200));

		gizmos.add( new GizmoCircle("1", 200, 250));

		

	}

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
		double newSpeed = oldSpeed + (GRAVITY * time * L);

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

	public void addGizmo(IGizmo g) {
		gizmos.add(g);
		for (LineSegment l : g.getLines()) {
			lines.add(l);
		}
		for (Circle c : g.getCircles()) {
			circles.add(c);
		}
	}

	public void setL(double width){
		L = (int) width/20;
	}


	public ArrayList<IGizmo> getGizmos() {
		return gizmos;
	}

	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}
}
