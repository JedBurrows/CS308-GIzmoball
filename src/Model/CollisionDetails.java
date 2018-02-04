package Model;

import physics.Circle;
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
    public void calculateMinTime(Ball ball, ArrayList<Wall> walls, ArrayList<GizmoCircle> gizmoCircles){
        Circle ballCircle = ball.getCircle();
        Vect ballVelocity = ball.getVelocity();
        minTime = 0;
        calculateWallCollision( walls, ballCircle,  ballVelocity);
        calculateCircleCollision(gizmoCircles, ballCircle, ballVelocity);
        //calculate square, triangle and flipper collisions
        //calculate collisions with size zero circless

    }

    private void calculateCircleCollision(ArrayList<GizmoCircle> gizmoCircles, Circle ballCircle, Vect ballVelocity){
        for(GizmoCircle gizmoCircle : gizmoCircles){
            double time = Geometry.timeUntilCircleCollision(gizmoCircle.getCircle(), ballCircle, ballVelocity);
            if(minTime == 0)
                minTime = time;
            else if(time < minTime) {
                minTime = time;
                velocityAfterCollision = Geometry.reflectCircle(gizmoCircle.getCircle().getCenter(), ballCircle.getCenter(), ballVelocity, 1);
            }
        }
    }

    private void calculateWallCollision(ArrayList<Wall> walls, Circle ballCircle, Vect ballVelocity){
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
