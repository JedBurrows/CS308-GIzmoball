package model;
import java.awt.Graphics;
import javax.swing.JPanel;
import physics.Vect;
import physics.Circle;


public class Ball extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawOval(0,0,150,150);

    }



    private String name;
    private float x;
    private float y;
    private float vx;
    private float vy;
    private double radius;
    private Circle circle;


    public Ball(){
        /*name = n;
        x = x_coordinate;
        y = y_coordinate;
        vx = x_vector;
        vy =y_vector;
        radius = 0.2;
        circle = new Circle(new Vect(x,y), radius);*/
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

 /*   public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }*/

    public float getVX() {
        return vx;
    }

    public float getVY() {
        return vy;
    }
}






