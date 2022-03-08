package screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import core.Exam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameScreenTest {
    Exam exam = new Exam();
    GameScreen game;
    ApplicationListener listener;

    Lwjgl3Application lw3;

    @BeforeEach
    void setupGame(){
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        // Application Title and Window Size
        cfg.setTitle("Absolutely Fantastic and Utterly Brilliant Title");
        cfg.setWindowedMode(1200, 480); // scaled as 1.5x castle board size
        lw3 = new Lwjgl3Application(exam, cfg);
        listener = lw3.getApplicationListener();
        //game = new GameScreen(exam);

    }

    @Test
    void dummy(){
        assertEquals(true, true);
        System.out.println(lw3.getFiles());
        System.out.println(listener);
    }
}
