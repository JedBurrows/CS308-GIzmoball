package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public interface IBoard  {

        void addGizmoBall(float x, float y);

        boolean setAbsorber(Absorber absorber);

        boolean hasAbsorber();

        boolean hasGizmoBall();

        void setFriction(float mu, float mu2);

        void setGravity(float gravity);

        Ball getGizmoBall();

        public Absorber getAbsorber();

        public boolean addConnector(String name1, String name2);

        public boolean removeConnector(String name1, String name2);

        public boolean addGizmo(IGizmo gizmo);

        public boolean deleteGizmo(String id);

        public boolean moveGizmo(String id, int newX, int newY);

//        public boolean moveGizmoBall(String name, float x, float y);

        public IGizmo getGizmoByID(String id) throws NoSuchGizmoException;

        public void switchMode();

        public boolean isRunMode();

        public ArrayList<IGizmo> getGizmos();

        public ArrayList<Connector> getConnectors();

        public void moveBall();

        public Ball getBall();

//        public ArrayList<LineSegment> getLines();
//
//        public ArrayList<Circle> getCircles();
//
//        public void addLine(LineSegment l);
//
//        public void addCircle(Circle c);

        public void setBallSpeed(int x, int y);

        public void clearGizmos();

        public IGizmo getGizmoByPosition(double x, double y);

        public void deleteBall();
        public boolean isInsideBall(float x, float y);

//        public void removeCircle(Vect v);

        void addObserver(Observer o);

}
