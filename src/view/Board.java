package view;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import model.LeftFlipper;
import model.RightFlipper;


/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Board extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
    protected int width;
    protected int height;
    protected Model gm;

    public Board(int w, int h, Model m) {
        // Observe changes in Model
//        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
        m.addObserver(this);
        width = w;
        height = h;
        gm = m;
    }

    // Fix onscreen size
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        //Draw all right flippers
        for (LeftFlipper lf : gm.getLeftFlippers()) {
            Graphics2D g2 = (Graphics2D) g;
            Point[] points = lf.getPoints();
            AffineTransform transform = new AffineTransform();
            transform.setToRotation(Math.toRadians(lf.getAngle()-90), points[0].x+6, points[0].y+6);
            g2.transform(transform);
            g2.fillRoundRect(points[0].x, points[0].y, 12, 50, 20,10);

        }
        for (RightFlipper rf : gm.getRightFlippers()) {
            Graphics2D g2 = (Graphics2D) g;

            Point[] points = rf.getPoints();
            AffineTransform transform = new AffineTransform();
            transform.setToRotation(Math.toRadians(90-rf.getAngle()), points[0].x+6, points[0].y+6);
            g2.transform(transform);
            g2.fillRoundRect(points[0].x, points[0].y, 12, 50, 20,10);
            g2.dispose();

        }




    }


    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();
    }


}
