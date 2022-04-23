package screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import helper.ScreenManager;

public class GameFinishedScreen extends AbstractScreen {
	
	public GameFinishedScreen(ScreenManager game) {
		super(game);
    }

	@Override
	public void show() {		
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

}
