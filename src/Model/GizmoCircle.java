package Model;


import physics.Circle;

public class GizmoCircle implements IGizmo {

    public Circle getCircle() {
        return circle;
    }

    private Circle circle;


    @Override
    public void action() {

    }

    @Override
    public void rotate() {

    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public Boolean move(int x, int y) {
        return null;
    }
}