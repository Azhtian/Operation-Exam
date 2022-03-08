package core;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        // Application Title and Window Size
        cfg.setTitle("Absolutely Fantastic and Utterly Brilliant Title");
        cfg.setWindowedMode(1200, 480); // scaled as 1.5x castle board size
        new Lwjgl3Application(new ScreenManager(), cfg);
    }
}