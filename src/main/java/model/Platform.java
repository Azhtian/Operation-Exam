package model;

import com.badlogic.gdx.math.Rectangle;

public class Platform extends Rectangle {

	private final Boolean thin;

	/** Create a platform using position and dimensions.
	 * A Platform might have the property thin, meaning players can pass through them in alot of ways.
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width of Platform
	 * @param height of Platform
	 * @param thin Platform property
	 */
	public Platform(float x, float y, float width, float height, Boolean thin) {
		super(x, y, width, height);
		this.thin = thin;
	}
	
	/** Create a platform using a Rectangle.
	 * A Platform might have the property thin, meaning players can pass through them in alot of ways.
     */
	public Platform(Rectangle rect, Boolean thin) {
		this.x = rect.x;
		this.y = rect.y;
		this.width = rect.width;
		this.height = rect.height;
		this.thin = thin;
	}
	
	/**
	 * @return true if this Platform has the thin property
	 */
	public Boolean isThin() {
		return this.thin;
	}
	
	/**
	 * @return a Rectangle with same dimensions as this platform
	 */
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
}
