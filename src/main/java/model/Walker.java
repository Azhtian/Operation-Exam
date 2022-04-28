package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Walker extends Enemy{
	private final Rectangle sensorLeft = new Rectangle(0, 0, 2, 16);
	private final Rectangle sensorRight = new Rectangle(0, 0, 2, 16);;
	private Boolean sensorLeftActivation;
	private Boolean sensorRightActivation;

	/** Creates a Jumper Enemy that turns around when it encounters a wall of is about to fall off a platform
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 */
	public Walker(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.setCurrentSpeed(1.2f);
	}
	
	/** Creates a Walker Enemy that turns around when it encounters a wall of is about to fall off a platform
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 * @param image
	 */
	public Walker(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		this.setCurrentSpeed(1.2f);
	}	

	@Override
	public void doAction(Model model) {
		// Turn if on edge
		doTurn();
		// Move
		move();
	}  
	
	@Override
	public void doMovement(Model model) {
		// Sensor
		updateSensor(model);
		
		// Action
		doAction(model);
		
		// X collisions
		xCollisions(model);
		
		// Falling
		applyGravity();
		setGrounded(false);
		
		// Y collisions
		yCollisions(model, false);
	}
	
	/** Enemy turns around if sensor is triggered
	 */
	public void doTurn() {
		if (sensorLeftActivation && !sensorRightActivation) {
			this.setMovingRight(true);
		} if (!sensorLeftActivation && sensorRightActivation) {
			this.setMovingRight(false);
		}
	}
	
	/** Moves Enemy along
	 */
	public void move() {
		if (isMovingRight()) {
			this.changeX(getCurrentSpeed());
		} else {
			this.changeX(-getCurrentSpeed());
		}
	}
	
	/** Updates sensors and checks collision
	 * @param model Game model
	 */
	public void updateSensor(Model model) {
		this.setSensor();
		this.sensorLeftActivation = false;
		this.sensorRightActivation = false;
		for (Rectangle rect : model.getPlatforms()) {
			if (this.sensorLeft.overlaps(rect)) {
				this.sensorLeftActivation = true;
			}
			if (this.sensorRight.overlaps(rect)) {
				this.sensorRightActivation = true;
			}
		}
	}
	
	/** Updates sensor position to Enemy position
	 */
	public void setSensor() {
		this.sensorRight.x = this.getX();
		this.sensorRight.y = this.getY() - 16;
		
		this.sensorLeft.x = this.getX() + 16 - this.sensorLeft.getWidth();
		this.sensorLeft.y = this.getY() - 16;
	}
	
	/**
	 * @return Left sensor
	 */
	public Rectangle getSensorLeft() {
		return sensorLeft;
	}
	
	/**
	 * @return Right sensor
	 */
	public Rectangle getSensorRight() {
		return sensorRight;
	}
}
