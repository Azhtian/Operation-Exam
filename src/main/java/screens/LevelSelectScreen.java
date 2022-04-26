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

import helper.LevelReader;
import helper.ScreenManager;

public class LevelSelectScreen implements Screen {
	final ScreenManager game;
	public final Stage stage;
	private final int numberOfLevels = LevelReader.getLevels();

	public LevelSelectScreen(ScreenManager game) {
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
		Label titleLabel = new Label("Select Level", skin, "big");
		table.add(titleLabel).colspan(4);
		table.row().pad(10, 0, 0 ,0);

		for (int i = 1; i <= numberOfLevels; i++) {
			TextButton level = new TextButton("" + i, skin);
			table.add(level).fillX().uniform();

			//Decides how many elements on each row
			int t = (int) Math.floor(Math.sqrt(numberOfLevels));
			if (i % t == 0){
				table.row().pad(10, 0, 0, 0);
			}

			int finalI = i;
			level.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					game.newGame();
					game.setLevel(finalI);
					game.changeScreen(ScreenManager.GAME);
				}
			});
		}
		table.row().pad(40, 10, 0, 0);
		TextButton back = new TextButton("Back", skin);
		table.add(back).fillX().uniform().colspan(4);
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
		//stage.dispose();
	}

}
