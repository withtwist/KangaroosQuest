package se.chalmers.kangaroo.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import se.chalmers.kangaroo.model.creatures.Creature;
import se.chalmers.kangaroo.model.creatures.MatryoshkaCreature;
import se.chalmers.kangaroo.model.utils.Direction;

public class MatryoshkaAnimation implements Animation{
	private MatryoshkaCreature mc;
	private int width;
	private int height;
	private Image leftSheet;
	private Image rightSheet;
	private int tick;
	private int currentSprite;
	
	/**
	 * Creates an animation for a SumoCreature
	 * @param c, must be a SumoCreature
	 */
	public MatryoshkaAnimation(Creature c){
		if(c instanceof MatryoshkaCreature)
			this.mc = (MatryoshkaCreature) c;
		this.width = 64;
		this.height = 96;
		this.leftSheet = Toolkit.getDefaultToolkit().getImage("resources/gfx/sheets/matryoshka_left.png");
		this.rightSheet = Toolkit.getDefaultToolkit().getImage("resources/gfx/sheets/matryoshka_right.png");
		this.tick = 0;
		this.currentSprite = 0;
	}
	@Override
	public void drawSprite(Graphics g, int x, int y) {
		if(mc.getLife() == 2){
			if(mc.getDirection() == Direction.DIRECTION_WEST){
				g.drawImage(leftSheet, x, y, x+64, y+96, 0, 0, 64, 96, null, null);
			}else{
				g.drawImage(rightSheet, x, y, x+64, y+96, 0, 0, 64, 96, null, null);
			}
		}else if(mc.getLife() == 1){
			if(mc.getDirection() == Direction.DIRECTION_WEST){
				g.drawImage(leftSheet, x, y, x+44, y+96, 64, 0, 108, 96, null, null);
			}else{
				g.drawImage(rightSheet, x, y, x+44, y+96, 64, 0, 108, 96, null, null);
			}
		}else{
			if(mc.getDirection() == Direction.DIRECTION_WEST){
				g.drawImage(leftSheet, x, y, x+32, y+96, 108, 0, 140, 96, null, null);
			}else{
				g.drawImage(rightSheet, x, y, x+32, y+96, 108, 0, 140, 96, null, null);
			}
		}
	}
	
}

