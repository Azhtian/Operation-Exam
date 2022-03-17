package model;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Player {
	
	private Boolean movingRight = false;
	private int moveSpeed;

	public Enemy(float x, float y, float width, float height, Texture playerImage) {
		super(x, y, width, height, playerImage);
		this.moveSpeed = 3;
	}
	
	public void move () {
		if (movingRight) {
			this.changePos(moveSpeed, 0);
		} else {
			this.changePos(-moveSpeed, 0);
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
	
}
