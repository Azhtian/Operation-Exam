package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Jumper extends Enemy{

	private final Rectangle sensor;
	private Boolean sensorActivation;


	public Jumper(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.setMoveSpeed((float)1.2);
		this.setJumpStrength(10);
		this.sensor = new Rectangle(0, 0, (float) (width * 0.75), 16);
	}

	public Jumper(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		
		this.setMoveSpeed((float)1.2);
		this.setJumpStrength(6);
		this.sensor = new Rectangle(0, 0, (float) (width * 0.75), 16);
	}
	
	public void doAction () {
		// Jump if on edge
		if (!this.sensorActivation && this.isGrounded()) {
			jump();
		}
		// Move
		if (getMovingRight()) {
			this.changeX(getMoveSpeed());
			this.sensor.x += getMoveSpeed();
		} else {
			this.changeX(-getMoveSpeed());
			this.sensor.x -= getMoveSpeed();
		}
	}
	
	public void doMovement(Model model) {
		
		// Sensor
		this.setSensor();
		this.sensorActivation = false;
		for (Rectangle rect : model.getPlatforms()) {
			if (this.sensor.overlaps(rect)) {
				this.sensorActivation = true;
			}
		}
		
		// Action
		this.doAction();
		
		// X collisions
		for (Rectangle rect : model.getPlatforms()) {
			if (this.getBounds().overlaps(rect)) {
				if (this.getMovingRight()) {
					this.setX(rect.x - this.getWidth());
					this.setMovingRight(false);
				} else {
					this.setX(rect.x + rect.width);
					this.setMovingRight(true);
				}
			}
		}
		// Falling
		this.changeYSpeed(model.getGravity());
		this.changeY(this.getYSpeed());
		this.setGrounded(false);
		
		// Y collisions
		for (Rectangle rect : model.getPlatforms()) {
			if (this.getBounds().overlaps(rect)) {
				if (this.getYSpeed() < 0) {
					this.setY(rect.getY() + rect.getHeight());
					this.setGrounded(true);
				} else {
					this.setY(rect.getY() - rect.getHeight());
				}
					this.setYSpeed(0);
			}
		}	
	}
	
	public void setSensor() {
		sensor.setX(this.getX() + this.getWidth() / 8);
		sensor.setY(this.getY() - 16);
	}

	public void jump(){
		this.setYSpeed(this.getJumpStrength());
	}
}
