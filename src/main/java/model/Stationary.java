package model;

import com.badlogic.gdx.graphics.Texture;

public class Stationary extends Enemy {

	/** Creates a Stationary Enemy
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 */
	public Stationary(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	/** Creates a Stationary Enemy with image
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param image
	 */
	public Stationary(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
	}
	
	@Override
	public void doMovement(Model model) {
	}
}
