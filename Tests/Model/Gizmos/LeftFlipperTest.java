package Model.Gizmos;

import Model.Ball;
import Model.Board;
import Model.Gizmos.LeftFlipper;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class LeftFlipperTest {
    LeftFlipper flipper;
    Board board;
    Ball ball;
    @Before
    public void setUp() throws Exception {
        board = new Board();
        ball = new Ball("ball",4.5f,7f,0f,0f);
        flipper = new LeftFlipper("LF",5,6, Color.RED,false);
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
    }

    @Test
    public void createLines1() throws Exception {
    }

}