package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import controls.Controls;
import model.Model;
import screens.GameOverScreen;
import screens.GameScreen;
import screens.HomeScreen;
import screens.LevelSelectScreen;
import screens.LoadingScreen;
import screens.PauseScreen;
import screens.PlayerModeScreen;
import screens.PreferencesScreen;
import screens.WinnerScreen;

/*
 * This class extends the Game class to manage and switch between different screens
 */

public class ScreenManager extends Game {
	public SpriteBatch batch;
    public BitmapFont font;

	private HomeScreen homeScreen;
	private PlayerModeScreen playerSelect;
	private LevelSelectScreen levelSelect;
	private PreferencesScreen preferencesScreen;
	private GameScreen gameScreen;
	private PauseScreen pauseScreen;
	private GameOverScreen gameOverScreen;
	private WinnerScreen winnerScreen;
	 
	public final static int HOME = 0;
	public final static int PLAYERMODE = 1;
	public final static int PREFERENCES = 2;
	public final static int LEVELSELECT = 3;
	public final static int GAME = 4;
	public final static int PAUSE = 5;
	public final static int GAMEOVER = 6;
	public final static int WINNER = 7;

	private int numberOfPlayers = 1;
	
	public AppPreferences preferences;

	@Override
	public void create() {
//		batch = new SpriteBatch();
//		font = new BitmapFont();
		// Setting the default screen
		LoadingScreen loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		preferences = new AppPreferences();
	}

	public void newGame(){
		gameScreen = null;
	}

	public void dispose() {
	}
	
	//@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("SF_SWITCH_NO_DEFAULT")
	public void changeScreen(int screen) {
		switch (screen) {
			case HOME -> {
				if (homeScreen == null) homeScreen = new HomeScreen(this);
				this.setScreen(homeScreen);
			}
			case PLAYERMODE -> {
				if (playerSelect == null) playerSelect = new PlayerModeScreen(this);
				this.setScreen(playerSelect);
			}
			case PREFERENCES -> {
				if (preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
			}
			case LEVELSELECT -> {
				if (levelSelect == null) levelSelect = new LevelSelectScreen(this);
				this.setScreen(levelSelect);
			}
			case GAME -> {
				if (gameScreen == null) {
					Model model = new Model(numberOfPlayers);
					Controls controls = new Controls();
					gameScreen = new GameScreen(this, model, controls);
					this.batch = new SpriteBatch();
					this.font = new BitmapFont();
				}
				this.setScreen(gameScreen);
			}
			case PAUSE -> {
				if (pauseScreen == null) pauseScreen = new PauseScreen(this);
				this.setScreen(pauseScreen);
			}
			case GAMEOVER -> {
				if (gameOverScreen == null) gameOverScreen = new GameOverScreen(this);
				this.setScreen(gameOverScreen);
			}
			case WINNER -> {
				if (winnerScreen == null) winnerScreen = new WinnerScreen(this);
				this.setScreen(winnerScreen);
			}
			default -> System.err.println("screen not found");
		}
	}

	public AppPreferences getPreferences() {
		return this.preferences;
	}

	public void setNumberOfPlayers(int numberOfPlayers){
		this.numberOfPlayers = numberOfPlayers;
	}

}
