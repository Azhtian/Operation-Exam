package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
    public static Texture getTexture(String textureName){
        switch (textureName){
            case "book":
                return new Texture(Gdx.files.internal("assets/sprites/red_book.png"));
            case "bomb":
                return new Texture(Gdx.files.internal("assets/sprites/fullHeartContainer.png"));
        }
        return null;
    }
}
