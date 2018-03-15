package View;

import Model.*;
import Model.Gizmos.IGizmo;
import physics.Circle;
import physics.LineSegment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements Observer {

    private IBoard board;
    private ColorChooserExample colours;
    private int dimension = 600;
    private Color col;
    private Color pls;


    public BoardPanel(IBoard b) {
        setPreferredSize(new Dimension(dimension, dimension));
        board = b;
        board.addObserver(this);

    }

    public void setColours(ColorChooserExample cce){
        colours = cce;
    }

    public int getDimension() {
        return dimension;
    }

    @Override
    protected void paintComponent(Graphics g) {



        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        final int width = this.getWidth();
        final int height = this.getHeight();

        final int Lwidth = width / 20;
        final int Lheight = height / 20;


        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, width, height);

        ArrayList<IGizmo> gizmos = board.getGizmos();

        for (IGizmo gizmo : gizmos) {

            //Todo fix to use colour from picker, Beware passing null to setColor will just end up drawing the last color set ie colour of board
            //pls = colours.getColorGiz();
            //System.out.println("pls is" + pls);
            //g2.setColor(pls);
            //System.out.println(g2.getColor().toString());
            if(colours.getColorGiz()!= null){
                g.setColor(colours.getColorGiz());
            }
            else{
                g.setColor(Color.MAGENTA);
            }


            String type = gizmo.getClass().getSimpleName();
            switch (type) {
                case "Square":
                    g2.fillRect((int) gizmo.getxPos() * Lwidth, (int) gizmo.getyPos() * Lheight, Lwidth, Lheight);
                    break;
                case "Circle":
                    g2.fillOval((int) gizmo.getxPos() * Lwidth, (int) gizmo.getyPos() * Lheight, Lwidth, Lheight);
                    break;
                case "Triangle":
                    int xPoints[], yPoints[];

                    xPoints = new int[]{((int)(gizmo.getCircles().get(0).getCenter().x())) * Lwidth, ((int)(gizmo.getCircles().get(1).getCenter().x())) * Lwidth, ((int)(gizmo.getCircles().get(2).getCenter().x())) * Lwidth};
                    yPoints = new int[]{((int)(gizmo.getCircles().get(0).getCenter().y())) * Lheight, ((int)(gizmo.getCircles().get(1).getCenter().y())) * Lheight, ((int)(gizmo.getCircles().get(2).getCenter().y())) * Lheight};

                    System.out.println(xPoints.length);
                    for (int x = 0; x < xPoints.length; x++) {
                        System.out.println("xpoints: " + xPoints[x]);
                    }
                    System.out.println(yPoints.length);
                    for (int y = 0; y < yPoints.length; y++) {
                        System.out.println("ypoints: " + yPoints[y]);
                    }
                    g2.fillPolygon(xPoints, yPoints, 3);
                    break;
                case "Flipper":
                    g2.setColor(Color.YELLOW);

                    for (LineSegment l : gizmo.getLines()) {
                        g.drawLine((int) (l.p1().x() * Lwidth), (int) (l.p1().y() * Lheight), (int) (l.p2().x() * Lwidth), (int) (l.p2().y() * Lheight));
                    }

                    for (Circle c : gizmo.getCircles()) {
                        g.fillOval((int)(c.getCenter().x() * Lwidth - (0.25 * Lwidth)),(int)(c.getCenter().y() * Lheight - (0.25 * Lheight)), (int)(c.getRadius()* 2 * Lwidth), (int)(c.getRadius()* 2 * Lwidth));
                    }


            }
        }
        if (board.hasGizmoBall()) {
            g2.setColor(Color.BLUE);
            IBall ball = board.getGizmoBall();

            float x = ball.getXPos(), y = ball.getYPos();

            System.out.println("X: " + x + "	Y:" + y);


            x = (float) Lwidth * x;
            y = (float) Lheight * y;

            System.out.println("X: " + x + "	Y:" + y);

            int r = (int) (ball.getRadius() * (double) Lwidth);

            System.out.println(r);
            g2.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
        }

        //Draw Absorber
        if (board.hasAbsorber()) {
            System.out.println("Drawing Abosrber");
            g2.setColor(Color.MAGENTA);
            IAbsorber absorber = board.getAbsorber();
            int x1 = absorber.getxPos1(), y1 = absorber.getyPos1(), x2 = absorber.getxPos2(), y2 = absorber.getyPos2();
            for (int xPos = x1; xPos <= x2; xPos++) {
                for (int yPos = y1; yPos <= y2; yPos++) {
                    g2.fillRect(xPos * Lwidth, yPos * Lheight, Lwidth, Lheight);
                }
            }
        }

        if (!board.isRunMode()) {
            //Draw Grid Lines
            g2.setStroke(new BasicStroke(1));
            g2.setColor(Color.GRAY);
            for (int x = Lwidth; x < width; x += Lwidth) {
                g2.drawLine(x, 0, x, height);
            }
            for (int y = Lheight; y < height; y += Lheight) {
                g2.drawLine(0, y, height, y);
            }
        }

        g2.setColor(Color.BLUE);
        ArrayList<Connector> connectors = board.getConnectors();

        for (Connector connection : connectors) {
            IGizmo source = connection.getSource(), target = connection.getTarget();

                int xSource = source.getxPos(), ySource = source.getyPos(), xTarget = target.getxPos(), yTarget = target.getyPos();
                g.drawLine((xSource * Lwidth) + (Lwidth / 2), (ySource * Lheight) + (Lheight / 2), (xTarget * Lwidth) + (Lwidth / 2), (yTarget * Lheight) + (Lheight / 2));
        }
    }


    public void setBoard(IBoard b) {

        board = (Board) b;
        board.addObserver(this);
        this.repaint();
    }

    public IBoard getBoard() {
        return board;
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
