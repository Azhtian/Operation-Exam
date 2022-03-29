package model;

import com.badlogic.gdx.graphics.Texture;

public class Player extends Mob {

	private static final int maxHealth = 3;
	private int health;

	Boolean grounded;
	public float width;
	public float height;
	private int[] controlSet;
	// String playerName;



	public Player(float x, float y, float width, float height, Texture playerImage, int[] controlSet) {
		super(x, y, width, height, playerImage);
		this.grounded = true;
		this.health = this.maxHealth;
		this.controlSet = controlSet.clone();
		//Rectangle bounds = new Rectangle(x, y, width, height);
		this.setJumpStrength(10);
		this.health = maxHealth;
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