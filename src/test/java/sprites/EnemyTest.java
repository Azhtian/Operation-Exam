package sprites;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import core.PlayerInputManager;
import core.ScreenManager;
import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    static Model model;


    @BeforeEach
    void setup(){
        model = new Model();
    }

    @Test
    void testJumperCanJump() {
        Jumper jumper = new Jumper(0, 0, 16, 16);
        assertEquals(0, jumper.getY());
        jumper.doMovement(model);
        assertNotEquals(0, jumper.getY());
    }

    @Test
    void runnerRuns(){
        Runner runner = new Runner(45, 288, 16, 16);
        Player player = new Player(113, 287, 16, 16);

        float moveSpeed = runner.getMoveSpeed();

        runner.findClosePlayer(model);
        runner.doMovement(model);

        assertNotEquals(moveSpeed, runner.getMoveSpeed());
    }

    @Test
    void stationaryDoesNotMove(){
        Stationary stationary = new Stationary(0, 0, 16, 16);
        assertEquals(0, stationary.getXSpeed());
        stationary.doMovement(model);
        assertEquals(0, stationary.getXSpeed());
    }

    @Test
    void enemyMovement(){
        Enemy enemy = new Walker(0, 0, 16, 16);
        assertEquals(0, enemy.getXSpeed());
        enemy.changeX(10);
        enemy.doMovement(model);
        assertNotEquals(0, enemy.getX());
    }
}
