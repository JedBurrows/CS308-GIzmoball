package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;

import java.util.ArrayList;
import java.util.Observer;

public interface IBoard {

	void addGizmoBall(String name, float x, float y, float vx, float vy);

	boolean hasGizmoBall();

	void setFriction(float mu, float mu2);

	void setGravity(float gravity);

	Ball getGizmoBall();


	boolean addConnector(String name1, String name2);

	boolean removeConnector(String name1, String name2);

	boolean addGizmo(IGizmo gizmo);

	boolean deleteGizmo(String id);

	boolean moveGizmo(String id, int newX, int newY);

//        public boolean moveGizmoBall(String name, float x, float y);

	IGizmo getGizmoByID(String id) throws NoSuchGizmoException;

	void switchMode();

	boolean isRunMode();

	ArrayList<IGizmo> getGizmos();

	ArrayList<Connector> getConnectors();

	void moveBall();

	Ball getBall();


	void setBallSpeed(int x, int y);

	void clearGizmos();

	IGizmo getGizmoByPosition(double x, double y);

	void deleteBall();

	boolean isInsideBall(float x, float y);

//        public void removeCircle(Vect v);

	void addObserver(Observer o);

	boolean getAbsorbCollide();

	void release();

}
