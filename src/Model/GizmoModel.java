package Model;


import Model.Gizmos.GizmoCircle;
import Model.Gizmos.IGizmo;
import Model.Gizmos.Square;
import Model.Gizmos.Triangle;

public class GizmoModel {


	public IGizmo createGizmo(char type, int x, int y) {
		String id = String.valueOf(type);
		id.concat(String.valueOf(x));
		id.concat(String.valueOf(y));
		
		switch (type) {
			case 's':
				return new Square(id,x, y);
			case 'c':
				return new GizmoCircle(id,x, y);
			case 't':
				return new Triangle(id,x, y);
		}
		return null;
	}
}
