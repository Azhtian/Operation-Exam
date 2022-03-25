package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Mob {

	private final int maxHealth = 3;
	private int health;
	Boolean grounded;
	public float width = 16;
	public float height = 16;
	private final Rectangle bounds;
	private Texture playerImage;
	private final int[] controlSet;
	private final int score = 0;
	// String playerName;


	public Player(float x, float y, float width, float height, Texture playerImage, int[] controlSet) {
		super(x, y, width, height, playerImage);
		this.grounded = true;
		this.health = this.maxHealth;
		this.controlSet = controlSet;
		bounds = new Rectangle(x, y, width, height);
		this.health = this.maxHealth;
		this.setJumpStrength(10);
	}


	public int getLeftControl(){
		return controlSet[0];
	}

	public int getJumpControl(){
		return controlSet[1];
	}

	public int getRightControl(){
		return controlSet[2];
	}

	public int getDownControl(){
		return controlSet[3];
	}

    public void setHealth(int health){
		this.health = health;
	}

	public void damage(int damage){
		this.health = this.health - damage;
	}

	public int getHealth(){
		return this.health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

}