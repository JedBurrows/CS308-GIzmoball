package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.Square;
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
    }

    @Test
    public void getMU2() throws Exception {
    }

    @Test
    public void getGravity() throws Exception {
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
    }

    @Test
    public void getBall() throws Exception {
    }

    @Test
    public void setBallSpeed() throws Exception {
    }

    @Test
    public void clearGizmos() throws Exception {
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

}