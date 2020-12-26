package screen;

import com.badlogic.gdx.Screen;

import monsters_of_pocket.Monster;

public abstract class AbstractScreen implements Screen {

	private Monster app;
	
	public AbstractScreen(Monster app) {
		this.app=app;
	}
	
	@Override
	public abstract void dispose(); 

	@Override
	public abstract void hide(); 

	@Override
	public abstract void pause(); 

	@Override
	public abstract void render(float delta); 
	

	@Override
	public abstract void resize(int widtg, int height); 

	@Override
	public abstract void resume(); 

	@Override
	public abstract void show();	
	


}
