package Model;


public class GizmoModel {
    Model model;

    public GizmoModel(Model m){
        model = m;
    }

    public IGizmo createGizmo(char type, int x, int y){
        switch (type){
            case 's':
                return new Square(x, y);
            case 'c':
                return new GizmoCircle(x, y);
            case 't':
                return new Triangle(x,y);
        }
        return null;
    }
}
