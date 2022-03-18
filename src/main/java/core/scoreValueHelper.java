package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class scoreValueHelper {
    public static int getScoreValue(String textureName) {
        switch (textureName) {
            case "book":
                return 20;
            case "bomb":
                return -50;
        }
        return 10;
    }
}
