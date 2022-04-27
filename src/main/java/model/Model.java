package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import helper.TextureManager;
import helper.PlayerInputManager;
import helper.ScoreValueHelper;

import java.util.ArrayList;

public class Model {

	private int screen = 4;

	private Goal goal;
	private TiledMap tileMap;
    private MapObjects objects;
    private final Array<Platform> platforms = new Array<>(100);
    private final Array<Enemy> enemies = new Array<>(100);
    private final ArrayList<Item> scoreItems = new ArrayList<>();
    private final ArrayList<Player> players = new ArrayList<>();

	private int gameScore = 0;
	private int currentLevel;
	private TimeCounter gameTime;

	public Model(){
	}

	public Model(int numberOfPlayers, TiledMap tileMap) {
		this.tileMap = tileMap;
		//Start timer
//		gameTime = new TimeCounter();

		// load images
		// Texture
		Texture enemyImage = TextureManager.getTexture("enemyLeft1");
		Texture playerImage1 = TextureManager.getTexture("player1idle");
        Texture playerImage2 = TextureManager.getTexture("player2idle");
		//bombTexture = tileMap.getTileSets().getTile(64).getTextureRegion();

		// Get objects from map
		MapObjects objects = tileMap.getLayers().get("objects").getObjects();
		for (MapObject object : objects) {
			if (object instanceof RectangleMapObject) {
				if (object.getProperties().get("type") == null){
					continue;
				}
				if (object.getProperties().get("type").equals("Platform")) {
					com.badlogic.gdx.maps.MapProperties o = object.getProperties();
					boolean thin = object.getProperties().containsKey("thin") && object.getProperties().get("thin").equals(true);

					Platform rect = new Platform(((RectangleMapObject) object).getRectangle(), thin);
					platforms.add(rect);
				}
				else if (object.getProperties().get("type").equals("scoreItem")) {
					String itemName = object.getName();
					Item item = new Item(TextureManager.getTexture(itemName), ScoreValueHelper.getScoreValue(itemName), (float) object.getProperties().get("x"), (float) object.getProperties().get("y"));
					scoreItems.add(item);
				} 
				else if (object.getProperties().get("type").equals("Goal")) {
					Rectangle goalRect = ((RectangleMapObject) object).getRectangle();
					goal = new Goal(goalRect.x, goalRect.y, goalRect.width, goalRect.height);
				}
				else if (object.getProperties().get("type").equals("Enemy")) {
					Rectangle enemyRect = ((RectangleMapObject) object).getRectangle();

					Enemy enemy;
					if (object.getName().equals("Jumper")) {
						enemy = new Jumper(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height, enemyImage);
					} else if (object.getName().equals("Runner")) {
						enemy = new Runner(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height, enemyImage);
					} else if (object.getName().equals("Stationary")) {
						enemy = new Stationary(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height, enemyImage);
					} else if (object.getName().equals("Walker")) {
						enemy = new Walker(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height, enemyImage);
					} else {
						throw new IllegalArgumentException("Invalid enemy type");

					}
					enemies.add(enemy);
				}
				else if (object.getProperties().get("type").equals("Player")) {
					if (numberOfPlayers == players.size()){
						continue;
					}
                    Rectangle playerRect = ((RectangleMapObject) object).getRectangle();
                    Player player;
                    if (players.size() == 0) {
                        player = new Player(playerRect.x, playerRect.y, playerRect.width, playerRect.height, playerImage1, PlayerInputManager.getControls(0));
                    } else {
                        player = new Player(playerRect.x, playerRect.y, playerRect.width, playerRect.height, playerImage2, PlayerInputManager.getControls(players.size()));
                    }
                    players.add(player);
				}
				else {
					System.out.println(object.getProperties().get("type") + " not added from map");
				}
			}
		}
    }
    
    public TiledMap getTileMap() {
    	return this.tileMap;
    }
    
    public ArrayList<Player> getPlayers() {
		return new ArrayList<>(players);
    }
    
    public Array<Enemy> getEnemies() {
    	return enemies;
    }
    
    public Array<Platform> getPlatforms() {
    	return platforms;
    }

	public ArrayList<Item> getScoreItems(){
		return scoreItems;
	}
   
    public Goal getGoal() {
    	return goal;
    }

	public int getWidth() {
		return 800;
	}

	public int getHeight() {
		return 400;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	public float getGravity() {
		return -0.5f;
	}

	public void addPlayer(Player player){
		players.add(player);
	}

	public int getGameScore(){
		return gameScore;
	}

	public void addScore(int scoreValue) {
		this.gameScore += scoreValue;
	}

//	public String getTime() {
//		return gameTime.getTime();
//	}
//
//	public void updateTime(){
//		gameTime.updateTime(Gdx.graphics.getDeltaTime());
//	}
}
