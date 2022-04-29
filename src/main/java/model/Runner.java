package model;

import com.badlogic.gdx.graphics.Texture;

public class Runner extends Walker {
	private final int detectionDistance;
	public Runner(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.detectionDistance = 10;
	}

	public Runner(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		this.detectionDistance = 10;
	}	

	@Override
	public void doAction(Model model) {
		// Turn if on edge
		doTurn();
		
		// Chase Player
		Player p = findClosePlayer(model, detectionDistance);
		chase(p);
		
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
	
	/** Changes speed to chase player
	 * @param p A player to chase
	 */
	public void chase(Player p) {
        // Chase Player
        float angle;
        if (p == null) {
            this.setCurrentSpeed((float) 1.2);
        } else {
            angle = Math.abs(p.getCentreX() - this.getCentreX()) / Math.abs(p.getCentreY() - this.getCentreY());
            if (angle < this.detectionDistance / 128f) {
                this.setCurrentSpeed(0);
            } else {
                this.setCurrentSpeed(2);
                this.setMovingRight(!(p.getCentreX() - this.getCentreX() < 0));
            }
        }
	}
}
