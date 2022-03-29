package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import core.ScreenManager;
import model.Player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setupPlayer(){
        player = new Player(0, 0, 0, 0);
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
