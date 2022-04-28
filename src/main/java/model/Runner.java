package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Runner extends Walker {
	private final int detectionDistance;
	private Player closePlayer;

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
		if (p == null) {
			this.setCurrentSpeed(1.2f);
		} else {
			this.setCurrentSpeed(2);
			this.setMovingRight(!(p.getCentreX() - this.getCentreX() < 0));
		}
	}	
}
