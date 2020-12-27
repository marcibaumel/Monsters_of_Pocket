package monsters_of_pocket;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import screen.GameScreen;

public class Monster extends Game {

	private GameScreen screen;
	
	@Override
	public void create() {
		screen=new GameScreen(this);
		
		this.setScreen(screen);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}
	
}
