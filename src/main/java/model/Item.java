package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Item extends Sprite {
    private final int scoreValue;
    private final Texture image;
    private final float x;
    private final float y;

    /** Creates an Item with Texture, position and value
     * @param image of Item
     * @param scoreValue How many points this Item will yield
     * @param x position bottom left
     * @param y position bottom left
     */
    public Item(Texture image, int scoreValue, float x, float y){
        this.image = image;
        this.scoreValue = scoreValue;
        this.x = x;
        this.y = y;
        this.setBounds(this.x, this.y, 16, 16);
    }

    /** @return x position*/
    public float getX(){
        return this.x;
    }
    
    /** @return y position*/
    public float getY(){
        return this.y;
    }

    /** @return the value of this score Item*/
    public int getScoreValue(){
        return this.scoreValue;
    }

    /** @return the Item Texture*/
    public Texture getImage() {
        return image;
    }
}
