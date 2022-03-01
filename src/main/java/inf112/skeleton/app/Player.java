package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

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
		super(x, y, 16, 16);
		this.x = x;
		this.y = y;
		this.vy = vy;
		this.playerImage = playerImage;
	}

	void move(float x, float y){
		this.x += x;
		this.y += y;
	}
	void setPos(float x, float y){
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean overlaps(Rectangle rect){
		float rectx = rect.getX();
		float recty = rect.getY();
		float rectw = rect.getWidth();
		float recth = rect.getHeight();
		float rectx_max = rectx + rectw;
		float recty_max = recty + recth;
		if (this.x >= rectx && this.x <= rectx_max){
			if (this.y >= recty && this.y <= recty_max){
				return true;
			}
		}
		if (rectx >= this.x && rectx <= (this.x + this.width)){
			if (recty >= this.y && recty <= (this.y + this.height)){
				return true;
			}
		}
		return false;
	}

	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}

	void load_image() {
		
	}
}
