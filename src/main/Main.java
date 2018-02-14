package main;

import javax.swing.UIManager;

import Model.IGizmo;
import Model.Model;
import Model.GizmoModel;
import View.MITRunGui;
import Model.L_Measurement;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Main {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();
		GizmoModel gizmoCreator = new GizmoModel(model);

		model.setBallSpeed(200, 200);

//		IGizmo c1 = gizmoCreator.createGizmo('c', 100, 100);
		model.addGizmo(gizmoCreator.createGizmo('c', 400, 200));
//		IGizmo s1 = gizmoCreator.createGizmo('s', 100 , 100);
		model.addGizmo(gizmoCreator.createGizmo('s', 100 , 100));
		model.addGizmo(gizmoCreator.createGizmo('t',200,300));
		// Vertical line at (100,100), width 300
//		model.addLine(new Line(100, 100, 300));
//		model.addCircle(new ComponentCircle(100,100,0));
//		model.addCircle(new ComponentCircle(400,100,0));
//
		//model.addCircle(new ComponentCircle(100, 100));

		/*model.addLine(new Line(100, 200, 300));
		model.addLine(new Line(100, 300, 300));
		model.addLine(new Line(100, 400, 300));*/

		MITRunGui gui = new MITRunGui(model);
		gui.createAndShowGUI();
	}

	public void addGizmo(GizmoModel gizmoCreator, Model model){

		//IGizmo s1 = gizmoCreator.createGizmo('s', new Vect(100 , 200));
//		for(Line l : s1.getLines())
//			model.addLine(l);
	}
}
