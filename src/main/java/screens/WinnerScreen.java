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

public class WinnerScreen extends AbstractScreen {

	public WinnerScreen(ScreenManager game) {
		super(game);
	}

	@Override
	public void show() {
		Label titleLabel = new Label("You Won !", skin, "big");
        
		table.add(titleLabel);
        table.row().pad(10,0,0,10);
		TextButton nextLevel = new TextButton("Next level", skin);
		TextButton levelSelect = new TextButton("Select Level", skin);
		TextButton home = new TextButton("Main Menu", skin);
		table.add(nextLevel).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(levelSelect).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(home).fillX().uniform();
		
		nextLevel.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.goToNextLevel();
				game.newGame();
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

}
