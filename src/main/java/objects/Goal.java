package objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Goal{
	private float x;
	private float y;
	private float width;
	private float height;
	private Rectangle bounds;

	public Goal(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
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
