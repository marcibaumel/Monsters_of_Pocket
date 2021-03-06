package monsters_of_pocket;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import screen.GameScreen;

public class Monster extends Game {

	private GameScreen screen;
	
	private AssetManager assetManager;
	
	@Override
	public void create() {
		assetManager= new AssetManager();
		
		/*
		 * This will recognize the png too
		 */
		
		assetManager.load("res/Characters/Cony/packed/textures.atlas", TextureAtlas.class);
		
		assetManager.finishLoading();
		
		screen=new GameScreen(this);
		
		this.setScreen(screen);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}
}
