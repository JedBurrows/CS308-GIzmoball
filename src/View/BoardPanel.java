package View;

import Model.Connector;
import Model.Gizmos.IGizmo;
import Model.IBall;
import Model.IBoard;
import physics.Circle;
import physics.LineSegment;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements Observer {

	private IBoard board;
	private int dimension = 600;
	private boolean debugMode;
	private Point point1, point2;


	public BoardPanel(IBoard b) {
		setPreferredSize(new Dimension(dimension, dimension));
		board = b;
		board.addObserver(this);
		debugMode = true;

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

//            if(colours.getColorGiz()!= null){
//                g.setColor(colours.getColorGiz());
//            }
//            else{
//                g.setColor(Color.MAGENTA);
//            }

			g.setColor(gizmo.getColor());
			String type = gizmo.getClass().getSimpleName();
			Point pos1 = gizmo.getPos1();
			switch (type) {
				case "Square":
					g2.fillRect(pos1.x * Lwidth, pos1.y * Lheight, gizmo.getWidth() * Lwidth, gizmo.getHeight() * Lheight);
					break;
				case "Circle":
					g2.fillOval(pos1.x * Lwidth, pos1.y * Lheight, gizmo.getWidth() * Lwidth, gizmo.getHeight() * Lheight);
					break;
				case "Triangle":
					int xPoints[], yPoints[];

					xPoints = new int[]{((int) (gizmo.getCircles().get(0).getCenter().x())) * Lwidth, ((int) (gizmo.getCircles().get(1).getCenter().x())) * Lwidth, ((int) (gizmo.getCircles().get(2).getCenter().x())) * Lwidth};
					yPoints = new int[]{((int) (gizmo.getCircles().get(0).getCenter().y())) * Lheight, ((int) (gizmo.getCircles().get(1).getCenter().y())) * Lheight, ((int) (gizmo.getCircles().get(2).getCenter().y())) * Lheight};

					g2.fillPolygon(xPoints, yPoints, 3);
					break;
				case "LeftFlipper":
				case "RightFlipper":
					//g2.setColor(Color.YELLOW);

					for (LineSegment l : gizmo.getLineSegments()) {
						g.drawLine((int) (l.p1().x() * Lwidth), (int) (l.p1().y() * Lheight), (int) (l.p2().x() * Lwidth), (int) (l.p2().y() * Lheight));
					}

					for (Circle c : gizmo.getCircles()) {
						g.fillOval((int) (c.getCenter().x() * Lwidth - (0.25 * Lwidth)), (int) (c.getCenter().y() * Lheight - (0.25 * Lheight)), (int) (c.getRadius() * 2 * Lwidth), (int) (c.getRadius() * 2 * Lwidth));
					}
					break;
				case "Absorber":
					g2.fillRect(gizmo.getPos1().x * Lwidth, gizmo.getPos1().y * Lheight, gizmo.getWidth() * Lwidth, gizmo.getHeight() * Lheight);
					break;
				default:
					System.out.println("Attempted to paint a gizmo that wasnt really a gizmo... What happened here?");


			}
		}

		if (board.hasGizmoBall()) {
			g2.setColor(Color.BLUE);
			IBall ball = board.getGizmoBall();

			float x = ball.getXPos(), y = ball.getYPos();

			x = (float) Lwidth * x;
			y = (float) Lheight * y;


			int r = (int) (ball.getRadius() * (double) Lwidth);

			System.out.println(r);
			g2.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
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
			Point sourcePos1 = source.getPos1(), targetPos1 = target.getPos1();

			g.drawLine((sourcePos1.x * Lwidth) + (Lwidth / 2), (sourcePos1.y * Lheight) + (Lheight / 2), (targetPos1.x * Lwidth) + (Lwidth / 2), (targetPos1.y * Lheight) + (Lheight / 2));
		}


		/**
		 * ##############################
		 * 			DEBUG VIEW
		 *
		 * ##############################
		 */
		if (debugMode) {
			paintDebug(g2, Lwidth, Lheight);
		}
		if (point1 != null && point2 != null) {
			paintSelectionArea(g2);
		}


	}


	private void paintDebug(Graphics2D g2, int Lwidth, int Lheight) {
		g2.setColor(Color.white);
		for (IGizmo gizmo : board.getGizmos()) {
			AffineTransform tx = new AffineTransform();
			tx.scale(Lwidth, Lheight);
			for (LineSegment lineSegment : gizmo.getLineSegments()) {
				g2.draw(tx.createTransformedShape(lineSegment.toLine2D()));
			}
			for (Circle circle : gizmo.getCircles()) {
				g2.draw(tx.createTransformedShape(circle.toEllipse2D()));
			}
		}
	}

	private void paintSelectionArea(Graphics2D g2) {
		Rectangle selection = new Rectangle(point1);
		selection.add(point2);
		g2.setColor(Color.orange);

		g2.draw(selection);

	}

	public IBoard getBoard() {
		return board;
	}

	public void setBoard(IBoard b) {

		board = b;
		board.addObserver(this);
		this.repaint();
	}

	public void setSelectPoint1(Point point) {
		this.point1 = point;


	}

	public void setSelectPoint2(Point point) {
		this.point2 = point;
	}

	public void removedSelected(){
		point1 = null;
		point2 = null;
	}


	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
