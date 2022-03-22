package model;

import com.badlogic.gdx.graphics.Texture;

public class Stationary extends Enemy{

	public Stationary(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
	}
	
	public void doAction() {
	}
	
	@ Override
	public void changeYSpeed(float gravity) {
	}

}
