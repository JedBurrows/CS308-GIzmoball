package view;

import model.Ball;
import model.LeftFlipper;
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Observable;
import java.util.Observer;


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

        Graphics2D g2 = (Graphics2D) g;
//
//
//        // Draw all the vertical lines
//        for (VerticalLine vl : gm.getLines()) {
//            g2.fillRect(vl.getX(), vl.getY(), 1, vl.getWidth());
//        }
//        Ball b = gm.getBall();
//        if (b != null) {
//            g2.setColor(b.getColour());
//            int x = (int) (b.getExactX() - b.getRadius());
//            int y = (int) (b.getExactY() - b.getRadius());
//            int width = (int) (2 * b.getRadius());
//            g2.fillOval(x, y, width, width);
//        }

        //Draw all left flippers
        for (LeftFlipper lf : gm.getLeftFlippers()) {
            Point[] points = lf.getPoints();
            AffineTransform transform = new AffineTransform();
            transform.rotate(Math.toRadians(lf.getAngle()-90), points[0].x+6, points[0].y+6);
            g2.transform(transform);
            g2.fillRoundRect(points[0].x, points[0].y, 12, 50, 20,10);

        }



    }


    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();
    }


}
