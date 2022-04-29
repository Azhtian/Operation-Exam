package screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import helper.FinalGrade;
import helper.ScoreValueHelper;
import helper.ScreenManager;
import model.Model;
import model.TimeCounter;

public class GameFinishedScreen extends AbstractScreen {
	TimeCounter gameTime = TimeCounter.getInstance();
	
	public GameFinishedScreen(ScreenManager game) {
		super(game);
    }

	@Override
	public void show() {	
        super.show();
		Label titleLabel = new Label("You completed the whole game !", skin, "big");
		int booksCollected = Model.gameScore/ScoreValueHelper.getScoreValue("book");
		Label scoreLabel = new Label("You collected " +  booksCollected + " books ouf of " + Model.books.size() + " and got to the exam at " + gameTime.getTime() + ", this gives a final grade of: ", skin);
		Label finalGrade = new Label("" + FinalGrade.calculate(booksCollected), skin, "big");
		table.add(titleLabel);
		table.row().pad(10, 0, 0, 0);
		table.add(scoreLabel);
		table.row().pad(10, 0, 0, 0);
		table.add(finalGrade);
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
