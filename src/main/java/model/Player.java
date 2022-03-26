package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Mob {

	private final int maxHealth = 3;
	private int health;
	final Boolean grounded;
	public float width = 16;
	public float height = 16;
	private Texture playerImage;
	private final int[] controlSet;
	private final int score = 0;
	// String playerName;


	public Player(float x, float y, float width, float height, Texture playerImage, int[] controlSet) {
		super(x, y, width, height, playerImage);
		this.grounded = true;
		this.controlSet = controlSet;
		Rectangle bounds = new Rectangle(x, y, width, height);
		this.setJumpStrength(10);
		this.health = this.maxHealth;
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