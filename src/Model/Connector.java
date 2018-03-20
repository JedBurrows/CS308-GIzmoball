package Model;

import Model.Gizmos.IGizmo;

import java.util.Objects;

public class Connector implements IConnector {
	private IGizmo source, target;

	/**
	 * Creates a new chain between the specified source gizmo and target.
	 */
	public Connector(IGizmo source, IGizmo target) {
		this.source = source;
		System.out.println("Source HashCode = " + this.source.hashCode());
		this.target = target;
		System.out.println("Target HashCode = " + this.target.hashCode());


	}
	public void execute() {
		target.setTrigger();
	}

	public IGizmo getSource() {
		return source;
	}

	public IGizmo getTarget() {
		return target;
	}

	@Override
	public int hashCode() {
		return Objects.hash(source.hashCode(), target.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		return obj.hashCode() == this.hashCode();
	}
}
