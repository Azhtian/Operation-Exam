package core;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import helper.ScreenManager;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        // Application Title and Window Size
        cfg.setTitle("It's Exam day and you are late, run!");
        cfg.setWindowedMode(1600, 800); // Scaled as 2x castle board size
        new Lwjgl3Application(new ScreenManager(), cfg);
    }
}