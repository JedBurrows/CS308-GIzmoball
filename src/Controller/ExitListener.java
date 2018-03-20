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



    public ExitListener(BoardPanel p) {
        panel = p;


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Press event");


        //Custom button text
        Object[] options = {"Yes, please",
                "No, thanks"};
        int n = JOptionPane.showOptionDialog(frame,
                "Do you want to save your layout? ",
                "Remember to Save",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if(n == JOptionPane.YES_OPTION){
            System.out.println("Remembered to save!!");
        }
        else{
            System.exit(0);
        }
    }
}
