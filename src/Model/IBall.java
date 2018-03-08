package Model;

import physics.Circle;
import physics.Vect;
import java.awt.*;

public interface IBall {

    public Vect getVelo();

    public void setVelo(Vect v);

    public double getRadius();

    public Circle getCircle();

    public float getXPos();

    public float getYPos();

    public String getName();

    public void setXPos(float x1);

    public void setYPos(float y1);

    public void stop();

    public void start();

    public boolean stopped();

    public Color getColour();
}
