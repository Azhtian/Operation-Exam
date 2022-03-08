package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Sprite {

	private float x;
	private float y;
	private int speedY = 0;
	Boolean grounded;
	private int a = -1;
	private int score = 0;
	public int width = 16;
	public int height = 16;
	private Rectangle bounds;
	private Texture playerImage;
	// String playerName;


	public Player(int x, int y, Texture playerImage) {
		this.x = x;
		this.y = y;
		this.playerImage = playerImage;

		bounds = new Rectangle(x, y, 16, 16);
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

	public Rectangle getBounds() {
		return bounds;
	}

	public Texture getPlayerImage() {
		return playerImage;
	}
}