package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Mob {

	private int maxHealth = 3;
	private int health;
	Boolean grounded;
	private int score = 0;
	public float width = 16;
	public float height = 16;
	private Rectangle bounds;
	private Texture playerImage;
	private int[] controlSet;
	// String playerName;


	public Player(float x, float y, float width, float height, Texture playerImage, int[] controlSet) {
		super(x, y, width, height, playerImage);
		this.grounded = true;
		this.health = this.maxHealth;
		this.controlSet = controlSet;

		bounds = new Rectangle(x, y, width, height);
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