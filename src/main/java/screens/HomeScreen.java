package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
<<<<<<< HEAD
import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
=======
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import core.Exam;
>>>>>>> 215f35358f465a5e9c6dea9c5513af033ef8ac47

import core.ScreenManager;

/*
 * This class shows a menu screen with buttons to change to a new screen
 */
		
public class HomeScreen implements Screen {
<<<<<<< HEAD
	final ScreenManager game;
//	OrthographicCamera camera;
	public Stage stage;
	public Table table;
	public Skin skin;
	
	public HomeScreen(ScreenManager game) {
=======
	final Exam game;
	OrthographicCamera camera;
	
	public HomeScreen(final Exam game) {
>>>>>>> 215f35358f465a5e9c6dea9c5513af033ef8ac47
		this.game = game;
//		camera = new OrthographicCamera();
//		camera.setToOrtho(false, 1200, 800); 
		// Stage is the controller
		stage = new Stage(new ScreenViewport());
		
		//Gdx.input.setInputProcessor(stage);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();
		
	}
	
	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		// The table helps place content on the screen  
		Table table = new Table();
		table.setFillParent(true);
		//table.setDebug(true);
		stage.addActor(table);
		Skin skin = new Skin(Gdx.files.internal("assets/glassy/skin/glassy-ui.json"));
		// Creating buttons using skins
		TextButton newGame = new TextButton("New Game", skin);
		TextButton playerMode = new TextButton("Player Mode", skin);
		TextButton preferences = new TextButton("Preferences", skin);
		TextButton exit = new TextButton("Exit", skin);
		
		// Adding the buttons to the screen table
		table.add(newGame).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(playerMode).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(preferences).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(exit).fillX().uniform();
		//table.row().pad(10,0,10,0);
		
		// Adding actions of pressing a button
		newGame.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.changeScreen(ScreenManager.GAME);
			}
		});
		playerMode.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.changeScreen(ScreenManager.PLAYERMODE);
			}
		});
		preferences.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.changeScreen(ScreenManager.PREFERENCES);
			}
		});
		exit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
	}

	@Override
	public void render(float delta) {
<<<<<<< HEAD
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
//		ScreenUtils.clear(0, 0, .2f, 0);
//		
//		camera.update();
//		game.batch.begin();
//		game.font.draw(game.batch, "OPERATION EXAM", 500, 600);
//		game.font.draw(game.batch, "choose 1 or 2 players", 500, 200);
//		game.batch.end();
//		
//		if (Gdx.input.isTouched()) {
//			game.setScreen(new GameScreen(game));
//			dispose();
//		}
=======
		ScreenUtils.clear(0, 0, .2f, 0);
		
		camera.update();
		game.batch.begin();
		game.font.draw(game.batch, "OPERATION EXAM", 500, 600);
		game.font.draw(game.batch, "choose 1 or 2 players", 500, 200);
		game.batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
		}

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
>>>>>>> 215f35358f465a5e9c6dea9c5513af033ef8ac47
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
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
		stage.dispose();
	}

}
