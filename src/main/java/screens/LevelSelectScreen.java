package screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import helper.LevelReader;

import helper.ScreenManager;


public class LevelSelectScreen extends AbstractScreen {
	private final int numberOfLevels = LevelReader.getLevels();

	public LevelSelectScreen(ScreenManager game) {
		super(game);
	}

	@Override
	public void show() {
        super.show();

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

}


