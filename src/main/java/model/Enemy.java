package model;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Mob {
	
	private Boolean movingRight = false;
	private Boolean stationary = true;
	private int moveSpeed;

	public Enemy(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		this.moveSpeed = 2;
	}
	
	public void doAction () {
		if (!stationary) {
			if (movingRight) {
				this.changeX(moveSpeed);
			} else {
				this.changeX(-moveSpeed);
			}
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
