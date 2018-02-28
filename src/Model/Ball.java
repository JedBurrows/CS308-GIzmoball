package Model;

import physics.Circle;
import physics.Vect;

import java.awt.*;


public class Ball {

	private String name;
	private float x;
	private float y;
	private Vect velocity;
	private double radius;
	private Color colour;
	private boolean stopped;

	public Ball(String name, float x, float y, float vx, float vy) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.velocity = new Vect(vx, vy);
		this.radius = 10;
		this.stopped = false;

	}

	public Vect getVelo() {
		return velocity;
	}

	public void setVelo(Vect v) {
		this.velocity = v;
	}

	public double getRadius() {
		return radius;
	}

	public Circle getCircle() {
		return new Circle(x, y, radius);

	}

	// Ball specific methods that deal with double precision.
	public float getXPos() {
		return x;
	}

	public float getYPos() {
		return y;
	}


	public String getName() {
		return name;
	}


	public void setXPos(float x) {
		this.x = x;
	}

	public void setYPos(float y) {
		this.y = y;
	}

	public void stop() {
		stopped = true;
	}

	public void start() {
		stopped = false;
	}

	public boolean stopped() {
		return stopped;
	}

	public Color getColour() {
		return colour;
	}

}






