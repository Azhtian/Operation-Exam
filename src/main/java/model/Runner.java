package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Runner extends Enemy{
	private final Rectangle sensorLeft;
	private final Rectangle sensorRight;
	private Boolean sensorLeftActivation;
	private Boolean sensorRightActivation;
	private final int detectionDistance;
	private Player closePlayer;

	public Runner(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		this.setMoveSpeed((float)1.2);
		this.sensorRight = new Rectangle( 0, 0 , 2,16);
		this.sensorLeft = new Rectangle( 0, 0 , 2,16);
		this.detectionDistance = 10;
	}	

	public void doAction() {
		// Turn if on edge
		if (sensorLeftActivation && !sensorRightActivation) {
			this.setMovingRight(true);
		} if (!sensorLeftActivation && sensorRightActivation) {
			this.setMovingRight(false);
		}
		
		// Chase Player
		if (this.closePlayer == null) {
			this.setMoveSpeed((float)1.2);
		} else {
			this.setMoveSpeed(2);
			this.setMovingRight(!(closePlayer.getCentreX() - this.getCentreX() < 0));
		}
	
		
		
		// Turn 
		
		// Move
		if (getMovingRight()) {
			this.changeX(getMoveSpeed());
		} else {
			this.changeX(-getMoveSpeed());
		}
	}   
	
	public void doMovement(Model model) {
		
		// Sensor
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
		
		this.findClosePlayer(model);
		
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
		this.sensorRight.x = this.getX();
		this.sensorRight.y = this.getY() - 16;
		
		this.sensorLeft.x = this.getX() + 16 - this.sensorLeft.getWidth();
		this.sensorLeft.y = this.getY() - 16;
	}
	
	public void findClosePlayer(Model model) {
		Player close = null;
		for (Player p : model.getPlayers()) {
			if (Math.sqrt(Math.pow(p.getCentreX()-this.getCentreX(),2) + Math.pow(p.getCentreY()-this.getCentreY(),2)) < this.detectionDistance*16) {
				if (close == null){
					close = p;
				}else if (Math.pow(p.getCentreX()-this.getCentreX(),2) + Math.pow(p.getCentreY()-this.getCentreY(),2) < Math.pow(close.getCentreX()-this.getCentreX(),2) + Math.pow(close.getCentreY()-this.getCentreY(),2)) {
					close = p;
				}
			}
		}
		this.closePlayer = close;
	}
	
}
