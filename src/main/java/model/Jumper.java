package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Jumper extends Walker {

	private final Rectangle sensor;
	private Boolean sensorActivation;


	/** Creates a Jumper Enemy that jumps when its about to fall off a platform
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 */
	public Jumper(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.sensor = new Rectangle(0, 0, (float) (width * 0.75), 16);
	}

	/** Creates a Jumper Enemy that jumps when its about to fall off a platform
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 * @param image
	 */
	public Jumper(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		this.sensor = new Rectangle(0, 0, (float) (width * 0.75), 16);
	}
	
	@Override
	public void doAction (Model model) {
		// Jump if on edge
		jump();
		// Move
		move();
	}
	
	@Override
	public void doMovement(Model model) {
		// Sensor
		this.setSensor();
		this.sensorActivation = false;
		for (Rectangle rect : model.getPlatforms()) {
			if (this.sensor.overlaps(rect)) {
				this.sensorActivation = true;
			}
		}
		updateSensor(model);
		// Action
		doAction(model);
		
		// X collisions
		xCollisions(model);
		
		// Falling
		setGrounded(false);
		applyGravity();
		
		// Y collisions
		yCollisions(model, false);
	}
	
	@Override
	public void setSensor() {
		sensor.setX(this.getX() + this.getWidth() / 8);
		sensor.setY(this.getY() - 16);
	}

	/** Enemy performs a jump
	 */
	public void jump() {
		if (!this.sensorActivation && this.isGrounded()) {
			this.setYSpeed(this.getJumpStrength());
		}
	}
}
