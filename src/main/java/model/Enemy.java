package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public abstract class Enemy extends Mob {
	
	private Boolean movingRight;
	private float moveSpeed;
	private Boolean hasGravity;


	public Enemy(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		
		this.setMovingRight(false);
	}
	
	public void doAction () {
	}
	
	public void doMovement(Model model) {
		
		// Action
		this.doAction();

		// X collisions
		for (Rectangle rect : model.getPlatforms()) {
			if (this.getBounds().overlaps(rect)) {
				if (this.getMovingRight()) {
					this.setX(rect.x - this.getWidth());
					this.setMovingRight(false);
				} else {
					this.setX(rect.x + rect.width);
					this.setMovingRight(true);
				}
			}
		}
		// Falling
		this.changeYSpeed(model.getGravity());
		this.changeY(this.getYSpeed());
		this.setGrounded(false);
		
		// Y collisions
		for (Rectangle rect : model.getPlatforms()) {
			if (this.getBounds().overlaps(rect)) {
					this.setY(rect.getY() + rect.getHeight());
					this.setYSpeed(0);
					this.setGrounded(true);
			}
		}
	}

	public boolean getMovingRight() {
		return movingRight;
	}

	public void setMovingRight(Boolean movingRight) {
		this.movingRight = movingRight;
	}


	public float getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(float moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public Boolean getHasGravity() {
		return hasGravity;
	}

	public void setHasGravity(Boolean hasGravity) {
		this.hasGravity = hasGravity;
	}
}
