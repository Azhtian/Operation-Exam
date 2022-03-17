package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import core.ScreenManager;

public class Model {
	
	private final int width = 800;
	private final int height = 320;
	
	private int screen = 4;
	
	private Goal goal;
	private TiledMap tileMap;
	private TiledMapTileLayer bgLayer, platformsLayer, playerLayer, itemsLayer;
    private MapObjects objects;
    private Array<Rectangle> platforms = new Array<Rectangle>(100);
    private Array<Enemy> enemies = new Array<Enemy>(100);
    // TODO private Array<Item> scoreItems;
    private Array<Player> players = new Array<Player>(4);
    
    // Texture
	private Texture enemyImage;
	private Texture playerImage;
    
    public Model() {
		
    	// load images
		enemyImage = new Texture(Gdx.files.internal("assets/sprites/enemy.png"));
		playerImage = new Texture(Gdx.files.internal("assets/sprites/player.png"));
		
    	
    	// Create tilemap. Tilemap source: https://0x72.itch.io/16x16-dungeon-tileset
		tileMap = new TmxMapLoader().load("assets/maps/map1.tmx");
		
		// Get objects from map
		objects = tileMap.getLayers().get("objects").getObjects();
		for (MapObject object : objects) {
			if (object instanceof RectangleMapObject) {
				if (object.getProperties().get("type").equals("Platform")) {
					Rectangle rect = ((RectangleMapObject) object).getRectangle();
					platforms.add(rect);
				}
				else if (object.getProperties().get("type").equals("scoreItem")) {
					
				} 
				else if (object.getProperties().get("type").equals("Goal")) {
					Rectangle goalRect = ((RectangleMapObject) object).getRectangle();
					goal = new Goal(goalRect.x, goalRect.y, goalRect.width, goalRect.height);
				}
				else if (object.getProperties().get("type").equals("Enemy")) {
					Rectangle enemyRect = ((RectangleMapObject) object).getRectangle();
					Enemy enemy = new Enemy(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height, enemyImage);
					if (object.getProperties().get("stationary").equals(false)) {
						enemy.setStationary(false);
					}
					enemies.add(enemy);
				}
				else if (object.getProperties().get("type").equals("Player")) {
					Rectangle playerRect = ((RectangleMapObject) object).getRectangle();
					Player player = new Player(playerRect.x, playerRect.y, playerRect.width, playerRect.height, playerImage);
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
    
    public Array<Player> getPlayers() {
    	return players;
    }
    
    public Array<Enemy> getEnemies() {
    	return enemies;
    }
    
    public Array<Rectangle> getPlatforms() {
    	return platforms;
    }
   
    public Goal getGoal() {
    	return goal;
    }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}
    
}
