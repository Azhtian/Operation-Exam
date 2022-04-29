package model;

import com.badlogic.gdx.math.Rectangle;

public class Goal {
	private final Rectangle bounds;

	/** Creates a Goal
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width of object
	 * @param height of object
	 */
	public Goal(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
	}

    /**@return bounds of Goal*/
	public Rectangle getBounds() {
		return bounds;
	}
}
