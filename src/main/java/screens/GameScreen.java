package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import controls.Controls;
import helper.ScreenManager;
import helper.TextureManager;
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
    private Viewport viewport;
    
    // Texture
    private final Texture fullHeart;
	private final Texture emptyHeart;
	private final Controls controls;
    private final Texture enemyMovingRight1;
    private final Texture enemyMovingRight2;
    private final Texture enemyMovingLeft1;
    private final Texture enemyMovingLeft2;

    private final Texture player1movingRight1;
    private final Texture player1movingRight2;
    private final Texture player1movingLeft1;
    private final Texture player1movingLeft2;
    private final Texture player1idle;

    private final Texture player2movingRight1;
    private final Texture player2movingRight2;
    private final Texture player2movingLeft1;
    private final Texture player2movingLeft2;
    private final Texture player2idle;

	public GameScreen(final ScreenManager game, Model model, Controls controls) {
		this.game = game;
		this.model = model;
		this.controls = controls;
		stage = new Stage(new ScreenViewport());
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();
		
		// Load images
		fullHeart = TextureManager.getTexture("fullHeart");
		emptyHeart = TextureManager.getTexture("emptyHeart");

        enemyMovingRight1 = TextureManager.getTexture("enemyRight1");
        enemyMovingRight2 = TextureManager.getTexture("enemyRight2");

        enemyMovingLeft1 = TextureManager.getTexture("enemyLeft1");
        enemyMovingLeft2 = TextureManager.getTexture("enemyLeft2");

        player1movingRight1 = TextureManager.getTexture("player1mvr1");
        player1movingRight2 = TextureManager.getTexture("player1mvr2");
        player1movingLeft1 = TextureManager.getTexture("player1mvl1");
        player1movingLeft2 = TextureManager.getTexture("player1mvl2");
        player1idle = TextureManager.getTexture("player1idle");

        player2movingRight1 = TextureManager.getTexture("player2mvr1");
        player2movingRight2 = TextureManager.getTexture("player2mvr2");
        player2movingLeft1 = TextureManager.getTexture("player2mvl1");
        player2movingLeft2 = TextureManager.getTexture("player2mvl2");
        player2idle = TextureManager.getTexture("player2idle");

		// Renderer
		renderer = new OrthogonalTiledMapRenderer(model.getTileMap());
		
		// create camera and viewport
		camera = new OrthographicCamera();
		camera.setToOrtho(false, model.getWidth(), model.getHeight()); // dimensions of castle board
		camera.position.set(model.getWidth()/2, model.getHeight()/2, 3); // centers the camera to middle of board instead of (by default) window.
		
		viewport = new ExtendViewport(model.getWidth(), model.getHeight(), camera);

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
            if (p.updateAnimation() || p.getIdleCounter() > 60 || p.getIdleCounter() == 0) {
                if (p.equals(model.getPlayers().get(0))) {
                    if (p.getIdleCounter() > 60) {
                        controls.changeMobTexture(p, player1idle, player1idle);
                    } else if (p.getAnimationPointer() == 0) {
                        controls.changeMobTexture(p, player1movingRight1, player1movingLeft1);
                    } else {
                        controls.changeMobTexture(p, player1movingRight2, player1movingLeft2);
                    }
                } else {
                    if (p.getIdleCounter() > 60) {
                        controls.changeMobTexture(p, player2idle, player2idle);
                    } else if (p.getAnimationPointer() == 0) {
                        controls.changeMobTexture(p, player2movingRight1, player2movingLeft1);
                    } else {
                        controls.changeMobTexture(p, player2movingRight2, player2movingLeft2);
                    }
                }
            }

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
		viewport.update(width, height);
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