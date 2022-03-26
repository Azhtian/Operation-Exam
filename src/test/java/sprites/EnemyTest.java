package sprites;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import core.PlayerInputManager;
import core.ScreenManager;
import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    static Model model;
    final Texture enemyImage = new Texture("assets/sprites/enemy.png");

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
        Lwjgl3Application lw3 = new Lwjgl3Application(new ScreenManager(), cfg);
        model = new Model(1, new TmxMapLoader().load("assets/maps/map1.tmx"));
    }

    @Test
    void testJumperCanJump() {
        Jumper jumper = new Jumper(0, 0, 16, 16, enemyImage);
        assertEquals(0, jumper.getY());
        jumper.doMovement(model);
        assertNotEquals(0, jumper.getY());
    }

    @Test
    void runnerRuns(){
        Runner runner = new Runner(0, 0, 16, 16, enemyImage);
        Player player = new Player(5, 0, 16, 16, enemyImage, PlayerInputManager.getControls(0));

        float moveSpeed = runner.getMoveSpeed();

        runner.findClosePlayer(model);
        runner.doMovement(model);

        assertNotEquals(moveSpeed, runner.getMoveSpeed());
    }

    @Test
    void stationaryDoesNotMove(){
        Stationary stationary = new Stationary(0, 0, 16, 16, enemyImage);
        assertEquals(0, stationary.getXSpeed());
        stationary.doMovement(model);
        assertEquals(0, stationary.getXSpeed());
    }

    @Test
    void enemyMovement(){
        Enemy enemy = new Walker(0, 0, 16, 16, enemyImage);
        assertEquals(0, enemy.getXSpeed());
        enemy.changeX(10);
        enemy.doMovement(model);
        assertNotEquals(0, enemy.getX());
    }
}
