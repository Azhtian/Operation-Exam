package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import helper.ScreenManager;

public class GameFinishedScreen implements Screen {
	final ScreenManager game;
	public final Stage stage;

	public GameFinishedScreen(ScreenManager game) {
		this.game = game;
		stage = new Stage(new ScreenViewport());
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();
	}

	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		Table table = new Table();
		table.setFillParent(true);
		//table.setDebug(true);
		stage.addActor(table);
		Skin skin = new Skin(Gdx.files.internal("assets/glassy/skin/glassy-ui.json"));
		
		// Same screen for Win/Loose?
		// if (gameScore == 0) {titleLabel = new Label( "You Loose !", skin, "big");} 
		// else:
		Label titleLabel = new Label("You completed the whole game !", skin, "big");
        
		table.add(titleLabel);
        table.row().pad(10,0,0,10);
		TextButton newGame = new TextButton("New game", skin);
		TextButton levelSelect = new TextButton("Select Level", skin);
		TextButton home = new TextButton("Main Menu", skin);
		table.add(newGame).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(levelSelect).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(home).fillX().uniform();
		
		newGame.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.newGame();
				game.setLevel(1);
				game.changeScreen(ScreenManager.GAME);
			}
		});
		levelSelect.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.changeScreen(ScreenManager.LEVELSELECT); 
			}
		});
		home.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.changeScreen(ScreenManager.HOME);
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
