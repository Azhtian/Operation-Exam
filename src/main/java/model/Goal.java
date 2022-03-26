package model;

import com.badlogic.gdx.math.Rectangle;

public class Goal{
	private final float x;
	private final float y;
	private final float width;
	private final float height;
	private final Rectangle bounds;

	public Goal(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
