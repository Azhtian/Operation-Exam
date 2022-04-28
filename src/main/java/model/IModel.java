package model;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;

public interface IModel {
	/** Retrieves all objects from the TileMap, then checks the type to create the correct Mob or Object.
	 * @param tileMap
	 * @param numberOfPlayers 1 or 2
	 */
	public void retrieveObjectsFromMap(TiledMap tileMap, int numberOfPlayers);
	
    /**
     * @return TiledMap of this Model
     */
    public TiledMap getTileMap();
    
    /**
     * @return Array of all Players
     */
    public ArrayList<Player> getPlayers();
    
    /**
     * @return Array of all enemies
     */
    public Array<Enemy> getEnemies();
    
    /**
     * @return Array of all Platforms
     */
    public Array<Platform> getPlatforms();

	/**
	 * @return Array of all ScoreItems
	 */
	public ArrayList<Item> getScoreItems();
   
    /**
     * @return the one and only Goal
     */
    public Goal getGoal();

	/** Adds this player to the array of players
	 * @param player
	 */
	public void addPlayer(Player player);
	
	/** Adds this enemy to the array of enemies
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy);

	/** Adds this platform to the array of platforms
	 * @param platform
	 */
	public void addPlatform(Platform p);
	
	/** Adds this item to the array of scoreItems
	 * @param item
	 */
	public void addScoreItem(Item item);
	
	/** Adds this value to the game score
	 * @param scoreValue book(20)
	 */
	public void addScore(int scoreValue);
	
	/**
	 * @return Current game score
	 */
	public int getGameScore();
	
	/**
	 * @return width of camera in units
	 */
	public int getCameraWidth();

	/**
	 * @return height of camera in units
	 */
	public int getCameraHeight();

	/**
	 * @return current screen
	 */
	public int getScreen();

	/** Sets the current screen
	 * @param screen Integer between 1 and 8
	 */
	public void setScreen(int screen);
}
