package Model;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ball extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawOval(0,0,150,150);

    }

}




