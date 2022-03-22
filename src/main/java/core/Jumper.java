package core;

import com.badlogic.gdx.graphics.Texture;

import model.Enemy;

public class Jumper extends Enemy{

	
	public Jumper(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
	}
	
	public void doAction () {
		if (!getStationary()) {
			if (getMovingRight()) {
				this.changeX(getXSpeed());
			} else {
				this.changeX(-getXSpeed());
			}
		} 
	}
	
}
