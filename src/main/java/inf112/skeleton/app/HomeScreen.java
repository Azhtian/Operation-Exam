package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class HomeScreen implements Screen {
	final Exam game;
	OrthographicCamera camera;
	
	public HomeScreen(final Exam game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1000, 1000); 
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, .2f, 0);
		
		camera.update();
		game.batch.begin();
		game.font.draw(game.batch, "OPERATION EXAM", 500, 600);
		game.font.draw(game.batch, "Press ENTER to start...", 500, 200);
		game.batch.end();
		
		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
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
