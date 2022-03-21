package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class Mob extends Sprite{	
	
	private Rectangle bounds;
	private boolean grounded;
	private Texture playerImage;
	private float height;
	private float width;
	private float y;
	private float x;
	private float ySpeed;
	private float xSpeed;
    private float gravity;
	
	public Mob(float x, float y, float width, float height, Texture image) {
        this.bounds = new Rectangle(x, y, width, height);
        this.playerImage = image;
        this.setX(x);
		this.setY(y);
		this.width = width;
		this.height = height;
		this.setGrounded(true);
        this.gravity = -4;
	}

    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
        this.bounds.x = x;
        this.bounds.y = y;
    }

    public float getGravity(){
        return gravity;
    }

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.bounds.x = x;
		this.x = x;
	}
	
	public void changeX(float x) {
		this.bounds.x += x;
		this.x += x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.bounds.y = y;
		this.y = y;
	}
	
	public void changeY(float y) {
		this.bounds.y += y;
		this.y += y;
	}

    public void changePos(float x, float y) {
        this.x += x;
        this.y += y;
        bounds.x += x;
        bounds.y += y;
    }
	
	public float getYSpeed() {
		return ySpeed;
	}

	public void setYSpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public void changeYSpeed(float ySpeed) {
		this.ySpeed += ySpeed;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public Texture getPlayerImage() {
		return playerImage;
	}

	public boolean isGrounded() {
		return grounded;
	}

	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}

	public float getXSpeed() {
		return xSpeed;
	}

	public void setXSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public void changeXSpeed(float xSpeed) {
		this.xSpeed += xSpeed;
	}
}
