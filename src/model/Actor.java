package model;

public class Actor {

	private TileMap map;
	private int x;
	private int y;
	
	public Actor(TileMap map, int x, int y) {
		this.map=map;
		this.x = x;
		this.y = y;
		map.getTile(x, y).setActor(this);
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
	
	public boolean move(int cx, int cy) {
		if(x+cx>=map.getWidth() || x+cx<0 || y+cy>=map.getHeight()|| y+cy<0) {
			return false;
		}
		
		if(map.getTile(x+cx, y+cy).getActor()!=null ){
			return false;
		}
		map.getTile(x, y).setActor(null);
		
		x+=cx;
		y+=cy;
		
		map.getTile(x, y).setActor(this);
		return true;
	}
	
	
}
