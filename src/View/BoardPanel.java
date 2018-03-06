package View;

import Model.Absorber;
import Model.Ball;
import Model.Board;
import Model.Connector;
import Model.Gizmos.Flipper;
import Model.Gizmos.IGizmo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements Observer {

	private Board board;


	public BoardPanel(Board board) {
		this.setPreferredSize(new Dimension(800, 800));
		this.board = board;
		board.addObserver(this);

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
			g.setColor(Color.GREEN);

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
					Flipper flipper = (Flipper) gizmo;
					int orientatation = flipper.getOrientation();
					int rotation = flipper.getRotation();
					int xPos = flipper.getxPos(), yPos = flipper.getyPos();

					if ((orientatation == Flipper.FLIPPER_LEFT && rotation == 0) || (orientatation == Flipper.FLIPPER_RIGHT && rotation == 2)) {
						g.fillRoundRect(xPos * Lwidth, yPos * Lheight, Lwidth / 2, 2 * Lheight, Lwidth / 2, Lheight / 2);
					} else if ((orientatation == Flipper.FLIPPER_LEFT && rotation == 1) || (orientatation == Flipper.FLIPPER_RIGHT && rotation == 3)) {

						g.fillRoundRect(xPos * Lwidth, yPos * Lheight, Lwidth * 2, Lheight / 2, Lwidth / 2, Lheight / 2);


					} else if ((orientatation == Flipper.FLIPPER_LEFT && rotation == 2) || (orientatation == Flipper.FLIPPER_RIGHT && rotation == 0)) {
						g.fillRoundRect(((xPos + 1) * Lwidth) + Lwidth / 2, yPos * Lheight, Lwidth / 2, Lheight * 2, Lwidth / 2, Lheight / 2);


					} else if ((orientatation == Flipper.FLIPPER_LEFT && rotation == 3) || (orientatation == Flipper.FLIPPER_RIGHT && rotation == 1)) {
						g.fillRoundRect(xPos * Lwidth, ((yPos + 1) * Lheight) + Lheight / 2, Lwidth * 2, Lheight / 2, Lwidth / 2, Lheight / 2);

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
			Ball ball = board.getGizmoBall();

			float x = ball.getXPos(), y = ball.getYPos();

			System.out.println("X: " + x + "	Y:" + y);


			x = (float) Lwidth * x;
			y = (float) Lheight * y;

			System.out.println("X: " + x + "	Y:" + y);

			int r = Lwidth / 4;


			g.fillOval((int) x - r, (int) y - r, Lwidth / 2, Lheight / 2);
		}


		if (!board.isPlayMode()) {
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

	public void setBoard(Board board) {
		this.board = board;
		this.repaint();
	}

	public Board getBoard() {
		return board;
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
