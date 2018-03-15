package Main;

import Model.Board;
import View.GBallFrame;

public class Main {

	public static void main(String args[]) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Board board = new Board();
				GBallFrame frame = new GBallFrame(board);
			}
		});


	}
}
