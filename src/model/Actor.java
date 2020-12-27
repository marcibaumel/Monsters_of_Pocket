package model;

public class Actor {

	private int x;
	private int y;
	
	public Actor(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}

	/*
	 * This method will provide the moving in the x and y axis
	 */
	
	public void move(int cx, int cy) {
		x+=cx;
		y+=cy;
	}
	
	
}
