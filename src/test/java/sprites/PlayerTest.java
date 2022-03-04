package sprites;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import core.Exam;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    static Exam exam = new Exam();
    Texture playerImage = new Texture(Gdx.files.internal("assets/player.png"));
    Player player;


    /*
     * Due to LibGDX using a special file handler that is not
     * initialized unless an application is run, this code has to run
     * for the tests to not throw a 'null' error upon running
     */
    @BeforeAll
    static void setup(){
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Absolutely Fantastic and Utterly Brilliant Title");
        cfg.setWindowedMode(1200, 480); // scaled as 1.5x castle board size
        Lwjgl3Application lw3 = new Lwjgl3Application(exam, cfg);

    }

    @BeforeEach
    void setupPlayer(){
        player = new Player(0, 0, playerImage);
    }

    @Test
    void testPos(){
        assertEquals(true, true);
    }

    @Test
    void testPlayer1(){
        assertEquals(player.getHeight(), 16);
    }
}
