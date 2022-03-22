package model;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Mob {

	private Boolean stationary = true;
	private int moveSpeed;

	public Enemy(float x, float y, float width, float height, Texture image) {
		super(x, y, width, height, image);
		this.moveSpeed = 2;
	}
	
	public void doAction () {
		if (!stationary) {
			if (this.getMovingRight()) {
				this.changeX(moveSpeed);
			} else {
				this.changeX(-moveSpeed);
			}
		} 
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

	public void setMoveSpeed(int speed){
		moveSpeed = speed;
	}
	
	public void setStationary(Boolean value) {
		stationary = value;
	}

    public Boolean getStationary() {
        return stationary;
    }
}
