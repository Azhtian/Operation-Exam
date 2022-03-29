package model;

import com.badlogic.gdx.math.Rectangle;

public class Platform extends Rectangle {

	private Boolean thin;

	public Platform(float x, float y, float width, float height, Boolean thin) {
		super(x, y, width, height);
		this.thin = thin;
	}
	
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
	
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
}
