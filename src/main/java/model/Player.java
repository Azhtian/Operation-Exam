package model;

import java.util.ArrayList;
import java.util.ListIterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class Player extends Mob {

	private static final int maxHealth = 3;
	private int health;
	private int crouchingSpeed = 2;
	private int walkingSpeed = 3;
	private int runningSpeed = 4;
	private int dashSpeed = 15;
	private int dashCounter;
	private int speed;
	private float stamina;
	private int maxStamina = 80;
	private float maxSpeed = 6;

	Boolean grounded;
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
		this.stamina = this.getMaxStamina();
	}

	public Player(float x, float y, float width, float height, Texture playerImage, int[] controlSet) {
		super(x, y, width, height, playerImage);
		this.grounded = true;
		this.health = Player.maxHealth;
		this.controlSet = controlSet.clone();
		//Rectangle bounds = new Rectangle(x, y, width, height);
		this.setJumpStrength(10);
		this.health = maxHealth;
		this.setSpeed(walkingSpeed);
		this.stamina = this.getMaxStamina();
	}
	
	public void doMovement(Model model) {
		// Death
		if (this.enemyCollisions(model.getEnemies())) {
			model.setScreen(6);
		}
		
		// Apply Gravity
		this.applyGravity(model.getGravity());	
					
		// Y movement
		this.yMovement(model.getPlatforms());
					
		// Player X Movement
		this.xMovement(model.getPlatforms());
					
		// Advanced movement (Sprint,crouch,jump,dash
		this.resetMovementOptions();
		
		if (Gdx.input.isKeyPressed(this.getDownControl())) {
			this.crouch();
		} else {
			this.jump();
			this.sprint();
		}
		this.dash();
		
		//Score item
		model.addScore(this.score(model.getScoreItems()));
	}
	
	public void resetMovementOptions() {
		this.addStamina();
		this.stand();
		this.walk();
	}
	
	public void dash() {
		if (Gdx.input.isKeyJustPressed(this.getDashControl()) && this.stamina >= 30) {
			this.exhaustStamina(30);
			this.dashCounter += 4;
		}
		if (this.dashCounter > 0) {
			this.setSpeed(this.dashSpeed);
			this.dashCounter -= 1;
		}
	}
	
	public void jump() {
		if (Gdx.input.isKeyJustPressed(this.getJumpControl()) && this.isGrounded() && this.stamina >= 20) {
			this.setYSpeed(6.5f); // Using getter for strength here delays the jump for some reason
			this.setGrounded(false);
			this.exhaustStamina(20);
		}
	}
	
	public void crouch () {
		this.setHeight(16);
		this.getBounds().setHeight(16);
		this.setSpeed(this.crouchingSpeed);
	}
	
	public void stand () {
		this.setHeight(24);
		this.getBounds().setHeight(24);
		this.setSpeed(this.walkingSpeed);
	}
	
	public void sprint () {
		if (Gdx.input.isKeyPressed(this.getSprintControl()) && this.stamina >= 1) {
			this.exhaustStamina(1);
			this.setSpeed(this.runningSpeed);
		}
	}
	
	public void walk () {
		this.setSpeed(this.walkingSpeed);
	}
	
	public boolean enemyCollisions (Array<Enemy> enemies) {
		for (Enemy e : enemies) {
			// If player touches an enemy
			if (this.getBounds().overlaps(e.getBounds())) {
				// Reset player to start-pos TODO Checkpoints
				this.setX(16);
				this.setY(16);
				// Player takes damage
				this.damage(1);
				this.setStamina(this.maxStamina);
				if (this.getHealth() <= 0) {
					// Changes screen to game-over screen
					return true;
				}
			}
		}
		return false;
	}
	
	public void applyGravity(float gravity) {
		this.changeYSpeed(gravity);
		if (this.getYSpeed() > this.getMaxSpeed()) this.getSpeed();
		else this.changeY(this.getYSpeed());
	}
	
	public void yMovement (Array<Platform> platforms) {
		this.setGrounded(false);
		for (Platform rect : platforms) {
			if (this.getBounds().overlaps(rect)) {
				if (rect.isThin()) {
					if (this.getYSpeed() >= 0 || Gdx.input.isKeyPressed(this.getDownControl())) {
						continue;
					}
					else if (this.getYSpeed() <= 0 && this.getY() >= rect.y+8) {
						this.setY(rect.height + rect.y);
						this.setYSpeed(0);
						this.setGrounded(true);
					} 
				}
				else if (!rect.isThin()) {
					if (this.getYSpeed() < 0) {
						this.setY(rect.height + rect.y);
						this.setGrounded(true); // Fun bug potential
					} else {
						this.setY(rect.y - this.getHeight());
					}
					this.setYSpeed(0);
					// Move fun bug here for fun 
				}
			}
		}
	}
	
	public void xMovement (Array<Platform> platforms) {
		this.setMoving(false);
		if (Gdx.input.isKeyPressed(this.getLeftControl())) {
			 this.setMovingRight(false);
			this.setXSpeed(-this.getSpeed());
			this.setMoving(true);
		}
		if (Gdx.input.isKeyPressed(this.getRightControl())){
			 this.setMovingRight(true);
			this.setXSpeed(this.getSpeed());
			this.setMoving(true);
			
		}
		this.changeX(this.getXSpeed());
		this.setXSpeed(0);
		for (Platform rect : platforms) {
			if (this.getBounds().overlaps(rect) && !rect.isThin()) {
				if (this.getMovingRight()) {
					this.setX(rect.x - this.getWidth());
				} else {
					this.setX(rect.x + rect.width);
				}
			}
		}
	}
	
	public int score(ArrayList<Item> scoreitems) {
		ListIterator<Item> iter = scoreitems.listIterator();
		int score = 0;
        while(iter.hasNext()){
            Item item = iter.next();
            if(this.getBounds().overlaps(item.getBoundingRectangle())){
                score += item.getScoreValue();
                iter.remove();
            }
        }
		return score;
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
	
	public int getSprintControl(){
		return controlSet[4];
	}
	
	public int getDashControl(){
		return controlSet[5];
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
    
	public int getWalkingSpeed() {
		return walkingSpeed;
	}

	public int getRunningSpeed() {
		return runningSpeed;
	}

	public float getStamina() {
		return stamina;
	}
	
	public void setStamina(float stamina) {
		this.stamina = stamina;
	}
	
	public void addStamina() {
		if (this.stamina < this.getMaxStamina())
		this.stamina += 0.5;
	}
	
	public void exhaustStamina(float loss) {
		this.stamina -= loss;
		if (this.stamina < 0 ){
			this.stamina = 0;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMaxStamina() {
		return maxStamina;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}
}