package Model;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import physics.Vect;
import physics.Circle;


public class Ball {


    private String name;
    private float x;
    private float y;
    private float vx;
    private float vy;
    private double radius;
    private Circle circle;


    public Ball(String name, float x, float y, float vx, float vy){
        this.name = name;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy =vy;
    }


    public Circle getCircle() {
        return circle;
    }


    public Vect getVelocity(){
        Vect vector = new Vect(vx, vy);
        return vector;
    }


    public String getName() {
        return name;
    }

    public float getXPos() {
        return x;
    }

    public float getYPos() {
        return y;
    }
}






