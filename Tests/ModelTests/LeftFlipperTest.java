package ModelTests;

import Model.Gizmos.LeftFlipper;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class LeftFlipperTest {
    LeftFlipper flipper;
    @Before
    public void setUp() throws Exception {
        flipper = new LeftFlipper("LF",5,6, Color.RED,false);
    }

    @Test
    public void action() throws Exception {
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