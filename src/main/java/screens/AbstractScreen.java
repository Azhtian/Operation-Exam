package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import helper.ScreenManager;

/**
 * This class contains display handling for the different screen classes.  
 * 
 */
public abstract class AbstractScreen implements Screen {
	
	final ScreenManager game;
    public Stage stage;
    public Table table;
    public Skin skin;

    public AbstractScreen(ScreenManager game) {
    	this.game = game;
        stage = new Stage(new ScreenViewport());
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();		
    }
	
    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        
        Table table = new Table(); // A table helps place content on the screen 
		table.setFillParent(true);
		//table.setDebug(true); // Checks how elements in table are lined up
		stage.addActor(table);
		Skin skin = new Skin(Gdx.files.internal("assets/glassy/skin/glassy-ui.json"));
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
