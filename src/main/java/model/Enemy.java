package model;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Player {
	
	private Boolean movingRight = false;
	private Boolean stationary = true;
	private int moveSpeed;

	public Enemy(float x, float y, float width, float height, Texture playerImage) {
		super(x, y, width, height, playerImage);
		this.moveSpeed = 2;
	}
	
	public void moveX () {
		if (!stationary) {
			if (movingRight) {
				this.changePos(moveSpeed, 0);
			} else {
				this.changePos(-moveSpeed, 0);
			}
		} 
	}
	
	public void moveY (int gravity) {
		if (!stationary) {
			this.changeSpeed(gravity);
			this.changePos(0, this.getSpeedY());
		}
	}
	
	public boolean getMovingRight() {
		return movingRight;
	}

	public void setMoveSpeed(int speed){
		moveSpeed = speed;
	}
	
	public void setMovingRight(Boolean value) {
		movingRight = value;
	}
	
	public void setStationary(Boolean value) {
		stationary = value;
	}	
}
