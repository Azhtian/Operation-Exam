package model;

import com.badlogic.gdx.math.Rectangle;

public class Goal{
	private final Rectangle bounds;

	public Goal(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
	}

    public Rectangle getBounds() {
		return bounds;
	}
}
