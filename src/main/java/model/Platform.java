package model;

import com.badlogic.gdx.math.Rectangle;

public class Platform extends Rectangle {

	private final Boolean thin;

    public Platform(Rectangle rect, Boolean thin) {
		this.x = rect.x;
		this.y = rect.y;
		this.width = rect.width;
		this.height = rect.height;
		this.thin = thin;
	}
	
	public Boolean isThin() {
		return this.thin;
	}

}
