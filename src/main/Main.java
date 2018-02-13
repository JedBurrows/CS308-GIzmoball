package main;

import javax.swing.UIManager;

import Model.VerticalLine;
import Model.ComponentCircle;
import Model.Model;
import Model.GizmoModel;
import Model.IGizmo;
import View.MITRunGui;
import physics.Vect;

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

		// Vertical line at (100,100), width 300
//		model.addLine(new VerticalLine(100, 100, 300));
//		model.addCircle(new ComponentCircle(100,100,0));
//		model.addCircle(new ComponentCircle(400,100,0));
//
		model.addCircle(new ComponentCircle(100, 100));

		/*model.addLine(new VerticalLine(100, 200, 300));
		model.addLine(new VerticalLine(100, 300, 300));
		model.addLine(new VerticalLine(100, 400, 300));*/

		MITRunGui gui = new MITRunGui(model);
		gui.createAndShowGUI();
	}

	public void addGizmo(GizmoModel gizmoCreator, Model model){

		IGizmo s1 = gizmoCreator.createGizmo('s', new Vect(100 , 200));
//		for(VerticalLine l : s1.getLines())
//			model.addLine(l);
	}
}
