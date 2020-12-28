package model;

public enum DIRECTION {

	NORTH(0,1),
	EAST(1,0),
	SOUTH(0,-1),
	WEST(-1,0),
	;
	
	private int cx, cy;
	
	private DIRECTION(int cx, int cy) {
		this.cx=cy;
		this.cy=cy;
	}
	
	public int getCX() {
		return cx;
	}
	
	public int getCY() {
		return cy;
	}
}
