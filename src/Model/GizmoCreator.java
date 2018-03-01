package Model;


import Model.Gizmos.GizmoCircle;
import Model.Gizmos.IGizmo;
import Model.Gizmos.Square;
import Model.Gizmos.Triangle;

public class GizmoCreator {


	public IGizmo createGizmo(String type, int x, int y) {
		String id = String.valueOf(type);
		id.concat(String.valueOf(x));
		id.concat(String.valueOf(y));

		switch (type) {
			case "Square":
				return new Square(id,x, y);
			case "Circle":
				return new GizmoCircle(id,x, y);
			case "Triangle":
				return new Triangle(id,x, y);
		}
		return null;
	}
}
