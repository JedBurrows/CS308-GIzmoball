package Model;

import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public interface IBoard {

	void addGizmoBall(String name, float x, float y, float vx, float vy);

	boolean hasGizmoBall();

	void setFriction(float mu, float mu2);

	void setGravity(float gravity);

	Ball getGizmoBall();

	boolean addConnector(String name1, String name2);

	boolean addKeyConnector(int key, String name);

	boolean removeConnector(String name1, String name2);

	boolean addGizmo(IGizmo gizmo);

	boolean deleteGizmo(String id);

	boolean moveGizmo(String id, int newX, int newY);

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


	void addObserver(Observer o);

	float getMU();
	float getMU2();
	float getGravity();

	HashMap<Integer, List<String>> getKeyPressEvents();
	HashMap<Integer, List<String>> getKeyReleaseEvents();

	boolean addKeyPressEvent(int event, String id);

	boolean addKeyReleaseEvent(int event, String id);


}
