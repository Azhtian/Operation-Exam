package screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import helper.ScreenManager;

public class PlayerModeScreen extends AbstractScreen {

	public PlayerModeScreen(ScreenManager game) {
		super(game);
	}

	@Override
	public void show() {
        super.show();

		Label titleLabel = new Label("Select Player Mode", skin, "big");
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

}
