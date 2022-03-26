package core;

import com.badlogic.gdx.Input;

public class playerInputManager {
    public static int[] getControls(int controlSet){
        return switch (controlSet) {
            case 0 -> new int[]{Input.Keys.LEFT, Input.Keys.UP, Input.Keys.RIGHT, Input.Keys.DOWN};
            case 1 -> new int[]{Input.Keys.A, Input.Keys.W, Input.Keys.D, Input.Keys.S};
            default -> null;
        };
    }
}
