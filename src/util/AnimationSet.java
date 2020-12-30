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
			Animation walkNorth, 
			Animation walkSouth, 
			Animation walkWest, 
			Animation walkEast, 
			TextureRegion standNorth, 
			TextureRegion standSouth, 
			TextureRegion standWest, 
			TextureRegion standEast) {
		
		walking= new HashMap<DIRECTION, Animation>();
		walking.put(DIRECTION.NORTH, walkNorth);
		walking.put(DIRECTION.SOUTH, walkSouth);
		walking.put(DIRECTION.WEST, walkWest);
		walking.put(DIRECTION.EAST, walkEast);
		
		standing= new HashMap<DIRECTION, TextureRegion>();
		standing.put(DIRECTION.NORTH, standNorth);
		standing.put(DIRECTION.SOUTH, standSouth);
		standing.put(DIRECTION.WEST, standWest);
		standing.put(DIRECTION.EAST, standEast);
		
	}
	
	public Animation getWalking(DIRECTION dir) {
		return walking.get(dir);
	}
	
	public TextureRegion getStanding(DIRECTION dir) {
		return standing.get(dir);
	}
}
