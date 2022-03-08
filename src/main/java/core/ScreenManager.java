package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
	
	private LoadingScreen loadingScreen;
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
	
	public AppPreferences preferences;

	@Override
	public void create() {
//		batch = new SpriteBatch();
//		font = new BitmapFont();
		// Setting the default screen
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		preferences = new AppPreferences();
	}
	
	public void render() {
		super.render();
	}
	
	public void dispose() {
//		batch.dispose();
//		font.dispose();
	}
	
	public void changeScreen(int screen) {
		switch(screen) {
		case HOME: 
			if (homeScreen == null) homeScreen = new HomeScreen(this);
			this.setScreen(homeScreen);
			break;
		case PLAYERMODE: 
			if (playerSelect == null) playerSelect = new PlayerModeScreen(this);
			this.setScreen(playerSelect);
			break;
		case PREFERENCES: 
			if (preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
			this.setScreen(preferencesScreen);
			break;
		case LEVELSELECT: 
			if (levelSelect == null) levelSelect = new LevelSelectScreen(this);
			this.setScreen(levelSelect);
			break;
		case GAME:
			if (gameScreen == null) gameScreen = new GameScreen(this);
			this.setScreen(gameScreen);
			this.batch = new SpriteBatch();
			this.font = new BitmapFont();
			break;
		case PAUSE:
			if (pauseScreen == null) pauseScreen = new PauseScreen(this);
			this.setScreen(pauseScreen);
			break;
		case GAMEOVER:
			if (gameOverScreen == null) gameOverScreen = new GameOverScreen(this);
			this.setScreen(gameOverScreen);
			break;
		case WINNER:
			if (winnerScreen == null) winnerScreen = new WinnerScreen(this);
			break;
		}
	}

	public AppPreferences getPreferences() {
		return this.preferences;
	}

}
