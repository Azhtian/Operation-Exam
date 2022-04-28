package model;

import com.badlogic.gdx.graphics.Texture;


public abstract class Enemy extends Mob {

	/** Creates an Enemy
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 */
	public Enemy(float x, float y, float width, float height) {
		super(x, y, width, height);
		this.setMovingRight(false);
	}

	/** Creates an Enemy with image
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param width
	 * @param height
	 * @param image
	 */
	public Enemy(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height);
		this.setPlayerImage(image);
		this.setMovingRight(false);
	}
	
	/** Makes Enemy do a series of actions
	 * @param model Game model
	 */
	public void doAction (Model model) {
	}
	
	/** Updates Enemy and performs actions
	 * @param model Game model
	 */
	public void doMovement(Model model) {
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
	
	/** 
	 * @param model Game model
	 * @param detectionDistance in units
	 * @return the closest player
	 */
	public Player findClosePlayer(Model model, int detectionDistance) {
		Player close = null;
		for (Player p : model.getPlayers()) {
			if (Math.sqrt(Math.pow(p.getCentreX()-this.getCentreX(),2) + Math.pow(p.getCentreY()-this.getCentreY(),2)) < detectionDistance*16) {
				if (close == null){
					close = p;
				} else if (Math.pow(p.getCentreX()-this.getCentreX(),2) + Math.pow(p.getCentreY()-this.getCentreY(),2) < Math.pow(close.getCentreX()-this.getCentreX(),2) + Math.pow(close.getCentreY()-this.getCentreY(),2)) {
					close = p;
				}
			}
		}
		return close;
	}
}
