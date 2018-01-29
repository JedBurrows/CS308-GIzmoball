package Model;

public class Chain {
	private IGizmo source, target;

	/**
	 * Creates a new chain between the specified source gizmo and target.
	 */
	public Chain(IGizmo source, IGizmo target){
		this.source = source;
		this.target = target;


	}

	public void execute(){

	}
}
