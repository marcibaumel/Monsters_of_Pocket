package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import controller.PlayerController;
import model.Actor;
import model.Camera;
import model.TERRAIN;
import model.TileMap;
import monsters_of_pocket.Monster;
import monsters_of_pocket.Settings;
import util.AnimationSet;


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
		
		playerFrontTexture = new Texture("res/Characters/Cony/unpacked/front_stand.png");
		grass1=new Texture("res/Map/grass1.png");
		grass2=new Texture("res/Map/grass2.png");
		camera=new Camera();
		
		batch = new SpriteBatch();
		
		TextureAtlas atlas =app.getAssetManager().get("res/Characters/Cony/packed/textures.atlas", TextureAtlas.class);
		
		AnimationSet animations = new AnimationSet(
				new Animation(0.3f/2f, atlas.findRegions("front_walk"), PlayMode.LOOP_PINGPONG),
				new Animation(0.3f/2f, atlas.findRegions("back_walk"), PlayMode.LOOP_PINGPONG),
				new Animation(0.3f/2f, atlas.findRegions("left_walk"), PlayMode.LOOP_PINGPONG),
				new Animation(0.3f/2f, atlas.findRegions("right_walk"), PlayMode.LOOP_PINGPONG),
				atlas.findRegion("front_stand"),
				atlas.findRegion("back_stand"),
				atlas.findRegion("left_stand"),
				atlas.findRegion("right_stand")
				);
				
		
		map=new TileMap(10,10);
		player =new Actor(map, 0, 0, animations);
		
		
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
		controller.update(delta);
		
		player.update(delta);
		camera.update(player.getWorldX()+0.5f, player.getWorldY()+0.5f);
		
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
		
		batch.draw(player.getSprite(), 
				worldStartX+player.getWorldX()*Settings.SCALED_TILE_SIZE,
				worldStartY+player.getWorldY()*Settings.SCALED_TILE_SIZE,
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
