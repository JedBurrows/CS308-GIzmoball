package Model;

import Model.Gizmos.IGizmo;
import javafx.scene.input.KeyCode;
import java.security.Key;
import java.util.Objects;

public class KeyConnector {
    private IGizmo target;
    private int source;
    /**
     * Creates a new chain between the specified source gizmo and target.
     */
    public KeyConnector(int source, IGizmo target) {
        this.source = source;
        System.out.println("Source HashCode = " + this.source);
        this.target = target;
        System.out.println("Target HashCode = " + this.target.hashCode());


    }
    public void execute() {
        target.setTrigger();
    }

    public int getSource() {
        return source;
    }

    public IGizmo getTarget() {
        return target;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(source.hashCode(), target.hashCode());
//    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }
}
