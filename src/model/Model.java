package model;

import physics.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Model extends Observable {

    private ArrayList<LeftFlipper> leftFlippers;
    private ArrayList<RightFlipper> rightFlippers;
    private Ball ball;
    private Wall gws;

    public Model() {

        // Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
//        ball = new Ball(25, 25, 100, 100);

        // Wall size 500 x 500 pixels
        gws = new Wall(0, 0, 500, 500);
        // Lines added in Main
//        line = new ArrayList<VerticalLine>();
        leftFlippers = new ArrayList<LeftFlipper>();
        rightFlippers = new ArrayList<RightFlipper>();
    }

    public void moveBall() {

        double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball

//        if (ball != null && !ball.stopped()) {
//
//            CollisionDetails cd = timeUntilCollision();
//            double tuc = cd.getTuc();
//            if (tuc > moveTime) {
//                // No collision ...
//                ball = movelBallForTime(ball, moveTime);
//            } else {
//                // We've got a collision in tuc
//                ball = movelBallForTime(ball, tuc);
//                // Post collision velocity ...
//                ball.setVelo(cd.getVelo());
//            }

        // Notify observers ... redraw updated view
        this.flipLeftFlipper(moveTime);
        this.flipRightFlipper(moveTime);
        this.setChanged();
        this.notifyObservers();

    }

    public void flipLeftFlipper(double tickTime) {

        for (model.LeftFlipper lf : leftFlippers) {
            lf.flip(tickTime);
        }
    }

    public void flipRightFlipper(double tickTime) {

        for (model.RightFlipper rf : rightFlippers) {
            rf.flip(tickTime);
        }
    }

//    private Ball movelBallForTime(Ball ball, double time) {
//
//        double newX = 0.0;
//        double newY = 0.0;
//        double xVel = ball.getVelo().x();
//        double yVel = ball.getVelo().y();
//        newX = ball.getExactX() + (xVel * time);
//        newY = ball.getExactY() + (yVel * time);
//        ball.setExactX(newX);
//        ball.setExactY(newY);
//        return ball;
//    }


//    private CollisionDetails timeUntilCollision() {
//        // Find Time Until Collision and also, if there is a collision, the new speed vector.
//        // Create a physics.Circle from Ball
//        Circle ballCircle = ball.getCircle();
////        Vect ballVelocity = ball.getVelo();
//        Vect newVelo = new Vect(0, 0);
//
//        // Now find shortest time to hit a vertical line or a wall line
//        double shortestTime = Double.MAX_VALUE;
//        double time = 0.0;
//
//        // Time to collide with 4 walls
//        ArrayList<LineSegment> lss = gws.getLineSegments();
//        for (LineSegment line : lss) {
//            time = Geometry.timeUntilWallCollision(line, ballCircle, ballVelocity);
//            if (time < shortestTime) {
//                shortestTime = time;
//                newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
//            }
//        }
//
//        // Time to collide with any vertical lines
//        for (VerticalLine line : lines) {
//            LineSegment ls = line.getLineSeg();
//            time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
//            if (time < shortestTime) {
//                shortestTime = time;
//                newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
//            }
//        }

//		for (LeftFlipper line : leftFlippers) {
//			LineSegment ls = line.getLineSeg();
//			time = Geometry.timeUntilWallCollision(ls, ballCircle, ballVelocity);
//			if (time < shortestTime) {
//				shortestTime = time;
//				newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
//			}
//		}
//        return new CollisionDetails(shortestTime, newVelo);
//    }

    public Ball getBall() {
        return ball;
    }

//    public ArrayList<VerticalLine> getLines() {
//        return lines;
//    }

    public ArrayList<model.LeftFlipper> getLeftFlippers() {
        return leftFlippers;
    }
    public ArrayList<model.RightFlipper> getRightFlippers() {
        return rightFlippers;
    }


    public void addLeftFlipper(model.LeftFlipper lf) {
        leftFlippers.add(lf);
        System.out.println("flipper added: " + lf);
    }

    public void addRightFlipper(model.RightFlipper rf) {
        rightFlippers.add(rf);
        System.out.println("flipper added: " + rf);
    }

    public void removeLeftFlipper(model.LeftFlipper lf) {
        leftFlippers.remove(lf);
    }
}

//    public void addLine(VerticalLine l) {
//        lines.add(l);
//    }
//
//    public void removeLine(VerticalLine l) {
//        lines.remove(l);
//    }

//    public void setBallSpeed(int x, int y) {
//        ball.setVelo(new Vect(x, y));
//    }
//}
