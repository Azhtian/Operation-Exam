package inf112.skeleton.app;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {
	final Exam game;
	
	Texture enemyImage;
	Texture playerImage;
	OrthographicCamera camera;
	SpriteBatch batch;
	Rectangle player;
	Rectangle enemy;
	Array<Rectangle> raindrops;
	long lastDropTime;
	int dropsGathered;
	Boolean rendering;
	
	public GameScreen(final Exam game) {
		this.game = game;
		
		// load images
		enemyImage = new Texture(Gdx.files.absolute("assets/enemy.png"));
		playerImage = new Texture(Gdx.files.absolute("assets/player.png"));
		
		// create camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
		
		// create batch
		batch = new SpriteBatch();
		
		// create bucket object
		player = new Rectangle();
		player.x = 1000/2 - 32/2;
		player.y = 20;
		player.width = 32;
		player.height = 64;
		
		// create bucket object
		enemy = new Rectangle();
		enemy.x = 1000;
		enemy.y = 20;
		enemy.width = 32;
		enemy.height = 64;
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0, 1);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		// player death
		if (player.overlaps(enemy)) {
			game.font.draw(game.batch, "You Died", 0, 400);
		}
		game.batch.draw(playerImage, player.x, player.y, player.width, player.height);
		game.batch.draw(enemyImage, enemy.x, enemy.y, enemy.width, enemy.height);
		game.batch.end();
		
		// mouse movement
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			player.x = touchPos.x - 64/2;
		}
		
		// left right movement
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) 
			player.x -= 400 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) 
			player.x += 400 * Gdx.graphics.getDeltaTime();
		
		// player x constraint
		if (player.x < 0) player.x = 0;
		if (player.x > 1200-32) player.x = 1200-32;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
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
		game.dispose();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
