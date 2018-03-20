package ModelTests;

import Model.Gizmos.Circle;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class CircleTest {
	private Circle circle;

	@Before
	public void setup(){
		circle = new Circle("C",1,1, Color.RED);
	}

	@Test
	public void createCircles() throws Exception {
		double y =  circle.getCircles().get(0).getCenter().y();
		double x = circle.getCircles().get(0).getCenter().x();

		assertEquals(1.5,x,0.01);
		assertEquals(1.5,y,0.01);
	}

	@Test
	public void createLines() throws Exception {
		circle.createLines();
	}

}