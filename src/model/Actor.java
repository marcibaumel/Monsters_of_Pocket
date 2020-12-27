package model;

import com.badlogic.gdx.math.Interpolation;

public class Actor {

	private TileMap map;
	private int x;
	private int y;
	private float worldX, worldY;
	
	private int srcX, srcY;
	private int desX, desY;
	private float animTimer;
	private float ANIM_TIME= 0.5f;
	
	private ACTOR_STATE state;
	
	
	public Actor(TileMap map, int x, int y) {
		this.map=map;
		this.x = x;
		this.y = y;
		this.worldX=x;
		this.worldY=y;
		
		map.getTile(x, y).setActor(this);
		this.state=ACTOR_STATE.STANDING;
	}
	
	public enum ACTOR_STATE{
		WALKING,
		STANDING,
		;
	}
	
	public void update(float delta) {
		if(state== ACTOR_STATE.WALKING) {
			animTimer+=delta;
			worldX=Interpolation.linear.apply(srcX, desX, animTimer/ANIM_TIME);
			worldY=Interpolation.linear.apply(srcY, desY, animTimer/ANIM_TIME);
			
			if(animTimer>ANIM_TIME) {
				finishMove();
			}
		}
	}

	public float getWorldX() {
		return worldX;
	}

	public float getWorldY() {
		return worldY;
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
		if(state !=ACTOR_STATE.STANDING) {
			return false;
		}
		
		if(x+cx>=map.getWidth() || x+cx<0 || y+cy>=map.getHeight()|| y+cy<0) {
			return false;
		}
		
		if(map.getTile(x+cx, y+cy).getActor()!=null ){
			return false;
		}
		
		initializeMove(x,y,cx,cy);
		map.getTile(x, y).setActor(null);
		
		x+=cx;
		y+=cy;
		
		map.getTile(x, y).setActor(this);
		return true;
	}
	
	private void initializeMove(int oldX, int oldY, int cX, int cY) {
		this.srcX=oldX;
		this.srcY=oldY;
		this.desX=oldX+cX;
		this.desY=oldY+cY;
		animTimer= 0f;
		state= ACTOR_STATE.WALKING;
		
	}
	
	private void finishMove() {
		state=ACTOR_STATE.STANDING;
	}
	
	
}
