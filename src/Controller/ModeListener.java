package Controller;

import View.BuildGUI;
import View.RunGUI;
import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ModeListener implements ActionListener {

    private Model model;
    private BuildGUI build;
    private RunGUI run;

    public ModeListener(Model m, BuildGUI b, RunGUI r){
        model = m;
        build = b;
        run = r;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        System.out.println(arg);
        if (arg.equals("Run")) {
            build.close();
            RunGUI run = new RunGUI(model);

        } else if (arg.equals("Build")) {
            run.close();
            BuildGUI run = new BuildGUI(model);
        }


    }

}
