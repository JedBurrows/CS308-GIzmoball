package Model.Gizmos;

import Model.Ball;
import Model.Board;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class RightFlipperTest {
    RightFlipper flipper;
    Board board;
    Ball ball;
    @Before
    public void setUp() throws Exception {
        board = new Board();
        ball = new Ball("ball",4.5f,7f,0f,0f);
        flipper = new RightFlipper("LF",5,6, Color.RED,false);
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
    }

    @Test
    public void createCircles1() throws Exception {
    }

    @Test
    public void rotate() throws Exception {
    }

    @Test
    public void getAngVel() throws Exception {
    }

    @Test
    public void getMoving() throws Exception {
    }

    @Test
    public void createLines1() throws Exception {
    }

}