package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class Item extends Sprite{
    private int scoreValue;
    private Texture image;
    private float x;
    private float y;

    public Item(Texture image, int scoreValue, float x, float y, int height, int width){
        this.image = image;
        this.scoreValue = scoreValue;
        this.x = x;
        this.y = y;
        this.setBounds(this.x, this.y, 16, 16);
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public int getScoreValue(){
        return this.scoreValue;
    }

    public Texture getImage() {
        return image;
    }
}
