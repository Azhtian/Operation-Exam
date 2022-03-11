package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import core.ScreenManager;
import sprites.Player;

import com.badlogic.gdx.utils.Array;

import core.Exam;
import sprites.Player;

public class GameScreen implements Screen {
	private final ScreenManager game;
	private final int width = 800;
	private final int height = 320;

	private Player p1;
	private Player enemy;
	private Texture enemyImage;
	private Texture playerImage;
	private OrthographicCamera camera;
	private TiledMap tileMap;
	private TiledMapTileLayer bgLayer, platformsLayer, playerLayer, itemsLayer;
	private OrthogonalTiledMapRenderer renderer;
    private MapObjects objects;
    private Array<Rectangle> platforms = new Array<Rectangle>(100);
    private Array<Player> enemies;
    // TODO private Array<Item> scoreItems;

    
    public Stage stage;

	public GameScreen(final ScreenManager game) {
		this.game = game;
		stage = new Stage(new ScreenViewport());
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();

		// load images
		enemyImage = new Texture(Gdx.files.internal("assets/sprites/enemy.png"));
		playerImage = new Texture(Gdx.files.internal("assets/sprites/player.png"));


		// create camera and viewport
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 320); // dimensions of castle board
		camera.position.set(400, 160, 3); // centers the camera to middle of board instead of (by default) window.

		// create player object, we should move this (and enemy) to a player class later
		p1 = new Player(16, 16, playerImage);

		// create enemy object
		enemy = new Player(width-16, 16, enemyImage);

		// Create tilemap. Tilemap source: https://0x72.itch.io/16x16-dungeon-tileset
		tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");
		renderer = new OrthogonalTiledMapRenderer(tileMap);
		
		// Get objects from map
		objects = tileMap.getLayers().get("objects").getObjects();
		for (MapObject object : objects) {
			if (object instanceof RectangleMapObject) {
				if (object.getProperties().get("type").equals("Platform")) {
					Rectangle rect = ((RectangleMapObject) object).getRectangle();
					platforms.add(rect);
				}
				else if (object.getProperties().get("type").equals("scoreItem")) {
					
				}
				else if (object.getProperties().get("type").equals("Enemy")) {
					
				}
				else if (object.getProperties().get("type").equals("Player")) {
					
				}
				else {
					System.out.println(object.getProperties().get("type") + " not added from map");
				}
			}
		}	
		
		
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
		game.font.draw(game.batch, "Score: " + p1.getScore(), 5, height-5);
		game.batch.draw(enemy.getPlayerImage(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
		game.batch.draw(p1.getPlayerImage(), p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
		game.font.draw(game.batch, "Press SPACE to pause game", width-150, height-5);
		game.batch.end();

		// TODO player death
		if (p1.getBounds().overlaps(enemy.getBounds())) {
			game.changeScreen(ScreenManager.GAMEOVER);
			p1.setPos(16, 16);
		}

		// Left right movement
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			p1.changePos(-5, 0);

		for (Rectangle rect : platforms) {
				if (p1.getBounds().overlaps(rect)) {
					p1.setPos(rect.x + rect.width, p1.getY());
				}
			}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			p1.changePos(5, 0);
			
		}
			for (Rectangle rect : platforms) {
				if (p1.getBounds().overlaps(rect)) {
					p1.setPos(rect.x - p1.width, p1.getY());
				}
			}


		// Jump
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && p1.getGrounded()) {
			p1.setSpeed(10);
			p1.setOnGround(false);
		}

		// Apply Gravity
		p1.changeSpeed(p1.getA());
		p1.changePos(0, p1.getSpeedY());

		// player Y constraint
		for (Rectangle rect : platforms) {
			if (p1.getBounds().overlaps(rect)) {
				if (p1.getSpeedY() < 0) {
					p1.setPos(p1.getX(), rect.height + rect.y);
				} else {
					p1.setPos(p1.getX(), rect.y - p1.height);
				}
				p1.setSpeed(0);
				p1.setOnGround(true);
			}
		}

		// player x constraint
		if (p1.getX() < 0) p1.setPos(0, p1.getY());
		if (p1.getX() > width - p1.getWidth()) p1.setPos(width - p1.getWidth(), p1.getY());
		
		// press SPACE to pause game
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			game.changeScreen(ScreenManager.PAUSE);
		
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		//map = new TmxMapLoader().load("assets/maps/map.tmx");
		//renderer = new OrthogonalTiledMapRenderer(tileMap);
		//camera = new OrthographicCamera();
		//player = new Player(new Sprite(new Texture(Gdx.files.internal("assets/sprites/player.png")), (Tiled;

		stage.clear();
		Gdx.input.setInputProcessor(stage);
	
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