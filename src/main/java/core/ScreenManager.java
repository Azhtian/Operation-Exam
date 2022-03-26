package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import controls.Controls;
import model.Model;
import screens.GameOverScreen;
import screens.GameScreen;
import screens.HomeScreen;
import screens.LevelSelectScreen;
import screens.LoadingScreen;
import screens.PauseScreen;
import screens.PreferencesScreen;
import screens.WinnerScreen;

/*
 * This class extends the Game class to manage and switch between different screens
 */

public class ScreenManager extends Game {
	public SpriteBatch batch;
    public BitmapFont font;

	private HomeScreen homeScreen;
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
	public final static int GAME2 = 8;
	public final static int PAUSE = 5;
	public final static int GAMEOVER = 6;
	public final static int WINNER = 7;

	private int numberOfPlayers = 1;
	private TiledMap tileMap;
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
		switch(screen) {
		case HOME: 
			if (homeScreen == null) homeScreen = new HomeScreen(this);
			this.setScreen(homeScreen);
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
			if (gameScreen == null) {
				tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");
				Model model = new Model(numberOfPlayers, tileMap);
				Controls controls = new Controls();
				gameScreen = new GameScreen(this, model, controls);
                this.batch = new SpriteBatch();
                this.font = new BitmapFont();
			}
			this.setScreen(gameScreen);
			break;
		case GAME2:
			if (gameScreen == null) {
				tileMap = new TmxMapLoader().load("assets/maps/map2.tmx");
				Model model = new Model(numberOfPlayers, tileMap);
				Controls controls = new Controls();
				gameScreen = new GameScreen(this, model, controls);
                this.batch = new SpriteBatch();
                this.font = new BitmapFont();
			}
			this.setScreen(gameScreen);
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
			this.setScreen(winnerScreen);
			break;
		}
	}

	public AppPreferences getPreferences() {
		return this.preferences;
	}

	public void setNumberOfPlayers(int numberOfPlayers){
		this.numberOfPlayers = numberOfPlayers;
	}

}
