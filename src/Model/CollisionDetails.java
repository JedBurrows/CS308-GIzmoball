package Model;

import Model.Model;
import physics.Circle;
import Model.Gizmos.*;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public  class CollisionDetails {
	private double tuc;
	private Vect velo;

	public CollisionDetails(double t, Vect v) {
		tuc = t;
		velo = v;
	}

	public double getTuc() {
		return tuc;
	}

	public Vect getVelo() {
		return velo;
	}


}
