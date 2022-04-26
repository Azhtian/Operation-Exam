package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import helper.ScreenManager;

/**
 * This class shows a the home screen with buttons to start the game
 * 
 */
public class HomeScreen extends AbstractScreen {

	public HomeScreen(ScreenManager game) {
		super(game);
    }
	
	@Override
	public void show() {
        super.show();
        
//      Table table = new Table(); // A table helps place content on the screen 
//		table.setFillParent(true);
//		//table.setDebug(true); // Checks how elements in table are lined up
//		stage.addActor(table);
//		Skin skin = new Skin(Gdx.files.internal("assets/glassy/skin/glassy-ui.json"));
		
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
		table.add(twoPlayer).fillX().uniform();
		table.row().pad(10,0,10,0);
		table.add(preferences).fillX().uniform();
		table.add(exit).fillX().uniform();
		
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

}
