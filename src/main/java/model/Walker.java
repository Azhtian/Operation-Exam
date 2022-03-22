package model;

import com.badlogic.gdx.graphics.Texture;

public class Walker extends Enemy{

	public Walker(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		this.setMoveSpeed(2);
	}	

	public void doAction() {
		if (getMovingRight()) {
			this.changeX(getMoveSpeed());
		} else {
			this.changeX(-getMoveSpeed());
		}
	}
}
