package Model;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.HashMap;

public class CollisionDetails {

    private double minTime;
    private Circle ball;
    private Vect ballVelocity;
    private Vect velocityAfterCollision;

    public CollisionDetails(){

    }

    /**
     *Calculates minimum time until collision
     **/

    public void calculateMinTime(Ball ball, Board gameboard){
        double time;
        this.ball = ball.getCircle();
        ballVelocity = ball.getVelocity();
        ArrayList<IGizmo> gizmos = gameboard.getGizmos();
        ArrayList<Circle> componentCircles;
        ArrayList<LineSegment> componentLines;

        for(IGizmo gizmo : gizmos){
            componentCircles = gizmo.getCircles();
            componentLines = gizmo.getLines();

            for (Circle componentCircle : componentCircles){
                time = Geometry.timeUntilCircleCollision(componentCircle, this.ball, ballVelocity);
                if (time < minTime)
                    minTime = time;
            }
            for (LineSegment line: componentLines){
                time = Geometry.timeUntilWallCollision(line, this.ball, ballVelocity);
                if (time < minTime)
                    minTime = time;
            }
        }
    }



    private double getMinTime(){
        return minTime;
    }


}