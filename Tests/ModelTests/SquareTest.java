package ModelTests;

import Model.Gizmos.Square;
import org.junit.Before;
import org.junit.Test;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SquareTest {

	private Square square;

	@Before
	public void setup(){
		square = new Square("Square",1,1, Color.RED);
	}

	@Test
	public void createLines() throws Exception {
		ArrayList<LineSegment> lines = square.lineSegments;

		for (LineSegment segment: lines){
			assertTrue(segment.p1().x() == 2 || segment.p1().x()==1);
			assertTrue(segment.p1().y() == 2 || segment.p1().y()==1);
			assertTrue(segment.p2().x() == 2 || segment.p2().x()==1);
			assertTrue(segment.p2().y() == 2 || segment.p2().y()==1);
		}

	}

	@Test
	public void createCircles() throws Exception {
		ArrayList<Circle> circles = square.getCircles();

		for (Circle circle: circles){
			assertTrue(circle.getCenter().x() == 2 || circle.getCenter().x()==1);
			assertTrue(circle.getCenter().y() == 2 || circle.getCenter().y()==1);
		}
	}

}