package View;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.color.*;
public class ColorChooserExample extends JFrame {
    JButton b;
    Container c;
    Color col;

    public void colourPicker() {
        Color initialcolor=Color.RED;
        Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);
        System.out.println("Color is"+ color);
      //  c.setBackground(color);
       col = color;
        System.out.println("Col is " + col);
    }

    public Color getColorGiz(){
        return col;
    }

    public static void main(String[] args) {
        ColorChooserExample ch=new ColorChooserExample();
        ch.setSize(400,400);
        ch.setVisible(true);
        ch.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}  