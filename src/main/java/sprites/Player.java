package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Rectangle {
	private float x;
	private float y;
	private int vy;
	private int a = 2;
	private int score = 0;
	private int width = 16;
	private int height = 16;
	private static final int SPEED = 400;
	private Texture playerImage;
	// String playerName;
	
	public Player(int x, int y, int vy, Texture playerImage) {
		super(x, y, 16, 16);
		this.x = x;
		this.y = y;
		this.vy = vy;
		this.playerImage = playerImage;
	}

	public void moveTo(float x, float y){
		this.x += x;
		this.y += y;
	}

	public void moveLeft(){
		this.x -= SPEED * Gdx.graphics.getDeltaTime();
	}

	public void moveRight(){
		this.x += SPEED * Gdx.graphics.getDeltaTime();
	}

	public void setPos(float x, float y){
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
	public Texture getPlayerImage(){
		return playerImage;
	}

	void load_image() {
		
	}
}
