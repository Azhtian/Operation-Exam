package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    private Model model;


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
        Runner runner = new Runner(70, 0, 16, 16);
        runner.doMovement(model);
        assertEquals(1.2f, runner.getCurrentSpeed());

        Player player = new Player(113, 0, 16, 16);
        model.addPlayer(player);

        float moveSpeed = runner.getCurrentSpeed();

        runner.findClosePlayer(model, 16);
        runner.doMovement(model);
        //runner.doAction();

        assertNotEquals(moveSpeed, runner.getCurrentSpeed());

        player.setPos(50, 0);
        runner.doMovement(model);
        assertFalse(runner.isMovingRight());
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

        enemy.setWasMovingRight(true);
        enemy.setMovingRight(false);
        assertTrue(enemy.wasMovingRight());
        assertFalse(enemy.isMovingRight());
    }

    @Test
    void enemyAnimationCounter(){
        Enemy enemy = new Walker(0, 0, 16, 16);

        enemy.setMovingRight(true);
        enemy.setWasMovingRight(true);
        assertEquals(enemy.getAnimationCounter(), 0);
        assertEquals(enemy.getAnimationPointer(), 0);

        assertFalse(enemy.updateAnimation());

        assertEquals(enemy.getAnimationCounter(), 1);
        assertEquals(enemy.getAnimationPointer(), 0);
        for (int i = 0; i < 18; i++){
            enemy.updateAnimation();
        }
        assertTrue(enemy.updateAnimation());
        assertEquals(enemy.getAnimationCounter(), 0);
        assertEquals(enemy.getAnimationPointer(), 1);

        enemy.updateAnimation();
        assertNotEquals(enemy.getAnimationCounter(),0);

        enemy.setMovingRight(false);
        assertTrue(enemy.updateAnimation());
        assertEquals(enemy.getAnimationCounter(), 0);
    }
}
