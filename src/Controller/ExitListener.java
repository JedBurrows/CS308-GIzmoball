package Controller;

import View.BoardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

    private BoardPanel panel;
    private JOptionPane OptionPane;
    private JFrame frame;

    private LoadSaveController loadsave;



    public ExitListener( ) {



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Press event");
        ImageIcon icon = new ImageIcon("Images/saveIcon1.jpg");


        //Custom button text
        Object[] options = {"Yes, please",
                "No, thanks"};
        int n = JOptionPane.showOptionDialog(frame,
                "Are you sure you want to exit?",
                "Remember to Save",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                options,
                options[1]);

        if(n == JOptionPane.YES_OPTION){
            System.exit(0);

        }
    }
}
