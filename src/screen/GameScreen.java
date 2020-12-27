package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import controller.PlayerController;
import model.Actor;
import monsters_of_pocket.Monster;
import monsters_of_pocket.Settings;

public class GameScreen extends AbstractScreen {

	
	private SpriteBatch batch;
	private Actor player;
	private Texture playerFrontTexture;
	private PlayerController controller;
	public GameScreen(Monster app) {
		super(app);
		
		playerFrontTexture = new Texture("res/Characters/Cony/front.png");
		batch = new SpriteBatch();
		
		player =new Actor(0, 0);
		
		controller = new PlayerController(player);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(playerFrontTexture, 
				player.getX()*Settings.SCALED_TILE_SIZE,
				player.getY()*Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE*1.5f);
		batch.end();
	}

	@Override
	public void resize(int widtg, int height) {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}
}
