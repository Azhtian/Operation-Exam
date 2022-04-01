package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import helper.ScreenManager;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        // Application Title and Window Size
        cfg.setTitle("Operation Exam");
        cfg.setWindowedMode(1440, 810); // scaled as 1.5x castle board size
        new Lwjgl3Application(new ScreenManager(), cfg);
    }
}