package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Mob {

	private int maxHealth = 3;
	private int health;
	Boolean grounded;
	private int score = 0;
	// String playerName;


	public Player(float x, float y, float width, float height, Texture playerImage) {
		super(x, y, width, height, playerImage);
		this.health = this.maxHealth;
	}




    public void setHealth(int health){
		this.health = health;
	}

	public void damage(int damage){
		this.health = this.health - damage;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score){this.score = score;}

	public void addScore(int score){this.score += score;}

	public int getHealth(){
		return this.health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

}