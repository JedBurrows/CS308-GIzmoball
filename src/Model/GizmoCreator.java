package Model;


import Model.Gizmos.GizmoCircle;
import Model.Gizmos.IGizmo;
import Model.Gizmos.Square;
import Model.Gizmos.Triangle;

public class GizmoCreator {


	public IGizmo createGizmo(String type, int x, int y) {
		String id = String.valueOf(type);

		id = id.replaceAll("[a-z]","");

		id = id.concat(String.format("%02d",x));
		id = id.concat(String.format("%02d",x));

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
