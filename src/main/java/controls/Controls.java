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
			for (Player e : model.getEnemies()) {
				// If player touches an enemy
				if (p.getBounds().overlaps(e.getBounds())) {
					// Reset player to start-pos
					p.setPos(16, 16);
					// Player takes damage
					p.damage(1);
					if (p.getHealth() <= 0){
						// Changes screen to game-over screen
						model.setScreen(6);
					}
				}
			}
			// Apply Gravity
			p.changeYSpeed(p.getGravity());
			p.changePos(0, p.getYSpeed());
			
			// player Y constraint
			for (Rectangle rect : model.getPlatforms()) {
				if (p.getBounds().overlaps(rect)) {
					if (p.getYSpeed() < 0) {
						p.setPos(p.getX(), rect.height + rect.y);
						p.setGrounded(true); // Fun bug potential
					} else {
						p.setPos(p.getX(), rect.y - p.height);
					}
					p.setYSpeed(0);
					// Move fun bug here for fun 
				}
			}
			
			// Left right movement
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				p.changePos(-5, 0);
				for (Rectangle rect : model.getPlatforms()) {
					if (p.getBounds().overlaps(rect)) {
						p.setPos(rect.x + rect.width, p.getY());
					}
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				p.changePos(5, 0);
				for (Rectangle rect : model.getPlatforms()) {
					if (p.getBounds().overlaps(rect)) {
						p.setPos(rect.x - p.width, p.getY());
					}
				}
			}
			// Jump
			if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && p.isGrounded()) {
				p.setYSpeed(10);
				p.setGrounded(false);
			}

			//Score item
			ListIterator<Item> iter = model.getScoreItems().listIterator();
			while(iter.hasNext()){
				Item item = iter.next();
				if(p.getBounds().overlaps(item.getBoundingRectangle())){
					p.addScore(item.getScoreValue());
					iter.remove();
				}
			}
		}




		// press SPACE to pause game
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			model.setScreen(5);

		// Enemy movement
		for (Enemy enemy : model.getEnemies()) {
			enemy.moveX();

			// Enemy X collisions
			for (Rectangle rect : model.getPlatforms()) {
				if (enemy.getBounds().overlaps(rect)) {
					if (enemy.getMovingRight()) {
						enemy.setPos(rect.x - enemy.width, enemy.getY());
						enemy.setMovingRight(false);
					} else {
						enemy.setPos(rect.x + rect.width, enemy.getY());
						enemy.setMovingRight(true);
					}
				}
			}

			// Enemy falling
			enemy.moveY(model.getGravity());

			// Enemy Y collisions
			for (Rectangle rect : model.getPlatforms()) {
				if (enemy.getBounds().overlaps(rect)) {
						enemy.setPos(enemy.getX(), rect.getY() + rect.getHeight());
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

