package Model;

import physics.LineSegment;

public class Wall {

	private int xpos1,xpos2,ypos1,ypos2;
	private LineSegment ls;

	public Wall(int xpos1, int ypos1, int xpos2, int ypos2 ){

		  ls = new LineSegment(xpos1,ypos1,xpos2,ypos2);


	}
}