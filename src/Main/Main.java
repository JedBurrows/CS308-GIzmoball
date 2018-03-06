package Main;

import View.BuildGUI;
import Model.Model;
import Model.*;
import View.RunGUI;

public class Main {
    public static void main(String args[]){
        Model model = new Model();
//        BuildGUI b = new BuildGUI(model);
        RunGUI g = new RunGUI((model));

//        model.addGizmoball();
    }
}
