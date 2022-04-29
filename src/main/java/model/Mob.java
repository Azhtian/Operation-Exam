package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/** A Mob is a rectangular libGDX Texture that can move, has collisions and superclass of Player and Enemy
 */
public abstract class Mob extends Sprite implements IMob {	
	
	private final Rectangle bounds;
	private boolean grounded;
	private Texture playerImage;
	private float height;
	private final float width;
	private float y;
	private float x;
	private float ySpeed;
	private float xSpeed;
	private float currentSpeed;
	private final float gravity;
    private boolean isMoving = false;
    private boolean isMovingRight = false;
    private boolean wasMovingRight = false;
    
    
    // Animation counters
    private int animationCounter;
    // Points to which animation frame to render
    private int animationPointer;


	/** Creates a new Mob with lower right corner position and dimensions
	 * @param x x-position
	 * @param y y-position
	 * @param width the width
	 * @param height the height
	 */
	public Mob(float x, float y, float width, float height) {
		this.bounds = new Rectangle(x, y, width, height);
		this.setPos(x, y);
		this.width = width;
		this.height = height;
		this.setGrounded(true);
		this.gravity = -0.5f;
		this.animationCounter = 0;
		this.animationPointer = 0;
	}

	public Texture getPlayerImage() {
		return playerImage;
	}

    @Override
	public void setPlayerImage(Texture image) {
		this.playerImage = image;
	}
	
    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
        this.bounds.x = x;
        this.bounds.y = y;
    }

    public float getGravity(){
        return gravity;
    }
    
    public void applyGravity() { 
		this.changeYSpeed(getGravity());
		this.changeY(Math.max(this.getYSpeed(), -this.getMaxSpeed()));
	}
    

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.bounds.x = x;
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.bounds.y = y;
		this.y = y;
	}

    public Rectangle getBounds() {
		return this.bounds;
	}
  
	public void xCollisions(Model model) {
		for (Platform rect : model.getPlatforms()) {
			if (this.getBounds().overlaps(rect) && !rect.isThin()) {
				if (this.isMovingRight()) {
					this.setX(rect.x - this.getWidth());
					if (this instanceof Enemy) {this.setMovingRight(false);}
				} else {
					this.setX(rect.x + rect.width);
					if (this instanceof Enemy) {this.setMovingRight(true);}
				}
			}
		}
	}
    
	public void yCollisions(Model model, Boolean downIsPressed) {
		for (Platform rect : model.getPlatforms()) {
			if (this.getBounds().overlaps(rect)) {
				if (rect.isThin()) {
					if (this.getYSpeed() >= 0 || downIsPressed) {
					}
					else if (this.getYSpeed() <= 0 && this.getY() >= rect.y+8) {
						this.setY(rect.height + rect.y);
						this.setYSpeed(0);
						this.setGrounded(true);
					} 
				}
				else if (!rect.isThin()) {
					if (this.getYSpeed() < 0) {
						this.setY(rect.height + rect.y);
						this.setGrounded(true);
					} else {
						this.setY(rect.y - this.getHeight());
					}
					this.setYSpeed(0);
				}
			}
		}
	}
	
	public void changeX(float x) {
		this.bounds.x += x;
		this.x += x;
	}

	public void changeY(float y) {
		this.bounds.y += y;
		this.y += y;
	}


	public float getXSpeed() {
		return xSpeed;
	}

	public void setXSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}

	public float getYSpeed() {
		return ySpeed;
	}

	public void setYSpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public void changeYSpeed(float ySpeed) {
		this.ySpeed += ySpeed;
	}
	
	public float getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(float currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	public boolean isGrounded() {
		return grounded;
	}

	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}

	public float getCentreX() {
			return this.getX() + this.getWidth()/2;
	}
	
	public float getCentreY() {
		return this.getY() + this.getHeight()/2;
	}

    public float getMaxSpeed() {
		return 6f;
	}

	public float getJumpStrength() {
		return 6f;
	}

	public void setMoving(boolean moving){
        this.isMoving = moving;
    }

    public boolean isMoving() {
        return this.isMoving;
    }
    
    public boolean wasMovingRight(){
        return this.wasMovingRight;
    }

    public void setWasMovingRight(boolean value) {
        this.wasMovingRight = value;
    }

    public void setMovingRight(boolean value) {
        this.isMovingRight = value;
    }

    public boolean isMovingRight() {
        return this.isMovingRight;
    }

    public boolean updateAnimation() {
        animationCounter = ((animationCounter + 1) % 20);
        if (wasMovingRight != isMovingRight) {
            wasMovingRight = isMovingRight;
            animationCounter = 0;
            return true;
        }
        // Update enemy texture pointer
        if (animationCounter == 0) {
        	animationPointer = ((animationPointer + 1) % 2);
            return true;
        }
        return false;
    }
    
    public void changeMobTexture(Texture right, Texture left) {
        if (this.isMovingRight()) {
            this.setPlayerImage(right);
        } else {
            this.setPlayerImage(left);
        }
    }
   
    public int getAnimationCounter() {
        return  animationCounter;
    }

    public int getAnimationPointer() {
        return animationPointer;
    }
}
