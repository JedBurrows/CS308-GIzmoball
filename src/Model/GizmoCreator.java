package Model;

import Model.Gizmos.*;

import java.awt.*;


public class GizmoCreator {


	public IGizmo createGizmo(String type, int x, int y, Color colour) {
		String id = String.valueOf(type);

		id = id.replaceAll("[a-z]", "");

		id = id.concat(String.format("%02d", x));
		id = id.concat(String.format("%02d", y));

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

		}
		return null;
	}
}
