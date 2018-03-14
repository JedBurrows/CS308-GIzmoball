package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ColorChooserExample extends JFrame implements ActionListener {
//    JButton b;
//    Container c;
    Color col;

    public ColorChooserExample(){
      //  this.setSize(400,400);
     //   this.setVisible(true);
     //   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       // col = Color.RED;
    }

    public void actionPerformed(ActionEvent e) {



    }

    public Color getColorGiz(){
        return col;
    }



}  