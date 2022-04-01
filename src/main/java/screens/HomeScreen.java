package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


import helper.ScreenManager;

/*
 * This class shows a menu screen with buttons to change to a new screen
 */
		
public class HomeScreen implements Screen {

	final ScreenManager game;
//	OrthographicCamera camera;
	public final Stage stage;

	public HomeScreen(ScreenManager game) {
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
		TextButton onePlayer = new TextButton("One Player", skin);
		TextButton twoPlayer = new TextButton("Two Player", skin);
		TextButton preferences = new TextButton("Preferences", skin);
		TextButton exit = new TextButton("Exit", skin);
		Label titleLabel = new Label("Main menu", skin, "big");
        // Adding title and buttons to the screen table
		table.add(titleLabel).colspan(2);
        table.row().pad(10,0,0,10);
		table.add(onePlayer).fillX().uniform();
//		table.row().pad(10,0,10,0);
		table.add(twoPlayer).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(preferences).fillX().uniform();
//		table.row().pad(10,0,10,0);
		table.add(exit).fillX().uniform();
		//table.row().pad(10,0,10,0);
		
		// Adding actions of pressing a button
		onePlayer.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setNumberOfPlayers(1);
				game.changeScreen(ScreenManager.LEVELSELECT);
			}
		});
		twoPlayer.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setNumberOfPlayers(2);
				game.changeScreen(ScreenManager.LEVELSELECT);
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
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();

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
