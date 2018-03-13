package Model;

import Model.Gizmos.*;


public class GizmoCreator {


	public IGizmo createGizmo(String type, int x, int y) {
		String id = String.valueOf(type);

		id = id.replaceAll("[a-z]","");

		id = id.concat(String.format("%02d",x));
		id = id.concat(String.format("%02d",y));

		switch (type) {
			case "Square":
				return new Square(id,x, y);
			case "Circle":
				return new Circle(id,x, y);
			case "Triangle":
				return new Triangle(id,x, y);
            case "LeftFlipper":
				return new Flipper(id,x,y,false);
			case "RightFlipper":
				return new Flipper(id,x,y,true);

		}
		return null;
	}
}
