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
		walking.put(DIRECTION.UP, walkUp);
		walking.put(DIRECTION.DOWN, walkDown);
		walking.put(DIRECTION.LEFT, walkLeft);
		walking.put(DIRECTION.RIGHT, walkRight);
		
		standing= new HashMap<DIRECTION, TextureRegion>();
		standing.put(DIRECTION.UP, standUp);
		standing.put(DIRECTION.DOWN, standDown);
		standing.put(DIRECTION.LEFT, standLeft);
		standing.put(DIRECTION.RIGHT, standRight);
		
	}
	
	public Animation getWalking(DIRECTION dir) {
		return walking.get(dir);
	}
	
	public TextureRegion getStanding(DIRECTION dir) {
		return standing.get(dir);
	}
}
