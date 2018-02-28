package Model;

public class Absorber {
	private int xPos1, yPos1, xPos2, yPos2;
	private String id;

	public Absorber(String id, int x1, int y1, int x2, int y2) {
		this.id = id;
		this.xPos1 = x1;
		this.xPos2 = x2;
		this.yPos1 = y1;
		this.yPos2 = y2;


	}

	public int getxPos1() {
		return xPos1;
	}

	public int getxPos2() {
		return xPos2;
	}

	public int getyPos1() {
		return yPos1;
	}

	public int getyPos2() {
		return yPos2;
	}
}
