package screens;

import com.badlogic.gdx.Screen;

import helper.ScreenManager;

public class LoadingScreen implements Screen {
	//private ScreenManager game;
	final ScreenManager game;

	public LoadingScreen(ScreenManager game) {
		this.game = game;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		game.changeScreen(ScreenManager.HOME);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
