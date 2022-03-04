package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Sprite {
	float x;
	float y;
	int speedY = 0;
	Boolean grounded;
	int a = -1;
	int score = 0;
	int width = 16;
	int height = 16;
	Rectangle bounds;
	Texture playerImage;
	// String playerName;


	public Player(int x, int y, Texture playerImage) {
		this.x = x;
		this.y = y;
		this.playerImage = playerImage;

		bounds = new Rectangle(x, y, 16, 16);
	}


	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}

	public void changePos(float x, float y) {
		this.x += x;
		this.y += y;
		bounds.x += x;
		bounds.y += y;
	}

	public void setSpeed(int y) {
		this.speedY = y;
	}

	public void changeSpeed(float y) {
		this.speedY += y;
	}

	public void moveY() {
		this.y += this.speedY;
	}

}
