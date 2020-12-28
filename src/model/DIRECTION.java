package model;

public enum DIRECTION {

	UP(0,1),
	RIGHT(1,0),
	DOWN(0,-1),
	LEFT(-1,0),
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
