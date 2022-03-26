package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
    public static Texture getTexture(String textureName){
        return switch (textureName) {
            case "book" -> new Texture(Gdx.files.internal("assets/sprites/red_book.png"));
            case "enemyRight1" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveRight1.png"));
            case "enemyRight2" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveRight2.png"));
            case "enemyLeft1" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveLeft1.png"));
            case "enemyLeft2" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveLeft2.png"));
            case "fullHeart" -> new Texture(Gdx.files.internal("assets/sprites/fullHeartContainer.png"));
            case "emptyHeart" -> new Texture(Gdx.files.internal("assets/sprites/emptyHeartContainer.png"));
            case "playerImage" -> new Texture(Gdx.files.internal("assets/sprites/player.png"));
            default -> null;
        };
    }
}
