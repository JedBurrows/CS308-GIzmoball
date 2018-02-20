package view;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
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
    private Ellipse2D.Double circle = null;

    public Board(int w, int h, Model m) {
        // Observe changes in Model
//        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
       circle = new Ellipse2D.Double(10, 10, 350, 350);
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
//            AffineTransform transform = new AffineTransform();
            Point[] points = lf.getPoints();
            Graphics2D g2 = (Graphics2D) g;
//            transform.rotate(Math.toRadians(lf.getAngle()-90), points[0].x+6, points[0].y+6);
//            g2.transform(transform);
//            g2.fillRoundRect(points[0].x, points[0].y, 12, 50, 20,10);
            g2.setStroke(new BasicStroke(20,BasicStroke.CAP_ROUND,1));
            g2.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);

        }
        for (RightFlipper rf : gm.getRightFlippers()) {
//            AffineTransform transform = new AffineTransform();
            Point[] points = rf.getPoints();
            Graphics2D g2 = (Graphics2D) g;
//            transform.rotate(Math.toRadians(90-rf.getAngle()), points[0].x+6, points[0].y+6);
//            g2.transform(transform);
//            g2.fillRoundRect(points[0].x, points[0].y, 12, 50, 20,10);
            g2.setStroke(new BasicStroke(20,BasicStroke.CAP_ROUND,1));
            g2.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);

        }




    }


    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();
    }


}
