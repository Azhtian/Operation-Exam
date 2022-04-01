package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class Mob extends Sprite{	
	
	private final Rectangle bounds;
	private boolean grounded;
	private Texture playerImage;
	private final float height;
	private final float width;
	private float y;
	private float x;
	private float ySpeed;
	private float xSpeed = 3;

    private final float gravity;

    private boolean movingRight = false;
    private boolean wasMovingRight = false;

    // Animation counters
    private int animationCounter;
    private int animationPointer;


	private float jumpStrength;

	public Mob(float x, float y, float width, float height){
		this.bounds = new Rectangle(x, y, width, height);
		this.setX(x);
		this.setY(y);
		this.width = width;
		this.height = height;
		this.setGrounded(true);
		this.gravity = -4;
		this.animationCounter = 0;
		this.animationPointer = 0;
	}
    private float maxSpeed = 6;
	private float jumpStrength = 6.5f;


	public Mob(float x, float y, float width, float height, Texture image) {
        this.bounds = new Rectangle(x, y, width, height);
        this.playerImage = image;
        this.setX(x);
		this.setY(y);
		this.width = width;
		this.height = height;
		this.setGrounded(true);
        this.gravity = -0.5f;
        this.animationCounter = 0;
        this.animationPointer = 0;
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

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.bounds.x = x;
		this.x = x;
	}

    public boolean getWasMovingRight(){
        return wasMovingRight;
    }

    public void setWasMovingRight(boolean wasMovingRight) {
        this.wasMovingRight = wasMovingRight;
    }

    public void setAnimationCounter(int animationCounter) {
        this.animationCounter = animationCounter;
    }
    public int getAnimationCounter() {
        return  animationCounter;
    }

    public void setAnimationPointer(int animationPointer) {
        this.animationPointer = animationPointer;
    }

    public int getAnimationPointer() {
        return animationPointer;
    }

    public void setMovingRight(Boolean value) {
        movingRight = value;
    }

    public boolean getMovingRight() {
        return movingRight;
    }
	
	public void changeX(float x) {
		this.bounds.x += x;
		this.x += x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.bounds.y = y;
		this.y = y;
	}
	
	public void changeY(float y) {
		this.bounds.y += y;
		this.y += y;
	}

    public void changePos(float x, float y) {
        this.x += x;
        this.y += y;
        bounds.x += x;
        bounds.y += y;
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

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public Texture getPlayerImage() {
		return playerImage;
	}

	public boolean isGrounded() {
		return grounded;
	}

	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}

	public float getXSpeed() {
		return xSpeed;
	}

	public void setXSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public void changeXSpeed(float xSpeed) {
		this.xSpeed += xSpeed;
	}
	
	public float getCentreX() {
			return this.getX() + this.getWidth()/2;
	}
	
	public float getCentreY() {
		return this.getY() + this.getHeight()/2;
	}


    public void setPlayerImage(Texture texture) {
        playerImage = texture;
    }

    public float getMaxSpeed() {
		return maxSpeed;
	}

	public float getJumpStrength() {
		return jumpStrength;
	}

	public void setJumpStrength(float jumpStrength) {
		this.jumpStrength = jumpStrength;
	}

    public boolean updateAnimation() {
        setAnimationCounter((getAnimationCounter() + 1) % 20);

        if (getWasMovingRight() != getMovingRight()){
            setWasMovingRight(getMovingRight());
            setAnimationCounter(0);
            return true;
        }
        // Update enemy texture
        if (getAnimationCounter() == 0) {
            setAnimationPointer((getAnimationPointer() + 1) % 2);
            return true;
        }
        return false;
    }
}
