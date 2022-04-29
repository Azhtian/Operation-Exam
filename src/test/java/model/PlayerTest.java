package model;

import com.badlogic.gdx.math.Rectangle;
import model.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testAddStamina() {
    	float temp = player.getStamina();
    	player.addStamina();
    	assertEquals(temp, player.getStamina());
    	player.exhaustStamina(10);
    	temp = player.getStamina();
    	player.addStamina();
    	assertTrue(temp < player.getStamina());
    }
    
    @Test
    void testCrouch() {
    	//player.stand();
    	float temp = player.getHeight();
    	player.crouch();
    	assertTrue(temp > player.getHeight());
    	//player.stand();
    	assertEquals(temp, player.getHeight());
    }
    
    @Test
    void testExhaustStamina() {
    	player.exhaustStamina(10);
    	assertEquals(player.getStamina(), player.getMaxStamina()-10);
    }
}
