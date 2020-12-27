package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import controller.PlayerController;
import model.Actor;
import model.Camera;
import model.TERRAIN;
import model.TileMap;
import monsters_of_pocket.Monster;
import monsters_of_pocket.Settings;

public class GameScreen extends AbstractScreen {

	
	private SpriteBatch batch;
	private Actor player;
	private Camera camera;
	private TileMap map;
	private Texture playerFrontTexture;
	private Texture grass1;
	private Texture grass2;
	private PlayerController controller;
	public GameScreen(Monster app) {
		
		super(app);
		
		playerFrontTexture = new Texture("res/Characters/Cony/front.png");
		grass1=new Texture("res/Map/grass1.png");
		grass2=new Texture("res/Map/grass2.png");
		camera=new Camera();
		
		batch = new SpriteBatch();
		map=new TileMap(10,10);
		player =new Actor(map, 0, 0);
		
		
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
		camera.update(player.getX()+0.5f, player.getY()+0.5f);
		batch.begin();
		
		float worldStartX= Gdx.graphics.getWidth()/2-camera.getCameraX()*Settings.SCALED_TILE_SIZE;
		float worldStartY= Gdx.graphics.getHeight()/2-camera.getCameraY()*Settings.SCALED_TILE_SIZE;
		
		for(int x=0; x<map.getWidth(); x++) {
			for(int y=0; y<map.getHeight(); y++) {
				Texture render;
				if(map.getTile(x, y).getTerrain()==TERRAIN.GRASS_1) {
					render=grass1;
				}
				else {
					render=grass2;
				}
				batch.draw(render,
						worldStartX+x*Settings.SCALED_TILE_SIZE,
						worldStartY+y*Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE);
			}
		}
		
		batch.draw(playerFrontTexture, 
				worldStartX+player.getX()*Settings.SCALED_TILE_SIZE,
				worldStartY+player.getY()*Settings.SCALED_TILE_SIZE,
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
