package se.chalmers.kangaroo.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import se.chalmers.kangaroo.model.creatures.Creature;
import se.chalmers.kangaroo.model.creatures.SumoCreature;
import se.chalmers.kangaroo.model.utils.Direction;

public class SumoAnimation implements Animation{
	private SumoCreature sumo;
	private int width;
	private int height;
	private Image sheet;
	private int tick;
	private int currentSprite;
	
	/**
	 * Creates an animation for a SumoCreature
	 * @param c, must be a SumoCreature
	 */
	public SumoAnimation(Creature c){
		if(c instanceof SumoCreature)
			this.sumo = (SumoCreature)c;
		this.width = 64;
		this.height = 64;
		this.sheet = Toolkit.getDefaultToolkit().getImage("resources/gfx/sheets/sumo_64x64.png");
		this.tick = 0;
		this.currentSprite = 0;
	}
	@Override
	public void drawSprite(Graphics g, int x, int y) {
		if(sumo.isStomping()){
			tick++;
			if(tick == 6){
				currentSprite = (sumo.getDirection() == Direction.DIRECTION_EAST) ? 4 : 0;
				currentSprite++;
			}	
			else if(tick == 12)
				currentSprite++;
			else if(tick == 18)
				currentSprite++;
			else if(tick == 138)
				currentSprite++;
			else if(tick == 139)
				currentSprite--;
			else if(tick == 140)
				currentSprite--;
			else if(tick == 141)
				currentSprite--;
		}else{
			tick = 0;
			currentSprite = 0;
		}
		g.drawImage(sheet, x, y, x+width, y+width, currentSprite*width, 0, (currentSprite+1)*width, height, null, null);
	}
	
}
