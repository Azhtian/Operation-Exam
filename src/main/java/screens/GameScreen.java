package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import controls.Controls;
import core.ScreenManager;
import core.TextureManager;
import model.Enemy;
import model.Model;
import model.Player;


import model.Item;

public class GameScreen implements Screen {
	private final ScreenManager game;
	private final Model model;
	
	private final OrthographicCamera camera;
	private final OrthogonalTiledMapRenderer renderer;
    public final Stage stage;
    
    // Texture
    private final Texture staminaFrame;
    private final Texture stamina;
    private final Texture fullHeart;
	private final Texture emptyHeart;
	private final Controls controls;
    private final Texture enemyMovingRight1;
    private final Texture enemyMovingRight2;
    private final Texture enemyMovingLeft1;
    private final Texture enemyMovingLeft2;

	public GameScreen(final ScreenManager game, Model model, Controls controls) {
		this.game = game;
		this.model = model;
		this.controls = controls;
		stage = new Stage(new ScreenViewport());
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();
		
		// Load images
		staminaFrame = TextureManager.getTexture("staminaFrame");
		stamina = TextureManager.getTexture("stamina");
		
		fullHeart = TextureManager.getTexture("fullHeart");
		emptyHeart = TextureManager.getTexture("emptyHeart");

        enemyMovingRight1 = TextureManager.getTexture("enemyRight1");
        enemyMovingRight2 = TextureManager.getTexture("enemyRight2");

        enemyMovingLeft1 = TextureManager.getTexture("enemyLeft1");
        enemyMovingLeft2 = TextureManager.getTexture("enemyLeft2");

		// Renderer
		renderer = new OrthogonalTiledMapRenderer(model.getTileMap());
		
		// create camera and viewport
		camera = new OrthographicCamera();
		camera.setToOrtho(false, model.getWidth(), model.getHeight()); // dimensions of castle board
		camera.position.set(model.getWidth()/2, model.getHeight()/2, 3); // centers the camera to middle of board instead of (by default) window.
		

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		//camera.position.set(Gdx.input.getX(), model.getHeight()-Gdx.input.getY(), 3); // centers the camera to middle of board instead of (by default) window.
		
		// render tilemap
		renderer.setView(camera);
		renderer.render();
		camera.update();
		game.batch.setProjectionMatrix(camera.combined); // will only render what is on camera

		// start batch
		game.batch.begin();
		for (Player p : model.getPlayers()) {
			game.batch.draw(p.getPlayerImage(), p.getX(), p.getY(), p.getWidth(), p.getHeight());
			game.font.draw(game.batch, "Score: " + model.getGameScore(), 0, model.getHeight());
		}


        // Updates enemy texture every 20 frames
		for (Enemy e : model.getEnemies()) {
			game.batch.draw(e.getPlayerImage(), e.getX(), e.getY(), e.getWidth(), e.getHeight());
            if (e.updateAnimation()){
                if (e.getAnimationPointer() == 0) {
                    controls.changeMobTexture(e, enemyMovingRight1, enemyMovingLeft1);
                } else {
                    controls.changeMobTexture(e, enemyMovingRight2, enemyMovingLeft2);
                }
            }

        }

		//Draw score items
		if (model.getScoreItems() != null) {
			for (Item item : model.getScoreItems()) {
				game.batch.draw(item.getImage(), item.getX(), item.getY());
			}
		}
		
		// Draw stamina bar
		game.batch.draw(staminaFrame, model.getWidth()-150, model.getHeight()-65, 100, 40);
		game.batch.draw(stamina, model.getWidth()-140, model.getHeight()-65, model.getPlayers().get(0).getStamina(), 40);

		// Draw heart containers
		for (int iter = 0; iter < model.getPlayers().get(0).getMaxHealth(); iter++){
			if (iter < model.getPlayers().get(0).getHealth()) {
				game.batch.draw(fullHeart, 5 + iter * (30 + 5), model.getHeight() - 50, 30, 30);
			} else {
				game.batch.draw(emptyHeart, 5 + iter * (30 + 5), model.getHeight() - 50, 30, 30);
			}
		}
		// TODO Put FPS counter in preference
		//game.font.draw(game.batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);	
		game.batch.end();
		
		controls.doControls(model);
		
		// Change screen
		if (model.getScreen() != ScreenManager.GAME) {
			game.changeScreen(model.getScreen());
            if (model.getScreen() == ScreenManager.PAUSE){
                model.setScreen(ScreenManager.GAME);
            }
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
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