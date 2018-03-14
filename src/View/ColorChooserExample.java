package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorChooserExample extends JFrame implements MouseListener {
//    JButton b;
//    Container c;
    Color col;



//    public void actionPerformed(ActionEvent e) {
//        this.setSize(400,400);
//        this.setVisible(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        Color initialcolor=Color.RED;
//        Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);
//        System.out.println("Color is"+ color);
//        //  c.setBackground(color);
//        col = color;
//        System.out.println("Col is " + col);
//
//
//    }

    public Color getColorGiz(){
        return col;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Color initialcolor=Color.RED;
        Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);
        System.out.println("Color is"+ color);
        //  c.setBackground(color);
        col = color;
        System.out.println("Col is " + col);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


//    public static void main(String[] args) {
//        ColorChooserExample ch=new ColorChooserExample();
//        ch.setSize(400,400);
//        ch.setVisible(true);
//        ch.setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//    }

}
