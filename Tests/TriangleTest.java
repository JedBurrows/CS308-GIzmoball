package Model.Gizmos;

import org.junit.Before;
import org.junit.Test;
import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TriangleTest {

	private Triangle triangle;
	@Before
	public void setup(){
		triangle = new Triangle("T",0,0, Color.RED);
	}

	@Test
	public void createLines() throws Exception {
		ArrayList<LineSegment> lines = triangle.lineSegments;

		for (int i = 0 ; i < 4; i++){
			for (LineSegment segment: lines){
				assertTrue(segment.p1().x() == 0 || segment.p1().x()==1);
				assertTrue(segment.p1().y() == 0 || segment.p1().y()==1);
				assertTrue(segment.p2().x() == 0 || segment.p2().x()==1);
				assertTrue(segment.p2().y() == 0 || segment.p2().y()==1);
			}
			triangle.rotate();
		}


	}

	@Test
	public void createCircles() throws Exception {
		ArrayList<physics.Circle> circles = triangle.getCircles();
		for (int i= 0; i<4 ; i++){
			for (Circle circle: circles){
				assertTrue(circle.getCenter().x() == 0 || circle.getCenter().x()==1);
				assertTrue(circle.getCenter().y() == 0 || circle.getCenter().y()==1);
			}
			triangle.rotate();
		}

	}

}