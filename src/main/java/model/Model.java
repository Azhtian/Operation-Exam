package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import core.TextureManager;
import core.playerInputManager;
import core.scoreValueHelper;

import java.util.ArrayList;

public class Model {

	private int screen = 4;
	
	private Goal goal;
	private final TiledMap tileMap;
	private TiledMapTileLayer bgLayer, platformsLayer, playerLayer, itemsLayer;
	private final Array<Rectangle> platforms = new Array<>(100);
    private final Array<Enemy> enemies = new Array<>(100);
    private final ArrayList<Item> scoreItems = new ArrayList<>();
    private final ArrayList<Player> players = new ArrayList<>();

	private int gameScore = 0;

	public Model(int numberOfPlayers) {

    	// Create tilemap. Tilemap source: https://0x72.itch.io/16x16-dungeon-tileset
		tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");

		// load images
		// Texture
		Texture enemyImage = TextureManager.getTexture("enemyLeft1");
		Texture playerImage = TextureManager.getTexture("playerImage");
		//bombTexture = tileMap.getTileSets().getTile(64).getTextureRegion();

		// Get objects from map
		MapObjects objects = tileMap.getLayers().get("objects").getObjects();
		for (MapObject object : objects) {
			if (object instanceof RectangleMapObject) {
				if (object.getProperties().get("type").equals("Platform")) {
					Rectangle rect = ((RectangleMapObject) object).getRectangle();
					platforms.add(rect);
				}
				else if (object.getProperties().get("type").equals("scoreItem")) {
					String itemName = object.getName();
					Item item = new Item(TextureManager.getTexture(itemName), scoreValueHelper.getScoreValue(itemName), (float) object.getProperties().get("x"), (float) object.getProperties().get("y"));
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
					Player player = new Player(playerRect.x, playerRect.y, playerRect.width, playerRect.height, playerImage, playerInputManager.getControls(players.size()));
					players.add(player);
				}
				else {
					System.out.println(object.getProperties().get("type") + " not added from map");
				}
			}
		}
    }
    
    public TiledMap getTileMap() {
    	return tileMap;
    }
    
    public ArrayList<Player> getPlayers() {
    	return players;
    }
    
    public Array<Enemy> getEnemies() {
    	return enemies;
    }
    
    public Array<Rectangle> getPlatforms() {
    	return platforms;
    }

	public ArrayList<Item> getScoreItems(){return scoreItems;}
   
    public Goal getGoal() {
    	return goal;
    }

	public int getWidth() {
		return 800;
	}

	public int getHeight() {
		return 320;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	public int getGravity() {
		return -1;
	}

	public int getGameScore(){
		return gameScore;
	}

	public void addScore(int scoreValue) {
		this.gameScore += scoreValue;
	}
}
