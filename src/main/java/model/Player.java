package model;

import com.badlogic.gdx.graphics.Texture;

public class Player extends Mob {

	private static final int maxHealth = 3;
	private int health;

	Boolean grounded;
	public float width;
	public float height;
	private int[] controlSet;
    private boolean isMoving = false;
    private int idleCounter = 0;
	// String playerName;


	public Player(float x, float y, float width, float height){
		super(x, y, width, height);
		this.grounded = true;
		this.health = this.maxHealth;
		this.setJumpStrength(10);
		this.health = maxHealth;
	}

	public Player(float x, float y, float width, float height, Texture playerImage, int[] controlSet) {
		super(x, y, width, height, playerImage);
		this.grounded = true;
		this.health = this.maxHealth;
		this.controlSet = controlSet.clone();
		//Rectangle bounds = new Rectangle(x, y, width, height);
		this.setJumpStrength(10);
		this.health = maxHealth;
	}

    public void setMoving(boolean moving){
        isMoving = moving;
    }

    public boolean isMoving() {
        return isMoving;
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

    public int getIdleCounter() {
        return idleCounter;
    }

    @Override
    public boolean updateAnimation() {
        if (this.isMoving) {
            idleCounter = 0;
            return super.updateAnimation();
        }
        idleCounter += 1;
        return false;
    }
}