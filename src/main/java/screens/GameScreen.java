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

import controls.Controls;
import core.ScreenManager;
import model.Enemy;
import model.Goal;
import model.Model;
import model.Player;

import com.badlogic.gdx.utils.Array;

import core.Exam;
import sprites.Item;

public class GameScreen implements Screen {
	private final ScreenManager game;
	private Model model;
	
	private OrthographicCamera camera;
	private OrthogonalTiledMapRenderer renderer;
    public Stage stage;
    
    // Texture
    private Texture fullHeart;
	private Texture emptyHeart;
	private Controls controls;

	public GameScreen(final ScreenManager game, Model model, Controls controls) {
		this.game = game;
		this.model = model;
		this.controls = controls;
		stage = new Stage(new ScreenViewport());
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();
		
		// Load images
		fullHeart = new Texture("assets/sprites/fullHeartContainer.png");
		emptyHeart = new Texture("assets/sprites/emptyHeartContainer.png");
		
		// Renderer
		renderer = new OrthogonalTiledMapRenderer(model.getTileMap());


		// create camera and viewport
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 320); // dimensions of castle board
		camera.position.set(400, 160, 3); // centers the camera to middle of board instead of (by default) window.

		

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
		for (Player p : model.getPlayers()) {
			game.batch.draw(p.getPlayerImage(), p.getX(), p.getY(), p.getWidth(), p.getHeight());
			game.font.draw(game.batch, "Score: " + p.getScore(), 0, model.getHeight());
		}
		for (Enemy e : model.getEnemies()) {
			game.batch.draw(e.getPlayerImage(), e.getX(), e.getY(), e.getWidth(), e.getHeight());
		}

		//Draw score items
		if (model.getScoreItems() != null) {
			for (Item item : model.getScoreItems()) {
				game.batch.draw(item.getImage(), item.getX(), item.getY());
			}
		}


		// Draw heart containers
		for (int iter = 0; iter < model.getPlayers().get(0).getMaxHealth(); iter++){
			if (iter < model.getPlayers().get(0).getHealth()) {
				game.batch.draw(fullHeart, 5 + iter * (30 + 5), model.getHeight() - 50, 30, 30);
			} else {
				game.batch.draw(emptyHeart, 5 + iter * (30 + 5), model.getHeight() - 50, 30, 30);
			}
		}
		game.batch.end();
		
		controls.doControls(model);
		
		// Change screen
		if (model.getScreen() != game.GAME) {
			game.changeScreen(model.getScreen());
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