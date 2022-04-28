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

public class Model implements IModel {
	
	private final int width = 800;
	private final int height = 400;
	private int screen = 4;
	private TiledMap tileMap;
	private int gameScore = 0;
	private int currentLevel;
	private TimeCounter gameTime;
	
	private Goal goal;
    private Array<Platform> platforms = new Array<Platform>(100);
    private Array<Enemy> enemies = new Array<Enemy>(100);
    private ArrayList<Item> scoreItems = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    
	/**Empty Model used for tests*/
	public Model(){
	}

	/** Creates a Model that sets up everything the game needs.
	 * Fetches locations of all Platforms, Players, Enemies etc. from a TileMap,
	 * @param numberOfPlayers
	 * @param tileMap
	 */
	public Model(int numberOfPlayers, TiledMap tileMap) {
		this.tileMap = tileMap;
		// Start timer
//		gameTime = new TimeCounter();

		// Get objects from map
        retrieveObjectsFromMap(tileMap, numberOfPlayers);
		
    }
    
	public void retrieveObjectsFromMap(TiledMap tileMap, int numberOfPlayers) {
		Texture enemyImage = TextureManager.getTexture("enemyLeft1");
		Texture bossImage = TextureManager.getTexture("bossLeft");
		Texture playerImage1 = TextureManager.getTexture("player1idle");
        Texture playerImage2 = TextureManager.getTexture("player2idle");
		
		MapObjects objects = tileMap.getLayers().get("objects").getObjects();
		for (MapObject object : objects) {
			if (object instanceof RectangleMapObject) {
				if (object.getProperties().get("type") == null){
					continue;
				}
				if (object.getProperties().get("type").equals("Platform")) {
					Boolean thin = false;
					if (object.getProperties().containsKey("thin") && object.getProperties().get("thin").equals(true)) {
						thin = true;
					}
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
					} else if (object.getName().equals("Boss")) {
						enemy = new Boss(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height, bossImage);
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
                        player = new Player(playerRect.x, playerRect.y, playerRect.width, playerRect.height, playerImage1, PlayerInputManager.getControls(players.size()));
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

	public ArrayList<Item> getScoreItems() {
		return scoreItems;
	}
   
    public Goal getGoal() {
    	return goal;
    }

	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	public void addPlatform(Platform p) {
		platforms.add(p);
	}
	
	public void addScoreItem(Item item) {
		scoreItems.add(item);
	}
	
	public void addScore(int scoreValue) {
		this.gameScore += scoreValue;
	}
	
	public int getGameScore() {
		return gameScore;
	}
	
	public int getCameraWidth() {
		return width;
	}

	public int getCameraHeight() {
		return height;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}
}
