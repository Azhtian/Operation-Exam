package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Mob {

	private float x;
	private float y;
	private int maxHealth = 3;
	private int health;
	private int speedY = 0;
	Boolean grounded;
	private int a = -1;
	private int score = 0;
	public float width = 16;
	public float height = 16;
	private Rectangle bounds;
	private Texture playerImage;
	// String playerName;


	public Player(float x, float y, float width, float height, Texture playerImage) {
		super(x,y,width,height,playerImage);
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
	}

	public Texture getPlayerImage() {
		return playerImage;
	}

	public int getHealth(){
		return this.health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

}