package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Sprite {

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
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.playerImage = playerImage;
		this.grounded = true;

		bounds = new Rectangle(x, y, width, height);
	}

	public void setHealth(int health){
		this.health = health;
	}

	public void damage(int damage){
		this.health = this.health - damage;
	}

	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}

	public void changePos(float x, float y) {
		this.x += x;
		this.y += y;
		bounds.x += x;
		bounds.y += y;
	}

	public void setOnGround(boolean ground){
		this.grounded = ground;
	}

	public void setSpeed(int y) {
		this.speedY = y;
	}

	public void changeSpeed(float y) {
		this.speedY += y;
	}

	public void moveY() {
		this.y += this.speedY;
	}

	public float getX(){
		return this.x;
	}

	public float getY(){
		return this.y;
	}

	public float getWidth(){
		return this.width;
	}

	public float getHeight(){
		return this.height;
	}


	public int getSpeedY() {
		return speedY;
	}

	public Boolean getGrounded() {
		return grounded;
	}

	public int getA() {
		return a;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score){this.score = score;}

	public void addScore(int score){this.score += score;}

	public Rectangle getBounds() {
		return bounds;
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