package model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Boss extends Enemy{
	Player closestPlayer;
	
	public Boss (float x, float y, float width, float height, Texture image){
		super(x, y, width, height, image);
		this.setMoveSpeed((float)0.8);
	}
	
	public void doMovement(Model model){
		this.findClosestPlayer(model.getPlayers());
		this.changeX((float) (this.getMoveSpeed() * (closestPlayer.getCentreX()-this.getCentreX())/(Math.sqrt(Math.pow(closestPlayer.getCentreX()-this.getCentreX(),2) + Math.pow(closestPlayer.getCentreY()-this.getCentreY(),2)))));
		this.changeY((float) (this.getMoveSpeed() * (closestPlayer.getCentreY()-this.getCentreY())/(Math.sqrt(Math.pow(closestPlayer.getCentreX()-this.getCentreX(),2) + Math.pow(closestPlayer.getCentreY()-this.getCentreY(),2)))));
	}
	
	public void findClosestPlayer(ArrayList<Player> players) {
		closestPlayer = null;
		for (Player p : players){
			if (closestPlayer == null) {
				closestPlayer = p;
			} else if ((Math.sqrt(Math.pow(p.getCentreX()-this.getCentreX(),2) + Math.pow(p.getCentreY()-this.getCentreY(),2)) < (Math.sqrt(Math.pow(closestPlayer.getCentreX()-this.getCentreX(),2) + Math.pow(closestPlayer.getCentreY()-this.getCentreY(),2))))) {
				closestPlayer = p;
			} 	
		}
	}
}
