package util;

import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.maps.Map;

import model.DIRECTION;

public class AnimationSet {

	
	private Map<DIRECTION, Animation> walking;
	
	private Map<DIRECTION, TextureRegion> standing;
	
	public AnimationSet(
			Animation walkUp, 
			Animation walkDown, 
			Animation walkLeft, 
			Animation walkRight, 
			TextureRegion standUp, 
			TextureRegion standDown, 
			TextureRegion standLeft, 
			TextureRegion standRight) {
		
		walking= new HashMap<DIRECTION, Animation>();
		walking.put(DIRECTION.NORTH, walkUp);
		walking.put(DIRECTION.SOUTH, walkDown);
		walking.put(DIRECTION.WEST, walkLeft);
		walking.put(DIRECTION.EAST, walkRight);
		
		standing= new HashMap<DIRECTION, TextureRegion>();
		standing.put(DIRECTION.NORTH, standUp);
		standing.put(DIRECTION.SOUTH, standDown);
		standing.put(DIRECTION.WEST, standLeft);
		standing.put(DIRECTION.EAST, standRight);
		
	}
	
	public Animation getWalking(DIRECTION dir) {
		return walking.get(dir);
	}
	
	public TextureRegion getStanding(DIRECTION dir) {
		return standing.get(dir);
	}
}
