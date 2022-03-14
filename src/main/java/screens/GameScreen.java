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
import objects.Goal;
import sprites.Player;

import com.badlogic.gdx.utils.Array;

import core.Exam;
import sprites.Enemy;
import sprites.Player;

public class GameScreen implements Screen {
	private final ScreenManager game;
	private final int width = 800;
	private final int height = 320;
	private final int maxHealth = 3;

	private Texture fullHeart;
	private Texture emptyHeart;
	private Texture enemyImage;
	private Texture playerImage;
	private Goal goal;
	private OrthographicCamera camera;
	private TiledMap tileMap;
	private TiledMapTileLayer bgLayer, platformsLayer, playerLayer, itemsLayer;
	private OrthogonalTiledMapRenderer renderer;
    private MapObjects objects;
    private Array<Rectangle> platforms = new Array<Rectangle>(100);
    private Array<Enemy> enemies = new Array<Enemy>(100);
    // TODO private Array<Item> scoreItems;
    private Array<Player> players = new Array<Player>(4);
    
    
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

		// create health
		fullHeart = new Texture("assets/sprites/fullHeartContainer.png");
		emptyHeart = new Texture("assets/sprites/emptyHeartContainer.png");


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
				else if (object.getProperties().get("type").equals("Goal")) {
					Rectangle goalRect = ((RectangleMapObject) object).getRectangle();
					goal = new Goal(goalRect.x, goalRect.y, goalRect.width, goalRect.height);
				}
				else if (object.getProperties().get("type").equals("Enemy")) {
					Rectangle enemyRect = ((RectangleMapObject) object).getRectangle();
					Enemy enemy = new Enemy(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height, enemyImage);
					enemies.add(enemy);
				}
				else if (object.getProperties().get("type").equals("Player")) {
					Rectangle playerRect = ((RectangleMapObject) object).getRectangle();
					Player player = new Player(playerRect.x, playerRect.y, playerRect.width, playerRect.height, playerImage);
					players.add(player);
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
		for (Player p : players) {
			game.batch.draw(p.getPlayerImage(), p.getX(), p.getY(), p.getWidth(), p.getHeight());
			game.font.draw(game.batch, "Score: " + p.getScore(), 0, height);
		}
		for (Player e : enemies) {
			game.batch.draw(e.getPlayerImage(), e.getX(), e.getY(), e.getWidth(), e.getHeight());
		}
		// Draw heart containers
		for (int iter = 0; iter < maxHealth; iter++){
			if (iter < players.get(0).getHealth()) {
				game.batch.draw(fullHeart, 5 + iter * (30 + 5), height - 50, 30, 30);
			} else {
				game.batch.draw(emptyHeart, 5 + iter * (30 + 5), height - 50, 30, 30);
			}
		}
		game.batch.end();

		
		// ALL PLAYER ACTIONS
		for (Player p : players) {
			// TODO Death
			for (Player e : enemies) {
				// If player touches an enemy
				if (p.getBounds().overlaps(e.getBounds())) {
					// Reset player to start-pos
					p.setPos(16, 16);
					// Player takes damage
					p.damage(1);
					if (p.getHealth() <= 0){
						// Changes screen to game-over screen
						game.changeScreen(6);
					}
				}
			}
			// Apply Gravity
			p.changeSpeed(p.getA());
			p.changePos(0, p.getSpeedY());
			
			// player Y constraint
			for (Rectangle rect : platforms) {
				if (p.getBounds().overlaps(rect)) {
					if (p.getSpeedY() < 0) {
						p.setPos(p.getX(), rect.height + rect.y);
					} else {
						p.setPos(p.getX(), rect.y - p.height);
					}
					p.setSpeed(0);
				}
			}
			
			// Left right movement
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				p.changePos(-5, 0);
				for (Rectangle rect : platforms) {
					if (p.getBounds().overlaps(rect)) {
						p.setPos(rect.x + rect.width, p.getY());
					}
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				p.changePos(5, 0);
				for (Rectangle rect : platforms) {
					if (p.getBounds().overlaps(rect)) {
						p.setPos(rect.x - p.width, p.getY());
					}
				}
			}
			// Jump
			if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) p.setSpeed(10);
		}
		// press SPACE to pause game
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			game.changeScreen(ScreenManager.PAUSE);

		// Enemy movement
		for (Enemy enemy : enemies) {
			enemy.move();

			// Enemy X collisions
			for (Rectangle rect : platforms) {
				if (enemy.getBounds().overlaps(rect)) {
					if (enemy.getMovingRight()) {
						enemy.setPos(rect.x - enemy.width, enemy.getY());
						enemy.setMovingRight(false);
					} else {
						enemy.setPos(rect.x + enemy.width, enemy.getY());
						enemy.setMovingRight(true);
					}
				}
			}

			// Enemy falling
			enemy.changeSpeed(enemy.getA());
			enemy.changePos(0, enemy.getSpeedY());


			// Enemy Y collisions
			for (Rectangle rect : platforms) {
				if (enemy.getBounds().overlaps(rect)) {
						enemy.setPos(enemy.getX(), rect.getY() + rect.getHeight());
						enemy.setSpeed(0);
				}
			}
			
			// Enemy border constraint
			// TODO remove when bounds are implemented
			if (enemy.getX() < 0){
				enemy.setPos(0, enemy.getY());
				enemy.setMovingRight(true);
			}
			if (enemy.getX() > width - enemy.getWidth()){
				enemy.setPos(width - enemy.getWidth(), enemy.getY());
				enemy.setMovingRight(false);
			}
		}
		
		// test victory
		
		for (Player player: players) {
			if (player.getBounds().overlaps(goal.getBounds())) {
				game.changeScreen(7);
			}
		}
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