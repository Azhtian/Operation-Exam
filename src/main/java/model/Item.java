package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Item extends Sprite{
    private final int scoreValue;
    private final Texture image;
    private final float x;
    private final float y;

    public Item(Texture image, int scoreValue, float x, float y){
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
