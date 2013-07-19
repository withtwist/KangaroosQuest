package se.chalmers.kangaroo.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class GiantCrabAnimation implements Animation{
	private int tick;
	private int currentSprite;
	private Image sheet;
	private int width;
	private int height;
	
	/**
	 * Creates the animation for a crab.
	 * @param c, must be a crabcreature. 
	 */
	public GiantCrabAnimation(){
		tick = 0;
		currentSprite = 0;
		this.sheet = Toolkit.getDefaultToolkit().getImage("resources/gfx/sheets/giant_crab_2048x256.png");
		this.width = 512;
		this.height = 256;
	}
	@Override
	public void drawSprite(Graphics g, int x, int y) {
		if(tick == 8){
			tick = 0;
			currentSprite++;
			currentSprite = currentSprite % 4;
		}
		g.drawImage(sheet, x, y, x+width, y+height, currentSprite*512, 0, currentSprite*512+width, height, null, null);
		tick++;
	}
	
	/**
	 * Returns the string showing the current animationstate of this creature. 
	 */
	@Override
	public String toString(){
		return "GiantCrabAnimation: " +tick +" "+currentSprite;
	}
}
