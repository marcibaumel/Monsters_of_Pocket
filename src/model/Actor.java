package model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;

import util.AnimationSet;

public class Actor {

	private TileMap map;
	private int x;
	private int y;
	private DIRECTION facing;
	private AnimationSet animation;
	private float worldX, worldY;
	
	private int srcX, srcY;
	private int desX, desY;
	private float animTimer;
	private float ANIM_TIME= 0.3f;
	
	private float walkTimer;
	private boolean moveRequestThisFrame;
	
	
	private ACTOR_STATE state;
	
	
	
	public Actor(TileMap map, int x, int y, AnimationSet animations) {
		this.map=map;
		this.x = x;
		this.y = y;
		this.worldX=x;
		this.worldY=y;
		this.animation=animations;
		this.facing=DIRECTION.SOUTH;
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
			walkTimer+=delta;
			worldX=Interpolation.linear.apply(srcX, desX, animTimer/ANIM_TIME);
			worldY=Interpolation.linear.apply(srcY, desY, animTimer/ANIM_TIME);
			
			if(animTimer>ANIM_TIME) {
				float leftOverTime=animTimer-ANIM_TIME;
				walkTimer-= leftOverTime;
				
				finishMove();
				if(moveRequestThisFrame) {
					move(facing);
				}else {
					walkTimer=0f;
				}
			}
		}
		moveRequestThisFrame=false;
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
	
	public TextureRegion getSprite() {
		if(state==ACTOR_STATE.WALKING ) {
			return animation.getWalking(facing).getKeyFrame(walkTimer);
		}
		else if(state == ACTOR_STATE.STANDING) {
			return animation.getStanding(facing);
		}
		return animation.getStanding(DIRECTION.SOUTH);
	}

	/*
	 * This method will provide the moving in the x and y axis
	 */
	
	public boolean move(DIRECTION dir) {
		if(state ==ACTOR_STATE.WALKING) {
			if(facing==dir) {
				moveRequestThisFrame=true;
			}
			return false;
		}
		
		
		if(x+dir.getDX()>=map.getWidth() || x+dir.getDX()<0 || y+dir.getDY()>=map.getHeight()|| y+dir.getDY()<0) {
			return false;
		}
		
		if(map.getTile(x+dir.getDX(), y+dir.getDY()).getActor() !=null ){
			return false;
		}
		
		
		initializeMove(dir);
		map.getTile(x, y).setActor(null);
		x+=dir.getDX();
		y+=dir.getDY();
		map.getTile(x, y).setActor(this);
		
		return true;
	}
	
	private void initializeMove(DIRECTION dir) {
		this.facing=dir;
		this.srcX=x;
		this.srcY=y;
		this.desX=x+dir.getDX();
		this.desY=y+dir.getDY();
		this.worldX=x;
		this.worldY=y;
		animTimer= 0f;
		state= ACTOR_STATE.WALKING;
		
	}
	
	private void finishMove() {
		state=ACTOR_STATE.STANDING;
		
		this.worldX=desX;
		this.worldY=desY;
		this.srcX=0;
		this.srcY=0;
		this.desX=0;
		this.desY=0;
		
		
	}
	
	
}
