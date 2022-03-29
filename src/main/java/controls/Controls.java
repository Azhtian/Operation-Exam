package controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import model.Enemy;
import model.Mob;
import model.Model;
import model.Platform;
import model.Player;
import model.Item;

import java.util.ListIterator;

public class Controls {
	
	public Controls() {
	}
	
	/** Updates all moving objects of the game, applying constraints where needed and 
	 * @param model the model to be used for controls*/
	public void doControls(Model model) {
		for (Player p : model.getPlayers()) {
			// Death
			for (Enemy e : model.getEnemies()) {
				// If player touches an enemy
				if (p.getBounds().overlaps(e.getBounds())) {
					// Reset player to start-pos TODO Checkpoints
					p.setX(16);
					p.setY(16);
					// Player takes damage
					p.damage(1);
					if (p.getHealth() <= 0) {
						// Changes screen to game-over screen
						model.setScreen(6);
					}
				}
			}
			// Apply Gravity
			p.changeYSpeed(model.getGravity());
			if (p.getYSpeed() > p.getMaxSpeed()) p.getMaxSpeed();
			else p.changeY(p.getYSpeed());
			
			
			// player Y constraint
			for (Platform rect : model.getPlatforms()) {
				if (p.getBounds().overlaps(rect)) {
					if (rect.isThin()) {
						if (p.getYSpeed() >= 0 || Gdx.input.isKeyPressed(p.getDownControl())) {
							continue;
						}
						else if (p.getYSpeed() <= 0 && p.getY() >= rect.y+8) {
							p.setY(rect.height + rect.y);
							p.setYSpeed(0);
							p.setGrounded(true);
						} 
					}
					else if (!rect.isThin()) {
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
			}
			
			// Left right movement
			if (Gdx.input.isKeyPressed(p.getLeftControl())) {
				p.changeX(-p.getXSpeed());
                p.setMovingRight(false);
				for (Platform rect : model.getPlatforms()) {
					if (p.getBounds().overlaps(rect) && !rect.isThin()) {
						p.setX(rect.x + rect.width);
					}
				}
			}
			if (Gdx.input.isKeyPressed(p.getRightControl())){
				p.changeX(p.getXSpeed());
                p.setMovingRight(true);
				for (Platform rect : model.getPlatforms()) {
					if (p.getBounds().overlaps(rect) && !rect.isThin()) {
						p.setX(rect.x - p.getWidth());
					}
				}
			}
			// Jump
			if (Gdx.input.isKeyJustPressed(p.getJumpControl()) && p.isGrounded()) {
				p.setYSpeed(6.5f); // Using getter for strength here delays the jump for some reason
				p.setGrounded(false);

			}
            //Score item
            ListIterator<Item> iter = model.getScoreItems().listIterator();
            while(iter.hasNext()){
                Item item = iter.next();
                if(p.getBounds().overlaps(item.getBoundingRectangle())){
                    model.addScore(item.getScoreValue());
                    iter.remove();
                }
            }
        }
		// Enemy movement
		for (Enemy enemy : model.getEnemies()) {
			enemy.doMovement(model);
		}


		// press SPACE to pause game (or escape)
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                model.setScreen(5);
        }

		
		
		// test victory
		for (Player player: model.getPlayers()) {
			if (player.getBounds().overlaps(model.getGoal().getBounds())) {
				model.setScreen(7);
			}
		}
	}

    public void changeMobTexture(Mob m, Texture right, Texture left) {
        if (m.getMovingRight()){
            m.setPlayerImage(right);
        } else {
            m.setPlayerImage(left);
        }
    }
}

