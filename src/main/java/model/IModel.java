package model;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;

public interface IModel {
	/** Retrieves all objects from the TileMap, then checks the type to create the correct Mob or Object.
	 * @param numberOfPlayers 1 or 2
	 */
	void retrieveObjectsFromMap(TiledMap tileMap, int numberOfPlayers);
	
    /**
     * @return TiledMap of this Model
     */
	TiledMap getTileMap();
    
    /**
     * @return Array of all Players
     */
	ArrayList<Player> getPlayers();
    
    /**
     * @return Array of all enemies
     */
	Array<Enemy> getEnemies();
    
    /**
     * @return Array of all Platforms
     */
	Array<Platform> getPlatforms();

	/**
	 * @return Array of all ScoreItems
	 */
	ArrayList<Item> getScoreItems();
   
    /**
     * @return the one and only Goal
     */
	Goal getGoal();

	/** Adds this player to the array of players
	 */
	void addPlayer(Player player);
	
	/** Adds this enemy to the array of enemies
	 */
	void addEnemy(Enemy enemy);

	/** Adds this platform to the array of platforms
	 */
	void addPlatform(Platform p);
	
	/** Adds this item to the array of scoreItems
	 */
	void addScoreItem(Item item);
	
	/** Adds this value to the game score
	 * @param scoreValue book(20)
	 */
	void addScore(int scoreValue);
	
	/**
	 * @return Current game score
	 */
	int getGameScore();
	
	/**
	 * @return width of camera in units
	 */
	int getCameraWidth();

	/**
	 * @return height of camera in units
	 */
	int getCameraHeight();

	/**
	 * @return current screen
	 */
	int getScreen();

	/** Sets the current screen
	 * @param screen Integer between 1 and 8
	 */
	void setScreen(int screen);
}
