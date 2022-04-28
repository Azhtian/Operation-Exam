package helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * This class handles textures
 */
public class TextureManager {
    public static Texture getTexture(String textureName){
        return switch (textureName) {
            case "book" -> new Texture(Gdx.files.internal("assets/sprites/red_book.png"));
            // Enemy sprites
            // Walker
            case "enemyRight1" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveRight1.png"));
            case "enemyRight2" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveRight2.png"));
            case "enemyLeft1" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveLeft1.png"));
            case "enemyLeft2" -> new Texture(Gdx.files.internal("assets/sprites/professorMoveLeft2.png"));
            // Runner
            case "runnerLeft1" -> new Texture(Gdx.files.internal("assets/sprites/runnerLeft1.png"));
            case "runnerLeft2" -> new Texture(Gdx.files.internal("assets/sprites/runnerLeft2.png"));
            case "runnerRight1" -> new Texture(Gdx.files.internal("assets/sprites/runnerRight1.png"));
            case "runnerRight2" -> new Texture(Gdx.files.internal("assets/sprites/runnerRight2.png"));
            // Jumper
            case "jumperLeft1" -> new Texture(Gdx.files.internal("assets/sprites/jumperLeft1.png"));
            case "jumperLeft2" -> new Texture(Gdx.files.internal("assets/sprites/jumperLeft2.png"));
            case "jumperRight1" -> new Texture(Gdx.files.internal("assets/sprites/jumperRight1.png"));
            case "jumperRight2" -> new Texture(Gdx.files.internal("assets/sprites/jumperRight2.png"));
            // Boss
            case "bossRight" -> new Texture(Gdx.files.internal("assets/sprites/bossRight.png"));
            case "bossLeft" -> new Texture(Gdx.files.internal("assets/sprites/bossLeft.png"));

            // Misc
            case "stamina" -> new Texture(Gdx.files.internal("assets/sprites/Stamina.png"));
            case "staminaFrame" -> new Texture(Gdx.files.internal("assets/sprites/StaminaFrame.png"));

            case "fullHeart" -> new Texture(Gdx.files.internal("assets/sprites/fullHeartContainer.png"));
            case "emptyHeart" -> new Texture(Gdx.files.internal("assets/sprites/emptyHeartContainer.png"));
            case "playerImage" -> new Texture(Gdx.files.internal("assets/sprites/player.png"));
            case "bg" -> new Texture(Gdx.files.internal("assets/sprites/bg_image.png"));
            case "sculpture" -> new Texture(Gdx.files.internal("assets/sprites/sculpture.png"));

            // Player sprites
            // Player 1
            case "player1mvr1" -> new Texture(Gdx.files.internal("assets/sprites/player1right1.png"));
            case "player1mvr2" -> new Texture(Gdx.files.internal("assets/sprites/player1right2.png"));
            case "player1mvl1" -> new Texture(Gdx.files.internal("assets/sprites/player1left1.png"));
            case "player1mvl2" -> new Texture(Gdx.files.internal("assets/sprites/player1left2.png"));
            case "player1idle" -> new Texture(Gdx.files.internal("assets/sprites/player1idle.png"));
            // Player 2
            case "player2mvr1" -> new Texture(Gdx.files.internal("assets/sprites/player2right1.png"));
            case "player2mvr2" -> new Texture(Gdx.files.internal("assets/sprites/player2right2.png"));
            case "player2mvl1" -> new Texture(Gdx.files.internal("assets/sprites/player2left1.png"));
            case "player2mvl2" -> new Texture(Gdx.files.internal("assets/sprites/player2left2.png"));
            case "player2idle" -> new Texture(Gdx.files.internal("assets/sprites/player2idle.png"));
            default -> throw new NullPointerException("No such texture: " + textureName);
        };
    }
}
