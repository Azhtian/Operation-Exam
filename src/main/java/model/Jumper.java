package model;

import com.badlogic.gdx.graphics.Texture;

public class Jumper extends Enemy{

	private int jumpCounter;
	
	public Jumper(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		
		this.setMoveSpeed(2);
		this.jumpCounter = 0;
		this.setJumpStrength(10);
	}
	
	public void doAction () {
		jumpCounter += 1;
		jumpCounter %= 200;
		if (jumpCounter == 0) {
			this.setYSpeed(this.getJumpStrength());
		}
		if (getMovingRight()) {
			this.changeX(getMoveSpeed());
		} else {
			this.changeX(-getMoveSpeed());
		}
	} 
}
