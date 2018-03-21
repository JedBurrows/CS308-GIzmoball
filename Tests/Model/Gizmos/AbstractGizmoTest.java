package Model.Gizmos;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractGizmoTest {
	private AbstractGizmo gizmo;

	@Before
	public void setup() {
		gizmo = new AbstractGizmo("AG", 0, 0, 1, 1, Color.GRAY) {
			@Override
			protected void createCircles() {

			}

			@Override
			protected void createLines() {

			}
		};

	}

	@Test
	public void action() throws Exception {
	}

	@Test
	public void getID() throws Exception {
		assertTrue(gizmo.getID().equals("AG"));
	}

	@Test
	public void rotate() throws Exception {
		gizmo.rotate();
		assertTrue(gizmo.getRotation() == 1);
	}

	@Test
	public void getRotation() throws Exception {
		assertTrue(gizmo.getRotation() == 1);
		gizmo.rotate();
		assertTrue(gizmo.getRotation() == 2);
		gizmo.rotate();
		assertTrue(gizmo.getRotation() == 3);
		gizmo.rotate();
		assertTrue(gizmo.getRotation() == 0);

	}

	@Test
	public void getWidth() throws Exception {
		assertTrue(gizmo.getWidth() == 1);
	}

	@Test
	public void getHeight() throws Exception {
		assertTrue(gizmo.getHeight() == 1);
	}

	@Test
	public void getCircles() throws Exception {
	}

	@Test
	public void getLineSegments() throws Exception {
	}

	@Test
	public void getColor() throws Exception {
		assertTrue(gizmo.getColor().equals(Color.GRAY));
	}

	@Test
	public void setColor() throws Exception {
		gizmo.setColor(Color.BLUE);
		assertTrue(gizmo.getColor().equals(Color.BLUE));

	}

	@Test
	public void getPos1() throws Exception {
		assertEquals(new Point(0, 0), gizmo.pos1);
	}

	@Test
	public void getPos2() throws Exception {
		assertEquals(new Point(1, 1), gizmo.pos1);

	}

	@Test
	public void setTrigger() throws Exception {
	}

	@Test
	public void getAngVel() throws Exception {
	}

	@Test
	public void getMoving() throws Exception {
	}

	@Test
	public void setPos1() throws Exception {
	}

}