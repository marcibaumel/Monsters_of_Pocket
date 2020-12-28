package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import model.Actor;
import model.DIRECTION;

public class PlayerController extends InputAdapter {

	private boolean up, down, left, right;
	
	private Actor player;
	
	public PlayerController(Actor p) {
		this.player=p;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP) {
			up=true;
		}
		if(keycode == Keys.DOWN) {
			down=true;
		}
		if(keycode == Keys.LEFT) {
			left=true;
		}
		if(keycode == Keys.RIGHT) {
			right=true;
		}
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP) {
			up=false;
		}
		if(keycode == Keys.DOWN) {
			down=false;
		}
		if(keycode == Keys.LEFT) {
			left=false;
		}
		if(keycode == Keys.RIGHT) {
			right=false;
		}
		return false;
	}
	
	public void update(float delta) {
		if(up) {
			player.move(DIRECTION.UP);
			return;
		}
		if(down) {
			player.move(DIRECTION.DOWN);
			return;
		}
		if(left) {
			player.move(DIRECTION.LEFT);
			return;
		}
		if(right) {
			player.move(DIRECTION.RIGHT);
			return;
		}
	}
	
}
