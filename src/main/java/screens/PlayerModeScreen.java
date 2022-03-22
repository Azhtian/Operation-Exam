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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import core.ScreenManager;

public class PlayerModeScreen implements Screen {
	final ScreenManager game;
	public Stage stage;
	private Label titleLabel; 
	
	public PlayerModeScreen(ScreenManager game) {
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
		
		titleLabel = new Label( "Select Player Mode", skin, "big" );
		TextButton single = new TextButton("Single Player", skin);
		TextButton duo = new TextButton("Duo player", skin);
		TextButton back = new TextButton("Back", skin);
		table.add(titleLabel).colspan(2);
        table.row().pad(10,0,0,10);
		table.add(single).fillX().uniform();
		table.row().pad(10,0,0,10);
		table.add(duo).fillX().uniform();
		table.row().pad(10,0,0,10);
        table.add(back);
		
		single.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.changeScreen(ScreenManager.LEVELSELECT);
			}
		});
		duo.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setNumberOfPlayers(2);
				game.changeScreen(ScreenManager.LEVELSELECT);
			}
		});
       back.addListener(new ChangeListener() {
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
