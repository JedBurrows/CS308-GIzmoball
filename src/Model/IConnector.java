package Model;

import Model.Gizmos.IGizmo;

public interface IConnector {

    public void execute();

    public IGizmo getSource();

    public IGizmo getTarget();

    public int hashCode();

    public boolean equals(Object obj);
}
