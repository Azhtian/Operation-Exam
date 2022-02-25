package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Rectangle {
	float x;
	float y;
	int vy;
	int a = 2;
	int score = 0;
	int width = 16;
	int height = 16;
	Texture playerImage;
	// String playerName;
	
	Player(int x, int y, int vy, Texture playerImage) {
		this.x = x;
		this.y = y;
		this.vy = vy;
		this.playerImage = playerImage;
	}
	
	void load_image() {
		
	}
}
