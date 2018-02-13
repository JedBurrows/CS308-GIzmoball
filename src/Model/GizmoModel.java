package Model;


import physics.Vect;

public class GizmoModel {
    Model model;

    public GizmoModel(Model m){
        model = m;
    }

    public IGizmo createGizmo(char type, Vect pos){
        switch (type){
            /*case 's':
                return new Square();
            case 'c':
                return new ComponentCircle();
            case 't':
                return new Triangle();*/
        }
        return null;
    }
}
