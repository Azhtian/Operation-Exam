package model;

import java.util.ArrayList;
import java.util.ListIterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import core.AppPreferences;

public class Player extends Mob {

	private static final int maxHealth = 3;
	private int health;
	private int crouchingSpeed = 2;
	private int walkingSpeed = 3;
	private int runningSpeed = 4;
	private int dashSpeed = 15;
	private int dashCounter;
	private final int maxStamina = 80;
	private float stamina;
	private int[] controlSet;
	private int idleCounter = 0;
	private Rectangle standSensor = new Rectangle(0, 0, 16, 24);
	
	public AppPreferences preferences;
	private Sound jumpSound;
	private Sound enemyHitSound;
	private Sound scoreSound;

	public Player(float x, float y, float width, float height){
		super(x, y, width, height);
		this.health = maxHealth;
		this.stamina = maxStamina;
	}
    
	public Player(float x, float y, float width, float height, Texture image, int[] controlSet){
		super(x, y, width, height);
		this.health = maxHealth;
		this.stamina = maxStamina;
		this.controlSet = controlSet.clone();
		this.setPlayerImage(image);
		
		jumpSound = Gdx.audio.newSound(Gdx.files.internal("assets/audio/jumpsound.wav"));
		enemyHitSound = Gdx.audio.newSound(Gdx.files.internal("assets/audio/death.wav"));
		scoreSound = Gdx.audio.newSound(Gdx.files.internal("assets/audio/pointSound.mp3"));
		preferences = new AppPreferences();		
	}
	
	public void doMovement(Model model) {
		// Death
		if (this.enemyCollisions(model.getEnemies())) model.setScreen(6);
		
		// Apply Gravity
		applyGravity();
		setGrounded(false);
					
		// Player XY movement'
		yCollisions(model, Gdx.input.isKeyPressed(this.getDownControl()));
		xMovement(model);
		
		// Advanced movement (Sprint,crouch,jump,dash)
		resetMovementOptions(model.getPlatforms());
		
		if (Gdx.input.isKeyPressed(this.getDownControl())) {
			crouch();
		} else {
			jump();
			sprint();
		}
		dash();
		
		//Score item
		model.addScore(score(model.getScoreItems()));
	}
	
	public void resetMovementOptions(Array<Platform> p) {
		this.addStamina();
		this.walk();
		this.stand(p);
		
	}
	
	public void dash() {
		if (Gdx.input.isKeyJustPressed(this.getDashControl()) && this.stamina >= 30) {
			this.exhaustStamina(30);
			this.dashCounter += 4;
		}
		if (this.dashCounter > 0) {
			this.setCurrentSpeed(this.dashSpeed);
			this.dashCounter -= 1;
		}
	}
	
	public void jump() {
		if (Gdx.input.isKeyJustPressed(this.getJumpControl()) && this.isGrounded() && this.stamina >= 20) {
			this.setYSpeed(6.5f); // TODO Using getter for strength here delays the jump for some reason
			this.setGrounded(false);
			this.exhaustStamina(20);
			if(preferences.isSoundOn()) {
				jumpSound.play();
			}
		}
	}
	
	public void crouch () {
		this.setHeight(16);
		this.getBounds().setHeight(16);
		this.setCurrentSpeed(this.crouchingSpeed);
	}
	
	public void stand (Array<Platform> platforms) {
		this.updateSensor();
		for (Platform p : platforms) {
			if (p.overlaps(this.standSensor) && !p.isThin()) {
				this.setCurrentSpeed(crouchingSpeed);
				return;
			}
		}
		this.setHeight(24);
		this.getBounds().setHeight(24);
		this.setCurrentSpeed(this.walkingSpeed);
	}
	
	public void sprint () {
		if (Gdx.input.isKeyPressed(this.getSprintControl()) && this.stamina >= 1) {
			this.exhaustStamina(1);
			this.setCurrentSpeed(this.runningSpeed);
		}
	}
	
	public void walk () {
		this.setCurrentSpeed(this.walkingSpeed);
	}
	
	public boolean enemyCollisions (Array<Enemy> enemies) {
		for (Enemy e : enemies) {
			if (this.getBounds().overlaps(e.getBounds())) {
				if(preferences.isSoundOn()) {
					enemyHitSound.play();
				}
				// Reset player to start-pos 
				// TODO should be from map
				this.setPos(16, 16);
				// Player takes damage
				this.damage(1);
				this.setStamina(this.maxStamina);
				if (this.getHealth() <= 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void xMovement(Model model) {
		this.setMoving(false);
		if (Gdx.input.isKeyPressed(this.getLeftControl())) {
			this.setMovingRight(false);
			this.setXSpeed(-getCurrentSpeed());
			this.setMoving(true);
		}
		if (Gdx.input.isKeyPressed(this.getRightControl())){
			this.setMovingRight(true);
			this.setXSpeed(getCurrentSpeed());
			this.setMoving(true);
		}
		this.changeX(this.getXSpeed());
		this.setXSpeed(0);
		this.xCollisions(model);
	}
	
	public int score(ArrayList<Item> scoreitems) {
		ListIterator<Item> iter = scoreitems.listIterator();
		int score = 0;
        while(iter.hasNext()){
            Item item = iter.next();
            if(this.getBounds().overlaps(item.getBoundingRectangle())){
            	if(preferences.isSoundOn()) {
					scoreSound.play();
				}
                score += item.getScoreValue();
                iter.remove();
            }
        }
		return score;
	}
	public void updateSensor() {
		this.standSensor.setX(this.getX());
		this.standSensor.setY(this.getY());
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

    @Override
    public boolean updateAnimation() {
        if (this.isMoving()) {
            idleCounter = 0;
            return super.updateAnimation();
        }
        idleCounter += 1;
        return false;
    }
    
    public int getIdleCounter() {
        return idleCounter;
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

	public int getMaxStamina() {
		return this.maxStamina;
	}
}