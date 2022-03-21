package controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

import core.ScreenManager;
import model.Enemy;
import model.Model;
import model.Player;
import sprites.Item;

import java.util.ListIterator;

public class Controls {
	
	public Controls() {
		
	}

	public void doControls(Model model) {
		// ALL PLAYER ACTIONS
		for (Player p : model.getPlayers()) {
			// TODO Death
			for (Enemy e : model.getEnemies()) {
				// If player touches an enemy
				if (p.getBounds().overlaps(e.getBounds())) {
					// Reset player to start-pos
					p.setX(16);
					p.setY(16);
					// Player takes damage
					p.damage(1);
					if (p.getHealth() <= 0){
						// Changes screen to game-over screen
						model.setScreen(6);
					}
				}
			}
			// Apply Gravity
			p.changeYSpeed(model.getGravity());
			p.changeY(p.getYSpeed());
			
			// player Y constraint
			for (Rectangle rect : model.getPlatforms()) {
				if (p.getBounds().overlaps(rect)) {
					if (p.getYSpeed() < 0) {
						p.setY(rect.height + rect.y);
						p.setGrounded(true); // Fun bug potential
					} else {
						p.setY(rect.y - p.getHeight());
					}
					p.setYSpeed(0);
					// Move fun bug here for fun 
				}
			}
			
			// Left right movement
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				p.changeX(-5);
				for (Rectangle rect : model.getPlatforms()) {
					if (p.getBounds().overlaps(rect)) {
						p.setX(rect.x + rect.width);
					}
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				p.changeX(5);
				for (Rectangle rect : model.getPlatforms()) {
					if (p.getBounds().overlaps(rect)) {
						p.setX(rect.x - p.getWidth());
					}
				}
			}
			// Jump
			if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && p.isGrounded()) {
				p.setYSpeed(10);
				p.setGrounded(false);

			}
		}




		// press SPACE to pause game
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			model.setScreen(5);

		// Enemy movement
		for (Enemy enemy : model.getEnemies()) {
			enemy.doAction();

			// Enemy X collisions
			for (Rectangle rect : model.getPlatforms()) {
				if (enemy.getBounds().overlaps(rect)) {
					if (enemy.getMovingRight()) {
						enemy.setX(rect.x - enemy.getWidth());
						enemy.setMovingRight(false);
					} else {
						enemy.setX(rect.x + rect.width);
						enemy.setMovingRight(true);
					}
				}
			}

			// Enemy falling
			enemy.changeYSpeed(model.getGravity());
			enemy.changeY(enemy.getYSpeed());

			// Enemy Y collisions
			for (Rectangle rect : model.getPlatforms()) {
				if (enemy.getBounds().overlaps(rect)) {
						enemy.setY(rect.getY() + rect.getHeight());
						enemy.setYSpeed(0);
				}
			}
		}
		
		// test victory
		for (Player player: model.getPlayers()) {
			if (player.getBounds().overlaps(model.getGoal().getBounds())) {
				model.setScreen(7);
			}
		}
	}
}

