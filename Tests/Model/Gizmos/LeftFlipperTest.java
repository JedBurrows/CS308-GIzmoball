package Model.Gizmos;

import Model.Ball;
import Model.Board;
import Model.Gizmos.LeftFlipper;
import org.junit.Before;
import org.junit.Test;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LeftFlipperTest {
    LeftFlipper flipper;
    LeftFlipper flipper2;
    Board board;
    Ball ball;
    @Before
    public void setUp() throws Exception {
        board = new Board();
        ball = new Ball("ball",4.5f,7f,0f,0f);
        flipper = new LeftFlipper("LF",5,6, Color.RED,false);
        flipper2 = new LeftFlipper("LF",13,10, Color.RED,false);
    }

    @Test
    public void action() throws Exception {
        assertTrue(flipper.getAngVel()==1080);
        flipper.setTrigger();
        flipper.action(0.2,ball);
        assertTrue(flipper.getAngVel()==-1080);



    }

    @Test
    public void createCircles() throws Exception {
    }

    @Test
    public void createLines() throws Exception {

        ArrayList<LineSegment> expectedLineSegments = new ArrayList<>();
        //Test rotate 1
        flipper2.rotate();
        flipper2.createLines(0.2);
        expectedLineSegments.add(new LineSegment(15.0, 10.25, 15.0, 11.75)); //1
        expectedLineSegments.add(new LineSegment(14.5, 10.25, 14.5, 11.75)); //2
        assertEquals(flipper2.getLineSegments(),expectedLineSegments);

        //Test rotate 2
        flipper2.rotate();
        flipper2.createLines(0.2);
        expectedLineSegments.clear();
        expectedLineSegments.add(new LineSegment(14.75, 11.5, 13.25, 11.5)); //1
        expectedLineSegments.add(new LineSegment(14.75, 12.0, 13.25, 12.0)); //2
        assertEquals(flipper2.getLineSegments(),expectedLineSegments);


        //Test rotate 3
        flipper2.rotate();
        flipper2.createLines(0.2);
        expectedLineSegments.clear();
        expectedLineSegments.add(new LineSegment(13.5, 11.75, 13.5, 10.25)); //2
        expectedLineSegments.add(new LineSegment(13, 11.75, 13, 10.25)); //1
        assertEquals(flipper2.getLineSegments(),expectedLineSegments);
    }

    @Test
    public void getAngVel() throws Exception {
    }

    @Test
    public void getMoving() throws Exception {
    }

    @Test
    public void rotate() throws Exception {
        assertTrue(flipper.getRotation() == 0);
        flipper.rotate();
        assertTrue(flipper.getRotation()==1);
        flipper.rotate();
        assertTrue(flipper.getRotation()==2);
        flipper.rotate();
        assertTrue(flipper.getRotation()==3);
        flipper.rotate();
        assertTrue(flipper.getRotation()==0);
    }

    @Test
    public void createLines1() throws Exception {
    }

}