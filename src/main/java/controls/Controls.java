package controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import model.Enemy;
import model.Model;
import model.Player;

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
}

