package Model;

import Model.Gizmos.IGizmo;

public class Connector implements Comparable<Connector>{
	private IGizmo source, target;

	/**
	 * Creates a new chain between the specified source gizmo and target.
	 */
	public Connector(IGizmo source, IGizmo target){
		this.source = source;
		this.target = target;


	}

	public void execute(){

	}

	public IGizmo getSource(){return source;}
	public IGizmo getTarget(){return target;}

	@Override
	public int compareTo(Connector o) {
		if (this.getSource().equals(o.getSource()) && this.getTarget().equals(o.getTarget())){
			return 0;
		}else if (!this.getSource().equals(o.getSource()) && this.getTarget().equals(o.getTarget())){
			return -1;

		}else if (this.getSource().equals(o.getSource()) && !this.getTarget().equals(o.getTarget())){
			return 1;
		}else{
			return 2;
		}
	}
}
