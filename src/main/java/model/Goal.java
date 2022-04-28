package model;

import com.badlogic.gdx.math.Rectangle;

public class Goal {
	private final float x;
	private final float y;
	private final float width;
	private final float height;
	private final Rectangle bounds;

	/** Creates a Goal
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 */
	public Goal(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	/** @return x position*/
	public float getX() {
		return x;
	}

	/** @return y position*/
	public float getY() {
		return y;
	}

	/** @return width of Goal*/
	public float getWidth() {
		return width;
	}

	/**@return height of Goal*/
	public float getHeight() {
		return height;
	}

	/**@return bounds of Goal*/
	public Rectangle getBounds() {
		return bounds;
	}
}
