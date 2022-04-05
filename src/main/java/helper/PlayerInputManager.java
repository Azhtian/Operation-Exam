package helper;

import com.badlogic.gdx.Input;

public class PlayerInputManager {
    public static int[] getControls(int controlSet){
        return switch (controlSet) {
            case 0 -> new int[]{Input.Keys.LEFT, Input.Keys.UP, Input.Keys.RIGHT, Input.Keys.DOWN, Input.Keys.PERIOD, Input.Keys.COMMA};
            case 1 -> new int[]{Input.Keys.A, Input.Keys.W, Input.Keys.D, Input.Keys.S, Input.Keys.SHIFT_LEFT, Input.Keys.TAB};
            default -> null;
        };
    }
}
