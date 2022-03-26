package screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import core.ScreenManager;
import org.junit.jupiter.api.BeforeEach;

public class GameScreenTest {

    GameScreen game;
    ApplicationListener listener;

    Lwjgl3Application lw3;

    @BeforeEach
    void setupGame(){
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        // Application Title and Window Size
        cfg.setTitle("Absolutely Fantastic and Utterly Brilliant Title");
        cfg.setWindowedMode(1200, 480); // scaled as 1.5x castle board size
        lw3 = new Lwjgl3Application(new ScreenManager(), cfg);
        listener = lw3.getApplicationListener();
        //game = new GameScreen(exam);

    }
}
