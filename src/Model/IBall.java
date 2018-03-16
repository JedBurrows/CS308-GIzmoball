package Model;

import physics.Circle;
import physics.Vect;

import java.awt.*;

public interface IBall {

	Vect getVelo();

	void setVelo(Vect v);

	double getRadius();

	Circle getCircle();

	float getXPos();

	void setXPos(float x1);

	float getYPos();

	void setYPos(float y1);

	String getName();

	void stop();

	void start();

	boolean stopped();

	Color getColour();
}
