package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class BoardTest {
    private IBoard board;
    private GizmoCreator gc;

    @Before
    public void setup(){
        board = new Board();
        gc = new GizmoCreator();
        board.addGizmo(gc.createGizmo("Square",  0, 0, Color.RED));
        board.addGizmo(gc.createGizmo("Square", 19, 0, Color.MAGENTA));
        board.addGizmo(gc.createGizmo("Square", 0, 19, Color.YELLOW));
        board.addGizmo(gc.createGizmo("Square", 19, 19, Color.BLUE));
        board.addConnector("S0000","S0019");
    }

    @Test
    public void addGizmo() throws Exception {
        assertTrue(board.addGizmo(gc.createGizmo("Square",  0, 1, Color.RED)));
        assertTrue(board.addGizmo((gc.createAbsorber(2,0,8,0,Color.RED))));
        assertFalse(board.addGizmo(gc.createGizmo("Circle",  0, 0, Color.RED)));
        assertFalse(board.addGizmo(gc.createGizmo("Triangle",  -1, 0, Color.RED)));
        assertFalse(board.addGizmo(gc.createGizmo("Square",  20, 0, Color.RED)));
        assertFalse(board.addGizmo(gc.createGizmo("Square",  0, -1, Color.RED)));
        assertFalse(board.addGizmo(gc.createGizmo("Square",  0, 20, Color.RED)));
        assertFalse(board.addGizmo(gc.createGizmo("LeftFlipper",  19, 0, Color.RED)));
        assertFalse(board.addGizmo(gc.createGizmo("RightFlipper",  0, 0, Color.RED)));
        assertFalse(board.addGizmo(gc.createGizmo("RightFlipper",  0, 19, Color.RED)));

    }


    @Test
    public void addGizmoBall() throws Exception {

    }

    @Test
    public void switchMode() throws Exception {
        assertFalse(board.isRunMode());
        board.switchMode();
        assertTrue(board.isRunMode());
    }

    @Test
    public void hasGizmoBall() throws Exception {
        assertFalse(board.hasGizmoBall());
        board.addGizmoBall("Ball",1,2,0,0);
        assertTrue(board.hasGizmoBall());
    }

    @Test
    public void setFriction() throws Exception {
        float mu = 0.010f;
        float mu2 = 0.033f;

        board.setFriction(mu,mu2);
        assertEquals(mu,board.getMU(),0.001);
        assertEquals(mu2,board.getMU2(),0.001);
    }

    @Test
    public void setGravity() throws Exception {
        float gravity = 5.0f;

        board.setGravity(gravity);
        assertEquals(gravity,board.getGravity(),0.01);
    }

    @Test
    public void getGizmoBall() throws Exception {
    }

    @Test
    public void addConnector() throws Exception {
        assertTrue(board.addConnector("S0019","S0000"));
        assertFalse(board.addConnector("S0000","S0019"));
        assertFalse(board.addConnector("S0000","None-Gizmo"));
    }

    @Test
    public void removeConnector() throws Exception {
        assertTrue(board.removeConnector("S0000","S0019"));
        assertFalse(board.removeConnector("S0000","S0019"));
        assertFalse(board.removeConnector("S0000","NoneGizmo"));
    }

    @Test
    public void deleteGizmo() throws Exception {
        board.addGizmo(gc.createGizmo("Square", "SQR", 0, 15, Color.YELLOW));

        assertTrue(board.deleteGizmo("SQR"));
        assertFalse(board.deleteGizmo("SQR1"));

    }

    @Test
    public void moveGizmo() throws Exception {
        board.addGizmo(gc.createGizmo("Square", "SQR", 0, 15, Color.YELLOW));

        assertTrue(board.moveGizmo("SQR", 5, 5));
        assertFalse(board.moveGizmo("SQR", 0, 0));
        assertFalse(board.moveGizmo("SQR1", 6, 6));
        assertFalse(board.moveGizmo("SQR", -1, 5));

    }

    @Test
    public void getGizmoByID() throws Exception {
        assertNotNull(board.getGizmoByID("S0019"));
    }

    @Test(expected = NoSuchGizmoException.class)
    public void getGizmoByIDException() throws Exception {
        board.getGizmoByID("None-Gizmo");
    }

    @Test
    public void isRunMode() throws Exception {
    }

    @Test
    public void getGizmos() throws Exception {
    }

    @Test
    public void getConnectors() throws Exception {
    }

    @Test
    public void getGizmoByPosition() throws Exception {
        assertNotNull(board.getGizmoByPosition(19.4,0.5));

        assertNull(board.getGizmoByPosition(0,0));
        assertNull(board.getGizmoByPosition(5.6,5.2));
        assertNull(board.getGizmoByPosition(-1,-13));
        assertNull(board.getGizmoByPosition(-1,13));
    }

    @Test
    public void deleteBall() throws Exception {
    }

    @Test
    public void isInsideBall() throws Exception {
    }

    @Test
    public void getMU() throws Exception {
        assertEquals(board.getMU(), 0.025, 0.0001);
    }

    @Test
    public void getMU2() throws Exception {
        assertEquals(board.getMU2(), 0.025, 0.0001);
    }

    @Test
    public void getGravity() throws Exception {
        assertEquals(board.getGravity(), 25, 0.01);
    }

    @Test
    public void gizmoAction() throws Exception {
    }

    @Test
    public void moveBall() throws Exception {
        board.addGizmoBall("Ball",1,2,0,0);
        Ball b = board.getGizmoBall();
        board.switchMode();
        for (int x = 0; x < 500; x ++) {
            board.moveBall();
            assertTrue(b.getXPos() >= 0 && b.getXPos() <= 19);
            assertTrue(b.getYPos() >= 0 && b.getYPos() <= 19);
        }


    }

    @Test
    public void absorbBall() throws Exception {
        Board board = new Board();
        IGizmo absorber = new Absorber("Absorber",5,18, 7, 18, Color.RED);
        Ball b = new Ball("ball",5.25f,7.75f,0f,0f);
        board.addGizmoBall("ball",4f,3f,5f,5f);
        assertFalse(b.getVelo().equals(board.getGizmoBall().getVelo()));
        board.absorbBall(absorber);
        assertTrue(b.getVelo().equals(board.getGizmoBall().getVelo()));
    }

    @Test
    public void getBall() throws Exception {
    }

    @Test
    public void setBallSpeed() throws Exception {
        Board board = new Board();
        board.addGizmoBall("ball",5.25f,7.75f,0f,0f);
        Ball ball1 = new Ball("ball1",6f,4f,0f,0f);
        Ball ball2 = new Ball("ball2",2f,3f,5f,5f);
        assertTrue(board.getGizmoBall().getVelo().equals(ball1.getVelo()));
        board.setBallSpeed(5,5);
        assertTrue(board.getGizmoBall().getVelo().equals(ball2.getVelo()));
    }

    @Test
    public void clearGizmos() throws Exception {
        assertTrue(board.getGizmos().size()==4);
        board.clearGizmos();
        assertTrue(board.getGizmos().size()==0);
    }

    @Test
    public void addKeyPressEvent() throws Exception {
    }

    @Test
    public void addKeyReleaseEvent() throws Exception {
    }

    @Test
    public void getKeyPressEvents() throws Exception {
    }

    @Test
    public void getKeyReleaseEvents() throws Exception {
    }

    @Test
    public void testGizmos()throws Exception{

        SquareTest squareTest = new SquareTest();
        squareTest.setup();
        squareTest.createCircles();
        squareTest.createLines();

        CircleTest circleTest = new CircleTest();
        circleTest.setup();
        circleTest.createCircles();
        circleTest.createLines();

        TriangleTest triangleTest = new TriangleTest();
        triangleTest.setup();
        triangleTest.createCircles();
        triangleTest.createLines();


    }

    @Test
    public void testAbstractGizmo() throws Exception {
        AbstractGizmoTest abstractGizmoTest = new AbstractGizmoTest();
        abstractGizmoTest.setup();
        abstractGizmoTest.getID();
        abstractGizmoTest.rotate();
        abstractGizmoTest.getRotation();
        abstractGizmoTest.getWidth();
        abstractGizmoTest.getHeight();
    }

}