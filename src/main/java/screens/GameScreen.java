package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import core.OperationExam;
import sprites.Player;

public class GameScreen implements Screen {
	private final OperationExam game;
	private final int width = 800;
	private final int height = 320;
	
	private Player p1;
	private Player enemy;
	private Texture enemyImage;
	private Texture playerImage;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Boolean rendering;
	private TiledMap tileMap;
	private TiledMapTileLayer bgLayer, platformsLayer, skullsBoxesEnemiesLayer;
	private OrthogonalTiledMapRenderer renderer;
	private Cell playerWonCell, playerDiedCell, playerCell;
    // Texture texture;
    // TiledMapTile[] tile; 
	
	public GameScreen(final OperationExam game) {
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
		p1 = new Player(16, 16, 0, playerImage);
		
		// create enemy object
		enemy = new Player(width-16, 16, 0, enemyImage);
		
		// create tilemap. Tilemap source: https://0x72.itch.io/16x16-dungeon-tileset
		tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");
		bgLayer = (TiledMapTileLayer) tileMap.getLayers().get("bg"); // no layers are active atm
		platformsLayer = (TiledMapTileLayer) tileMap.getLayers().get("platforms"); 
		skullsBoxesEnemiesLayer = (TiledMapTileLayer) tileMap.getLayers().get("items"); 
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
		if (p1.overlaps(enemy)) {
			game.font.draw(game.batch, "You Died", 0, 200); // just some text
		}
		game.batch.draw(enemy.getPlayerImage(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getWidth());
		game.batch.draw(p1.getPlayerImage(), p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
		game.batch.end();
		
		// TODO mouse movement (remove later)
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			p1.setX(touchPos.x - 64/2);
		}
		
		// left right movement
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			p1.moveLeft();

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			p1.moveRight();
		// player x constraint
		if (p1.getX() < 0) p1.setX(0);
		if (p1.getX() > width - p1.getWidth()) p1.setX(width - p1.getWidth());
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
