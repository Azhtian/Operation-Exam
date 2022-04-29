package screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import helper.ScreenManager;

public class PauseScreen extends AbstractScreen {

	public PauseScreen(ScreenManager game) {
		super(game);
	}

	@Override
	public void show() {
        super.show();

		TextButton continueButton = new TextButton("Continue", skin);
		TextButton levelSelect = new TextButton("Level Select", skin);
		TextButton home = new TextButton("Main Menu", skin);
		Label titleLabel = new Label( "Game paused", skin, "big");

		table.add(titleLabel);
        table.row().pad(10,0,0,10);
        table.row().pad(10,0,0,10);
		table.add(continueButton).fillX().uniform();
        table.row().pad(10,0,0,10);
		table.add(levelSelect).fillX().uniform();
        table.row().pad(10,0,0,10);
        table.add(home).fillX().uniform();
		
		continueButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
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