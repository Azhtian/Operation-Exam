package sprites;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import core.Exam;
import model.Player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    static Exam exam = new Exam();
    Texture playerImage = new Texture(Gdx.files.internal("assets/sprites/player.png"));
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
        player = new Player(0, 0, 0, 0, playerImage, new int[] {Input.Keys.LEFT, Input.Keys.UP, Input.Keys.RIGHT, Input.Keys.DOWN});
    }


    @Test
    void testSpeed(){
        assertEquals(player.getYSpeed(), 0);
        player.setYSpeed(5);
        assertEquals(player.getYSpeed(), 5);
        player.changeYSpeed(-5);
        assertEquals(player.getYSpeed(), 0);
        player.changeYSpeed(-5);
        assertEquals(player.getYSpeed(), -5);
    }


    @Test
    void testSetPos(){
        assertEquals(player.getX(), 0);
        assertEquals(player.getY(), 0);
        player.setPos(5, 5);
        assertEquals(player.getX(), 5);
        assertEquals(player.getY(), 5);
    }

    @Test
    void testPosAndRectanglePos(){
        Rectangle rect = player.getBounds();
        assertEquals(rect.getX(), player.getX());
        assertEquals(rect.getY(), player.getY());
        player.setPos(15, 15);
        rect = player.getBounds();
        assertEquals(rect.getX(), player.getX());
        assertEquals(rect.getY(), player.getY());
    }


}
