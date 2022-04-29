package model;

import com.badlogic.gdx.graphics.Texture;

public class Boss extends Enemy {

	/** Creates a Boss enemy (Anya) which follows the closest player
	 * @param x position bottom left
	 * @param y position bottom left
	 * @param image of boss
	 */
	public Boss(float x, float y, float width, float height, Texture image){
		super(x, y, width, height, image);
		this.setCurrentSpeed(0.8f);
	}
	
	public void doMovement(Model model){
		Player closestPlayer = findClosePlayer(model, 1000);
		facePlayer(closestPlayer);
		this.changeX((float) (this.getCurrentSpeed() * (closestPlayer.getCentreX()-this.getCentreX())/(Math.sqrt(Math.pow(closestPlayer.getCentreX()-this.getCentreX(),2) + Math.pow(closestPlayer.getCentreY()-this.getCentreY(),2)))));
		this.changeY((float) (this.getCurrentSpeed() * (closestPlayer.getCentreY()-this.getCentreY())/(Math.sqrt(Math.pow(closestPlayer.getCentreX()-this.getCentreX(),2) + Math.pow(closestPlayer.getCentreY()-this.getCentreY(),2)))));
	}
	
	/** Turns the boss towards the player
	 * @param p Player to face
	 */
	public void facePlayer(Player p) {
		this.setMovingRight(!(this.getCentreX() >= p.getCentreX()));
	}

}
