package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen {
	final Exam game;
	final int width = 800;
	final int height = 320;
	
	Texture enemyImage;
	Texture playerImage;
	OrthographicCamera camera;
	SpriteBatch batch;
	Rectangle player;
	Rectangle enemy;
	Boolean rendering;
	TiledMap tileMap;
	TiledMapTileLayer stageLayer, playerLayer, enemyLayer, itemLayer;
	OrthogonalTiledMapRenderer renderer;
	Cell playerWonCell, playerDiedCell, playerCell; 
    // Texture texture;
    // TiledMapTile[] tile; 
	
	public GameScreen(final Exam game) {
		this.game = game;
		
		// load images
		enemyImage = new Texture(Gdx.files.internal("assets/enemy.png")); // internal references the directory root (learned after 1h research)
		playerImage = new Texture(Gdx.files.internal("assets/player.png"));
		
		// create camera and viewport
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 320); // dimensions of castle board
		camera.position.set(400, 160, 3); // centers the camera to middle of board instead of (by default) window.
		
		// create batch
		batch = new SpriteBatch();
		
		// create player object, we should move this (and enemy) to a player class later
		player = new Rectangle();
		player.x = 16;
		player.y = 16;
		player.width = 16;
		player.height = 16;
		
		// create enemy object
		enemy = new Rectangle();
		enemy.x = width-16;
		enemy.y = 16;
		enemy.width = 16;
		enemy.height = 16;
		
		// create tilemap. Tilemap source: https://0x72.itch.io/16x16-dungeon-tileset
		tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");
		stageLayer = (TiledMapTileLayer) tileMap.getLayers().get("Stage"); // no layers are active atm
		playerLayer = (TiledMapTileLayer) tileMap.getLayers().get("Player"); 
		enemyLayer = (TiledMapTileLayer) tileMap.getLayers().get("Enemy"); 
		itemLayer = (TiledMapTileLayer) tileMap.getLayers().get("Item");
		renderer = new OrthogonalTiledMapRenderer(tileMap); 		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		// render tilemap
		renderer.setView(camera);
		renderer.render();
		camera.update();
		game.batch.setProjectionMatrix(camera.combined); // will only render what is on camera
		
		// start batch
		game.batch.begin();
		// player death
		if (player.overlaps(enemy)) {
			game.font.draw(game.batch, "You Died", 0, 200); // just some text
		}
		game.batch.draw(enemyImage, enemy.x, enemy.y, enemy.width, enemy.height);
		game.batch.draw(playerImage, player.x, player.y, player.width, player.height);
		game.batch.end();
		
		// TODO mouse movement (remove later)
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
		if (player.x > width-player.width) player.x = width-player.width;
	}

	@Override
	public void resize(int width, int height) {

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
