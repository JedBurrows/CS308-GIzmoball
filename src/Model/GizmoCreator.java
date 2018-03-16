package Model;

import Model.Gizmos.*;

import java.awt.*;


public class GizmoCreator {


	public IGizmo createGizmo(String type, int x, int y, Color colour) {

		String id = createID(type, x, y);

		switch (type) {
			case "Square":
				return new Square(id, x, y, colour);
			case "Circle":
				return new Circle(id, x, y, colour);
			case "Triangle":
				return new Triangle(id, x, y, colour);
			case "LeftFlipper":
				return new Flipper(id, x, y, colour, false);
			case "RightFlipper":
				return new Flipper(id, x, y, colour, true);
			case "Absorber":

		}
		return null;
	}

	public IGizmo createAbsorber(int x1, int y1, int x2, int y2, Color colour) {
		String id = createID("Absorber", x1, y1);

		return new Absorber(id, x1, y1, x2, y2, colour);
	}

	private String createID(String type, int x, int y) {
		String id = String.valueOf(type);

		id = id.replaceAll("[a-z]", "");

		id = id.concat(String.format("%02d", x));
		id = id.concat(String.format("%02d", y));
		return id;

	}

}
