package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import model.Actor;

public class PlayerController extends InputAdapter {

	private Actor player;
	
	public PlayerController(Actor p) {
		this.player=p;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP) {
			player.move(0, 1);
		}
		if(keycode == Keys.DOWN) {
			player.move(0, -1);
		}
		if(keycode == Keys.LEFT) {
			player.move(-1, 0);
		}
		if(keycode == Keys.RIGHT) {
			player.move(1, 0);
		}

		
		return false;
	}
}
