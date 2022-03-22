package model;

import com.badlogic.gdx.graphics.Texture;

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

	public Boolean getMovingRight() {
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
