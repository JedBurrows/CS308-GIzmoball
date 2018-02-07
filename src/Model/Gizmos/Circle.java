package Model.Gizmos;


public class Circle implements IGizmo {

    public physics.Circle getCircle() {
        return circle;
    }

    private physics.Circle circle;

    private static final String TYPE = "Circle";



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

    @Override
    public String getType() {
        return TYPE;
    }
}
