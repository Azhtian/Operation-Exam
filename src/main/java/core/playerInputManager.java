package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class playerInputManager {
    public static int[] getControls(int controlSet){
        switch (controlSet){
            case 0:
                return new int[] {Input.Keys.LEFT, Input.Keys.UP, Input.Keys.RIGHT, Input.Keys.DOWN} ;
            case 1:
                return new int[] {Input.Keys.A, Input.Keys.W, Input.Keys.D, Input.Keys.S};
        }
        return null;
    }
}
