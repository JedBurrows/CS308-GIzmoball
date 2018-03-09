package View;

import Model.*;
import Model.Gizmos.Flipper;
import Model.Gizmos.IGizmo;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements Observer {

    private Board board;
    private ColorChooserExample colours;
    private int dimension = 800;
    private Color col;
    private Color pls;



    public BoardPanel(IBoard b) {
        setPreferredSize(new Dimension(dimension, dimension));
        board = (Board) b;
        board.addObserver(this);

    }

    public int getDimension() {
        return dimension;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        final int width = this.getWidth();
        final int height = this.getHeight();

        final int Lwidth = width / 20;
        final int Lheight = height / 20;


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        ArrayList<IGizmo> gizmos = board.getGizmos();

        for (IGizmo gizmo : gizmos) {
            pls = colours.getColorGiz();
            System.out.println("pls is" + pls);
            g.setColor(pls);
           //g.setColor(Color.GREEN);





            String type = gizmo.getClass().getSimpleName();
            switch (type) {
                case "Square":
                    g.fillRect(gizmo.getxPos() * Lwidth, gizmo.getyPos() * Lheight, Lwidth, Lheight);
                    break;
                case "GizmoCircle":
                    g.fillOval(gizmo.getxPos() * Lwidth, gizmo.getyPos() * Lheight, Lwidth, Lheight);
                    break;
                case "Triangle":
                    int rotationTriangle;

                    rotationTriangle = gizmo.getRotation();

                    Point LTopLeft, LTopRight, LBottomLeft, LBottomRight;

                    LTopLeft = new Point(gizmo.getxPos() * Lwidth, gizmo.getyPos() * Lheight);
                    LTopRight = new Point(gizmo.getxPos() * Lwidth + (Lwidth), gizmo.getyPos() * Lheight);
                    LBottomLeft = new Point(gizmo.getxPos() * Lwidth, gizmo.getyPos() * Lheight + (Lheight));
                    LBottomRight = new Point(gizmo.getxPos() * Lwidth + (Lwidth), gizmo.getyPos() * Lheight + (Lheight));

                    int xPoints[] = new int[4], yPoints[] = new int[4];
                    switch (rotationTriangle) {
                        case 0:
                            xPoints = new int[]{LTopLeft.x, LBottomLeft.x, LTopRight.x};
                            yPoints = new int[]{LTopLeft.y, LBottomLeft.y, LTopRight.y};
                            break;
                        case 1:
                            xPoints = new int[]{LTopLeft.x, LBottomRight.x, LTopRight.x};
                            yPoints = new int[]{LTopLeft.y, LBottomRight.y, LTopRight.y};
                            break;
                        case 2:
                            xPoints = new int[]{LBottomRight.x, LBottomLeft.x, LTopRight.x};
                            yPoints = new int[]{LBottomRight.y, LBottomLeft.y, LTopRight.y};
                            break;
                        case 3:
                            xPoints = new int[]{LTopLeft.x, LBottomLeft.x, LBottomRight.x};
                            yPoints = new int[]{LTopLeft.y, LBottomLeft.y, LBottomRight.y};
                            break;

                    }
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
                case "Flipper":
                    g.setColor(Color.YELLOW);
                    int xPos = gizmo.getxPos();
                    int yPos = gizmo.getyPos();
                    int x2Pos = gizmo.getx2Pos();
                    int y2Pos = gizmo.gety2Pos();
                    int rotation = gizmo.getRotation();
                    boolean direction = gizmo.getDirection();

                    if (!direction && rotation == 0){
//                        g.fillRoundRect(xPos * Lwidth, yPos * Lheight, Lwidth / 2, 2 * Lheight, Lwidth / 2, Lheight / 2);
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setStroke(new BasicStroke(20,BasicStroke.CAP_ROUND,1));
                        g2.drawLine(xPos * Lwidth, yPos * Lheight, x2Pos * Lwidth, y2Pos * Lheight);

                    }

                    break;
            }
        }


        //Draw Absorber
        g.setColor(Color.MAGENTA);

        if (board.hasAbsorber()) {
            Absorber absober = board.getAbsorber();
            int x1 = absober.getxPos1(), y1 = absober.getyPos1(), x2 = absober.getxPos2(), y2 = absober.getyPos2();
            for (int xPos = x1; xPos <= x2; xPos++) {
                for (int yPos = y1; yPos <= y2; yPos++) {
                    g.fillRect(xPos * Lwidth, yPos * Lheight, Lwidth, Lheight);
                }

            }

        }

        g.setColor(Color.BLUE);

        if (board.hasGizmoBall()) {
            IBall ball = board.getGizmoBall();

            float x = ball.getXPos(), y = ball.getYPos();

            System.out.println("X: " + x + "	Y:" + y);


            x = (float) Lwidth * x;
            y = (float) Lheight * y;

            System.out.println("X: " + x + "	Y:" + y);

            int r = (int) (ball.getRadius() * (double) Lwidth);

            System.out.println(r);
            g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
        }


        if (!board.isRunMode()) {
            //Draw Grid Lines
            g.setColor(Color.GRAY);
            for (int x = Lwidth; x < width; x += Lwidth) {
                g.drawLine(x, 0, x, height);
            }
            for (int y = Lheight; y < height; y += Lheight) {
                g.drawLine(0, y, height, y);
            }


            g.setColor(Color.BLUE);
            ArrayList<Connector> connectors = board.getConnectors();

            for (Connector connection : connectors) {
                IGizmo source = connection.getSource(), target = connection.getTarget();

                int xSource = source.getxPos(), ySource = source.getyPos(), xTarget = target.getxPos(), yTarget = target.getyPos();
                g.drawLine((xSource * Lwidth) + (Lwidth / 2), (ySource * Lheight) + (Lheight / 2), (xTarget * Lwidth) + (Lwidth / 2), (yTarget * Lheight) + (Lheight / 2));
            }
        }
    }


    public void setBoard(IBoard b) {
        board = (Board) b;
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
