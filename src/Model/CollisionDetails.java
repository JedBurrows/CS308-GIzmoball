package Model;

import Model.Gizmos.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;

public class CollisionDetails {

    private double minTime;
    private Vect velocityAfterCollision;

    public CollisionDetails(){

    }

    /**
    *Calculates minimum time until collision
    **/
    public void calculateMinTime(Ball ball, ArrayList<Wall> walls, ArrayList<Circle> circles){
        physics.Circle ballCircle = ball.getCircle();
        Vect ballVelocity = ball.getVelocity();
        minTime = 0;
        calculateWallCollision( walls, ballCircle,  ballVelocity);
        calculateCircleCollision(circles, ballCircle, ballVelocity);
        //calculate square, triangle and flipper collisions
        //calculate collisions with size zero circless

    }

    private void calculateCircleCollision(ArrayList<Circle> circles, physics.Circle ballCircle, Vect ballVelocity){
        for(Circle circle : circles){
            double time = Geometry.timeUntilCircleCollision(circle.getCircle(), ballCircle, ballVelocity);
            if(minTime == 0)
                minTime = time;
            else if(time < minTime) {
                minTime = time;
                velocityAfterCollision = Geometry.reflectCircle(circle.getCircle().getCenter(), ballCircle.getCenter(), ballVelocity, 1);
            }
        }
    }

    private void calculateWallCollision(ArrayList<Wall> walls, physics.Circle ballCircle, Vect ballVelocity){
        for(Wall wall : walls){
            LineSegment line = wall.getLine();
            double time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
            if(minTime == 0)
                minTime = time;
            else if(time < minTime) {
                minTime = time;
                velocityAfterCollision = Geometry.reflectWall(line, ballVelocity, 1);
            }
        }
    }

    private double getMinTime(){
        return minTime;
    }


}
