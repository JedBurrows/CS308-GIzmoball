package View;

import Model.Board;
import Model.Gizmos.IGizmo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BoardPanel extends JPanel implements Observer{

	private Board board;


	public BoardPanel(Board board){
		this.setPreferredSize(new Dimension(800,800));
		this.board = board;
		board.addObserver(this);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		final int width = this.getWidth();
		final int height = this.getHeight();

		final int Lwidth = width/20;
		final int Lheight = height/20;



		g.setColor(Color.BLACK);
		g.fillRect(0,0,width,height);

		ArrayList<IGizmo> gizmos = board.getGizmos();
		g.setColor(Color.GREEN);

		for (IGizmo gizmo : gizmos){
			String type = gizmo.getClass().getSimpleName();
			switch(type){
				case "Square":
					g.fillRect(gizmo.getxPos()*Lwidth,gizmo.getyPos()*Lheight,Lwidth,Lheight);
					break;
				case "GizmoCircle":
					g.drawOval(gizmo.getxPos()*Lwidth,gizmo.getyPos()*Lheight,Lwidth,Lheight);
					break;
			}
		}

		if(!board.isPlayMode()){
			//Draw Grid Lines
			g.setColor(Color.GRAY);
			for (int x = Lwidth; x<width; x+= Lwidth){
				g.drawLine(x,0,x,height);
			}
			for (int y = Lheight; y<height; y+= Lheight){
				g.drawLine(0,y,height,y);
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
