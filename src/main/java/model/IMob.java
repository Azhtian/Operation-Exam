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
	Texture getPlayerImage();
	
	/** Sets the image of this mob/player
	 */
	void setPlayerImage(Texture image);
	
    /** Sets the positions of this mob
	 */
	void setPos(float x, float y);

    /**
     * @return gravity of mob
     */
	float getGravity();

    /** Applies gravity to the ySpeed unless it is larger than the maxSpeed
     */
	void applyGravity();
    
	/** 
	 * @return x position
	 */
	float getX();

	/** Sets x-position
	 * @param x new x-position
	 */
	void setX(float x);
	
	/** 
	 * @return y position
	 */
	float getY();
	
	/** Sets y-position
	 * @param y new y-position
	 */
	void setY(float y) ;

    /**
     * @return Rectangle of boundingBox
     */
	Rectangle getBounds();
  
	
	/** Moves x-position relative to self
	 * @param x amount to move
	 */
	void changeX(float x);

	/** Moves y-position relative to self
	 * @param y amount to move
	 */
	void changeY(float y);

	/**
	 * @return current xSpeed of mob
	 */
	float getXSpeed();

	/** Sets the xSpeed of mob
	 */
	void setXSpeed(float xSpeed);

	/**
	 * @return current ySpeed of mob
	 */
	float getYSpeed();

	/** Sets the ySpeed of mob
	 */
	void setYSpeed(float ySpeed);
	
	/** Changes ySpeed relative to current
	 */
	void changeYSpeed(float ySpeed);

	/**
	 * @return width of mob
	 */
	float getWidth();

	/**
	 * @return height of mob
	 */
	float getHeight();
	
	/** Sets the height of the mob
	 */
	void setHeight(float height);

	/**
	 * @return whether mob is grounded or not
	 */
	boolean isGrounded();

	/** Sets whether mob is grounded or not
	 * @param value new value 
	 */
	void setGrounded(boolean value);
	
	/**
	 * @return x-position of middle of mob width
	 */
	float getCentreX();
	
	/**
	 * @return y-position of middle of mob height
	 */
	float getCentreY();

    /**
     * @return max speed of mob
     */
	float getMaxSpeed();

	/**
	 * @return jump strength of mob
	 */
	float getJumpStrength();

	// Collisions
	/** Constrains mob in y direction by checking collisions between this mob and platforms
	 * @param model, Game model
	 * @param downIsPressed, whether down is pressed or not
	 */
	void yCollisions(Model model, Boolean downIsPressed);
	
	/** Constrains mob in x direction by checking collisions between this mob and platforms
	 * @param model, Game model
	 */
	void xCollisions(Model model);
	
	
	// Movement directions
	
	/** Sets whether mob is moving or not
	 */
	void setMoving(boolean moving);

    /**
     * @return true if moving, false if not
     */
	boolean isMoving();
	
	/**
     * @return true if mob was moving right
     */
	boolean wasMovingRight();

    /** Sets the wasMovingRight variable
	 */
	void setWasMovingRight(boolean value);

    /** Sets the isMovingRight variable
	 */
	void setMovingRight(boolean value);

    /**
     * @return true if is moving right
     */
	boolean isMovingRight();
	
	
	// Animations //
	
    /** Updates the animation counters and pointers
     * @return true if updated, false otherwise
     */
	boolean updateAnimation();

    /** Changes the mob texture based on its horizontal direction
     * @param right texture
     * @param left texture
     */
	void changeMobTexture(Texture right, Texture left);
    
    /** 
     * @return animationCounter value
     */
	int getAnimationCounter();

    /**
     * @return animationPointer value
     */
	int getAnimationPointer();
}