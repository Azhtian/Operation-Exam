package model;

import com.badlogic.gdx.graphics.Texture;

public class Stationary extends Enemy{

	public Stationary(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
	}


	public Stationary(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public void doMovement(Model model) {
	}
	
	
	public void changeYSpeed(float gravity) {
	}

}
