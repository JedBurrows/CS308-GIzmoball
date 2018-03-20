package Model;

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
    }

    @Test
    public void setFriction() throws Exception {
    }

    @Test
    public void setGravity() throws Exception {
    }

    @Test
    public void getGizmoBall() throws Exception {
    }

    @Test
    public void addConnector() throws Exception {
    }

    @Test
    public void removeConnector() throws Exception {
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