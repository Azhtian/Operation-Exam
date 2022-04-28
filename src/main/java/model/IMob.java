package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
/**
 * @author stian
 *
 */
public interface IMob {

	/**
	 * @return texture of mob/player
	 */
	public Texture getPlayerImage();
	
	/** Sets the image of this mob/player
	 * @param image
	 */
	public void setPlayerImage(Texture image);
	
    /** Sets the positions of this mob
     * @param x
     * @param y
     */
    public void setPos(float x, float y);

    /**
     * @return gravity of mob
     */
    public float getGravity();

    /** Applies gravity to the ySpeed unless it is larger than the maxSpeed
     */
    public void applyGravity();
    
	/** 
	 * @return x position
	 */
	public float getX();

	/** Sets x-position
	 * @param x new x-position
	 */
	public void setX(float x);
	
	/** 
	 * @return y position
	 */
	public float getY();
	
	/** Sets y-position
	 * @param y new y-position
	 */
	public void setY(float y) ;

    /**
     * @return Rectangle of boundingBox
     */
    public Rectangle getBounds();
  
	
	/** Moves x-position relative to self
	 * @param x amount to move
	 */
	public void changeX(float x);

	/** Moves y-position relative to self
	 * @param y amount to move
	 */
	public void changeY(float y);

	/** Moves x- and y-position relative to self
	 * @param x to move
	 * @param y to move
	 */
    public void changePos(float x, float y);
    
	/** 
	 * @return current xSpeed of mob
	 */
	public float getXSpeed();

	/** Sets the xSpeed of mob
	 * @param xSpeed
	 */
	public void setXSpeed(float xSpeed);
	
	/** Changes xSpeed relative to current
	 * @param xSpeed
	 */
	public void changeXSpeed(float xSpeed);
	
	/**
	 * @return current ySpeed of mob
	 */
	public float getYSpeed();

	/** Sets the ySpeed of mob
	 * @param ySpeed
	 */
	public void setYSpeed(float ySpeed);
	
	/** Changes ySpeed relative to current
	 * @param ySpeed
	 */
	public void changeYSpeed(float ySpeed);

	/**
	 * @return width of mob
	 */
	public float getWidth();

	/**
	 * @return height of mob
	 */
	public float getHeight();
	
	/** Sets the height of the mob
	 * @param height
	 */
	public void setHeight(float height);

	/**
	 * @return whether mob is grounded or not
	 */
	public boolean isGrounded();

	/** Sets whether mob is grounded or not
	 * @param value new value 
	 */
	public void setGrounded(boolean value);
	
	/**
	 * @return x-position of middle of mob width
	 */
	public float getCentreX();
	
	/**
	 * @return y-position of middle of mob height
	 */
	public float getCentreY();

    /**
     * @return max speed of mob
     */
    public float getMaxSpeed();

	/**
	 * @return jump strength of mob
	 */
	public float getJumpStrength();

	/** Sets the jump strength om mob
	 * @param value positive value
	 */
	public void setJumpStrength(float value);

	// Collisions
	/** Constrains mob in y direction by checking collisions between this mob and platforms
	 * @param model, Game model
	 * @param downIsPressed, whether down is pressed or not
	 */
	public void yCollisions(Model model, Boolean downIsPressed);
	
	/** Constrains mob in x direction by checking collisions between this mob and platforms
	 * @param model, Game model
	 */
	public void xCollisions(Model model);
	
	
	// Movement directions
	
	/** Sets whether mob is moving or not
	 * @param moving
	 */
	public void setMoving(boolean moving);

    /**
     * @return true if moving, false if not
     */
    public boolean isMoving();
	
	/**
     * @return true if mob was moving right
     */
    public boolean wasMovingRight();

    /** Sets the wasMovingRight variable
     * @param value
     */
    public void setWasMovingRight(boolean value);

    /** Sets the isMovingRight variable
     * @param value
     */
    public void setMovingRight(boolean value);

    /**
     * @return true if is moving right
     */
    public boolean isMovingRight();
	
	
	// Animations //
	
    /** Updates the animation counters and pointers
     * @return true if updated, false otherwise
     */
    public boolean updateAnimation();

    /** Changes the mob texture based on its horizontal direction
     * @param right texture
     * @param left texture
     */
    public void changeMobTexture(Texture right, Texture left);
    
    /** 
     * @return animationCounter value
     */
    public int getAnimationCounter();

    /**
     * @return animationPointer value
     */
    public int getAnimationPointer();
}