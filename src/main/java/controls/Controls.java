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
		
		// Player actions
		for (Player p : model.getPlayers()) {
			p.doMovement(model);
        }
		// Enemy actions
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

