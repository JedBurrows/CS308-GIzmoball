package main;

import javax.swing.UIManager;

import model.LeftFlipper;
import model.Model;
import view.RunGUI;

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

//        model.setBallSpeed(100, 100);
        model.addLeftFlipper(new LeftFlipper(1,100, 100, 50));
//        model.addLine(new VerticalLine(200, 200, 100));


        RunGUI gui = new RunGUI(model);
        gui.getFrame();
    }
}
