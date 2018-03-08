package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.LineSegment;

import java.util.ArrayList;

public interface IBoard  {

        public void addGizmoBall(Ball ball);

        public boolean setAbsorber(Absorber absorber);

        public boolean hasAbsorber();

        public boolean hasGizmoBall();

        public void setFriction(float mu, float mu2);

        public void setGravity(float gravity);

        public Ball getGizmoBall();

        public Absorber getAbsorber();

        public boolean addConnector(String name1, String name2);

        public void removeConnector(IGizmo gizmo);

        public boolean addGizmo(IGizmo gizmo);

        public boolean deleteGizmo(String id);

        public boolean moveGizmo(String id, int newX, int newY);

//        public boolean moveGizmoBall(String name, float x, float y);

        public IGizmo getGizmoByID(String id) throws NoSuchGizmoException;

        public boolean isPlayMode();

        public ArrayList<IGizmo> getGizmos();

        public ArrayList<Connector> getConnectors();

        public void moveBall();

        public Ball getBall();

        public ArrayList<LineSegment> getLines();

        public ArrayList<Circle> getCircles();

        public void addLine(LineSegment l);

        public void addCircle(Circle c);

        public void setBallSpeed(int x, int y);

}
